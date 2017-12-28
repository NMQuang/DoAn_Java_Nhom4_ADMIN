<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!--Custom Font-->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!--[if lt IE 9]>
    <script src="<c:url value="/resources/js/html5shiv.min.js"/>"></script>
    <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    <![endif]-->
<style lang="css">
.logo {
	width: 213px;
	height: 100px;
	background: url('<c:url value="/resources/images/common/food.png"/>')
		no-repeat center;
	margin: 30px auto;
}

.login-block {
	width: 320px;
	padding: 20px;
	background: #fff;
	border-radius: 5px;
	border-top: 5px solid #ff656c;
	margin: 0 auto;
}

.login-block h1 {
	text-align: center;
	color: #000;
	font-size: 18px;
	text-transform: uppercase;
	margin-top: 0;
	margin-bottom: 20px;
}

.login-block > input {
	width: 100%;
	height: 42px;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 20px;
	font-size: 14px;
	font-family: Montserrat;
	padding: 0 20px 0 50px;
	outline: none;
}

.login-block input#username {
	background: #fff
		url('<c:url value="/resources/images/common/u0XmBmv.png"/>') 20px top
		no-repeat;
	background-size: 16px 80px;
}

.login-block input#username:focus {
	background: #fff
		url('<c:url value="/resources/images/common/u0XmBmv.png"/>') 20px
		bottom no-repeat;
	background-size: 16px 80px;
}

.login-block input#password {
	background: #fff
		url('<c:url value="/resources/images/common/Qf83FTt.png"/>') 20px top
		no-repeat;
	background-size: 16px 80px;
}

.login-block input#password:focus {
	background: #fff
		url('<c:url value="/resources/images/common/Qf83FTt.png"/>') 20px
		bottom no-repeat;
	background-size: 16px 80px;
}

.login-block input:active, .login-block input:focus {
	border: 1px solid #ff656c;
}

.login-block button {
	width: 100%;
	height: 40px;
	background: #ff656c;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #e15960;
	color: #fff;
	font-weight: bold;
	text-transform: uppercase;
	font-size: 14px;
	font-family: Montserrat;
	outline: none;
	cursor: pointer;
}

.login-block button:hover {
	background: #ff7b81;
}
</style>
</head>
<body style="background-color: #efeeda">
	<div class="container">

		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
			rel='stylesheet' type='text/css'>
		<div class="logo"></div>
		<form class="login-block" method="post">
			<h1>Login</h1>
			<c:if test="${!empty param.error}">
				<div id="fail" class="alert alert-danger">Thất bại. Vui
					lòng kiểm tra lại.</div>
			</c:if>
			<input type="text"  placeholder="Username"
				name="username" id="username"/>
			<input type="password"
				placeholder="Password" name="password" id="password"/>

			

            <div class="checkbox">
                        <label><input name="remember-me" type="checkbox">Ghi nhớ đăng nhập</label>
                    </div>
			<button type="submit">Submit</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</body>
</html>