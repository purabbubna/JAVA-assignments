
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h2>Student Information Form</h2>

    <form action="student.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Roll Number: <input type="text" name="roll" required><br><br>
        Branch: <input type="text" name="branch" required><br><br>
        Semester: <input type="number" name="semester" required><br><br>
        <input type="submit" value="Submit">
    </form>

    <%
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String branch = request.getParameter("branch");
        String semester = request.getParameter("semester");

        if (name != null && roll != null && branch != null && semester != null) {
    %>
        <h3>Submitted Student Details</h3>
        <p>Name: <%= name %></p>
        <p>Roll Number: <%= roll %></p>
        <p>Branch: <%= branch %></p>
        <p>Semester: <%= semester %></p>
    <%
        }
    %>
</body>
</html>
