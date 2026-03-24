<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Document</title>
</head>
<body>
server file code
<%
String emp_id = request.getParameter("emp_id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");
String dept = request.getParameter("dept");
String desg = request.getParameter("desg");
String salary = request.getParameter("salary");
String date = request.getParameter("date");
String gender = request.getParameter("gender");



try {
Class.forName("com.mysql.cj.jdbc.Driver");
out.println("Driver Loaded");
    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/form",
        "root",
        "12345"
    );

    String query = "insert into data values('" + emp_id + "','" + name + "','" + email + "','" + password + "','" + dept + "','" + desg + "','" + salary + "','" + date + "','" + gender + "')";

    Statement st = conn.createStatement();
    st.executeUpdate(query);

    out.println("Data inserted successfully");

    st.close();
    conn.close();

}
catch (ClassNotFoundException e) {
            out.print("Driver not found");
        }

catch (Exception e) {
    e.printStackTrace();
}
%>

</body>
</html>