<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp"%>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">질문을 등록해주세요.</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">



            <form method="post">
                <p class="panel panel-default">
                <div class="panel-heading">
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form">
                                <div class="form-group">
                                    <label>질문</label>
                                    <select name="question">
  										<option value="혹시 더 설명이 필요할까요?">혹시 더 설명이 필요할까요?</option>
  										<option value="제안드린 기간까지 가능하겠어요?">제안드린 기간까지 가능하겠어요?</option>
  										<option value="복습시간 필요하세요?">복습시간 필요하세요?</option>
  										<option value="완성까지 얼마나 필요하세요?">완성까지 얼마나 필요하세요?</option>
  										<option value="점심 뭐 드셨어요?">점심 뭐 드셨어요?</option>
									</select>
                                </div>
                                <div class="form-group">
                                    <label>응답 제한시간</label>
                                    <input class="form-control" placeholder="Enter text" name="limittime"  >
                                    <h6>*분 단위로 입력 바랍니다. 미입력 시 1분 제한시간으로 자동 생성됩니다.</h6>
                                </div>

                                <button>등록</button>
                            </form>
                    </div>
                    <!-- /.panel-body -->
                </div>

            <form action = "qlist">
                <button>취소</button>
            </form>

        </div>




<%@ include file="includes/footer.jsp"%>