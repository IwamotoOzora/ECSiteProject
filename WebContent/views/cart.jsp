<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	  href="${pageContext.request.contextPath}/css/item.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>買い物カゴ|MysteriousTeaParty</title>
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<h1>MysteriousTeaParty</h1>
		<div class="message">ようこそ${sessionScope.userBean.userCode}さん</div>

		<!-- 検索欄 -->
		<form class="search" action="SearchItemServlet" method="post">
			<input type="search" name="search" placeholder="キーワード入力">
			<input type="submit" name="submit" value="検索">
		</form>

		<!-- カート -->
		<form class="cart" action="GoToCartServlet" method="get">
			<input type="image"
				   src="http://localhost:8080/ECSiteProject/images/cart.png">
		</form>
		<hr>
	</header>

	<!-- カート -->
	<h1>カート</h1>
	<c:out value="${requestScope.messageBean.smsg}"></c:out>

   <div class="cart">
    <form action="CartServlet" method="post">
		<hr>
		<table>
			<tr>
				<th>商品名  </th>
				<th>イメージ画像  </th>
				<th>価格(税抜き)</th>
				<th>個数</th>
				<th>小計(税込み)</th>
				<th></th>
			</tr>

			<c:forEach var="data" items="${carts}">
				<form action="CartServlet" method="post">
					<input type="hidden" value="${sessionScope.userBean.userCode}"
						   name="user_code">
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
					    <input type="number" name="count"value="${data.count}" min="1" max="10" step="1" placeholder="最大10個">
					    <input type="hidden" value="${data.count}"></input>
						<input type="submit" name="update" value="数量変更">
					</td>

                    <td>
					    <fmt:formatNumber maxFractionDigits="0" value="${data.price * data.count * 1.1}"/>円
					    <input type="hidden" class="subtotal" name="subtotal" value="${data.price * data.count}"></input>

					</td>

					<td>
					    <input type="submit" name="delete" value="削除"></input>
					</td>
				</tr>
              </form>
			</c:forEach>
		</table>

			<div id="total">
			</div>
			<div>
			    <input type="submit" name="purchase" value="購入" formaction="PurchaseServlet">
			    <input type="submit" name="purchase_history" value="購入履歴" formaction="GoToHistoryServlet">
			</div>
    </form>
   </div>

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