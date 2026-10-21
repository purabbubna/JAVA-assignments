
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
String url = "jdbc:mysql://localhost:3306/javalab";
String dbUser = "root";
String dbPassword = "purabP@$$W0rd";
String error = "";
String message = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String action = request.getParameter("action");

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword)) {
            if ("add".equals(action)) {
                String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setString(2, request.getParameter("department"));
                    ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                    ps.executeUpdate();
                }
                message = "Employee added successfully";
            } else if ("update".equals(action)) {
                String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setString(2, request.getParameter("department"));
                    ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                    ps.setInt(4, Integer.parseInt(request.getParameter("id")));
                    int count = ps.executeUpdate();
                    message = count > 0 ? "Employee updated successfully" : "Employee ID not found";
                }
            } else if ("delete".equals(action)) {
                String sql = "DELETE FROM employees WHERE id=?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                    int count = ps.executeUpdate();
                    message = count > 0 ? "Employee deleted successfully" : "Employee ID not found";
                }
            }
        }
    }
} catch (Exception e) {
    error = e.getMessage();
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee CRUD</title>
</head>
<body>
    <h2>Employee Management System</h2>

    <% if (!message.isEmpty()) { %>
        <p><%= message %></p>
    <% } %>

    <% if (!error.isEmpty()) { %>
        <p style="color:red;">Error: <%= error %></p>
    <% } %>

    <h3>Add Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="add">

        Name:
        <input type="text" name="name" required>
        <br><br>

        Department:
        <input type="text" name="department" required>
        <br><br>

        Salary:
        <input type="number" name="salary" step="0.01" min="0" required>
        <br><br>

        <button type="submit">Add Employee</button>
    </form>

    <h3>Update Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="update">

        Employee ID:
        <input type="number" name="id" min="1" required>
        <br><br>

        New Name:
        <input type="text" name="name" required>
        <br><br>

        New Department:
        <input type="text" name="department" required>
        <br><br>

        New Salary:
        <input type="number" name="salary" step="0.01" min="0" required>
        <br><br>

        <button type="submit">Update Employee</button>
    </form>

    <h3>Delete Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="delete">

        Employee ID:
        <input type="number" name="id" min="1" required>

        <button type="submit">Delete Employee</button>
    </form>

    <h3>All Employees</h3>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM employees ORDER BY id")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getBigDecimal("salary") %></td>
        </tr>
        <%
                }
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="4">Unable to load employees: <%= e.getMessage() %></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
