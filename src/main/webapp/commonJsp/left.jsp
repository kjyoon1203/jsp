<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<ul class="nav nav-sidebar">
	<!--  a tag: get method -->
	<li class="active"><a href="${pageContext.request.contextPath}/userList">사용자리스트<span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${pageContext.request.contextPath}/userListOnlyHalf">사용자리스트(onlyHalf)</a></li>
	<!-- lprodList로 요청시 db에 있는 lprod 테이블의 모든 테이터를 사용자 리스트 화면처럼 table로 출력
	package: kr.or.ddit.lprod.web
			 kr.or.ddit.lprod.repository
			 kr.or.ddit.lprod.model
	생성코드
	1. LprodListController
	2. LprodDao / LprodDaoTest
	3. LprodVo
	4. webapp/lprod/lprodList.jsp
	5. mybatis-config.xml에 mapper파일 추가, alias추가 -->
	<li class="active"><a href="${pageContext.request.contextPath}/lprodList">제품그룹리스트</a></li>
</ul>