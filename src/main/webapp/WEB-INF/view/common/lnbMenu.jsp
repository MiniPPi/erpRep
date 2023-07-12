<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<script type="text/javascript" >


  /** OnLoad event */
  $(function() {
    //fSelectMngrWorkStat();
  });

  /* 
  function fSelectMngrWorkStat() {
  	
  	if ("${sessionScope.ofcDvsCod}" != "M") return;
  	
  	var resultCallback = function(data) {
  		fSelectMngrWorkStatResult(data);
  	};
  	
  	callAjax("/dashboard/selectMngrWorkStat.do", "post", "json", true, "", resultCallback);
  }
  
  function fSelectMngrWorkStatResult(data) {
  	
  	if (data.result == "SUCCESS") {
  		
  		var model = data.selectMngrWorkStat;
  		$("#B_CNT").text(model.B_CNT);
  		$("#B_ALM_CNT").text(model.B_ALM_CNT);
  		$("#D_CNT").text(model.D_CNT);
  		$("#D_ALM_CNT").text(model.D_ALM_CNT);
  		$("#M_CNT").text(model.M_CNT);
  		$("#M_ALM_CNT").text(model.M_ALM_CNT);
  	} else {
  		alert(data.resultMsg);
  	}	
  	
  }
   */


</script> 
<form id="myForm" action=""  method="">
<input type="hidden" id="loginId"  name="loginId"  />

	<h3 class="hidden">lnb 영역</h3>
	<div id="lnb_area">
	  <div class="logo">
	    <div id="header">
	      <a class="logo" href="/dashboard/dashboard.do"> <img src="/images/admin/login/dk_logo_dark_5.jpg" alt="메인페이지" width="100%" height="25px" /></a>
	    </div>  
	  </div>
	  <div class="login">
	    <img id="LoginImg" src="${sessionScope.logic_path}" class="LoginImg" />
	    <span class="LoginName">${sessionScope.userNm}</span>
	    <div class="btn_loginArea">
	      <a href="#" onclick="fLogOut();" class="logout">LOGOUT</a>
	    </div>
	  </div>
	  <ul class="lnbMenu">
	    <c:forEach items="${sessionScope.usrMnuAtrt}" var="list">
	      <li>
	        <dl>
	          <dt>
	            <a class="lnbBtn ${list.mnu_ico_cod}" href="#">${list.mnu_nm}<em></em></a>
	          </dt>
	          <dd>
	            <c:forEach items="${list.nodeList}" var="i">
	              <c:set var="urls" value="${fn:split(i.mnu_url, '/')}" />
	              <c:choose>
	                <c:when test="${fn:indexOf(urls[fn:length(urls)-1], '=') > -1}">
	                  <c:set var="url" value="${fn:split(urls[fn:length(urls)-1], '=')}" />
	                  <a href="${i.mnu_url}" id="lnb_${url[fn:length(url)-1]}">- ${i.mnu_nm}</a>
	                </c:when>
	                <c:otherwise>
	                  <c:set var="url" value="${fn:split(urls[fn:length(urls)-1], '.')}" />
	                  <a href="${i.mnu_url}" id="lnb_${url[0]}">- ${i.mnu_nm}</a>
	                </c:otherwise>
	              </c:choose>
	            </c:forEach>
	          </dd>
	        </dl>
	      </li>
	    </c:forEach>
	  </ul>
	  <div style="clear: both;"></div>
	</div>
	
</form> 
