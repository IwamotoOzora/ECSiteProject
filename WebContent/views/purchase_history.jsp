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
    <body>
      <h2>購入履歴</h2>
        <form action="PurchaseHistoryServlet" method="post">
          <input type="submit" name="history" value="購入履歴"></input>
          <input type="hidden" name="user_code" value="${sessionScope.userBean.userCode}"></input>
        </form>

          <c:out value="${requestScope.messageBean.smsg}"></c:out>
          <c:out value="${requestScope.messageBean.emsg}"></c:out>

          <table>
		<tr>
			<th>商品名</th>
			<th>個数</th>
			<th>小計</th>
			<th>購入日</th>
		</tr>

           <c:forEach var="data" items="${histories}">
		<tr>
			<td>
			    <c:out value="${data.name}"></c:out>
			    <input type="hidden" name="name" value="${data.name}"></input>
		    </td>

			<td>
			    <c:out value="${data.count}"></c:out>個
				<input type="hidden" name="count" value="${data.count}"></input>
			</td>

            <td>
                <c:out value="${data.total}"></c:out>円
            </td>

			<td>
				<c:out value="${data.purchaseDate}"></c:out>
			</td>
		</tr>
            </c:forEach>
    </table>
     </body>

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