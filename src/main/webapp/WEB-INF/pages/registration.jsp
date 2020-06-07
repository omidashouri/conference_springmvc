<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
    <body>
    <h1>Registration Page</h1>
        <form:form modelAttribute="registration">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add Registration"></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>