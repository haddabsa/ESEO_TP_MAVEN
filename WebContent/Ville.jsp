<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://127.0.0.1/eseo_tp_maven"
        user="maven" password="network"
    />
     
    <sql:query var="listVille"   dataSource="${myDS}">
        SELECT * FROM ville_france;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Listes des differentes communes</h2></caption>
            <tr>
                
                <th>Nom_commune</th>
                <th>Code_postal</th>
                
            </tr>
            <c:forEach var="ville" items="${listVille.rows}">
                <tr>
                    
                    <td><c:out value="${ville.Nom_commune}"  /></td>
                    <td><c:out value="${ville.Code_postal}"  /></td>
                    
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>