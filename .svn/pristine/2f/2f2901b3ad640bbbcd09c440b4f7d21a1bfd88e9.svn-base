<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<title>급여조회</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정
	var pageSize = 10;     
	var pageBlockSize = 5;    
	
	
	
	/** OnLoad event */ 
	$(function() {
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		
		$("#empSasTax").css("visibility","hidden");
		$("#empSasResult").css("visibility","hidden");
		
		//보험료율 팝업 띄우기
	 	$('#taxPer').hover(function() {
			$("#taxPopup").css("visibility","visible");
	  	}, function(){
	     	$("#taxPopup").css("visibility","hidden");
	  	});
		
		
	});
	

	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_empSasList1();
					fn_empSasList2();
					break;
				
			}
		});
	}
	
	
	
	//개인급여내역서 리스트 뿌려주기1
	function fn_empSasList1() {
		var searchLoginID = $("#searchLoginID").val();
		var  searchDate = $("#searchDate").val();
		
		if(searchLoginID != null && searchLoginID != "" &&
			searchDate != null && searchDate != "") {
			var param = {
				searchLoginID : searchLoginID
			  ,	searchDate : searchDate
			}
			
			$("#empSasTax").css("visibility","visible");
			
			var listCallBack = function(returnvalue) {
				console.log(JSON.stringify(returnvalue));

				//salSerchGrd append
				$("#listEmpSas1").empty().append(returnvalue);
			}
			callAjax("/empSas/salSerarchList1.do", "post", "text", false, param, listCallBack);
		}else {
			alert("사번이랑 날짜를 입력해 주세요");
		}
	}
	
	//개인급여내역서 리스트 뿌려주기2
	function fn_empSasList2() {
		var searchLoginID = $("#searchLoginID").val();
		var  searchDate = $("#searchDate").val();
		
		if(searchLoginID != null && searchLoginID != "" &&
			searchDate != null && searchDate != "") {
			var param = {
				searchLoginID : searchLoginID
			  ,	searchDate : searchDate
			}
			
			$("#empSasResult").css("visibility","visible");
			
			var listCallBack = function(returnvalue) {
				console.log(JSON.stringify(returnvalue));
				
				
				//salSerchGrd append
				$("#listEmpSas2").empty().append(returnvalue);
			}
			callAjax("/empSas/salSerarchList2.do", "post", "text", false, param, listCallBack);
		}else {
			alert("사번이랑 날짜를 입력해 주세요");
		}
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
								class="btn_nav bold">인사</span> <span class="btn_nav bold">급여조회</span> 
							<a href="../system/comnCodMgr.do" class="btn_set refresh">새로고침</a>
						</p>
						<p class="conTitle">
							<span>급여조회</span> 
							<span class="fr"> 
								
							</span>
									
						</p>
						<div style="display:flex; justify-content:center; align-content:center; line-height:2; border:solid 3px #c0c0c0; border-radius: 10px; padding:40px 40px; margin:20px auto;">									
							<!-- 사번, 년월 검색 -->
							<span style="font-size:15px; font-weight:bold; margin-right:10px;">사  번</span>
							<input type="text" style="height:30px; width:100px; margin-right:5px;" id="searchLoginID" name="searchLoginID" value="${loginID}" readonly>
							<input type="month" style="height:30px; width:100px; margin-right:5px;" id="searchDate" name="searchDate" >
							<a href="" class="btnType blue" id="btnSearch" name="btn"><span>검  색</span></a>
						</div>
						
						
						<!-- 개인급여내역서 조회 리스트 뿌리기 -->
						<div style="display:flex; flex-grow: 1; justify-content: space-evenly;">
							<div class="item" id="empSasTax" style="width:100%;margin-right: 10px">
								<table class="col">
									<caption>caption</caption>
									<colgroup>
										<col width="30%">
										<col width="30%">
										<col width="30%">
									</colgroup>
			
									<thead>
										<tr>
											<th scope="col">공제항목</th>
											<th scope="col">회사부담금</th>
											<th scope="col">개인부담금</th>
										</tr>
									</thead>
									<tbody id="listEmpSas1"></tbody>
								</table>
								
							</div>
							
							<!-- 개인급여내역서 조회 리스트 뿌리기 -->
							<div class="item" id="empSasResult" style="width:100%;">
								<table class="col">
									<caption>caption</caption>
									<colgroup>
										<col width="50%">
										<col width="50%">
									</colgroup>
			
									<thead>
										<tr>
											<th scope="col">지급항목</th>
											<th scope="col">금액</th>
										</tr>
									</thead>
									<tbody id="listEmpSas2"></tbody>
								</table>
								<!-- 보험료 몇퍼 떼는지 알려준다 (마우스 올리면 실행) -->
								<div style="margin-top:20px">
									<span style="border:1px; width:30px; height:10px;border-radius: 50%; background-color: gray; padding:3px;"><a id="taxPer" name="taxPer" style="color:white; ">?</a></span>
									<span id="taxPopup"  style="width: 100px;visibility:hidden; border:2px; padding:10px; borderColor: black; margin:10px;">
										<p>보험료율(근로자부담)</p>
										<ul>
											<li>국민연금: 4.5%</li>
											<li>건강보험: 3.43%</li>
											<li>고용보험: 0.8%%</li>
											<li>산재보험: 1.56%</li>
										</ul>	
									</span>
								
								</div>	
								<!-- 보험료율 모달팝업 (taxPer에 마우스 올리면 실행) -->
								
							</div>
							
						</div>
						
                    
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	
	
	
</form>
</body>
</html>