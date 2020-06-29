<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <head>
        <!-- 文字エンコーディングの指定 -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>ログイン画面｜MysteriousTeaParty</title>
    </head>
 <head>

<body>
 <header></header>
    <!-- 一般会員用ログイン -->
    <h1>ログイン</h1>

     <div class="emsg">
       ${requestScope.userBean.emsg}
       ${requestScope.administratorBean.emsg}
     </div>

      <div class="login-nomral">
        <div class="message">一般会員の方はこちら</div>
          <form action="./LoginServlet" method="post">

            <div class="text-input">
              <label for="user_code">会員番号:</label>
                <input type="text" name="user_code" id="user_code">
                <span class="separate"> </span>
            </div>

            <div class="text-input">
              <label for="password">パスワード:</label>
                <input type="password" name="password">
                <span class="separate"> </span>
            </div>

            <div class="button">
              <input type="submit" value="送信" class="form_button" name="normal">
            </div>

          </form>

          <form action="GoToTopServlet" method="get">
             <div class="button">
               <input type="submit" value="戻る" class="back_button" name="nomarl">
                <span class="separate"> </span>
             </div>
          </form>
      </div>

    <!-- 管理者用ログイン -->
    <div class="login-administrator">
      <div class="message">管理者はこちら</div>
        <form action="./LoginServlet" method="post">
          <div class="text-input">
            <label for="administrator_code">管理者番号:</label>
              <input type="text" name="administrator_code" id="administrator_code">
              <span class="separate"> </span>
          </div>

          <div class="text-input">
            <label for="password">パスワード:</label>
              <input type="password" name="password">
              <span class="separate"> </span>
          </div>

          <div class="button">
            <input type="submit" value="送信" class="form_button" name="administrator">
          </div>
        </form>
     </div>
 </body>
</html>