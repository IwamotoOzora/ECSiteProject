<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/item.css">
<title>管理者用画面|商品変更確認画面</title>
</head>
<body>
  <!-- 変更する商品の確認をするjsp -->
  <h1>商品削除確認画面</h1>
      <div class="delete">削除商品一覧</div>
       <form action="DeleteDisicionServlet" method="post">
        <table class="delete_item">
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
          <input type="submit" name="delete" value="削除"></input>
          <input type="submit" name="back" value="戻る" formaction="GoToAdministrationDeleteServlet"></input>
       </form>
           <div class="message">${requestScope.messageBean.smsg}</div>
</body>
</html>