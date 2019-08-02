<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	int sum = 0;
	int number = Integer.parseInt(request.getParameter("number"));	
	int number2 = Integer.parseInt(request.getParameter("number2"));	

%>

<%
	for(int i=number; i<number2; i++){
		sum +=i;
	}
%>

	number: <%=number%> <br>
	number2: <%=number2 %> <br>
	result: <%=sum %>
</body>
</html>