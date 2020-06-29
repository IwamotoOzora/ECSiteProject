<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/administraition_register.css">
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理者用画面|商品登録画面</title>
</head>
<body>
    <h1>商品登録画面</h1>

      <div class="regist">登録内容</div>

        <div class="register_content">
          <form action="RegisterItemServlet" method="post">

           <div class="item_code">
			<label for="item_code">商品コード</label>
			<input type="text" name="item_code">
		   </div>

		   <div class="name">
			<label for="name">商品名</label>
			<input type="text" name="name">
		   </div>

		   <div class="price">
		    <label for="price">値段</label>
		    <input type="number" name="price" value=0>
		   </div>

		   <div class="color">
		    <label for="color">色</label>
		    <input type="text" name="color">
		   </div>

		   <div class="category">
		    <label for="category">カテゴリ</label>
		    <input type="text" name="category">
		   </div>

		   <div class="image">
		    <label for="image">イメージ画像</label>
		    <input type="file" name="image">
		   </div>

		   <div class="introduction">
		    <label for="introduction">商品紹介文</label>
		    <input type="text" name="introduction">
		   </div>

           <div class="button">
		     <button class="regist_button" type="submit" name="register">商品登録</button>
		     <button class="back_button" type="submit" name="back" formaction="GoToAdministrationServlet">戻る</button>
		   </div>

	      </form>
	    </div>

	    <div class="message">${requestScope.messageBean.smsg}</div>
	    <div class="message">${requestScope.messageBean.emsg}</div>
</body>
</html>