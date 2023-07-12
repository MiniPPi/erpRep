<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<title>급여관리</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정
	var pageSize = 10;     
	var pageBlockSize = 5;    
	
	//변수설정
	//미지급버튼, 일괄지급 버튼에서 사번 or 해당년월이 날라간다
	var userInfo=null;
	var sal_date=null;
	//현재페이지 담는 용도
	var currentPage=null;
	
	/** OnLoad event */ 
	$(function() {
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
		
		fn_empSamList();
		
		
	});
	

	/** 버튼 이벤트 등록 */

	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSearch' :
					fn_empSamList();
					break;
				case 'btnPayOne' :
					fn_salPayOne(userInfo);
					break;	
				case 'btnPayAll' :
					fn_salPayAll();
					break;	
				case 'calSal' :
					fn_calSalChk();
					break;	
				case 'btnBack' :
					gfCloseModal();
					break;
			}
		});
	}
	
	
	//급여지급 리스트 뿌려주기
	function fn_empSamList(pagenum) {
		
		pagenum = pagenum || 1;
		
		//현재페이지 기억
		currentPage = pagenum;
		
		var param = {
			dept_cd : $("#dept_cd").val()
		  ,	level_cd : $("#level_cd").val()
		  ,	sal_pay_yn : $("#sal_pay_yn").val()
		  ,	emp_info : $("#emp_info").val()
		  , sname : $("#sname").val()
		  , pageSize : pageSize
		  , pageBlockSize : pageBlockSize
		  , pagenum : pagenum
		}
		
		var listCallBack = function(returnvalue) {
			console.log(JSON.stringify(returnvalue));
			
			console.log(returnvalue);
			$("#listEmpSam").empty().append(returnvalue);//noticelistgrd.jsp가 append됨
			
			var  totalcnt = $("#totalcnt").val();
			
			console.log("totalcnt : " + totalcnt);
			
			var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_empSamList');
			console.log("paginationHtml : " + paginationHtml);
			 
			$("#empSamPagination").empty().append( paginationHtml );
			
			$("#pageno").val(pagenum);
		}
		
		callAjax("/empSam/salManagementList.do", "post", "text", false, param, listCallBack) ;
			
	}
	
	
	//모달창 오픈
	function fn_openpopup(info, date) {//사번 이 날라온다
		console.log(info);
		userInfo=info;
		date=date.toString();
		sal_date=date.substring(0,4)+'-'+date.substring(4);
		console.log(sal_date);
		// 모달 팝업
		gfModalPop("#layer1");
			
	}
	function fn_openpopup2() {
		
		// 모달 팝업
		gfModalPop("#layer2");
			
	}
	
	
	//개별지급
	function fn_salPayOne(userInfo) {//사번이 날라옴
		console.log(userInfo)
		var param = {
				loginID : userInfo,
				sal_date : sal_date
		}
		
		var payOneCallback = function(reval) {
			console.log( JSON.stringify(reval) );
			
			if(reval.salPaysf > 0) {
				alert("지급되었습니다");
				gfCloseModal();
				fn_empSamList(currentPage);
				
			}  else {
				alert("지급 실패하였습니다.");				
			}
		}
		
		callAjax("/empSam/salPayOne.do", "post", "json", false, param , payOneCallback) ;
		
	}
	
	//일괄지급(지급여부 N인것들만 지급하기(N>Y로 변경))
	function fn_salPayAll() {
		var param= {
					dept_cd : $("#dept_cd").val()
				  ,	level_cd : $("#level_cd").val()
				  ,	sal_pay_yn : $("#sal_pay_yn").val()
				  ,	emp_info : $("#emp_info").val()
				  , sname : $("#sname").val()
				  
		}
		
		
		var payAllCallback = function(reval) {
			console.log( JSON.stringify(reval) );
			
			if(reval.salPaysf > 0) {
				alert("일괄 지급되었습니다.");
				fn_empSamList(currentPage);

			}  else {
				alert("이미 모두 지급되었습니다.");	
				gfCloseModal();
			}
		}
		
		callAjax("/empSam/salPayAll.do", "post", "json", false, param, payAllCallback) ;
		
	}
	
	
	//급여계산전 확인
	function fn_calSalChk() {
		if($("#calDate").val() != null && $("#calDate").val() != '') {
			var param = {};
			var calSalChkCallback = function (reval) {
				
				//입력한 달 숫자로 변경
				var calDate = $("#calDate").val();
				calDate = Number(calDate.substring(0,4) + calDate.substring(5,7));
				
				console.log(reval);
				
				//db에 저장되어있는 이미 급여계산이 끝난달과 입력한 달 비교
				var check = true;
				
				for(var i in reval) {
					var a = reval[i];
					console.log(a);
					if(a == calDate){
						alert("이미 계산된 목록 입니다.");
						check = false;
						break;
					}
				}
				if(check) { //입력한 달이 db에 없으면 급여 계산 함수 실행
					fn_calSal();
				}
				
			}
			callAjax("/empSam/calSalChk.do", "post", "json", false, param, calSalChkCallback) ;
		}else {
			var calSalHtml = "년도랑 월을 선택해주세요"
				$("#calSalSpan").empty().append( calSalHtml );
		}
		
	}
	
	
	
	//급여계산(tb_emp 테이블에서 조인해오기 지급여부는 N로 해서 insert)
	function fn_calSal() {
		
			var param = {
					calDate : $("#calDate").val()
			}
			var calSalCallback = function(reval) {
				//리스트 다시 뿌려주기
				fn_empSamList();
			}
			callAjax("/empSam/calSal.do", "post", "json", false, param, calSalCallback) ;
			
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
								class="btn_nav bold">인사</span> <span class="btn_nav bold">급여관리</span> 
							<a href="../empSam/salManagement.do" class="btn_set refresh">새로고침</a>
						</p>
						<p class="conTitle">
							<span>급여관리</span> 
							<span class="fr"> 
								<!-- 이번달 급여계산 버튼 -->
								<span id="calSalSpan" style="color:red;"></span>
								<input type="month" id="calDate" name="calDate" style="padding:6px"/>
								<a href="#" class="btnType3 color1" id="calSal" name="btn" >이번달 급여계산</a>
								
							</span>
						</p>
						<div style="display:flex; justify-content:center; align-content:center; line-height:2; border:solid 3px #c0c0c0; border-radius: 10px; padding:40px 40px; margin:20px auto;">
							
								<select id="dept_cd" name="dept_cd" style="width: 130px; margin-right:5px;">
								        <option value="" >부서</option>
										<option value="300" >회계팀</option>
										<option value="400" >영업팀</option>
										<option value="500" >인사팀</option>
										
								</select> 
								 <select id="level_cd" name="level_cd" style="width: 130px; margin-right:5px;" >
								        <option value="" >직급</option>
										<option value="10" >사원</option>
										<option value="20" >주임</option>
										<option value="30" >대리</option>
										<option value="40" >과장</option>
										<option value="50" >부장</option>
										<option value="60" >상무</option>
										<option value="70" >전무</option>
										<option value="80" >이사</option>
								</select> 
								<select id="sal_pay_yn" name="sal_pay_yn" style="width: 130px; margin-right:5px;" >
										<option value="" >전체</option>
								        <option value="Y" >지급</option>
										<option value="N" >미지급</option>
								</select> 
								 <select id="emp_info" name="emp_info" style="width: 130px; margin-right:5px;" >
								        <option value="" >전체</option>
										<option value="loginID" >사번</option>
										<option value="name" >사원명</option>
								</select> 
								<input type="text" style="width: 200px; height: 25px; margin-right:5px;" id="sname" name="sname">
								<a href="" class="btnType blue" id="btnSearch" name="btn"><span>검  색</span></a>
								 
							
					</div>
						
						
						<!-- 급여 상세 조회 리스트 목록 뿌리기(thead부분 tbody는 salManagementGrd에서 삽입) -->
						<div class="empSamList">
							
							<table class="col" style="margin:10px 0;">
							<caption>caption</caption>
							<colgroup>
								<col width="7%">
								<col width="7%">
								<col width="6%">
								<col width="6%">
								<col width="4%">
								<col width="8%">
								<col width="6%">
								<col width="6%">
								<col width="6%">
								<col width="6%">
								<col width="6%">
								<col width="6%">
								<col width="6%">
								<col width="3%">
								<col width="5%">
							</colgroup>
	
							<thead>
								<tr>
									<th scope="col">해당년월</th>
									<th scope="col">사번</th>
									<th scope="col">사원명</th>
									<th scope="col">부서명</th>
									<th scope="col">직급</th>
									<th scope="col">연봉</th>
									<th scope="col">기본급</th>
									<th scope="col">국민연금</th>
									<th scope="col">건강보험</th>
									<th scope="col">산재보험</th>
									<th scope="col">고용보험</th>
									<th scope="col">실급여</th>
									<th scope="col">퇴직금</th>
									<th scope="col">비고</th>
									<th scope="col"><a class="btnType2 color1" href="javascript:fn_openpopup2();" id="btnChoice" name="btnChoice" >일괄지급</a></th>
									
								</tr>
							</thead>
							<tbody id="listEmpSam"></tbody>
						</table>
					</div>
	
						<div class="paging_area"  id="empSamPagination"> </div>
						
                     
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	<!-- 모달팝업 -->
	<!-- 개인지급 모달 팝업 -->
	<div id="layer1" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>지급 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<h2>지급하시겠습니까?</h2>
				
				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnPayOne" name="btn"><span>지급</span></a> 
					<a href="" class="btnType blue" id="btnBack" name="btn"><span>취소</span></a> 
				</div>
			</dd>
		</dl>
	</div>
	<!-- 일괄지급 모달 팝업 -->
	<div id="layer2" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>일괄 지급 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<h2>일괄 지급하시겠습니까?</h2>
				
				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnPayAll" name="btn"><span>이번달 일괄 지급</span></a> 
					<a href="" class="btnType blue" id="btnBack" name="btn"><span>취소</span></a> 
				</div>
			</dd>
		</dl>
	</div>
	<!--// 모달팝업 -->
</form>
</body>
</html>