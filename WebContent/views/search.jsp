<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/item.css">
<head>
    <!-- 文字エンコーディングの指定 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>商品検索画面|MysteriousTeaParty</title>
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
            <form  class="cart" action="GoToCartServlet" method="get">
              <input type="image" src="http://localhost:8080/ECSiteProject/images/cart.png">
            </form>
        <hr>
    </header>

    <!-- メインコンテンツ -->
          <!-- 検索欄 -->
          <h2>商品検索</h2>
           <form class="search" action="./SearchItemServlet" method="post">

               <ul>
                <li>商品名
                   <input type="search" name="search" placeholder="キーワード入力">
                <li>色
                   <input type="checkbox" name="color" value="赤">赤
                   <input type="checkbox" name="color" value="青">青
                   <input type="checkbox" name="color" value="なし">なし
                <li>値段
                   <select name="price">
                     <option value="0"></option>
                     <option value="1000">1000～1999</option>
                     <option value="2000">2000～2999</option>
                     <option value="3000">3000～</option>
                   </select>
                 <input type="submit" name="search" value="検索">
               </ul>
           </form>

    <!-- 商品表示欄 -->
      <h2>検索結果商品一覧</h2>

          <table>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>画像</th>
		</tr>

		<c:forEach var="data" items="${searchItems}">
		  <form action="CartServlet" method="post">
			<tr>
				<td>
				   <c:out value="${data.name}"></c:out>
				</td>
				<td><c:out value="${data.price}"></c:out>円</td>
				<td><img src="<c:out value="http://localhost:8080/ECSiteProject/images/${data.imagePath}"></c:out>"></td>
                <td>
                    <input type="submit" name="register" value="購入"></input>
                    <input type="hidden" name="count" value="1"></input>
                    <input type="hidden" name="item_code" value="${data.itemCode}"></input>
                </td>
			</tr>
		 </form>
		</c:forEach>
	</table>

	    <div class="emsg">${requestScope.messageBean.emsg}</div>


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
