<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>detail 페이지</h1>

<hr/>

번호: ${post.id}<br/>
제목: ${post.title}<br/>
내용: ${post.content}<br/>
조회수: ${post.readCount}<br/>

</body>
</html>