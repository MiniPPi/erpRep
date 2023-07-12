<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>계정과목관리</title>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">

<script type="text/javascript">

	//// 페이징 설정
	var pageSize = 5;     
	var pageBlockSize = 5;    
	
	var pageDSize = 10;
	var pageDBlockSize = 5;
	
	
	/** OnLoad event */ 
	$(function() {
		
		// 부서 콤보    상세코드테이블의 상세코드, 상세코드명 으로 만듬   
		comcombo("dep_cd","deptcombo","all","");   // group_code, combo_name, type(기본값  all : 전체   sel : 선택)    , selvalue(선택 되어 나올 값)         
		
		// combo box 종류  acc : 회계 계정     조회 대상 테이블  tb_acnt_sbject   
		selectComCombo("acc","acccombo","all","","");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , "", "" 
		
		// combo box 종류  accd : 상세 회계계정   acccombo 변경시 계정 상세 재조회 event   조회 대상 테이블  tb_dt_sbject   
		$('#acccombo').change(function() {   
			selectComCombo("accd","accdcombo","all",$('#acccombo').val(),"");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
		});
		
		// combo box 종류  cli : 거래처    조회 대상 테이블  tb_clnt   
		selectComCombo("cli","clicombo","all","","");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , "", "" 
		
		// combo box 종류  pro : 제품 전체   조회 대상 테이블  tb_product   
		selectComCombo("pro","proallcombo","all","","");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , "", "" 
		
		
// 		// 제품 대분류
// 		productCombo("l","ltypecombo","all","","","","");  // combo type( l : 대분류   m : 중분류   s : 소분류) combo_name, type(기본값  all : 전체   sel : 선택) ,  대분류 코드, 중분류코드, 소분류 코드, ""
		
// 		// 제품 중분류
// 		$('#ltypecombo').change(function() {
// 			productCombo("m","mtypecombo","all",$("#ltypecombo").val(),"","","");   // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
// 			$("#stypecombo option").remove();
// 			$("#ptypecombo option").remove();
// 		});
		
// 		// 제품 소분류
// 		$('#mtypecombo').change(function() {   
// 			productCombo("s","stypecombo","all",$("#ltypecombo").val(),$("#mtypecombo").val(),"","");   // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
// 			$("#ptypecombo option").remove();
// 		});		
		
// 		// 제품
// 		$('#stypecombo').change(function() {   
// 			productCombo("p","ptypecombo","all",$("#ltypecombo").val(),$("#mtypecombo").val(),$("#stypecombo").val(),"");   // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
// 		});
		
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		
		fn_accAcmList();
	});
	

	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_accAcmList();
					break;
				case 'btnSave' :
					$("#action").val("I");	
					fn_bigInsert();
					break;	
				case 'btnDelete' :
					$("#action").val("D");	
					fn_save();
					break;	
				case 'btnDeleteFile' :
					$("#action").val("D");	
					fn_savefile();
					break;		
				case 'btnSaveFile' :
					$("#action").val("I");	
					fn_smallInsert();
					break;	
				case 'btnClose' :
				case 'btnCloseFile' :
					gfCloseModal();
					break;
			}
		})
	};
	
	// 중복검사 - 계정대분류 코드
// 	function fn_LAccCdChk(saveyn) {
		
// 		var returnval = "N";
		
// 		if(!fn_Validate()){
// 			$("#chkLCd").val("0");
// 			return "N";
// 			//빈값이면 false가 true로 되면서 N 반환
// 			//값이 있으면 true가 false가 되어서 else 절로 이동
			
// 		} else {
			
// 			$.ajax({
				
// 				type : "post"
// 				, url : "/accAcm/LCdDupChk.do"
// 				, data : { acnt_sbject_cd : $("#acnt_sbject_cd").val()}
// 				, dataType : "json"
// 				, async : false
// 				, success : function(result) {
// 					console.log("AJAX 성공")
// 					console.log(result)
					
					
					
// 					if(result==1){
// 						console.log("중복")
// 						swal("이미 해당 코드가 있습니다. 다른 코드를 입력해주세요.");
// 						$("#chkLCd").val("0");
						
// 						returnval = "N";
						
// 					}else if (result == 0){
// 						console.log("중복아님")
						
// 						if(saveyn != "Y") {
// 							swal("사용가능한 계정코드입니다.");
// 						}
						
// 						$("#chkLCd").val("1");
// 						returnval = "Y"
// 					}
// 					return returnval;
// 				}
// 				,error : function() {
// 					console.log("AJAX 실패")
// 				}
// 			})
// 		}
// 	};


	// 중복검사 - 계정대분류 코드
	function fn_LAccCdChk(saveyn) {
		
		var returnval = "N";
		var LcdChk = /^[0-9]{4}$/;
		var LCdValue = $("#acnt_sbject_cd").val();
		
		
		if(!fn_Validate()){
			$("#chkLCd").val("0");
			return "N";
			//빈값이면 false가 true로 되면서 N 반환
			//값이 있으면 true가 false가 되어서 else 절로 이동
			
		} else {
			
				if(LcdChk.test(LCdValue) == false){
					console.log("하하하 숫자하하하")
					swal("계정코드는 4자리 숫자만 가능합니다.").then(function() {$("#acnt_sbject_cd").focus()})
					return "N";
				} 
				
			$.ajax({
				
				type : "post"
				, url : "/accAcm/LCdDupChk.do"
				, data : { acnt_sbject_cd : $("#acnt_sbject_cd").val()}
				, dataType : "json"
				, async : false
				, success : function(result) {
					console.log("AJAX 성공")
					console.log(result)
					
	
					if(result==1){
						console.log("중복")
						swal("이미 해당 코드가 있습니다. 다른 코드를 입력해주세요.");
						$("#chkLCd").val("0");
						
						returnval = "N";
						
					}else if (result == 0){
						console.log("중복아님")
						
						if(saveyn != "Y") {
							swal("사용가능한 계정코드입니다.");
						}
						
						$("#chkLCd").val("1");
						returnval = "Y"
					}
					return returnval;
				}
				,error : function() {
					console.log("AJAX 실패")
				}
			})
		}
	};
	
	
	// 중복검사 - 계정상세 코드
	function fn_SAccDtCdChk(saveyn) {
		
		var returnval = "N";
		var DtcdChk = /^[0-9]{4}$/;
		var DtCdValue = $("#acnt_dt_sbject_cd").val();
		
		if(!fn_SValidate()){
			return "N";
			//값이 없으면 fn_SValidate -> false --> !fn_SValidate() - true : 값 없을 때  return "N" ---> fn_bigInsert에서 else 구문 실행
			//값이 있으면 fn_SValidate -> true --> !fn_SValidate() - false : 값 있을 때 아래 Ajax 실행
			
		} else {
			
			if(DtcdChk.test(DtCdValue) == false){
				console.log("하하하 숫자하하하")
				swal("계정코드는 4자리 숫자만 가능합니다.").then(function() {$("#acnt_dt_sbject_cd").focus()})
				return "N";
				} 
			
			
			$.ajax({
				
				type : "post"
				, url : "/accAcm/SCdDupChk.do"
				, data : { acnt_dt_sbject_cd : $("#acnt_dt_sbject_cd").val()}
				, dataType : "json"
				, async : false
				, success : function(result) {
					console.log("AJAX 성공")
					console.log(result)
					
					
					
					if(result==1){
						console.log("중복")
						swal("이미 해당 코드가 있습니다. 다른 코드를 입력해주세요.");
						$("#chkLNm").val("0");
						
						returnval = "N";
						
					}else if (result == 0){
						console.log("중복아님")
						
						if(saveyn != "Y") {
							swal("사용가능한 상세코드입니다.");
						}
						
						$("#chkLNm").val("1");
						returnval = "Y"
					}
					return returnval;
				}
				,error : function() {
					console.log("AJAX 실패")
				}
			})
		}
	};

	
	
	
	// 계정대분류 조회
	function fn_accAcmList(pagenum) {
		
		pagenum = pagenum || 1;
		
		var param = {
			acnt_sbjct_inout : $("#acnt_sbjct_inout").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listcollabck = function(returnvalue) {
			console.log(returnvalue);
			
			$("#listnaccAcm").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_accAcmList');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#accAcmPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/accAcm/accManagementList.do", "post", "text", false, param, listcollabck) ;
			
	}
	
	
	function fn_accAcmSListSearch(currentPage, LL_acnt_sbject_cd, LL_acnt_sbject_name) {
		
		
		console.log("dddddddddddddddddddddddd" + $("#LL_acnt_sbject_cd").val());
		
		$("#tmpAcnt_sbject_cd").val(LL_acnt_sbject_cd);
		$("#tmpAcnt_sbject_name").val(LL_acnt_sbject_name);
		
		console.log("파람뽑기001" + $("#tmpAcnt_sbject_cd").val());
		console.log("파람뽑기002" + $("#tmpAcnt_sbject_name").val());
		
		fn_accAcmSList(currentPage);
		
	}
	
	
	/** 계정상세 목록 조회 */
	function fn_accAcmSList(currentPage) {
		
		currentPage = currentPage || 1;
		
		// 그룹코드 정보 설정
		
		
		var param = {
					acnt_sbject_cd : $("#tmpAcnt_sbject_cd").val()
					, acnt_sbject_name : $("#tmpAcnt_sbject_name").val()
				,	currentPage : currentPage
				,	pageSize : pageDSize
		}
		
		var resultCallback = function(data) {
			
			console.log("히히히" + param.acnt_sbject_cd);
			console.log("히히히 이름 형0" + param.acnt_sbject_name);
			console.log("히히히 이름 형" + JSON.stringify(param.acnt_sbject_name));
			
			accAcmDResult(data, currentPage);
		};
		
		callAjax("/accAcm/accAcmSList.do", "post", "text", true, param, resultCallback);
	}
	
	
	/** 상세코드 조회 콜백 함수 */
	function accAcmDResult(data, currentPage) {
		
		// 기존 목록 삭제
		$('#accAcmDResultList').empty().append(data); 

		
		// 총 개수 추출
		var totalCount = $("#totalCount").val();		
	
		
		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCount, pageDSize, pageDBlockSize, 'fn_accAcmSList');
		$("#accSLPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPageComnDtlCod").val(currentPage);
	}
	
	
	
	
	
	
	function fn_openpopup() {
		
		popupinit();
		
		// 모달 팝업
		gfModalPop("#layer1");
		
		
	}
	
	
	function popupinit(object) {
		
		if(object == "" || object == null || object == undefined) {

			$("#acnt_sbject_cd").val("");		
			$("#acnt_sbject_name").val("");

			$("#btnDelete").hide();
			
			$("#action").val("I");	

		} else {
			return;
		}
	}
	
	
	function fn_InitFormAccDtlCod(object) {
		
		var acnt_sbject_cd = $("#tmpAcnt_sbject_cd").val();
		var acnt_sbject_name = $("#tmpAcnt_sbject_name").val();
		
		if( object == "" || object == null || object == undefined) {
			
		$("#acnt_sbject_namee").val(acnt_sbject_name);
		$("#acnt_sbject_namee").attr("readonly", true);
		$("#acnt_sbject_cdd").val(acnt_sbject_cd);
		$("#acnt_sbject_cdd").attr("readonly", true);
		
		$("#acnt_dt_sbject_cd").val("");
		$("#acnt_dt_sbjct_name").val("");
			
		} else {
			
		return;
		}
		
		console.log("끼랄랄" + $("#tmpAcnt_sbject_cd").val());
		console.log("끼랄랄22" + acnt_sbject_cd);
		console.log("끼랄랄" + $("#tmpAcnt_sbject_name").val());
		console.log("끼랄랄34" + acnt_sbject_name);
		
			
			$("#btnDelete").hide();
			
			$("#action").val("I");	
			
	}
	

	function fn_bigInsert() {

		
		
		if(fn_LAccCdChk("Y") == "N") {
			return;
		} else {
			
			 if ($("#chkLCd").val() == "0") {
					swal("계정코드 중복확인을 진행해주세요.").then(function() {
						$("#acnt_sbject_cd").focus();
					  })
				return;	  
			 };
			 
			
			var param = {
					action : $("#action").val(),
					acnt_sbject_cd : $("#acnt_sbject_cd").val(),
					acnt_sbject_name : $("#acnt_sbject_name").val(),
					acnt_sbjct_inout : $("#M_acnt_sbjct_inout").val()
					
			}
			
			var savecollback = function(reval) {
				console.log( JSON.stringify(reval) );
				
				if(reval.returncval > 0) {
					alert("저장 되었습니다.");
					gfCloseModal();
					
					if($("#action").val() == "U") {
						fn_accAcmList($("#pageno").val());
					} else {
						fn_accAcmList();
					}
				}  else {
					alert("오류가 발생 되었습니다.");				
				}
			}
			
			callAjax("/accAcm/bigInsert.do", "post", "json", true, $("#myForm2").serialize() , savecollback) ;
			
			
		}
		

		
	}
	
	function fn_smallInsert() {
		
		
		if(fn_SAccDtCdChk("Y") == "N") {
			return;
		} else {
			
			 if ($("#chkLNm").val() == "0") {
					swal("계정상세코드 중복확인을 진행해주세요.").then(function() {
						$("#acnt_sbject_cd").focus();
					  })
				return;	  
			 };
			 
		
		
		var param = {
				action : $("#action").val(),
				acnt_sbject_cd : $("#acnt_dt_sbject_cd").val(),
				acnt_sbject_name : $("#acnt_dt_sbjct_name").val(),
		}
		
		var savecollback = function(reval) {
			console.log( JSON.stringify(reval) );
			
			if(reval.returncval > 0) {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					fn_accAcmSList($("#pageno").val());
				} else {
					fn_accAcmSList();
				}
			}  else {
				alert("오류가 발생 되었습니다.");				
			}
		}
		

		callAjax("/accAcm/smallInsert.do", "post", "json", false, $("#myForm2").serialize() , savecollback) ;
		
	}
	}
	
	function fn_Validate() {

		
		
		var chk = checkNotEmpty(
				[
						[ "acnt_sbject_cd", "새로 만들 계정 대분류 코드를 입력해 주세요." ]
					,	[ "acnt_sbject_name", "새로 만들 계정 대분류 이름을 입력해 주세요" ]
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	
	function fn_SValidate() {

		var chk = checkNotEmpty(
				[
						[ "acnt_dt_sbject_cd", "새로 만들 계정 상세 코드를 입력해 주세요." ]
					,	[ "acnt_dt_sbjct_name", "새로 만들 계정 상세 이름을 입력해 주세요" ]
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	
	
	
	
	
	
	/** 상세코드 모달 실행 */
	function fn_accDtlPop(tmpAcnt_sbject_cd, tmpAcnt_sbject_name) {
		
		
		
		// 신규 저장
		if (tmpAcnt_sbject_cd == null || tmpAcnt_sbject_cd=="") {
			
			
			if ($("#tmpAcnt_sbject_name").val() == "") {
				swal("그룹 코드를 선택해 주세요.");
				return;
			}
		
			$("#action").val("I");
			
			
			// 상세코드 폼 초기화
			fn_InitFormAccDtlCod();
			
			// 모달 팝업
			gfModalPop("#layer2");

// 		수정 저장
		} else {
			
			return;
		}
	}
	
	
	
	
	
	
	
	//유효성검사
	
	
	
	
</script>

</head>
<body>
<form id="myForm" action=""  method="">

	
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
								class="btn_nav bold">회계</span> <span class="btn_nav bold">계정과목 관리
								</span> <a href="../accAcm/accManagement.do" class="btn_set refresh">새로고침</a>
						</p>
                        
                        
                        
                        
						<p class="conTitle">
							<span>계정과목 관리</span> <span class="fr"> 
							<a href="javascript:fn_openpopup();" name="modal"><span style=" color: black; display: inline-block; border: 3px solid #c0c0c0; padding: 7px 30px 7px 30px; font-weight: bold; font-size: 15px; background: #c0c0c0; border-radius: 2px;">신규등록</span></a>
							</span>
						</p>
						
						
<!-- 						<div style="height: 50px;  float: right; margin-right: 25px;"> -->
<!-- 							<label for="acnt_sbjct_inout" style=" font-size: 15px; font-weight: bold; margin-right: 10px;">구분</label> -->
<!-- 							<select id="acnt_sbjct_inout" name="acnt_sbjct_inout" style="width: 150px; margin-right: 30px;"> -->
<!-- 							        <option value="" >전체</option> -->
<!-- 									<option value="1" >수입</option> -->
<!-- 									<option value="2" >비용</option> -->
<!-- 							</select>  -->
							
<!-- 							<div style="display: inline-block; border: 3px solid #c0c0c0; padding: 5px 40px 5px 40px; font-weight: bold; font-size: 15px; background: #c0c0c0; border-radius: 2px;"><a href="" id="btnSearch" name="btn"><span style=" color: black;">검&nbsp;색</span></a></div> -->
<!-- 						</div>	 -->

						<div style="height: 30px;  text-align: center; border: 3px solid #c0c0c0;  border-radius: 10px; padding-top: 13px; padding-bottom: 13px; margin-bottom: 20px; margin-top: 20px;">
							<label for="acnt_sbjct_inout" style=" font-size: 15px; font-weight: bold; margin-right: 10px;">구분</label>
							<select id="acnt_sbjct_inout" name="acnt_sbjct_inout" style="width: 150px; margin-right: 30px;">
							        <option value="" >전체</option>
									<option value="1" >수입</option>
									<option value="2" >비용</option>
							</select> 
							
							<div style="display: inline-block; border: 3px solid #c0c0c0; padding: 5px 40px 5px 40px; font-weight: bold; font-size: 15px; background: #c0c0c0; border-radius: 2px;"><a href="" id="btnSearch" name="btn"><span style=" color: black;">검&nbsp;색</span></a></div>
						</div>	
							
						<div class="noticeList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="20%">
									<col width="40%">
									<col width="40%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">구분</th>
										<th scope="col">계정 대분류코드</th>
										<th scope="col">계정 대분류명</th>
									</tr>
								</thead>
								<tbody id="listnaccAcm"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="accAcmPagination"> </div>
						
						<p class="conTitle mt50">
							<span>계정 상세 코드</span> <span class="fr"> 
							<a class=""  href="javascript:fn_accDtlPop();" name="modal">
							<span style=" color: black; display: inline-block; border: 3px solid #c0c0c0; padding: 7px 30px 7px 30px; font-weight: bold; font-size: 15px; background: #c0c0c0; border-radius: 2px;">신규등록</span>
							</a>
							</span>
						</p>
	
						<div class="divComDtlCodList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="15%">
									<col width="20%">
									<col width="20%">
									<col width="25%">
									<col width="20%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">구분</th>
										<th scope="col">계정 대분류명</th>
										<th scope="col">계정 상세코드</th>
										<th scope="col">계정 상세명</th>
										<th scope="col">비고</th>
									</tr>
								</thead>
								<tbody id="accAcmDResultList">
									<tr>
										<td colspan="12">그룹코드를 선택해 주세요.</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<div class="paging_area"  id="accSLPagination"> </div>
    
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div><!-- containeron -->
	</div> <!-- wrap_area -->

	<!-- 모달팝업 -->
	  <form id="myForm2" >
	  	<input type="hidden" id="action"  name="action"  value=""/>
	<input type="hidden" id="pageno"  name="pageno"  />
	
	<input type="hidden" id="currentPageComnGrpCod" value="1" />
	<input type="hidden" id="currentPageComnDtlCod"  value="1"  />
	
	<input type="hidden" id="tmpAcnt_sbject_cd" value="">
	<input type="hidden" id="tmpAcnt_sbject_name" value="">
	
	 <input type="hidden" name="chkLCd" id="chkLCd" value="2"/>
	 <input type="hidden" name="chkLNm" id="chkLNm" value="2"/>
	<div id="layer1" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>계정 대분류 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						<col width="120px">
						<col width="*">
					</colgroup>

					<tbody>
						<tr style="height: 80px;">
							<th scope="row">계정 대분류코드<span class="font_red">*</span></th>
							<td colspan="2">
								<input type="text" class="inputTxt p100" style="" name="acnt_sbject_cd" id="acnt_sbject_cd"  placeholder="숫자 4자리를 입력해주세요."  />
								<div onclick="fn_LAccCdChk()" style="padding: 3px 8px 3px 8px;border: 0px solid #cdcdcd; width: 50px; border-radius : 6px; text-align: center; background: #cdcdcd; margin-top: 10px;">
									<span id ="LCdDupBtn" name = "LCdDupBtn" > 중복확인</span>
								</div>
							</td>
						</tr>
						
						
						<tr>
							<th scope="row">계정 대분류명<span class="font_red">*</span></th>
							<td colspan="2"><input type="text" class="inputTxt p100"  name="acnt_sbject_name" id="acnt_sbject_name" placeholder="한글로 입력해주세요." /></td>
						</tr>
						<tr>
							<th scope="row">구분<span class="font_red">*</span></th>
							<td colspan="2">
								<select id="M_acnt_sbjct_inout" name="M_acnt_sbjct_inout" style="width: 150px;">
										<option value="1" >수입</option>
										<option value="2" >비용</option>
								</select>
							</td>
						</tr>
				
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSave" name="btn"><span>저장</span></a> 
					<a href=""	class="btnType gray"  id="btnClose" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>




	<div id="layer2" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>상세코드 관리</strong>
			</dt>
			<dd class="content">

				<!-- s : 여기에 내용입력 -->

				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						<col width="120px">
						<col width="*">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">계정대분코드 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100" name="acnt_sbject_cdd" id="acnt_sbject_cdd" /></td>
						</tr>
						<tr>
							<th scope="row">계정대분류명 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100" name="acnt_sbject_namee" id="acnt_sbject_namee" /></td>
							
						</tr>
						<tr style="height: 80px;">
							<th scope="row">계정상세코드 <span class="font_red">*</span></th>
							<td colspan="3">
								<input type="text" class="inputTxt p100" name="acnt_dt_sbject_cd" id="acnt_dt_sbject_cd" placeholder="숫자 4자리를 입력해주세요."/>
								<div onclick="fn_SAccDtCdChk()" style="padding: 3px 8px 3px 8px;border: 0px solid #cdcdcd; width: 50px; border-radius : 6px; text-align: center; background: #cdcdcd; margin-top: 10px;">
									<span id ="SCdDupBtn" name = "SCdDupBtn" > 중복확인</span>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">계정상세코드명 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100" name="acnt_dt_sbjct_name" id="acnt_dt_sbjct_name" placeholder="한글로 입력해주세요."/></td>
						</tr>

					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveFile" name="btn"><span>저장</span></a>
					<a href="" class="btnType gray" id="btnCloseFile" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	  </form>
	<!--// 모달팝업 -->
</form>
</body>
</html>