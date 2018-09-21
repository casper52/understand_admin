<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-12
  Time: 오후 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp"%>

<!-- 제목 -->
<table width="100%">
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">${result.get(0).question}</h3>
			</div>
		</div>
		
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div style="height: auto; max-width: 1080px; text-align: right;">
						현황이욤 후읍 </div>
					</div>
				</div>
				<div class="panel-body">
					<div class="panel panel-default">
						<div style="height: 1000px; max-width: 1080px; text-align: left">
							<c:forEach var="response" items="${result}" >
								<br>${response.mno}
								<br>${response.seatnum}
								<br>${response.name}
								<br>${response.reply}
								<br>${response.cmt}
								<br>${response.replydate}
							</c:forEach>
								<br><h1>${result.get(0).ratio}</h1>					
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</table>
							<a href="result?page=${page}">

								<button type="button" class="btn btn-outline btn-primary btn-sm">목록보기</button>
							</a>

<%@ include file="includes/footer.jsp"%>