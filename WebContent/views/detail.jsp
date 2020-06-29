<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
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
            <form class="search" action="" method="get">
              <input type="search" name="search" placeholder="キーワード入力">
              <input type="submit" name="submit" value="検索">
            </form>

            <!-- カート -->
            <form  class="cart" action="" method="post">
              <input type="image" src="http://localhost:8080/ECSiteProject/images/cart.png">
            </form>
        <hr>
    </header>

    <!-- メインコンテンツ -->
    <!-- おすすめ商品掲載 -->
        <h2>商品詳細</h2>
        <img class="red" src="http://localhost:8080/ECSiteProject/images/magcup_red.jpg">

    <!-- フッター -->
    <footer>
        <hr>
          <a href="/ECSiteProject/GoToLoginServlet">ログイン</a>
          <a href="/ECSiteProject/LogoutServlet">ログアウト</a>
          <a href="/ECSiteProject/GoToItemServlet">商品一覧</a>
          <a href="?action=">商品検索</a>
          <a href="?action=">カート</a>
    </footer>

</body>

</html>
