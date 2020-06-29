<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/item.css">
<title>管理者用画面|商品登録確認画面</title>
</head>
<body>
    <!-- 登録画面から入力された情報を表示するjsp -->
    <h1>商品登録確認画面</h1>
      <div class="register">登録商品一覧</div>
       <form action="RegisterDisicionServlet" method="post">
        <table class="register_item">
          <tr>
            <th id="itemCode">商品コード</th>
            <th id="name">商品名</th>
            <th id="price">価格</th>
            <th id="color">色</th>
          </tr>

          <tr>
             <td><input name="item_code" value="${requestScope.itemBean.itemCode}" readonly></input></td>
             <td><input name="name" value="${requestScope.itemBean.name}" readonly></input></td>
			 <td><input name="price" value="${requestScope.itemBean.price}" readonly></input></td>
			 <td><input name="color" value="${requestScope.itemBean.color}" readonly></input></td>
		  </tr>
        </table>

        <table>
          <tr>
            <th id="category">カテゴリ</th>
            <th id="imagePath">イメージ</th>
            <th id="introduction">紹介文</th>
          </tr>

          <tr>
            <td><input name="category" value="${requestScope.itemBean.category}" readonly></input></td>
			<td><img src="http://localhost:8080/ECSiteProject/images/${requestScope.itemBean.imagePath}">
			    <input type="hidden" name="image_path" value="${requestScope.itemBean.imagePath}"></input>
			</td>
			<td><input name="introduction" value="${requestScope.itemBean.introduction}" readonly></input></td>
          </tr>
        </table>
          <input type="submit" name="register" value="登録"></input>
          <input type="submit" name="back" value="戻る" formaction="GoToAdministrationRegisterServlet"></input>
       </form>
           <div class="message">${requestScope.messageBean.smsg}</div>
</body>
</html>