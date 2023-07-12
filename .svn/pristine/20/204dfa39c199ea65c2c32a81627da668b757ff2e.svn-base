<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<title>휴가 신청 및 연차 조회</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정
	var pageSize = 10;     
	var pageBlockSize = 5;    
	
	
	//로그인 쿠키
	var loginID = null;
	
	/** OnLoad event */ 
	$(function() {
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		loginID = $("#loginID").val();
		fn_empVcpList();
		fn_vacaRemain();
		
		
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
					fn_data_validation();
					break;
				case 'btnBack' :
					gfCloseModal();
					break;
					
			}
		});
	}
	
	
	//개인휴가 리스트 뿌려주기
	function fn_empVcpList(pagenum) {
		
		IDCheck = false;
		
		pagenum = pagenum || 1;
		
		var param = {
			loginID : loginID
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listCallBack = function(returnvalue) {
			console.log(JSON.stringify(returnvalue));
			
			console.log(returnvalue);
			$("#listEmpVcp").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_empVcpList');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#empVcpPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/empVcp/vacaPersonalList.do", "post", "text", false, param, listCallBack) ;
			
	}
	
	
	//휴가신청폼 insert
	function fn_vacaFormInsert(){
		
		var param = {
				appro_type_cd : $("#appro_type_cd").val(),
				form_loginID : $("#form_loginID").val(),
				form_vaca_tel : $("#form_vaca_tel").val(),
				form_vaca_sdate : $("#form_vaca_sdate").val(),
				form_vaca_edate : $("#form_vaca_edate").val(),
				form_vaca_reson : $("#form_vaca_reson").val()
				
			} 
			
			
			var vacaInsertCallback = function (reval) {
				console.log(JSON.stringify(reval));
				if(reval.vacaApp > 0) {
					if(reval.approIn > 0) {
						if(reval.vacaApproUpdate > 0) {
							alert("신청되었습니다");
							gfCloseModal();
						}else {
							alert("결재번호등록오류");
						}
					}else {
						alert("결재등록오류");
					}
					
				}else {
					alert("신청오류");
				}
				fn_empVcpList();
			}
			
			callAjax("/empVcp/vacaInsertvcp.do", "post", "json", false, param, vacaInsertCallback) ;
				
				
		
		
	}
	
	//data유효성 체크
	function fn_data_validation() {
		var check=true;
		var form_vaca_tel = $("#form_vaca_tel").val();
		var form_vaca_sdate = $("#form_vaca_sdate").val();
		var form_vaca_edate = $("#form_vaca_edate").val();
		var form_vaca_reson = $("#form_vaca_reson").val();
		var valiList = [form_vaca_tel, form_vaca_sdate, form_vaca_edate, form_vaca_reson];
		for(var i in valiList) {
			console.log(valiList[i]);
			if(valiList[i] == null || valiList[i] == "") {
				check = false;
				break;
			}
		}
		console.log(check);
		
		//빈항목체크
		if(check == false) {
			alert("모든 항목을 채워주세요");
			return;
		}
		
		//휴가사유 글자제한
		if(form_vaca_reson.length > 200) {
			alert("휴가사유를 200자 이내로 적어주세요");
			return;
		}
		
		//날짜 체크
		form_vaca_sdate = parseInt(form_vaca_sdate.replace(/-/g,""));
		form_vaca_edate = parseInt(form_vaca_edate.replace(/-/g,""));
		console.log(form_vaca_sdate);
		
		if(form_vaca_sdate > form_vaca_edate){
			alert("휴가 시작 날짜와 종료 날짜를 정확히 입력해주세요");
			return;
		}
		
		fn_vacaFormInsert();
		
		
	}
	
	//textarea 글자수 표기
	function fn_textArea() {
		var totText = 200;
		//남은 글자 수
		var remainText;
		//현재 작성한 글자 수
		var vacaResonLength = $("#form_vaca_reson").val().length;
		//현재 남은 글자 수
		remainText = totText - vacaResonLength;
		
		if(remainText < 0 ) {
			$("#textAreaRemain").html("글자 수 초과").css("color","red");
			return;
		}
		
		$("#textAreaRemain").html(remainText + "/" + totText).css("color","black");
		
	}
	
	//휴가신청모달창 오픈
	function fn_openpopup1() {
		popupinit();
		// 모달 팝업
		gfModalPop("#vacaForm");
		fn_textArea();
			
	}
	//모달 초기화
	function popupinit() {
		$("#form_vaca_tel").val("");
		$("#form_vaca_sdate").val("");
		$("#form_vaca_edate").val("");
		$("#form_vaca_reson").val("");
	}
	
	//개인연차신청 상세 모달창 오픈
	function fn_openpopup2(vaca_no) {
		
		var param = {
			vaca_no : vaca_no
		}
		var vacaRejCallback = function (reval) {
			console.log(JSON.stringify(reval));
			$("#vaca_rej_info_detail").val(reval.rej);
		}
		callAjax("/empVcp/vacaRejDetailvcp.do", "post", "json", false, param, vacaRejCallback) ;
		
		gfModalPop("#vaca_rej_info");
	}
	
	
	
	function fn_vacaRemain () {
		
		var param = {
				loginID : loginID
		}
		
		var vacaRemainCallback = function (reval) {
			
			if(reval.length > 0) {
				$("#vacaTot").empty().append(reval[0].dt_va_tot);
				$("#vacaRemain").empty().append(reval[0].dt_vaca_rest);
			}else {
				$("#vacaTot").empty().append("0");
				$("#vacaRemain").empty().append("0");
			}
			
		}
		callAjax("/empVcp/vacaRemain.do", "post", "json", false, param, vacaRemainCallback) ;
	}
	
	

	
	
	
	
	


	
	
	
	
	
	
	
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="pageno"  name="pageno"  />
	<input type="hidden" id="loginID" name="loginID" value="${loginID}"/>
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
								class="btn_nav bold">인사</span> <span class="btn_nav bold">휴가 신청 및 연차 조회</a>
								<a href="../empVcp/vacaPersonal.do" class="btn_set refresh">새로고침</a>
						</p>
						<p class="conTitle">
								<span>휴가 신청 및 연차 조회</span><span class="fr">
								<a href="" class="btnType3 color1" id="btnVacaForm" name="btn" >휴가 신청</a>
								</span>
						</p>
						
							
						<!-- 휴가 신청 조회 리스트 -->
						<div class="empVcpList">
							
							<!-- 개인잔여연차 -->
							<div id="empVcpRemain" style="width:300px; text-align:center; margin:10px 0;">
								<table class="row">
									<caption>caption</caption>
									
			
									<tbody id="remainEmpVcp">
										<tr>
											<th scope="row">총연차</th>
											<td id="vacaTot"></td>
											<th scope="row">잔여연차</th>
											<td id="vacaRemain"></td>
											
										</tr>
									
									</tbody>
								</table>
							</div>
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
							<tbody id="listEmpVcp"></tbody>
						</table>
					</div>
	
						<div class="paging_area"  id="empVcpPagination"> </div>
						
                     
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	<!-- 휴가신청 모달 팝업 -->
	<div id="vacaForm" class="layerPop layerType2" style="width: 600px;">
		<!-- 결재유형코드 -->
		<input type="hidden" name="appro_type_cd" id="appro_type_cd" value="V"/>
		<dl>
			<dt>
				<strong>휴가 신청 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<span style="font-weight:900; font-size:20px">휴가 신청서</span>
				<table class="row" style="margin-top:10px;">
					<caption>caption</caption>
					<colgroup>
						<col width="20%">
						<col width="30%">
						<col width="20%">
						<col width="30%">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">사번 </th>
							<td><input type="text" class="inputTxt p100" name="form_loginID" id="form_loginID" value="${loginID}" readonly/></td>
							<th scope="row">비상연락처 </th>
							<td><input type="text" class="inputTxt p100" name="form_vaca_tel" id="form_vaca_tel" placeholder="ex) 010-0000-0000"/></td>
							
						</tr>
						<tr>
							<th scope="row">휴가시작일 </th>
							<td><input type="date" class="inputTxt p100" name="form_vaca_sdate" id="form_vaca_sdate" /></td>
							<th scope="row">휴가종료일 </th>
							<td><input type="date" class="inputTxt p100" name="form_vaca_edate" id="form_vaca_edate" /></td>
							
						</tr>
						<tr>
							<th scope="row">휴가사유 </th>
							<td colspan="3" rowspan="3"><textarea id="form_vaca_reson" name="form_vaca_reson" placeholder="200자 이내로 작성가능" onkeyup="fn_textArea()"></textarea><div id="textAreaRemain" ></div></td>
							
						</tr>
				
					</tbody>
				</table>
				
				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnVacaApp" name="btn"><span>신청</span></a> 
					<a href="" class="btnType blue" id="btnBack" name="btn"><span>취소</span></a> 
				</div>
			</dd>
		</dl>
	</div>
	
	
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