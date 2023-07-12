<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

							<c:if test="${totalcnt eq 0 }">
								<tr>
									<td colspan="10">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalcnt > 0 }">
								<c:forEach items="${empVcpSearchList}" var="list">
									<tr>
										<td>${list.vaca_no}</td>
										<td>${list.loginID}</td>
										<td>${list.name}</td>
										<td>${list.vaca_req_date}</td>
										<td>${list.vaca_sdate}</td>
										<td>${list.vaca_edate}</td>
										<td>${list.vaca_tel}</td>
									<c:if test="${list.appro_bos eq null}">
										<td>-</td>
									</c:if>
									<c:if test="${list.appro_bos ne null}">
										<td>${list.appro_bos}</td>
									</c:if>
										<td>${list.appro_yn}</td>
									<c:if test="${list.vaca_rej eq null}">
										<td>-</td>
									</c:if>
									<c:if test="${list.vaca_rej ne null}">
										<td><a href="javascript:fn_openpopup2(${list.vaca_no})"class="btnType3 color1" id="btnVacaRej" name="btn" >상세</a></td>
									</c:if>
									
										
									</tr>
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>
							