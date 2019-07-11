<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Student</h1>
       <form:form method="POST" action="/SpringMVCPagination/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>CGPA :</td>  
          <td><form:input path="cgpa" /></td>
         </tr> 
         <tr>  
          <td>Department :</td>  
          <td><form:input path="department" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><button type="submit" formaction="/SpringMVCPagination/editsave">Save</button></td>  
         </tr>  
        </table>  
       </form:form>  
