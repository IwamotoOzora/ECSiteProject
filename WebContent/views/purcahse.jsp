<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/item.css">
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>買い物カゴ|MysteriousTeaParty</title>
<body>
</head>
<!-- ヘッダー -->
<header>
	<h1>MysteriousTeaParty</h1>
	<div class="message">ようこそ${sessionScope.userBean.userCode}さん</div>

	<!-- 検索欄 -->
	<form class="search" action="SearchItemServlet" method="post">
		<input type="search" name="search" placeholder="キーワード入力"> <input
			type="submit" name="submit" value="検索">
	</form>

	<!-- カート -->
	<form class="cart" action="GoToCartServlet" method="get">
		<input type="image"
			src="http://localhost:8080/ECSiteProject/images/cart.png">
	</form>
	<hr>
</header>

<!-- メインコンテンツ -->
<h1>最終購入確認</h1>
<form action="PurchaseServlet" method="post">
	<table>
		<tr>
			<th>商品名</th>
			<th>イメージ画像</th>
			<th>価格(税抜き)</th>
			<th>個数</th>
			<th>小計(税込み)</th>
			<th></th>
		</tr>

           <c:forEach var="data" items="${carts}">
		<tr>
			<td>
			    <c:out value="${data.name}"></c:out>
			    <input type="hidden" name="name" value="${data.name}"></input>
			    <input type="hidden" name="item_code" value="${data.itemCode}"></input>
		    </td>

            <td>
			    <img src="<c:out value="http://localhost:8080/ECSiteProject/images/${data.imagePath}"></c:out>">
			</td>

			<td>
			    <c:out value="${data.price}"></c:out>円
			    <input type="hidden" value="${data.price}" name="price"></input>
			</td>

			<td>
			    <c:out value="${data.count}"></c:out>個
				<input type="hidden" name="count" value="${data.count}"></input>
			</td>

			<td>
				<fmt:formatNumber maxFractionDigits="0" value="${data.price * data.count * 1.1}" />円
				<input class="subtotal" type="hidden" name="subtotal" value="${data.price * data.count}"></input>
			</td>
		</tr>
            </c:forEach>
    </table>

           <div id="total">
           </div>
           <div class="purcahse">
               <input type="submit" name="purchase_disicion" value="購入確定" formaction="PurchaseServlet">
               <input type="hidden" name="user_code" value="${sessionScope.userBean.userCode}">
               <input type="submit" name="back" value="戻る" formaction="GoToCartServlet"></input>
               <c:out value="${requestScope.messageBean.smsg}"></c:out>
           </div>
</form>

<!-- フッター -->
<footer>
	<hr>
	<a href="/ECSiteProject/GoToTopServlet">TOP</a>
	<a href="/ECSiteProject/GoToLoginServlet">ログイン</a>
	<a href="/ECSiteProject/LogoutServlet">ログアウト</a>
	<a href="/ECSiteProject/ItemListServlet">商品一覧</a>
	<a href="/ECSiteProject/GoToSearchServlet">商品検索</a>
	<a href="/ECSiteProject/GoToCartServlet">カート</a>
</footer>
</body>
<script type="text/javascript" src='<c:url value="/js/cart.js"/>'></script>
</html>