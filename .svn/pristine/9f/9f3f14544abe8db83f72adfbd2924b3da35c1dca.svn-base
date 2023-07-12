<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

							<c:if test="${totalcnt eq 0 }">
								<tr>
									<td colspan="11">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalcnt > 0 }">
								<c:forEach items="${busDlvList}" var="list">
									<tr>
										<td>${list.dlv_no}</td>
										<td>${list.splr_name}</td>
										<td>${list.product_name}</td>
										<td>${list.dlv_amt}</td>
										<td>${list.dlv_date}</td>
										<td>${list.dlv_state}</td>
										<td>${list.loginID}</td>
										<td>${list.appro_no}</td>
									<c:if test="${list.appro_bos eq null}">
										<td>-</td>
									</c:if>
									<c:if test="${list.appro_bos ne null}">
										<td>${list.appro_bos}</td>
									</c:if>
										<td>${list.appro_yn}</td>
									<c:if test="${list.dlv_rej eq null}">
										<td>-</td>
									</c:if>
									<c:if test="${list.dlv_rej ne null}">
										<td><a href="javascript:fn_openpopup2(${list.dlv_no})"class="btnType3 color1" id="btnVacaRej" name="btn" >상세</a></td>
									</c:if>
									
										
									
									
										
									</tr>
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>
							