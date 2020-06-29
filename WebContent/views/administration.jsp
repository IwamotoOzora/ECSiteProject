<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/administration.css">
<head>
    <!-- 文字エンコーディングの指定 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理者用画面</title>
</head>
<body>
    <h1>管理者用画面</h1>

    <div class="administrator">
      <form action="./ItemListServlet" method="get">

      <div class="button">
        <div>
          <input class="list_item" type="submit" value="商品一覧" name="list">
        </div>

        <div>
          <input class="register" type="submit" value="商品登録" formaction="GoToAdministrationRegisterServlet">
        </div>

        <div>
          <input class="update" type="submit" value="商品変更" formaction="GoToAdministrationUpdateServlet">
        </div>

        <div>
          <input class="delete" type="submit" value="商品削除" formaction="GoToAdministrationDeleteServlet">
        </div>

		<div>
		  <input type="submit" value="戻る" class="back_button" formaction="LogoutServlet">
		</div>
	   </div>

      </form>
    </div>

</body>
</html>