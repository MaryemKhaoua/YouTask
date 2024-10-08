<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New User</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${pageContext.request.contextPath}/assets/js/UserValidator.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.css" rel="stylesheet" />
</head>
<body class="bg-gray-100">
<section class="bg-white dark:bg-gray-800">
    <div class="flex justify-center min-h-screen">
        <div class="flex items-center w-full max-w-3xl p-8 mx-auto lg:px-12 lg:w-3/5">
            <div class="w-full">
                <h1 class="text-3xl font-bold text-gray-900 dark:text-white">
                    Create New User
                </h1>

                <form id="userForm" class="grid grid-cols-1 gap-6 mt-8 md:grid-cols-2" action="users?action=create" method="post" onsubmit="return validateForm()">
                    <div>
                        <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">First Name</label>
                        <input type="text" name="firstName" id="firstName" placeholder="John" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:ring focus:ring-blue-400 focus:outline-none" />
                        <span id="firstNameError" class="text-red-500 text-sm"></span>
                    </div>

                    <div>
                        <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Last Name</label>
                        <input type="text" name="lastName" id="lastName" placeholder="Snow" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:ring focus:ring-blue-400 focus:outline-none" />
                        <span id="lastNameError" class="text-red-500 text-sm"></span>
                    </div>

                    <div>
                        <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Email Address</label>
                        <input type="email" name="email" id="email" placeholder="johnsnow@example.com" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:ring focus:ring-blue-400 focus:outline-none" />
                        <span id="emailError" class="text-red-500 text-sm"></span>
                    </div>

                    <div>
                        <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Password</label>
                        <input type="password" name="password" id="password" placeholder="Enter your password" class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:ring focus:ring-blue-400 focus:outline-none" />
                        <span id="passwordError" class="text-red-500 text-sm"></span>
                    </div>

                    <div>
                        <label class="block mb-2 text-sm font-medium text-gray-700 dark:text-gray-300">Role</label>
                        <select name="role" id="role" class="block w-full px-5 py-3 mt-2 text-gray-700 bg-gray-50 border border-gray-300 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-gray-300 focus:ring focus:ring-blue-400 focus:outline-none">
                            <option selected disabled>Choose a role</option>
                            <option value="MANAGER">Manager</option>
                            <option value="USER">User</option>
                        </select>
                        <span id="roleError" class="text-red-500 text-sm"></span>
                    </div>

                    <button type="submit" class="flex items-center justify-center w-full px-6 py-3 mt-4 text-sm font-semibold text-white capitalize transition-colors duration-300 bg-blue-600 rounded-lg hover:bg-blue-500 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-50">
                        Create User
                    </button>
                </form>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.js"></script>
</body>
</html>