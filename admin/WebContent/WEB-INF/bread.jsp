<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp"%>

<!-- 제목 -->
<table width="100%">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">${board.title}</h3>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div style="height: 100%; max-width: 1080px; text-align: right;">
                            no.${board.bno} by.${board.name} at ${board.regdate} 
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="panel panel-default">
                        <div style="height: 100%; max-width: ;  text-align: left">
                            <br>
                            ${board.cnt}
                            <br>
                         	
                            <a href="/getfile?fname=${board.addfile}"><img src="/getfile?fname=${board.addfile}" max-width=100% height=auto"/></a>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div style="height: 100%; max-width: 100%; text-align: right;">
                            <%--<form action="/modify">--%>
                                <a href="bmodify?bno=${board.bno}&page=${page}">

                                <input type="hidden" name="bno" value="${board.bno}">
                                <input type="hidden" name="page" value="${pageMaker.pageDTO.page}">
								
								<a href="/getfile?fname=${board.addfile}"><button class="btn btn-outline btn-primary btn-sm">첨부파일 다운로드</button></a>
                                <button class="btn btn-outline btn-primary btn-sm">수정 혹은 삭제</button>
                            <%--</form>--%>
                            <%-- <a href="reply?bno=${board.bno}&page=${page}"><button type="button" class="btn btn-outline btn-primary btn-sm">답글달기</button></a> --%>
                            <a href="list?page=${page}"><button type="button" class="btn btn-outline btn-primary btn-sm">목록보기</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</table>


<%@ include file="includes/footer.jsp"%>