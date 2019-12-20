<%--
  Created by IntelliJ IDEA.
  User: LazovoyOV
  Date: 13.11.2019
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Пользователи</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Custom style -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript"></script>
</head>
<body>
<div class="container">
<p><a href="/main.jsp">Назад</a></p>
<%--
<div>
    <h3>Окно регистрации</h3>
    <style>
        label {
            width: 150px;
            display: inline-block;
        }
    </style>
    <form action="users" method="post" target="_self">
        <p>
            <label for="name">Укажите имя: </label>
            <input id="name" type="text" name="firstName" placeholder="Ваше имя?" required>
        </p>
        <p>
            <label for="surname">Укажите фамилию: </label>
            <input id="surname" type="text"  name="lastName" placeholder="Ваша фамилия?" required>
        </p>
        <p><button class="btn btn-success btn-mg" type="submit" >Отправить</button>    <button  class="btn btn-warning btn-mg" type="reset">Очистить</button></p>
    </form>
</div>
--%>
    <div>
        <p><h3>Список зарегистрированных пользователей</h3></p>

                    <p>
                    <table border="0" frame="border" rules="all">
                    <col width="100" valign="top">
                    <col width="100" valign="top">
                        <c:choose>
                        <c:when test="${fn:length(users) gt 0}">
                        <tr>
                            <th>Фамилия</th><th>Имя</th>
                        </tr>
                        <c:forEach items="${users}" var="a">
                                 <tr>
                                     <td>${a.lastName}</td>
                                     <td>${a.firstName}</td>
                                 </tr>
                        </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <h5>Нет</h5>
                        </c:otherwise>
                        </c:choose>

                    </table>
                </p>

   </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
