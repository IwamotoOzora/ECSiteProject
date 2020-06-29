<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/administration.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/administration_delete.css">
<title>管理者用画面|商品削除画面</title>
</head>
<body>
  <!-- 商品コード入力による商品情報表示と内容変更を記入するjsp -->
  <h1>商品削除画面</h1>
      <form action="ViewServlet" method="post" name="delete">
        <div class="member_no">
            <label for="member_no">商品コード</label>
            <input type="text" name="item_code" value="${requestScope.item.itemCode}">
            <button class="button" type="submit" name="view_delete">表示</button>
        </div>

        <div class="del">削除内容</div>
          <div class="delete">

		   <div class="name">
			<label for="name">商品名</label>
			<input type="text" name="name" value="${requestScope.item.name}" readonly>
		   </div>

		   <div class="price">
		    <label for="price">値段</label>
		    <input type="number" name="price" value="${requestScope.item.price}" readonly>
		   </div>

		   <div class="color">
		    <label for="color">色</label>
		    <input type="text" name="color" value="${requestScope.item.color}" readonly>
		   </div>

		   <div class="category">
		    <label for="category">カテゴリ</label>
		    <input type="text" name="category" value="${requestScope.item.category}" readonly>
		   </div>

		   <div class="image">
		    <label for="image">イメージ画像</label>
		    <img src="http://localhost:8080/ECSiteProject/images/${requestScope.item.imagePath}">
		    <input type="hidden" name="image_path" value="${requestScope.item.imagePath}"></input>
		   </div>

		   <div class="introduction">
		    <label for="introduction">商品紹介文</label>
		    <input type="text" name="introduction" value="${requestScope.item.introduction}" readonly>
		   </div>

		  </div>

         <div class="button">
		    <button class="delete_button" type="submit" name="delete" formaction="DeleteItemServlet">削除</button>
		    <button class="back_button" type="submit" name="back" formaction="./GoToAdministrationServlet">戻る</button>
		</div>
	</form>

	    <div class="message">${requestScope.messageBean.smsg}</div>
	    <div class="message">${requestScope.messageBean.emsg}</div>
</body>
</html>