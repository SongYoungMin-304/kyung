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
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="../vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	
	});
	
	 function deleteNoticeById(id){
	        if(confirm("글이 삭제됩니다!")==true){
	            location.href="/deleteNoticeById/"+id;
	        }
	        
	    };
	    
	    
		 function setNoticeById(id){
		        if(confirm("글을 수정 하시겠습니까?")==true){
		            location.href="/setNotice/"+id;
		        }
		        
		    };
	    
	   


</script>

</head>

<body id="page-top">

	<jsp:include page="./sidebar/top.jsp" flush="false" />



	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">공지 사항</h1>
		<!--           <p class="mb-4">공지 사항</p>
 -->

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<!--      <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div> -->

			<div class="card-body">
			 <table class="table table-striped"

               style="text-align: center; border: 1px solid #dddddd">

               <thead>
                  <tr>
                     <th colspan="2"
                        style="background-color: #eeeeee; text-align: left;"></th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td><div class="form-control"name="subject" id="subject" maxlength="50"  style ="text-align: left;" >${notice.subject}</td>
                  </tr>
                  <tr>
                     <td><div class="form-control" maxlength="2048" name="content" id="content" style="height: 350px; text-align: left;" >${notice.content}</td>
                  </tr>
               </tbody>
            </table>   

				<hr />


				<div class="table-responsive">
				<button type="button" class="btn btn-outline-secondary" onclick="deleteNoticeById(${notice.id})">삭제하기</button>
				<button type="button" class="btn btn-outline-secondary" onclick="setNoticeById(${notice.id})">수정하기</button>
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='/notice' ">목록으로</button>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->

	<!-- Footer -->
	<jsp:include page="./sidebar/bottom.jsp" flush="false" />

	<!-- Bootstrap core JavaScript-->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="../vendor/datatables/jquery.dataTables.min.js">
		
	</script>
	<script src="../vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../js/demo/datatables-demo.js"></script>


</body>

</html>
