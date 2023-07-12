<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>월별결재관리</title>

<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<!-- 공통 js/css src 모은 jsp -->
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- fullCalendar css import -->
<link rel="stylesheet" type="text/css" href="${CTX_PATH}/css/fullcalendar/main.css" />
<!-- 대광유통 Favicon -->
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
<!-- fullCalendar js import -->
<script src='${CTX_PATH}/js/fullcalendar/main.js'></script>
<script src='${CTX_PATH}/js/fullcalendar/ko.js'></script>
<script src='${CTX_PATH}/js/fullcalendar/moment.js'></script>

<script type="text/javascript">
	var calendarEl;
	var calendar;
	var dayCheckList;
	
	document.addEventListener('DOMContentLoaded', function() {
	    	calendarEl = document.getElementById('calendar');
    		calendar = new FullCalendar.Calendar(calendarEl, {
    	    initialView: 'dayGridMonth',
    	    contentHeight: 'auto',
    	    locale : 'ko',
    	    headerToolbar: {
    	      left : '',
    	      center: 'prev title next',
    	      right : 'today'
    	    },
    	   	events : function (info, callback){
    	   		$.ajax({
    	   			url : '/calDay/dateCheckList.do',
    	   			type : 'POST',
    	   			data : {
    	   				  startDate: moment(info.start).format('YYYY-MM-DD')
    	   				, endDate: moment(info.end).format('YYYY-MM-DD')   				
    	   			},
    	   			dataType : 'json',
    	   			success : function(data){
    	   				var list = data.dateCheckList;
    	   				dateCheckList = [];
    	   				for(var i = 0; i < list.length; i++){
    	   					
    	   					//승인여부에 따른 색상표시
	    	   					var appro_ynColor = "";
	    	   					if(list[i].appro_yn == 'N'){
	    	   						appro_ynColor = "#ff9175";
	    	   					}else if (list[i].appro_yn == 'Y'){
	    	   						appro_ynColor = "#5470d6";
	    	   					}
	    	   					
	    	   					var appro_yn = "";
	    	   					if(list[i].appro_yn == 'N'){
	    	   						appro_yn = "승인대기";
	    	   					}else if (list[i].appro_yn == 'Y'){
	    	   						appro_yn = "승인완료";
	    	   					}
	    	   					
	    	   				var CheckList = {	
	    	   					// 이벤트 추가
    	   				        title : appro_yn +' '+list[i].vaca_yn_cnt+ '건 ',
    	   				        start : list[i].vaca_req_date,
    	   				        color : appro_ynColor,
    	   				        textColor : 'white',
    	   				        allDay : true,
    	   					};
	    	   				dateCheckList.push(CheckList);
    	   				}//for문
	    	   			callback(dateCheckList);
    	   			}//success
    	   		});//ajax 
    	   	}, //events
    	   	
    	   	
    	   	
    	   	//버튼 클릭 후 동작
    	 	eventClick : function(info){
    	   		var taDate = moment(info.event.start).format('YYYY-MM-DD');
    	   		var ta_info = info.event.title.split(' ');
    	   		var ta_info2 = ta_info[0];
    	   		var ta_yn_kind;
    	   			if (ta_info2 == '승인대기'){
    	   				appro_yn = 1;
    	   			}else if (ta_info2 == '승인완료'){
    	   				appro_yn = 2;
    	   			} 
        	   		var ta_datail_title = '';
    				$('#ta_detail_title').empty();
    				ta_datail_title += '<strong>' + taDate + ' ' + ta_info2 + ' 건 현황</strong>';
    				$('#ta_detail_title').append(ta_datail_title);
    	   		
        	   		
        	   		$.ajax({
        	   			url : '/calDay/dateCheckDList.do',
        	   			type : 'POST',
        	   			data : {
        	   				  vacaDate : taDate
        	   				, appro_yn : ta_yn_kind  				
        	   			},
        	   			dataType : 'json',
        	   			success : function(data){
        	   				
        	   				console.log(JSON.stringify(data));
        	   				
    						var detailList = data.dateCheckDList;
    						var ta_detailList = '';
    						$('#ta_detail').empty();
    						for(var i = 0; i < detailList.length; i++){    
    							
    							ta_detailList += '<tr>';
    							ta_detailList += '<td>'+ detailList[i].appro_type_cd + '</td>';
    							ta_detailList += '<td>'+ detailList[i].dept_name + '</td>';
    							ta_detailList += '<td>'+ detailList[i].level_name + '</td>';
    							ta_detailList += '<td>'+ detailList[i].name + '</td>';
    							ta_detailList += '<td>'+ detailList[i].appro_yn + '</td>';
    							ta_detailList += '</tr>';
    						} //for
    						
    						console.log(ta_detailList);
    					
    						$('#ta_detail').append(ta_detailList); //아이디
    						
    						gfModalPop('#layer1');
        	   			}//success
        	   		});//ajax 
        	   	}//eventClick
    	    });
	    calendar.render();
	    
	    
   	});
	
	
</script>
</head>
<body>

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
							class="btn_nav bold">달력</span> <span class="btn_nav bold">월별결재내역</span> <a href="/calDay/datecheck.do" class="btn_set refresh">새로고침</a>
					</p>

					<p class="conTitle">
						<span>월별결재내역</span> 
					</p>
					<br>
					<div id='calendar'></div>
					</div> <!--// content -->
				<h3 class="hidden">풋터 영역</h3>
					<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
			</li>
		</ul>
	</div>
</div>

<!-- 모달팝업 -->
<div id="layer1" class="layerPop layerType2" style="width: 500px;">
	<dl>
		<dt id = "dateCheckDList">
		</dt>
		<dd class="content">
			<!-- s : 여기에 내용입력 -->
			<div style = "overflow-y : auto; overflow-x : hidden; height : 300px; width : 443px;">
				<table class="col">
					<caption>caption</caption>
					<colgroup>
						<col width="20%">					
						<col width="20%">
						<col width="20%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>	
						<tr>
							<th scope = "col">결재유형</th>
							<th scope = "col">부서</th>
							<th scope = "col">직급</th>
							<th scope = "col">사원명</th>
							<th scope = "col">승인여부</th>
							
							<%-- <th scope = "col">신청구분</th> --%>
						</tr>
					</thead>
					<tbody id = "ta_detail">
					<!-- 팝업아이디 -->
					</tbody>
				</table>
			</div>
		</dd>
	</dl>
	<a href="" class="closePop"><span class="hidden">닫기</span></a>
</div>
</body>
</html>