<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!IUserService userService = new UserService();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 1. userdao 선언
	 2. getUserList() 호출
	 3. 호출 결과(List<UserVo>)를 for loop를 통해 tr 태그를 반복 생성 --%>
	<table border = 1>
		<tr>
			<th>이름</th>
		</tr>
		<%
			List<User> userList = userService.getUserList();
		%>
<%-- 		<% for(int i=0; i<userList.size(); i++){ %> --%>
<!-- 			<tr> -->
<%-- 				<td><%=userList.get(i).getUserName() %></td> --%>
<!-- 			</tr>		 -->
<%-- 		<%}%> --%>
		
		<%
					for(User userVo:userList){
				%>
			<tr>
				<td><%=userVo.getUserName() %></td>
			</tr>		
		<%}%>
	</table>
</body>
</html>