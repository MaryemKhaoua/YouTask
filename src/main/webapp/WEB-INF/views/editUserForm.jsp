<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit User</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.css" rel="stylesheet" />
</head>
<body class="bg-gray-100">
<section class="bg-white dark:bg-gray-800">
  <div class="flex justify-center min-h-screen">
    <div class="flex items-center w-full max-w-3xl p-8 mx-auto lg:px-12 lg:w-3/5">
      <div class="w-full">
        <h1 class="text-3xl font-bold text-gray-900 dark:text-white">
          Edit User
        </h1>

        <form class="grid grid-cols-1 gap-6 mt-8 md:grid-cols-2" action="users?action=edit&id=${user.id}" method="POST">
          <div>
            <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">First Name</label>
            <input type="text" name="firstName" value="${user.firstName}" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:border-blue-500 dark:focus:border-blue-400 focus:ring focus:ring-blue-400 focus:outline-none" />
          </div>

          <div>
            <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Last Name</label>
            <input type="text" name="lastName" value="${user.lastName}" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:border-blue-500 dark:focus:border-blue-400 focus:ring focus:ring-blue-400 focus:outline-none" />
          </div>

          <div>
            <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Email Address</label>
            <input type="email" name="email" value="${user.email}" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:border-blue-500 dark:focus:border-blue-400 focus:ring focus:ring-blue-400 focus:outline-none" />
          </div>

          <div>
            <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Password</label>
            <input type="password" name="password" value="${user.password}" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:border-blue-500 dark:focus:border-blue-400 focus:ring focus:ring-blue-400 focus:outline-none" />
          </div>

          <div>
            <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Role</label>
            <select name="role" class="block w-full px-5 py-3 mt-2 text-gray-700 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:border-blue-500 dark:focus:border-blue-400 focus:ring focus:ring-blue-400 focus:outline-none">
              <option selected disabled>Choose a role</option>
              <option value="MANAGER" ${user.role == 'MANAGER' ? 'selected' : ''}>Manager</option>
              <option value="USER" ${user.role == 'USER' ? 'selected' : ''}>User</option>
            </select>
          </div>

          <button type="submit" class="flex items-center justify-center w-full px-6 py-3 mt-4 text-sm font-semibold text-white bg-blue-600 rounded-lg hover:bg-blue-500 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-50">
            Edit User
          </button>
        </form>
      </div>
    </div>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.js"></script>
</body>
</html>