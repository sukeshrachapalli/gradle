    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 {
  width: 100%;    
  background-color: #f1f1c1;
}
</style>
</head>
<body>

<h2>STUDENT DETAILS</h2>

<br>

<table id="t01">
  <tr>
    <th>ID</th>
    <th>NAME</th> 
    <th>CGPA</th>
  <th>DEPARTMENT</th>
  <th>EDIT</th>
  <th>DELETE</th>
  </tr>
  <c:forEach var="stud" items="${list}"> 
    <tr>
    <td>${stud.id}</td>
    <td>${stud.name}</td>
    <td>${stud.cgpa}</td>
    <td>${stud.department}</td>
    <td><a href="editstud/${stud.id}">Edit</a></td>
    <td><a href="deletestud/${stud.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
<br/>
    <a href="studform">Add New Student</a>
</body>
</html>
