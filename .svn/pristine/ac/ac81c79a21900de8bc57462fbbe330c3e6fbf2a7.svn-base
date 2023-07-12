<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<style type="text/css">
.empty{
height:10px;
}

.emptySpace1{
display:inline-block;
width:100px;
}


.emptySpace2{
display:inline-block;
width:10px;
}

.emptySpace3{
display:inline-block;
width:10px;
}
.emptySpace4{
display:inline-block;
width:230px;
}

.emptySpace5{

height:10px;
}



.emptySpace6{
display:inline-block;
width:10px;
}

.inputCheck input[type="radio"]{
	width: 5px;
	height: 5px;
}

#appro_req_date{
	font-size:small;
}

#expen_date{
	font-size:small;
}

.label-font{
	font-size: 15px;
	font-weight: bold;

}

.border-line{
	display:flex;
	align-items: center;
	justify-content:center;



	
}

.inputSpace{

position:absolute;
margin-left: 10px;

}

.search-btn{
font-weight: bold;
font-size: 16px;
color:black;

}

.btnTypegray{
	background-color: #c0c0c0;
	border-radius: 2px;
	width: 100px;
	height: 22px;
	margin:0 auto;
 	display:flex;
 	align-items: center;
 	justify-content:center;
 	padding: 7px;
 	

}
.center{
	width: 850px;
}


</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>지출결의서 조회 및 승인</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
 <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<script type="text/javascript">

	// 페이징 설정
	var pageSize = 10;     
	var pageBlockSize = 5;    
	
	/** OnLoad event */ 
	$(function() {
		
		// combo box 종류  acc : 회계 계정     조회 대상 테이블  tb_acnt_sbject   
		selectComCombo("acc","search_acnt_sbject_cd","all","","");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , "", "" 
		
		// combo box 종류  accd : 상세 회계계정   acccombo 변경시 계정 상세 재조회 event   조회 대상 테이블  tb_dt_sbject   
		$('#search_acnt_sbject_cd').change(function() {   
			selectComCombo("accd","search_acnt_dt_sbject_cd","all",$('#search_acnt_sbject_cd').val(),"");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
		});
		// combo box 종류  acc : 회계 계정     조회 대상 테이블  tb_acnt_sbject   
		selectComCombo("acc","acnt_sbject_cd","all","","");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , "", "" 
		
		// combo box 종류  accd : 상세 회계계정   acccombo 변경시 계정 상세 재조회 event   조회 대상 테이블  tb_dt_sbject   
		$('#acnt_sbject_cd').change(function() {   
			selectComCombo("accd","acnt_dt_sbject_cd","all",$('#acnt_sbject_cd').val(),"");  // combo type(combo box 종류),  combo_name, type(기본값  all : 전체   sel : 선택) , 선택된 상위 계정코드, "" 
		});
		
		
		
	
		
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		
		fn_expenseSearch();
		
		
	});
	


	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_expenseSearch();
					break;
				case 'btnSaveFile' :
					fn_savefile();
					break;	
				case 'btnClose' :
				case 'btnCloseFile' :
					gfCloseModal();
					break;
			}
		});
	}
	
	
	function fn_expenseSearch(pagenum) {
		
		pagenum = pagenum || 1;
		
		var param = {
		   from: $("#from").val()
		   ,to: $("#to").val()
		  , appro_yn : $("#search_appro_yn").val()
		  ,	acnt_sbject_cd : $("#search_acnt_sbject_cd").val()
		  ,	acnt_dt_sbject_cd : $("#search_acnt_dt_sbject_cd").val()
		  , 	sname : $("#sname").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listcallback = function(returnvalue) {
			console.log(returnvalue);
			
			$("#expenseSearch").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_expenseSearch');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#listPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/accEps/expenseSearchList.do", "post", "text", false, param, listcallback) ;
			
	}
	
 
	
	function fn_selectone(no) {
		
		
		var param = {
				
				appro_no : no
				
				
				
		}
		
		var selectonecallback = function(returndata) {			
			console.log( JSON.stringify(returndata) );
								
			popupinitfile(returndata.listSearch);
			
			// 모달 팝업
			gfModalPop("#layer2");
			
		}
		
		callAjax("/accEps/listSelectOneEps.do", "post", "json", false, param, selectonecallback) ;
		
	}
	
	
	function fn_Validate() {

		var chk = checkNotEmpty(
				[
						[ "appro_type_cd", "결재유형을 선택해주세요." ]
					   ,[ "dept_cd", "부서를 선택해주세요." ]
					   ,[ "acnt_sbject_cd", "계정대분류를 선택해주세요." ]
					   ,[ "acnt_dt_sbject_cd", "계정상세를 선택해주세요" ]
					   
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	
	function fn_openpopupfile() {
        popupinitfile();
		
		// 모달 팝업
		gfModalPop("#layer2");
	} 
	
   function popupinitfile(object) {
		
		if(object == "" || object == null || object == undefined) {
			$("#appro_type_cd").val("");		
			 $("#dept_cd").val("");
			 $("#loginID").val("");
			 $("#name").val("");		
			 $("#acnt_sbject_cd").val("");
			 $("#acnt_dt_sbject_cd").val("");
			 $("#expen_inf").val("");	
			 $("#expen_shop").val("");
			 $("#expen_price").val("");
			 $("#expen_report_no").val("");
			 $("#appro_req_date").val("");
			 $("#expen_date").val("");
			 $("#upfile").val("");	
			 $("#appro_yn").val("");
			 $("#budget_no").val("");
			
			$("#previewdiv").empty();
			
			$("#btnSaveFile").show();
			$("#btnDeleteFile").hide();
			
			$("#action").val("I");	
		} else {
			
			 $("#appro_type_cd").val(object.appro_type_cd);		
			 $("#dept_cd").val(object.dept_cd);
			 $("#loginID").val(object.loginID);
			 $("#name").val(object.name);		
			 $("#acnt_sbject_cd").val(object.acnt_sbject_cd);
			 selectComCombo("accd","acnt_dt_sbject_cd","all",object.acnt_sbject_cd,object.acnt_dt_sbject_cd);  
			 $("#expen_inf").val(object.expen_inf);	
			 $("#expen_shop").val(object.expen_shop);	
			 $("#expen_price").val(object.expen_price);
			 $("#expen_report_no").val(object.expen_report_no);
			 $("#appro_req_date").val(object.appro_req_date);
			 $("#expen_date").val(object.expen_date);
			 $("#upfile").val(object.upfile);		
			 $("input[name='appro_yn'][value='" + object.appro_yn + "']").prop("checked", true);
			 $("#appro_rej_reason").val(object.appro_rej_reason);
			 $("#appro_no").val(object.appro_no);
			 $("#budget_no").val(object.appro_no);
			 
			 if(object.appro_yn === "Y"){
				 $("#btnSaveFile").hide();
			 }else{
				 $("#btnSaveFile").show();
				 
			 } 
			 
			 
			 
			
			var inserthtml = "<a href='javascript:fn_filedownload()'>";
			
			if(object.file_name == "" || object.file_name == null || object.file_name == undefined) {
				inserthtml += "";
			} else {
				var selfile = object.file_name;
			    var selfilearr = selfile.split(".");
			    var lastindex = selfilearr.length - 1;
			    if(selfilearr[lastindex].toLowerCase() == "jpg" || selfilearr[lastindex].toLowerCase() == "gif" || selfilearr[lastindex].toLowerCase() == "jpeg" || selfilearr[lastindex].toLowerCase() == "png") {
			    	  inserthtml += "<img src='" + object.logic_path + "' style='width:100px; height:80px' />";
			    } else {
			    	  inserthtml += object.file_name;
			    }				
			} 
			

			inserthtml += "</a>"
			
			$("#previewdiv").empty().append(inserthtml);
			
			$("#btnDeleteFile").hide();
			
			$("#action").val("U");	
		}
	}
	
	function preview(event) {
		var image = event.target;
		  
		
		
		 if(image.files[0]){
			 
			 
			  var selfile = image.files[0].name;
		      var selfilearr = selfile.split(".");
		      var inserthtml = "";
		      var lastindex = selfilearr.length - 1;
		      
		      
		      if(selfilearr[lastindex].toLowerCase() == "jpg" || selfilearr[lastindex].toLowerCase() == "gif" || selfilearr[lastindex].toLowerCase() == "jpge" || selfilearr[lastindex].toLowerCase() == "png") {
		    	  inserthtml = "<img src='" + window.URL.createObjectURL(image.files[0]) + "' style='width:100px; height:80px' />";
		      } else {
		    	  inserthtml = selfile;
		      }
			  
			  
			  $("#previewdiv").empty().append(inserthtml);
		}
		
		
	}
    function fn_save() {
		
		if ( ! fn_Validate() ) {
			return;
		}
		
		var param = {
				
			
				action : $("#action").val(),
				appro_type_cd : $("#appro_type_cd").val(),
				dept_cd : $("#dept_cd").val(),
				loginID : $("#loginID").val(),
				name : $("#name").val(),
				acnt_sbject_cd :$("#acnt_sbject_cd").val(),
				acnt_dt_sbject_cd : $("#acnt_dt_sbject_cd").val(),
				expen_inf : $("#expen_inf").val(),
				expen_shop : $("#expen_shop").val(),
				expen_price : $("#expen_price").val(),
				appro_req_date : $("#appro_req_date").val(),
				expen_date : $("#expen_date").val(),
				appro_yn : $("#appro_yn").val()
		}
		
		var savecallback = function(reval) {
			console.log( JSON.stringify(reval) );
			
			if(reval.returncval > 0) {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					fn_expenseSearch($("#pageno").val());
				} else {
					fn_expenseSearch();
				}
			}  else {
				alert("오류가 발생 되었습니다.");				
			}
		}
		
		//callAjax("/mngNot/noticesave.do", "post", "json", false, param, savecollback) ;
		callAjax("/accEps/listSaveEps.do", "post", "json", false, $("#myForm").serialize() , savecallback) ;
		
	}
 
	function fn_savefile() {
		
		 var param = {
				 appro_yn : $("input[name='appro_yn']:checked").val()
				,appro_no :  $("#appro_no").val()
				,appro_rej_reason : $("#appro_rej_reason").val()
				,budget_no : $("#budget_no").val()
				,acnt_sbject_cd : $("#acnt_sbject_cd").val()
			    ,acnt_dt_sbject_cd : $("#acnt_dt_sbject_cd").val()
			    ,expen_report_no : $("#expen_report_no").val()
				,action :  $("#action").val()
		 }
		 
		
		/* var frm = document.getElementById("myForm");
		frm.enctype = 'multipart/form-data';
		var fileData = new FormData(frm); */
		
		var filesavecallback = function(returnval) {
			console.log( JSON.stringify(returnval) );
			
			if(returnval.returncval > 0) {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					fn_expenseSearch($("#pageno").val());
				} else {
					fn_expenseSearch();
				}
			}  else {
				alert("오류가 발생 되었습니다.");				
			}
		}
				
		//callAjaxFileUploadSetFormData("/accEps/listSaveFileEps.do", "post", "json", true, fileData, filesavecallback);
		callAjax("/accEps/listSaveFileEps.do", "post", "json", true, param, filesavecallback);
		
	}
	
	
	
	 function fn_filedownload() {
		alert("다운로드");
		
		var params = "";
		params += "<input type='hidden' name='appro_no' id='appro_no' value='"+ $("#appro_no").val() +"' />";
		
		jQuery("<form action='/accEps/downloadListFileEps.do' method='post'>"+params+"</form>").appendTo('body').submit().remove();
		
	} 
	

		 
		   
	  </script>
	
	
	
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="action"  name="action"  />
	<input type="hidden" id="appro_no"  name="appro_no"  />
	<input type="hidden" id="pageno"  name="pageno"  />
	<input type="hidden" id="expen_report_no"  name="expen_report_no"  />
	<input type="hidden" id="budget_no"  name="budget_no"  />
	
	
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
								class="btn_nav bold">회계</span> <span class="btn_nav bold">지출결의서 조회 및 승인
								</span> <a href="../accEps/expenseSearch.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>지출결의서 조회 및 승인</span> <span class="fr">
						</p>
						
							<div style ="border:solid 3px #c0c0c0; height: 160px; border-radius: 10px;" class="border-line">
								<div class="center">
									<span class="emptySpace4"></span><span class="label-font">신청일자&nbsp; </span><input type = "date" id = "from" name="from" style = "width: 140px; height:25px">
									<label for= "to">  -  </label>
									<input type = "date"  id = "to"  name = "to" style = "width: 140px;height:25px"> <div class="emptySpace5"></div> 
							
									<span class="emptySpace1"></span><span class="label-font">결재&nbsp;</span>
									<select id="search_appro_yn" name="search_appro_yn" style="width: 100px; height:27px">
									        <option value="" >전체</option>
											<option value="Y" >결재</option>
											<option value="N" >반려</option>
									</select>
									
									<span class="label-font">&nbsp;&nbsp;&nbsp;&nbsp;계정 대분류&nbsp;</span>
									 <select id="search_acnt_sbject_cd" name="search_acnt_sbject_cd" style="width: 100px; height:27px" >
									   
									</select>
									
									<span class="label-font">&nbsp;&nbsp;&nbsp;&nbsp;계정 상세&nbsp;</span>
									 <select id="search_acnt_dt_sbject_cd" name="search_acnt_dt_sbject_cd" style="width: 100px; height:27px " >
									</select> 
							
									<input type="text" style="width: 120px; height: 25px" id="sname" name="sname" class="inputSpace"> <div class="emptySpace5"></div> 
									<div class="btnTypegray"><a href="" id="btnSearch" name="btn"><span class="search-btn">검  색</span></a></div>
									
								</div>
							</div><div class="empty"></div>
							
						
						<div class="noticeList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="7%">
									<col width="7%">
									<col width="6%">
									<col width="9%">
									<col width="9%">
									<col width="8%">
									<col width="11%">
									<col width="11%">
									<col width="10%">
									<col width="5%">
									<col width="11%">
									<col width="8%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">결재번호</th>
										<th scope="col">사원번호</th>
										<th scope="col">사원명</th>
										<th scope="col">계정대분류</th>
										<th scope="col">상세분류</th>
										<th scope="col">지출내용</th>
										<th scope="col">신청일자</th>
										<th scope="col">사용일자</th>
										<th scope="col">지출금액</th>
										<th scope="col">결재</th>
										<th scope="col">결재일자</th>
										<th scope="col">결재자</th>
									</tr>
								</thead>
								<tbody id="expenseSearch"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="listPagination"> </div>
						
                     
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	
	
	<div id="layer2" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>지출결의서</strong>
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
							<th scope="row">결재유형 </th>
							<td>
								<select id="appro_type_cd" name="appro_type_cd" style="width: 135px; height:30px">
									<option value="E" >지출결의서</option>
							</select>
							</td>
							<th scope="row">부서코드 </th>
							<td >
							<select id="dept_cd" name="dept_cd" style="width: 135px; height:30px">
									<option value="300" >회계팀</option>
									<option value="100" >관리자</option>
									<option value="200" >임원진</option>
									<option value="400" >영업팀</option>
									<option value="500" >인사팀</option>
							</select>
							</td>
						</tr>						
						<tr>
							<th scope="row">계정대분류 </th>
							<td >
							<select id="acnt_sbject_cd" name="acnt_sbject_cd" style="width: 135px; height:30px">
							      
							</select>
							</td>
							<th scope="row">계정상세 </th>
							<td >
								<select id="acnt_dt_sbject_cd" name="acnt_dt_sbject_cd" style="width: 135px; height:30px" >
							        
							</select>
							</td>
						</tr>
						<tr>
							<th scope="row">거래처명 </th>
							<td ><input type="text" class="inputTxt p100" name="expen_shop" id="expen_shop" /></td>
							<th scope="row">지출금액 </th>
							<td ><input type="text" class="inputTxt p100" name="expen_price" id="expen_price" /></td>
						</tr>
						<tr>
							<th scope="row">신청일자 </th>
							<td ><input type = "date" id = "appro_req_date" name="appro_req_date" style = "width: 130px; height:30px"></td>
							<th scope="row">지출날짜 </th>
							<td ><input type = "date" id = "expen_date" name="expen_date" style = "width: 130px; height:30px"></td>
						</tr>
						<tr>
							<th scope="row">첨부파일 </th>
							<td ><input type="file" id="upfile"  name="upfile"  onchange="javascript:preview(event)" style = "width: 100px; "/></td>
							<th scope="row">미리보기 </th>
							<td >
							      <div id="previewdiv" ></div>
							</td>
						</tr>
						<tr>
							<th scope="row">지출내용</th>
							<td colspan="3">
							    <textarea id="expen_inf" name="expen_inf"> </textarea>
							</td>
						</tr>
						
						<tr>
							<th scope="row">결재 </th>
							<td><input type="radio" class="inputCheck" name="appro_yn"  value="Y"/>&nbsp;결재</td>
							<th scope="row">반려 </th>
							<td><input type="radio" class="inputCheck" name="appro_yn"  value="N"/>&nbsp;반려</td>
						</tr>
					
						<tr>
							<th scope="row">반려사유</th>
							<td colspan="3">
							    <textarea id="appro_rej_reason" name="appro_rej_reason"> </textarea>
							</td>
						</tr>
						
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveFile" name="btn"><span>저장</span></a>
    				<a href="" class="btnType blue" id="btnDeleteFile" name="btn"><span>삭제</span></a> 
					<a href=""	class="btnType gray"  id="btnCloseFile" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	
	
	<!--// 모달팝업 -->
</form>
</body>
</html>