package org.example.servlets;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.entities.Task;
import org.example.model.entities.User;
import org.example.model.enums.TaskStatus;
import org.example.repository.implementation.TaskRepositoryImpl;
import org.example.repository.interfaces.TaskRepository;
import org.example.service.TaskService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskServlet extends HttpServlet {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DevSync");
    TaskRepository taskRepository = new TaskRepositoryImpl(entityManagerFactory);
    TaskService taskService = new TaskService(taskRepository);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            listTasks(request, response);
        } else if ("create".equals(action)) {
            showCreateForm(request, response);
        } else if ("edit".equals(action)) {
            showEditForm(request, response);
        } else if ("delete".equals(action)) {
            deleteTask(request, response);
        } else {
            listTasks(request, response);
        }
    }

    private void listTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = taskService.getAllTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/WEB-INF/views/tasks.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/createTaskForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long taskId = Long.parseLong(request.getParameter("id"));
        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            response.sendRedirect(request.getContextPath() + "/tasks?action=list");
            return;
        }
        request.setAttribute("task", task);
        request.getRequestDispatcher("/WEB-INF/views/editTaskForm.jsp").forward(request, response);
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long taskId = Long.parseLong(request.getParameter("id"));
        taskService.deleteTask(taskId);
        response.sendRedirect(request.getContextPath() + "/tasks?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createTask(request, response);
        } else if ("edit".equals(action)) {
            updateTask(request, response);
        }
    }

    private void createTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDateTime deadline = LocalDateTime.parse(request.getParameter("deadline"));
        String status = request.getParameter("status");
        Long assignedToId = Long.parseLong(request.getParameter("assignedTo"));

        // Assume that the user creating the task is the logged-in user
        User createdBy = (User) request.getSession().getAttribute("user");
        User assignedTo = taskService.getUserById(assignedToId); // Assuming this method exists

        Task newTask = new Task();
        newTask.setTitle(title);
        newTask.setDescription(description);
        newTask.setDeadLine(deadline);
        newTask.setStatus(TaskStatus.valueOf(status));
        newTask.setCreatedBy(createdBy);
        newTask.setAssignedTo(assignedTo);

        taskService.createTask(newTask);
        response.sendRedirect(request.getContextPath() + "/tasks?action=list");
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long taskId = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDateTime deadline = LocalDateTime.parse(request.getParameter("deadline"));
        String status = request.getParameter("status");
        Long assignedToId = Long.parseLong(request.getParameter("assignedTo"));

        Task updatedTask = taskService.getTaskById(taskId);
        if (updatedTask == null) {
            response.sendRedirect(request.getContextPath() + "/tasks?action=list");
            return;
        }

        updatedTask.setTitle(title);
        updatedTask.setDescription(description);
        updatedTask.setDeadLine(deadline);
        updatedTask.setStatus(TaskStatus.valueOf(status));
        User assignedTo = taskService.getUserById(assignedToId); // Assuming this method exists
        updatedTask.setAssignedTo(assignedTo);

        taskService.updateTask(updatedTask);
        response.sendRedirect(request.getContextPath() + "/tasks?action=list");
    }
}
