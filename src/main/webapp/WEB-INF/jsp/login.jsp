<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<html>

<head>

  <meta charset="euc-kr">
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Login Page</title>

  <!-- Custom fonts for this template-->
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  
  <link rel="stylesheet" type="text/css" href="css/sb-admin-2.min.css">
  <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.css">
  


</head>

<body class="bg-gradient-primary">

  <div class="container">
<h1></h1>
    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"><img src="img/song.png"  style="max-width: 103%; max-height: 100%;"></div>  <!--  --> 
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">관리자 페이지</h1>
                  </div>
                  <form class="user" action="/login" method="post">
                    <div class="form-group">
                      <input type="txt" name="username" class="form-control form-control-user" id="exampleInputEmail"  placeholder="아이디를 입력하시요">
                      <!-- aria-describedby="emailHelp"  -->
                    </div>
                    <div class="form-group">
                      <input type="password" name="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="비밀번호">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">로그인 정보 저장</label>
                      </div>
                    </div>
                   
                    <button type="submit"class="btn btn-primary btn-user btn-block">Login</button>

                    <hr>
                 <!--    <a href="index.html" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with Google
                    </a>
                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                    </a> -->
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="forgot-password.html">비밀번호 찾기</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="regist">회원가입</a>
                  </div>
                  <div> ${error}</div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  
  
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>


  <!-- Core plugin JavaScript-->

  
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>

  <!-- Custom scripts for all pages-->

  
  <script src="<c:url value="/resources/js/sb-admin-2.min.js" />"></script>

</body>

</html>
