<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/sum.jsp" method="get">
	<input type="text" name="number" value="1"/><br>
	<input type="text" name="number2" value="10"/><br>
	<input type="submit" value="결과"/>
</form>

<form action="${pageContext.request.contextPath}/jsp/mul.jsp" method="get">
	<input type="text" name="number" value="1"/><br>
	<input type="text" name="number2" value="10"/><br>
	<input type="submit" value="결과"/>
</form>

</body>
</html>