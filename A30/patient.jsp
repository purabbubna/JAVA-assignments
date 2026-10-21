
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
String url = "jdbc:mysql://localhost:3306/javalab";
String dbUser = "root";
String dbPassword = "purabP@$$W0rd";
String message = "";
String error = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String action = request.getParameter("action");

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword)) {
            if ("add".equals(action)) {
                String sql = "INSERT INTO patients (name, age, disease, treatment_status) VALUES (?, ?, ?, ?)";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                    ps.setString(3, request.getParameter("disease"));
                    ps.setString(4, request.getParameter("treatment_status"));
                    ps.executeUpdate();
                }

                message = "Patient added successfully";

            } else if ("update".equals(action)) {
                String sql = "UPDATE patients SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                    ps.setString(3, request.getParameter("disease"));
                    ps.setString(4, request.getParameter("treatment_status"));
                    ps.setInt(5, Integer.parseInt(request.getParameter("patient_id")));

                    int count = ps.executeUpdate();
                    message = count > 0 ? "Patient updated successfully" : "Patient ID not found";
                }

            } else if ("delete".equals(action)) {
                String sql = "DELETE FROM patients WHERE patient_id=?";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));

                    int count = ps.executeUpdate();
                    message = count > 0 ? "Patient deleted successfully" : "Patient ID not found";
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
    <title>Patient Records Management</title>
</head>
<body>
    <h2>Patient Records Management System</h2>

    <% if (!message.isEmpty()) { %>
        <p><%= message %></p>
    <% } %>

    <% if (!error.isEmpty()) { %>
        <p style="color:red;">Error: <%= error %></p>
    <% } %>

    <h3>Add Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="add">

        Name:
        <input type="text" name="name" required>
        <br><br>

        Age:
        <input type="number" name="age" min="0" required>
        <br><br>

        Disease:
        <input type="text" name="disease" required>
        <br><br>

        Treatment Status:
        <select name="treatment_status" required>
            <option value="Admitted">Admitted</option>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select>
        <br><br>

        <button type="submit">Add Patient</button>
    </form>

    <hr>

    <h3>Update Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="update">

        Patient ID:
        <input type="number" name="patient_id" min="1" required>
        <br><br>

        Name:
        <input type="text" name="name" required>
        <br><br>

        Age:
        <input type="number" name="age" min="0" required>
        <br><br>

        Disease:
        <input type="text" name="disease" required>
        <br><br>

        Treatment Status:
        <select name="treatment_status" required>
            <option value="Admitted">Admitted</option>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select>
        <br><br>

        <button type="submit">Update Patient</button>
    </form>

    <hr>

    <h3>Delete Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="delete">

        Patient ID:
        <input type="number" name="patient_id" min="1" required>

        <button type="submit">Delete Patient</button>
    </form>

    <hr>

    <h3>All Patient Records</h3>
    <table border="1" cellpadding="8">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM patients ORDER BY patient_id")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <%
                }
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">Unable to load records: <%= e.getMessage() %></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
