<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<title>휴가신청내역</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정
	var pageSize = 10;     
	var pageBlockSize = 5;    
	
	
	//로그인체크 변수
	var IDCheck = false;
	
	
	/** OnLoad event */ 
	$(function() {
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		
		fn_empVcsList();
		
		
	});
	

	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_empVcsList();
					break;
				case 'btnVacaForm' :
					fn_openpopup1();
					break;
				case 'btnVacaApp' :
					fn_vacaFormInsert();
					break;
				case 'btnBack' :
					gfCloseModal();
					break;
					
			}
		});
	}
	
	
	//휴가신청리스트 뿌려주기
	function fn_empVcsList(pagenum) {
		
		IDCheck = false;
		
		pagenum = pagenum || 1;
		
		var param = {
			vaca_req_sdate : $("#vaca_req_sdate").val()
		  , vaca_req_edate : $("#vaca_req_edate").val()
		  , loginID : $("#loginID").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listCallBack = function(returnvalue) {
			console.log(JSON.stringify(returnvalue));
			
			console.log(returnvalue);
			$("#listEmpVcs").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_empVcsList');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#empVcsPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/empVcs/vacaSearchList.do", "post", "text", false, param, listCallBack) ;
			
	}
	
	
	
	//반려사유조회 모달창 오픈
	function fn_openpopup2(vaca_no) {
		
		var param = {
			vaca_no : vaca_no
		}
		var vacaRejCallback = function (reval) {
			console.log(JSON.stringify(reval));
			$("#vaca_rej_info_detail").val(reval.rej);
		}
		callAjax("/empVcs/vacaRejDetail.do", "post", "json", false, param, vacaRejCallback) ;
		
		gfModalPop("#vaca_rej_info");
	}
	
	

</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="pageno"  name="pageno"  />
	
	<!-- 모달 배경 -->
	<div id="mask"></div>

	<div id="wrap_area">

		<h2 class="hidden">header 영역</h2>
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

		<h2 class="hidden">컨텐츠 영역</h2>
		<div id="container">
			<ul>
				<li class="lnb">
					<!-- lnb 영역 --> <jsp:include
						page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
				</li>
				<li class="contents">
					<!-- contents -->
					<h3 class="hidden">contents 영역</h3> <!-- content -->
					<div class="content">

						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> <span
								class="btn_nav bold">인사</span> <span class="btn_nav bold">휴가신청내역</a>
								<a href="../empVcs/vacaSearch.do" class="btn_set refresh">새로고침</a>
						</p>
						<p class="conTitle">
								<span>휴가신청 내역</span> 
								
						</p>
						<div style="display:flex; justify-content:center; align-content:center; line-height:2; border:solid 3px #c0c0c0; border-radius: 10px; padding:40px 40px; margin:20px auto;">
							
								
									<!-- 휴가신청 범위 시작 -->
									<span style="font-size:15px; font-weight:bold; margin-right:10px;">신청일</span> 
									<input type="date" style="height:30px; width:100px; margin-right:5px;" id="vaca_req_sdate" name="vaca_req_sdate">
									<!-- 휴가신청 범위 끝 -->
									<span style="margin-right:5px; line-height:3;">-</span>
									<input type="date" style="height:30px; width:100px; margin-right:5px;" id="vaca_req_edate" name="vaca_req_edate">
									<!-- 사번 -->
									<span style="font-size:15px; font-weight:bold; margin-right:10px;">사번</span> 
									<input type="text" style="width: 150px; height: 25px; margin-right:5px;" id="loginID" name="loginID">
									<a href="" class="btnType blue" id="btnSearch" name="btn"><span>검  색</span></a>
								 
								
						</div>
						
						
						<!-- 휴가 신청 조회 리스트 -->
						<div class="empVcsList">
							<span id="calSalSpan" style="color:red;"></span>
							<table class="col">
							<caption>caption</caption>
							<colgroup>
								<col width="5%">
								<col width="7%">
								<col width="6%">
								<col width="8%">
								<col width="8%">
								<col width="8%">
								<col width="8%">
								<col width="6%">
								<col width="3%">
								<col width="3%">
							</colgroup>
	
							<thead>
								<tr>
									<th scope="col">휴가번호</th>
									<th scope="col">사번</th>
									<th scope="col">이름</th>
									<th scope="col">휴가신청일</th>
									<th scope="col">휴가시작일</th>
									<th scope="col">휴가종료일</th>
									<th scope="col">비상연락처</th>
									<th scope="col">결재자</th>
									<th scope="col">결재여부</th>
									<th scope="col">반려사유</th>
									
								</tr>
							</thead>
							<tbody id="listEmpVcs"></tbody>
						</table>
					</div>
	
						<div class="paging_area"  id="empVcsPagination"> </div>
						
                     
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	<!-- 반려사유 모달팝업-->
	<div id="vaca_rej_info" class="layerPop layerType2" style="width: 600px;">
		
		<dl>
			<dt>
				<strong>휴가 신청 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<span style="font-weight:900; font-size:20px">반려사유</span>
				<table class="row" style="margin-top:10px;">					
					<tbody>
						<tr>
							<td><input type="text" class="inputTxt p100" name="vaca_rej_info_detail" id="vaca_rej_info_detail" readonly/></td>
						</tr>
				
					</tbody>
				</table>
				
				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnBack" name="btn"><span>닫기</span></a> 
				</div>
			</dd>
		</dl>
	</div>
	
	<!--// 모달팝업 -->
</form>
</body>
</html>