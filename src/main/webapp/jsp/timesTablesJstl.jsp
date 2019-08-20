<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width: 700px;
		height: 300px;
		text-align: center;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	timesTablesJstl.jsp
	<table border = 1>
	<c:forEach begin="1" end="9" var="i" step="1">
		<tr>
		<c:forEach begin="2" end="9" var="j" step="1">
			<td>
				${j } * ${i } = ${j * i }
			</td>
		</c:forEach>
		</tr>
	</c:forEach>	
	</table>	
	
</body>
</html>