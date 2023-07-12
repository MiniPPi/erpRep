<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<title>발주내역조회</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정
	var pageSize = 10;     
	var pageBlockSize = 5;    
	
	
	//로그인 쿠키
	var loginIDck = null;
	
	/** OnLoad event */ 
	$(function() {
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		//로그인 쿠키값 넣어주기
		loginIDck = $("#loginIDck").val();
		
		// 제품 대분류
		productCombo("l","ltypecombo","all","","","","");  // combo type( l : 대분류   m : 중분류   s : 소분류) combo_name, type(기본값  all : 전체   sel : 선택) ,  대분류 코드, 중분류코드, 소분류 코드, ""
		
		// 제품 중분류
		$('#ltypecombo').change(function() {
			productCombo("m","mtypecombo","all",$("#ltypecombo").val(),"","","");   // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
			$("#ptypecombo option").remove();
		});
		
		// 제품
		$('#mtypecombo').change(function() {   
			productCombo("p","ptypecombo","all",$("#ltypecombo").val(),$("#mtypecombo").val(),"");   // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
		});
		
		//리스트 목록 뿌려주기
		fn_busDlvList();
		
		
	});
	

	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_busDlvList();
					break;
				case 'btnDlvForm' :
					fn_openpopup1();
					break;	
				case 'btnDlvInsert' :
					fn_data_validation();
					break;
				case 'btnBack' :
					gfCloseModal();
					break;
					
			}
		});
	}
	
	
	
	//개인휴가 리스트 뿌려주기
	function fn_busDlvList(pagenum) {
		
		pagenum = pagenum || 1;
		
		var param = {
			loginID : $("#loginID").val()
		  , dlv_sdate : $("#dlv_sdate").val()
		  , dlv_edate : $("#dlv_edate").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listCallBack = function(returnvalue) {
			console.log(JSON.stringify(returnvalue));
			
			console.log("reval"+returnvalue);
			$("#listBusDlv").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_busDlvList');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#busDlvPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/busDlv/deliveryInfoList.do", "post", "text", false, param, listCallBack) ;
			
	}
	
	
	
	//발주신청모달창 오픈
	function fn_openpopup1() {
		//모달 초기화
		popupinit();
		// 모달 팝업
		gfModalPop("#dlvForm");
			
	}
	//모달 초기화
	function popupinit() {
		$("#ltypecombo").val("");		
		$("#mtypecombo").val("");
		$("#ptypecombo").val("");
		$("#dlv_amt").val("");
	}
	//발주신청함수
	function fn_dlvInsert() {
		//발주수량제한
		var maxNum = 3;
		if($("#dlv_amt").val().length > maxNum) {
			alert("발주수량초과.3자리로 입력해주세요");
			return;
		}
		
		var param = {
				ltypecombo : $("#ltypecombo").val()
				,mtypecombo : $("#mtypecombo").val()
				,ptypecombo : $("#ptypecombo").val()
				,form_loginID : $("#form_loginID").val()
				,dlv_amt : $("#dlv_amt").val()
				,appro_type_cd : $("#appro_type_cd").val()
		}
		var dlvInsertCallback = function (reval) {
			
			console.log(reval.dlvApplication);
			if(reval.dlvApplication > 0) {
				if(reval.approIn > 0) {
					if(reval.dlvApproUpdate> 0) {
						alert("발주신청완료");
						gfCloseModal();
						fn_busDlvList();
					}else {
						alert("결재번호업데이트실패");
					}
					
				}else {
					alert("결재등록실패");
				}
			}else {
				alert("발주실패");
			}
			fn_busDlvList();
		}
		callAjax("/busDlv/dlvInsert.do", "post", "json", false, param, dlvInsertCallback) ;
	}
	
	//data유효성 체크
	function fn_data_validation() {
		var check=true;
		var ltypecombo = $("#ltypecombo").val();
		var mtypecombo = $("#mtypecombo").val();
		var ptypecombo = $("#ptypecombo").val();
		var dlv_amt = $("#dlv_amt").val();
		var valiList = [ltypecombo, mtypecombo, ptypecombo , dlv_amt];
		for(var i in valiList) {
			console.log(valiList[i]);
			if(valiList[i] == null || valiList[i] == "") {
				check = false;
				break;
			}
		}
		console.log(check);
		if(check == false) {
			alert("모든 항목을 채워주세요");
		}else {
			fn_dlvInsert();
		}
		
	}
	//반려사유조회 모달창 오픈
	function fn_openpopup2(dlv_no) {
		
		var param = {
			dlv_no : dlv_no
		}
		var dlvRejCallback = function (reval) {
			console.log(JSON.stringify(reval));
			$("#dlv_rej_info_detail").val(reval.rej);
		}
		callAjax("/busDlv/dlvRejDetail.do", "post", "json", false, param, dlvRejCallback) ;
		
		gfModalPop("#dlv_rej_info");
	}
	
	
	
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="pageno"  name="pageno"  />
	<input type="hidden" id="loginIDck" name="loginIDck" value="${loginID}"/>
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
								class="btn_nav bold">영업</span> <span class="btn_nav bold">발주내역조회</a>
								<a href="../busDlv/deliveryInfo.do" class="btn_set refresh">새로고침</a>
						</p>
						<p class="conTitle">
							<span>발주내역조회</span> <span class="fr">
							 <a class="btnType3 color1" id="btnDlvForm" name="btn" >발주신청</a>
							</span>
						</p>
						<div style="display:flex; justify-content:center; align-content:center; line-height:2; border:solid 3px #c0c0c0; border-radius: 10px; padding:40px 40px; margin:20px auto;">

								 
									<span style="font-size:15px; font-weight:bold; margin-right:10px;">주문자 사번</span>
									<input type="text" id="loginID" name="loginID" style="width: 150px; height: 25px; margin-right:5px;"/>
									<span style="font-size:15px; font-weight:bold; margin-right:10px;">발주일</span>
									<input type="date" id="dlv_sdate" name="dlv_sdate" style="height:30px; width:100px; margin-right:5px;"/>
									<span style="margin-right:5px; line-height:3;">-</span>
									<input type="date" id="dlv_edate" name="dlv_edate" style="height:30px; width:100px; margin-right:5px;"/>
									<a href="" class="btnType blue" id="btnSearch" name="btn"><span>검  색</span></a>
									 
								
							</p>
							
						</div>
							
						<!-- 휴가 신청 조회 리스트 -->
						<div class="busDlvList">
							
							<table class="col" style=" margin:10px 0;">
							<caption>caption</caption>
							<colgroup>
								<col width="6%">
								<col width="11%">
								<col width="21%">
								<col width="7%">
								<col width="13%">
								<col width="5%">
								<col width="8%">
								<col width="6%">
								<col width="8%">
								<col width="5%">
								<col width="5%">
							</colgroup>
	
							<thead>
								<tr>
									<th scope="col">발주번호</th>
									<th scope="col">납품기업</th>
									<th scope="col">제품명</th>
									<th scope="col">수량</th>
									<th scope="col">발주일자</th>
									<th scope="col">발주상태</th>
									<th scope="col">주문자</th>
									<th scope="col">결재번호</th>
									<th scope="col">결재자</th>
									<th scope="col">결재여부</th>
									<th scope="col">반려사유</th>
									
								</tr>
							</thead>
							<tbody id="listBusDlv"></tbody>
						</table>
					</div>
	
						<div class="paging_area"  id="busDlvPagination"> </div>
						
                     
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	
	<!-- 휴가신청 모달 팝업 -->
	<div id="dlvForm" class="layerPop layerType2" style="width:750px;">
		<!-- 결재유형코드 -->
		<input type="hidden" name="appro_type_cd" id="appro_type_cd" value="D"/>
		<dl>
			<dt>
				<strong>발주 신청 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<span style="font-weight:900; font-size:20px">발주 신청서</span>
				<div class="comcombo" ">
	                <table class="row">
	                   <caption>caption</caption>
	                   <colgroup>
	                      <col width="15%">
	                      <col width="15%">
	                      <col width="15%">
	                      <col width="15%">
	                      <col width="15%">
	                      <col width="15%">
	                   </colgroup>   
	                   <tbody>
	                      <tr>
	                      
	                        <th scope="row">제품 종류<span class="font_red">*</span></th>
	                        <td>
	                            <select id="ltypecombo" name="ltypecombo" style="width:100px"></select>
                            </td>
	                        <th scope="row">제품 중분류<span class="font_red">*</span></th>
	                        <td>
	                            <select id="mtypecombo" name="mtypecombo" style="width:100px"></select>
                           	</td>
	                        <th scope="row">제품<span class="font_red">*</span></th>
	                        <td>
	                            <select id="ptypecombo" name="ptypecombo" style="width:100px"></select>
                           	</td>   
                           	
                         </tr> 
                         <tr>
                         	<th scope="row">사번<span class="font_red">*</span> </th>
							<td colspan="2"><input type="text" class="inputTxt p100" name="form_loginID" id="form_loginID" value="${loginID}" readonly/></td>
							<th scope="row">수량 <span class="font_red">*</span></th>
							<td colspan="2"><input class="inputTxt p100" type="number" id="dlv_amt" name="dlv_amt"/></td>
							
                         </tr>  
                        
	                               
	                   </tbody>
	                </table>
	             </div>
				
				
				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnDlvInsert" name="btn"><span>신청</span></a>
					<a href="" class="btnType blue" id="btnBack" name="btn"><span>취소</span></a> 
				</div>
			</dd>
		</dl>
	</div>
	
	
	<!-- 반려사유 모달팝업-->
	<div id="dlv_rej_info" class="layerPop layerType2" style="width: 600px;">
		
		<dl>
			<dt>
				<strong>발주 신청 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<span style="font-weight:900; font-size:20px">반려사유</span>
				<table class="row" style="margin-top:10px;">
					

					<tbody>
						<tr>
							<td><input type="text" class="inputTxt p100" name="dlv_rej_info_detail" id="dlv_rej_info_detail" readonly/></td>
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