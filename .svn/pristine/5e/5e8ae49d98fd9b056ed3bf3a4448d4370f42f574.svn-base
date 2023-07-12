<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${totalcnt eq 0 }">
  <tr>
    <td colspan="6">데이터가 존재하지 않습니다</td>
  </tr>
</c:if>

<c:if test="${totalcnt > 0 }">
  <c:forEach items="${empSearchList}" var="list">
    <tr>
      <td>${list.loginId}</td>
      <td><a href="javascript:fn_empSelectOne('${list.loginId}')" >${list.name}</a></td>
<%--       <td>${list.dept_cd}</td> --%>
      <td>
      		<c:choose>
      		<c:when test="${list.dept_cd eq '100'}">관리자</c:when>
      		<c:when test="${list.dept_cd eq '200'}">임원진</c:when>
      		<c:when test="${list.dept_cd eq '300'}">회계팀</c:when>
      		<c:when test="${list.dept_cd eq '400'}">영업팀</c:when>
      		<c:when test="${list.dept_cd eq '500'}">인사팀</c:when>
   			</c:choose>
      
      </td>
      <td>
            <c:choose>
      		<c:when test="${list.level_cd eq '10'}">사원</c:when>
      		<c:when test="${list.level_cd eq '20'}">주임</c:when>
      		<c:when test="${list.level_cd eq '30'}">대리</c:when>
      		<c:when test="${list.level_cd eq '40'}">과장</c:when>
      		<c:when test="${list.level_cd eq '50'}">부장</c:when>
      		<c:when test="${list.level_cd eq '60'}">상무</c:when>
      		<c:when test="${list.level_cd eq '70'}">전무</c:when>
      		<c:when test="${list.level_cd eq '80'}">이사</c:when>
      		<c:when test="${list.level_cd eq '90'}">대표</c:when>
   			</c:choose>
          
      </td>
      <td>${list.emp_sdate}</td>
      
      <td>${list.emp_work_yn}</td>
    </tr>
  </c:forEach>
</c:if>

<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>