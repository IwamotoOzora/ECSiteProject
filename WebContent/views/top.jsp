<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src='<c:url value="/js/slide.js"/>'></script>
<head>
    <!-- 文字エンコーディングの指定 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>TOP|MysteriousTeaParty</title>
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
            <form  class="cart" action="GoToCartServlet" method="get">
              <input type="image" src="http://localhost:8080/ECSiteProject/images/cart.png">
            </form>
        <hr>
    </header>

    <!-- メインコンテンツ -->
    <!-- おすすめ商品掲載 -->
     <div class="main">
        <h2>ようこそ</h2>
           <a href="/ECSiteProject/GoToLoginServlet">まずはログインしてください</a>
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

</html>
