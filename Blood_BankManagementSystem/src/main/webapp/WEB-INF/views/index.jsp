<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags"prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<s:form name="exportNews"id="exportNewsForm" theme="simple"  namespace="/"  action="exportNews" onsubmit="return validate(this);"  method="post"> 
        <s:submit value="Export"  />
         </s:form> --> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>
	
		<a href="<spring:url value='/user/login'/>">User Login</a>
	</h4>

	
</body>
</html>