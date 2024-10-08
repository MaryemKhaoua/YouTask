<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.css" rel="stylesheet" />
    <title>DevSync</title>
</head>
<body class="bg-gray-100">
<section class="container mx-auto px-6 py-8">
    <div class="flex items-center justify-between mb-6">
        <h2 class="text-2xl font-semibold text-gray-900">User Management</h2>
        <a href="users?action=create" class="inline-flex items-center px-4 py-2 bg-indigo-600 text-white rounded-lg shadow-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-400">
            Add User
        </a>
    </div>

    <div class="overflow-hidden bg-white shadow rounded-lg">
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-indigo-500 text-white">
            <tr>
                <th class="px-12 py-3 text-left text-sm font-medium">Name</th>
                <th class="px-12 py-3 text-left text-sm font-medium">Email</th>
                <th class="px-4 py-3 text-left text-sm font-medium">Password</th>
                <th class="px-4 py-3 text-left text-sm font-medium">Role</th>
                <th class="relative py-3 px-4">Actions</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <c:forEach var="user" items="${users}">
                <tr>
                    <td class="px-4 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">
                        <div class="flex items-center">
                            <p class="text-lg font-semibold text-gray-800">${user.firstName}</p>
                            <p class="ml-2 text-xs text-gray-500">ID: ${user.id}</p>
                        </div>
                    </td>
                    <td class="px-12 py-4 text-sm text-gray-700 whitespace-nowrap">${user.email}</td>
                    <td class="px-4 py-4 text-sm text-gray-500 whitespace-nowrap">${user.password}</td>
                    <td class="px-4 py-4 text-sm text-gray-500 whitespace-nowrap">${user.role}</td>
                    <td class="px-4 py-4 text-sm whitespace-nowrap">
                        <div class="flex space-x-2">
                            <a href="users?action=edit&id=${user.id}" class="inline-flex items-center px-3 py-1 bg-green-500 text-white rounded-lg hover:bg-green-600 focus:outline-none">
                                Edit
                            </a>
                            <a href="users?action=delete&id=${user.id}" class="inline-flex items-center px-3 py-1 bg-red-500 text-white rounded-lg hover:bg-red-600 focus:outline-none">
                                Delete
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.js"></script>
</body>
</html>
