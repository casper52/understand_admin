<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp"%>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">글을 등록해주세요</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">



			<form method="post" enctype="multipart/form-data">
				<p class="panel panel-default">
				<div class="panel-heading">원하는 글을 써주세요~</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form">
								<div class="form-group">
									<label>제목</label> <input class="form-control" name="title">
								</div>
								<div class="form-group">
									<label>작성자</label> 
									<input class="form-control"placeholder="Teacher" name="name" value="Teacher">
								</div>
								<div class="form-group">
									<label>내용</label>
									<input class="form-control"placeholder="Enter text" name="content">
								</div>
								<div class="form-group">
									<label>파일첨부</label> <input type="file" name="filename">
								</div>


								<button>등록</button>
							</form>
						</div>
						<!-- /.panel-body -->
					</div>

					<form action="list">
						<button>취소</button>
					</form>

				</div>




				<%@ include file="includes/footer.jsp"%>