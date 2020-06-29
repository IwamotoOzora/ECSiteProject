<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/administration_item.css">

<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理者用画面｜商品一覧</title>
</head>
<body>
    <!-- 管理者用の商品一覧表示jsp -->
	<h1>商品一覧</h1>
	<table>
		<tr>
			<th colspan="8" class="userdata">商品一覧</th>
		</tr>

		<tr>
			<th>商品コード</th>
			<th>商品名</th>
			<th>価格</th>
			<th>色</th>
			<th>カテゴリ</th>
			<th>画像</th>

		</tr>

		<c:forEach var="data" items="${items}">
			<tr>
				<td><c:out value="${data.itemCode}"></c:out></td>
				<td><c:out value="${data.name}"></c:out></td>
				<td><c:out value="${data.price}"></c:out>円</td>
				<td><c:out value="${data.color}"></c:out></td>
				<td><c:out value="${data.category}"></c:out></td>
				<td><img src="<c:out value="http://localhost:8080/ECSiteProject/images/${data.imagePath}"></c:out>"></td>
			</tr>
		</c:forEach>
	</table>

	<form action="GoToAdministrationServlet" method="get">
		<div class="button">
			<input type="submit" value="戻る" class="back_button" name="nomarl">
		</div>
	</form>
</body>
</html>