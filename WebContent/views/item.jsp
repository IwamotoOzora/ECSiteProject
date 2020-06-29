<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/item.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sort.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/css/theme.default.min.css">

<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src='<c:url value="/js/sort.js"/>'></script>

<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品一覧|MysteriousTeaParty</title>
</head>

<body>
    <!-- ヘッダー -->
    <header>
        <h1>MysteriousTeaParty</h1>
            <div class="message">ようこそ${sessionScope.userBean.userCode}さん</div>

            <!-- 検索欄 -->
            <form class="search" action="SearchItemServlet" method="get">
              <input type="search" name="search" placeholder="キーワード入力">
              <input type="submit" name="submit" value="検索">
            </form>

            <!-- カート -->
            <form  class="cart" action="GoToCartServlet" method="get">
              <input type="image" src="http://localhost:8080/ECSiteProject/images/cart.png">
            </form>
        <hr>
    </header>

    <!-- 商品一覧(メインコンテンツ) -->
      <h2>商品一覧</h2>

      <table class="tablesorter" id="list_items">

        <thead>
	     <tr>
			<th><span>&#10606;</span>商品名</th>
			<th><span>&#10606;</span>価格</th>
			<th><span>&#10606;</span></th>
		 </tr>
		</thead>


        <tbody>
		 <c:forEach var="data" items="${items}">
		  <tr>
			 <td class="item_name"><c:out value="${data.name}"></c:out></td>
			 <td class="item_price"><c:out value="${data.price}"></c:out>円</td>
			 <td><img src="<c:out value="http://localhost:8080/ECSiteProject/images/${data.imagePath}"></c:out>"></td>
             <td>
               <form action="CartServlet" method="post">
                 <input type="submit" name="register" value="購入"></input>
                 <input type="hidden" name="count" value=1></input>
                 <input type="hidden" name="item_code" value="${data.itemCode}"></input>
               </form>
            </td>
		  </tr>
		 </c:forEach>
        <tbody>
	  </table>



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

</html>