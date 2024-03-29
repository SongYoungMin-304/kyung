<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

<meta charset="euc-kr">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>SB Admin 2 - Tables</title>


<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
   type="text/css">
<link
   href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
   rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      
       var table = $('#noticeTable').DataTable({
             "lengthChange": false,
             "pageLength": 5,
             "language": {
                 "emptyTable": "데이터가 없어요.",
                 "lengthMenu": "페이지당 _MENU_ 개씩 보기",
                 "info": "현재 _START_ - _END_ / _TOTAL_건",
                 "infoEmpty": "데이터 없음",
                 "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
                 "search": "에서 검색: ",
                 "zeroRecords": "일치하는 데이터가 없어요.",
                 "loadingRecords": "로딩중...",
                 "processing":     "잠시만 기다려 주세요...",
                 "paginate": {
                     "next": "다음",
                     "previous": "이전"
                 }
             },
         });
       
       
   });

</script>

</head>

<body id="page-top">

   <jsp:include page="./sidebar/top.jsp" flush="false" />



   <!-- Begin Page Content -->
   <div class="container-fluid">

      <!-- Page Heading -->
      <h1 class="h3 mb-2 text-gray-800">공지 사항 등록</h1>
      <!--           <p class="mb-4">공지 사항</p>
 -->

      <!-- DataTales Example -->
      <div class="card shadow mb-4">
         <!--      <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div> -->

         <div class="card-body">

               <form method="post" action="/addNoticeAction" method="post">

            <table class="table table-striped"

               style="text-align: center; border: 1px solid #dddddd">

               <thead>
                  <tr>
                     <th colspan="2"
                        style="background-color: #eeeeee; text-align: center;">게시판
                        글쓰기 양식</th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td><input type="text" class="form-control" placeholder="글 제목" name="subject" id="subject" maxlength="50"/></td>
                  </tr>
                  <tr>
                     <td><textarea class="form-control" placeholder="글 내용" maxlength="2048" name="content" id="content" style="height: 350px;"></textarea></td>
                  </tr>
               </tbody>
            </table>   
            <input type="submit" class="btn btn-primary pull-right" value="글쓰기" />
         </form>


            <div class="table-responsive"></div>
         </div>
      </div>

   </div>
   <!-- /.container-fluid -->

   </div>
   <!-- End of Main Content -->

   <!-- Footer -->
   <jsp:include page="./sidebar/bottom.jsp" flush="false" />

   <!-- Bootstrap core JavaScript-->
   <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

   <!-- Core plugin JavaScript-->
   <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

   <!-- Custom scripts for all pages-->
   <script src="js/sb-admin-2.min.js"></script>

   <!-- Page level plugins -->
   <script src="vendor/datatables/jquery.dataTables.min.js">
      
   </script>
   <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

   <!-- Page level custom scripts -->
   <script src="js/demo/datatables-demo.js"></script>


</body>

</html>