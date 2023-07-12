<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<style type="text/css">

 .emptySpace2{
display:inline-block;
width:120px;
} 

.emptySpace3{
display:inline-block;
width:10px;
}
.emptySpace5{

height:10px;
}

#appro_req_date{
	font-size:small;
}

#expen_date{
	font-size:small;
}

.border-line{
	display:flex;
	justify-content:center;
	align-items: center;
	position:relative;
	bottom:23px;
}

.label-font{
	font-size: 15px;
	font-weight: bold;

}

.btnTypegray{
	background-color: #c0c0c0;
	border-radius: 2px;
	width: 100px;
	height: 22px;
 	display:flex;
 	align-items: center;
 	justify-content:center;
 	padding: 7px; 
 	margin: 0 auto;
 	

}

.gray-btn{
	background-color: #c0c0c0;
	border-radius: 2px;
	width: 120px;
	height: 22px;
	position:relative;
 	left: 860px;
 	bottom: 60px;
 	display:flex;
 	align-items: center;
 	justify-content:center;
 	padding: 7px; 
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
.center{
width: 650px;
}

.textAreaRemain{

}

</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>지출결의서 신청</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<!--  <link rel="stylesheet" href="/resources/demos/style.css"> -->
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
		
		fn_expenseRequireList();
		
		
	});
	


	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_expenseRequireList();
					break;
				case 'btnDeleteFile' :
					$("#action").val("D");	
					fn_savefile();
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
	
	
	function fn_expenseRequireList(pagenum) {
		
		pagenum = pagenum || 1;
		
		var param = {
		   from: $("#from").val()
		   ,to: $("#to").val()
		  , appro_yn : $("#appro_yn").val()
		  ,	acnt_sbject_cd : $("#search_acnt_sbject_cd").val()
		  ,	acnt_dt_sbject_cd : $("#search_acnt_dt_sbject_cd").val()
		  , 	sname : $("#sname").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listcallback = function(returnvalue) {
			console.log(returnvalue);
			
			$("#expenseRequireList").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_expenseRequireList');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#listPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/accEpr/expenseRequireList.do", "post", "text", false, param, listcallback) ;
			
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
		
		callAjax("/accEpr/listSelectOne.do", "post", "json", false, param, selectonecallback) ;
		
	}
	
	
	function fn_Validate() {

		var chk = checkNotEmpty(
				[
						[ "appro_type_cd", "결재유형을 선택해주세요." ]
					   ,[ "dept_cd", "부서를 선택해주세요." ]
					   ,[ "acnt_sbject_cd", "계정대분류를 선택해주세요." ]
					   ,[ "acnt_dt_sbject_cd", "계정상세를 선택해주세요" ]
					   ,[ "expen_shop", "거래처명을 입력해주세요" ]
					   ,[ "expen_price", "지출금액을 입력해주세요" ]
					   ,[ "appro_req_date", "신청일자를 선택해주세요" ]
					   ,[ "expen_date", "지출날짜를 선택해주세요" ]
					   ,[ "expen_inf", "지출내용을 선택해주세요" ]
					   
					   
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	//////////////////////////   위는 파일 업이 처리
	/////////////////////////    file upload
	function fn_textArea() {
	      var totText = 20;
	      //남은 글자 수
	      var remainText;
	      //현재 작성한 글자 수
	      var expenonLength = $("#expen_inf").val().length;
	      //현재 남은 글자 수
	      remainText = totText - expenonLength;
	      
	      if(remainText < 0 ) {
	         $("#textAreaRemain").html("글자 수 초과").css("color","red");
	         return;
	      }
	      
	      $("#textAreaRemain").html(remainText + "/" + totText).css("color","black");
	      
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
			 $("#appro_req_date").val("");
			 $("#expen_report_no").val();
			 $("#expen_date").val("");
			 $("#upfile").val("");
			 $("#appro_yn").val("");
			
			$("#previewdiv").empty();
			$("#appro_type_cd").attr("disabled",false); 
			$("#dept_cd").attr("disabled",false); 
			$("#acnt_sbject_cd").attr("disabled",false); 
			$("#acnt_dt_sbject_cd").attr("disabled",false); 
			$("#expen_shop").attr("readonly",false); 
			$("#expen_price").attr("readonly",false); 
			$("#appro_req_date").attr("readonly",false); 
			$("#expen_date").attr("readonly",false); 
			$("#expen_inf").attr("readonly",false); 
			$("#appro_type_cd").css('color','black');
			$("#appro_type_cd").css('font-weight','normal');
			$("#dept_cd").css('color','black');
			$("#dept_cd").css('font-weight','normal');
			$("#acnt_sbject_cd").css('color','black');
			$("#acnt_sbject_cd").css('font-weight','normal');
			$("#acnt_dt_sbject_cd").css('color','black');
			$("#acnt_dt_sbject_cd").css('font-weight','normal');
			 
			var fontRedSpans = document.querySelectorAll("span.font_red");
			
			for(var i = 0; i<fontRedSpans.length; i++){
				fontRedSpans[i].style.display = "inline";
			}
			$("#btnSaveFile").show();
			$("#btnDeleteFile").hide();
			
			 
			  
			$("#action").val("I");	
		} else {
			console.log(object.expen_price);
			
			 $("#appro_type_cd").val(object.appro_type_cd);		
			 $("#dept_cd").val(object.dept_cd);
			 $("#loginID").val(object.loginID);
			 $("#name").val(object.name);		
			 $("#acnt_sbject_cd").val(object.acnt_sbject_cd);
			 selectComCombo("accd","acnt_dt_sbject_cd","all",object.acnt_sbject_cd,object.acnt_dt_sbject_cd);  
			 $("#expen_inf").val(object.expen_inf);	
			 $("#expen_shop").val(object.expen_shop);	
			 $("#expen_price").val(object.expen_price.toLocaleString());
			 $("#appro_req_date").val(object.appro_req_date);
			 $("#expen_report_no").val(object.expen_report_no);
			 $("#expen_date").val(object.expen_date);
			 $("#upfile").val(object.upfile);
			 $("#appro_no").val(object.appro_no);
			 $("input[name='appro_yn'][value='" + object.appro_yn + "']").prop("checked", true);
			 
			 
			 $("#appro_type_cd").attr("disabled",true); 
			 $("#appro_type_cd").css('color','black');
			 $("#appro_type_cd").css('font-weight','bolder');
			 $("#dept_cd").attr("disabled",true); 
			 $("#dept_cd").css('color','black');
			 $("#dept_cd").css('font-weight','bolder');
			 $("#acnt_sbject_cd").attr("disabled",true); 
			 $("#acnt_sbject_cd").css('color','black');
			 $("#acnt_sbject_cd").css('font-weight','bolder');
			 $("#acnt_dt_sbject_cd").attr("disabled",true); 
			 $("#acnt_dt_sbject_cd").css('color','black');
			 $("#acnt_dt_sbject_cd").css('font-weight','bolder');
			 $("#expen_shop").attr("readonly",true); 
			 $("#expen_price").attr("readonly",true); 
			 $("#appro_req_date").attr("readonly",true); 
			 $("#expen_date").attr("readonly",true); 
			 $("#expen_inf").attr("readonly",true); 
		
			
			 
			if(object.appro_yn === "Y"){
				$("#btnDeleteFile").hide();
			}else{
				$("#btnDeleteFile").show();
			}
			
			var fontRedSpans = document.querySelectorAll("span.font_red");
			
			for(var i = 0; i<fontRedSpans.length; i++){
				fontRedSpans[i].style.display = "none";
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
			
			$("#btnSaveFile").hide();
			
			$("#action").val("U");	
		}
	}
	
	function preview(event) {
		var image = event.target;
		  
		//alert(image.files[0].file_name + " : " + image.files[0].file_nm + " : " + image.files[0].name);
		
		 if(image.files[0]){
			  //alert(window.URL.createObjectURL(image.files[0]));
			 
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
  
	function fn_savefile() {
		
		if ( ! fn_Validate() ) {
			return;
		}
		
		var frm = document.getElementById("myForm2");
		frm.enctype = 'multipart/form-data';
		var fileData = new FormData(frm);
		
		var filesavecallback = function(returnval) {
			console.log( JSON.stringify(returnval) );
			
			if(returnval.returncval > 0) {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					fn_expenseRequireList($("#pageno").val());
				} else {
					fn_expenseRequireList();
				}
			}  else {
				alert("오류가 발생 되었습니다.");				
			}
		}
				
		callAjaxFileUploadSetFormData("/accEpr/listSaveFile.do", "post", "json", true, fileData, filesavecallback);
		
	}
	
	
	
	function fn_filedownload() {
		alert("다운로드 " +  $("#appro_no").val() );
		
		var appro_no = $("#appro_no").val();
		var params = "";
		params += "<input type='hidden' name='appro_no' id='appro_no' value='"+ appro_no +"' />";
		
		jQuery("<form action='/accEpr/downloadListFile.do' method='post'>"+params+"</form>").appendTo('body').submit().remove();
		
	}
	

		 
		   
	  </script>
	
	
	
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
								class="btn_nav bold">회계</span> <span class="btn_nav bold">지출결의서 신청
								</span> <a href="../accEpr/expenseRequire.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>지출결의서 신청</span> <span class="fr">
							<div class="gray-btn">
								<a href="javascript:fn_openpopupfile();" name="modal"><span class="search-btn">지출결의서 작성</span></a> 
							</div>
						</p>
						
							<div style ="border:solid 3px #c0c0c0; height: 160px; border-radius: 10px;" class="border-line">
								<div class="center">
									<span class="emptySpace2"></span><span class="label-font">신청일자 &nbsp; </span><input type = "date" id = "from" name="from" style = "width: 140px; height:25px">
									<label for= "to">  -  </label>
									<input type = "date"  id = "to"  name = "to" style = "width: 140px;height:25px"><div class="emptySpace5"></div> 
										
									<span class="label-font">결재 &nbsp;</span>
									<select id="appro_yn" name="appro_yn" style="width: 100px; height:27px" >
										    <option value="" >전체</option>
											<option value="Y" >결재</option>
											<option value="N" >반려</option>
									</select>
										
									<span class="emptySpace3"></span><span class="label-font">&nbsp;&nbsp;계정 대분류 &nbsp;</span>
									<select id="search_acnt_sbject_cd" name="search_acnt_sbject_cd" style="width: 100px; height:27px" >   
									</select>
										
									<span class="emptySpace3"></span><span class="label-font">&nbsp;&nbsp;계정 상세 &nbsp;</span>
									<select id="search_acnt_dt_sbject_cd" name="search_acnt_dt_sbject_cd" style="width: 100px; height:27px" >
									</select> 
										
									<input type="text" style="width: 120px; height: 25px" id="sname" name="sname" class="inputSpace">
									<div class="emptySpace5"></div><div class="btnTypegray"><a href="" id="btnSearch" name="btn"><span class="search-btn">검  색</span></a></div>
								</div>
							</div>
							
							
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
								<tbody id="expenseRequireList"></tbody>
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
	
	 <form id="myForm2" action=""  method=""> 
	<input type="hidden" id="action"  name="action"  />
	<input type="hidden" id="appro_no"  name="appro_no"  />
	<input type="hidden" id="expen_report_no"  name="expen_report_no"  />
		
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
							<th scope="row">결재유형<span class="font_red" >*</span> </th>
							<td>
								<select id="appro_type_cd" name="appro_type_cd" style="width: 135px; height:30px">
									<option value="E" >지출결의서</option>
							</select>
							</td>
							<th scope="row">부서코드<span class="font_red" >*</span> </th>
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
							<th scope="row">계정대분류<span class="font_red">*</span> </th>
							<td >
							<select id="acnt_sbject_cd" name="acnt_sbject_cd" style="width: 135px; height:30px">
							      
							</select>
							</td>
							<th scope="row">계정상세<span class="font_red">*</span> </th>
							<td >
								<select id="acnt_dt_sbject_cd" name="acnt_dt_sbject_cd" style="width: 135px; height:30px" >
							        
							</select>
							</td>
						</tr>
						<tr>
							<th scope="row">거래처명<span class="font_red">*</span> </th>
							<td ><input type="text" class="inputTxt p100" name="expen_shop" id="expen_shop"  style="text-indent:5px"/></td>
							<th scope="row">지출금액 <span class="font_red">*</span></th>
							<td ><input type="text" class="inputTxt p100" name="expen_price" id="expen_price" style="text-indent:5px"/></td>
						</tr>
						<tr>
							<th scope="row">신청일자 <span class="font_red">*</span></th>
							<td ><input type = "date" id = "appro_req_date" name="appro_req_date" style = "width: 130px; height:30px; text-indent:2px"></td>
							<th scope="row">지출날짜<span class="font_red">*</span> </th>
							<td ><input type = "date" id = "expen_date" name="expen_date" style = "width: 130px; height:30px; text-indent:2px"></td>
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
							<th scope="row">지출내용<span class="font_red" style="display:none">*</span></th>
							<td colspan="3" rowspan="3">
							    <textarea id="expen_inf" name="expen_inf"style="text-indent:5px" placeholder="20자 이내로 작성" onkeyup="fn_textArea()"> </textarea><div id="textAreaRemain"></div>
							</td>
						</tr>
						
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveFile" name="btn"><span>저장</span></a>
					<c:if test="${sessionScope.userType == 'A' || sessionScope.userType == 'C'}">
    					<a href="" class="btnType blue" id="btnDeleteFile" name="btn"><span>삭제</span></a> 
					</c:if>
					<a href=""	class="btnType gray"  id="btnCloseFile" name="btn"><span>취소</span></a>
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