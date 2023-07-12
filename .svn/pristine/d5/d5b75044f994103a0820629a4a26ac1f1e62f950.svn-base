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


.emptySpace2{
display:inline-block;
width:10px;
}

.inputTxt p1001{
 width:100px;

}

.border-line{
	display:flex;
	align-items: center;
	justify-content:center;
	position:relative;
	
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
 	float:left;
 	/* position:relative;
 	bottom:50px;
 	left: 100px; */
 	

}

.search-btn{
font-weight: bold;
font-size: 16px;
color:black;

}

.center{

display:flex;
align-items:center;
}


</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>마이페이지</title>
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
		
		
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		
		fn_myPage();
		
		
	});
	


	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_myPage();
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
	
	
	function fn_myPage(pagenum) {
		
		pagenum = pagenum || 1;
		
		var param = {
		   sname : $("#sname").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listcallback = function(returnvalue) {
			
			console.log(returnvalue);
			
			$("#myPage").empty().append(returnvalue);
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_myPage');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#listPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/empMpg/empMypageList.do", "post", "text", false, param, listcallback) ;
			
	}
	
 
	
	function fn_selectone(loginID) {
			
		var hutype = $("#usertype").val();
		var hloginId = $("#cloginId").val();
		
		if(hutype != "A"  && hloginId != loginID  ) {
			alert("수정 권한이 없습니다.");
			return;
		}
		
		var param = {				
				loginID : loginID
		}
		
		var selectonecallback = function(returndata) {			
			console.log( JSON.stringify(returndata) );
								
			popupinitfile(returndata.listSearch);
		
			
			// 모달 팝업
			gfModalPop("#layer1");
			
		}
		
		callAjax("/empMpg/listSelectOneMpg.do", "post", "json", false, param, selectonecallback) ;
		
	}
	
	
	
	
	
	function fn_openpopupfile() {
		
		
		
        popupinitfile();
		
		// 모달 팝업
		gfModalPop("#layer1");
	} 
	
   function popupinitfile(object) {
		
		if(object == "" || object == null || object == undefined) {
			
			 $("#loginID").val("");
			 $("#name").val("");		
			 $("#password").val("");
			 $("#emp_hp").val("");
			 $("#emp_email").val("");	
			 $("#emp_zip").val("");
			 $("#emp_addr").val("");
			 $("#emp_dt_addr").val("");
			 
			
			$("#btnSaveFile").show();
			$("#btnDeleteFile").hide();
			
		} else {
			
			 $("#loginID").val(object.loginID);
			 $("#name").val(object.name);		
			 $("#password").val(object.password);
			 $("#emp_hp").val(object.emp_hp);
			 $("#emp_email").val(object.emp_email);	
			 $("#emp_zip").val(object.emp_zip);
			 $("#emp_addr").val(object.emp_addr);
			 $("#emp_dt_addr").val(object.emp_dt_addr);
			  
			 
			 $("#loginID").attr("readonly",true); 
			 $("#name").attr("readonly",true); 
			 
			
			 var inserthtml = "";
			 
			
				if(object.file_name == "" || object.file_name == null || object.file_name == undefined) {
					inserthtml += "";
				} else {
					var selfile = object.file_name;
				    var selfilearr = selfile.split(".");
				    var lastindex = selfilearr.length - 1;
				    if(selfilearr[lastindex].toLowerCase() == "jpg" || selfilearr[lastindex].toLowerCase() == "gif" || selfilearr[lastindex].toLowerCase() == "jpeg" || selfilearr[lastindex].toLowerCase() == "png") {
				    	  inserthtml += "<img src='" + object.logic_path + "' style='width:100px; height:120px' />";
				    } else {
				    	  inserthtml += object.file_name;
				    }				
				} 
				
				$("#previewdiv").empty().append(inserthtml);
				$("#LoginImg").empty().append(inserthtml);
				
				$("#btnSaveFile").show();
				$("#btnDeleteFile").hide();
			
				$("#action").val("U");	
		}
	}
   
   
	function fn_savefile() {
		
		 var param = {
				 
			
				 loginID : $("#loginID").val()
				,name :  $("#name").val()
				,password : $("#password").val()
				,emp_hp : $("#emp_hp").val()
				,emp_email : $("#emp_email").val()
			    ,emp_zip : $("#emp_zip").val()
			    ,emp_addr : $("#emp_addr").val()
			    ,emp_dt_addr : $("#emp_dt_addr").val()
				,action :  $("#action").val()
		 }
		 
	
		var filesavecallback = function(returnval) {
			console.log( JSON.stringify(returnval) );
			
			if(returnval.returncval > 0) {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					fn_myPage($("#pageno").val());
				} else {
					fn_myPage();
				}
			}  else {
				alert("오류가 발생 되었습니다.");				
			}
		}
				
		//callAjaxFileUploadSetFormData("/accEps/listSaveFileEps.do", "post", "json", true, fileData, filesavecallback);
		callAjax("/empMpg/listSaveFileMpg.do", "post", "json", true, param, filesavecallback);
		
	
	}

		  
	  </script>
	
	
	
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="action"  name="action"  />
	<input type="hidden" id="pageno"  name="pageno"  />
	<input type="hidden" id="usertype"  name="usertype"  value="${usertype}"  />
	<input type="hidden" id="cloginId"  name="cloginId"  value="${cloginId}"  />
	
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
								class="btn_nav bold">인사</span> <span class="btn_nav bold">마이페이지
								</span> <a href="../empMpg/empMypage.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>마이페이지</span> <span class="fr">
						</p>
						
							<div style ="border:solid 3px #c0c0c0; height: 100px; border-radius: 10px;" class="border-line">
								<div class="center">
									</span><span style="font-weight:bold; font-size: 15px; float:left">사번 &nbsp;</span>
									<input type="text" style="width: 130px; height: 25px; float:left; margin-right: 10px" id="sname" name="sname">
									<div class="btnTypegray"><a href="" id="btnSearch" name="btn"><span class="search-btn">검  색</span></a></div>
									</span>
								</div>
								
							</div><div class="empty"></div>
						
						<div class="mypageList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="10%">
									<col width="10%">
									<col width="15%">
									<col width="10%">
									<col width="8%">
									<col width="32%">
									<col width="15%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">사번</th>
										<th scope="col">이름</th>
										<th scope="col">연락처</th>
										<th scope="col">이메일</th>
										<th scope="col">우편번호</th>
										<th scope="col">직원주소</th>
										<th scope="col">상세주소</th>
									</tr>
								</thead>
								<tbody id="myPage"></tbody>
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
	
	
	<div id="layer1" class="layerPop layerType2" style="width: 550px;">
		<dl>
			<dt>
				<strong>마이페이지</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="90px">
						<col width="120px">
						<col width="90px">
						<col width="*">
					</colgroup>

					<tbody>
					
						<tr>
							<th scope="row" rowspan ="3">사진 </th>
							<td rowspan="3" >
								<div id="previewdiv" name="previewdiv" ></div>
								</div>
							</td>
							<th scope="row" >사번 </th>
							<td><input type="text" class="inputTxt p100" name="loginID" id="loginID" /></td>
							
						</tr>
						<tr>
							<th scope="row">이름 </th>
							<td ><input type="text" class="inputTxt p100" name="name" id="name" /></td>
						
						</tr>
							<th scope="row">연락처 </th>
							<td ><input type="text" class="inputTxt p100" name="emp_hp" id="emp_hp" /></td>
						
						</tr>
												
						<tr>
							<th scope="row" >비밀번호 </th>
							<td><input type="text" class="inputTxt p1001" name="password" id="password"  /></td>
							<th scope="row">이메일 </th>
							<td><input type="text" class="inputTxt p100" name="emp_email" id="emp_email" /></td>
						</tr>
						
						<tr>
							<th scope="row">우편번호 </th>
							<td colspan = "3"><input type="text" class="inputTxt p100" name="emp_zip" id="emp_zip" /></td>
							
						</tr>
						<tr>
							<th scope="row">직원주소 </th>
							<td colspan = "3"><input type="text" class="inputTxt p100" name="emp_addr" id="emp_addr" /></td>
							
						</tr>
						<tr>
							<th scope="row">상세주소 </th>
							<td colspan = "3"><input type="text" class="inputTxt p100" name="emp_dt_addr" id="emp_dt_addr" /></td>
						</tr>
						
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveFile" name="btn"><span>수정</span></a>
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