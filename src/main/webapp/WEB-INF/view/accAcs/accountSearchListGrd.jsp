<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

							<c:if test="${totalcnt eq 0 }">
								<tr>
									<td colspan="7">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalcnt > 0 }">
								<c:forEach items="${accountSearchList}" var="list" >
									<tr>
										<td><a href="javascript:fn_selectone('${list.budget_no}')">${list.budget_no}</a></td>
										<td><a href="javascript:fn_selectone('${list.budget_no}')">${list.pdate}</a></td>
										<td>${list.acnt_sbjct_inout}</td>
										<td>${list.acnt_dt_sbjct_name}</td>
										<td>${list.client}</td>
<%-- 										<td>${list.outamt}</td> --%>
										<td><fmt:formatNumber value="${list.outamt}" pattern="#,##0" /></td>
										<td><fmt:formatNumber value="${list.inamt}" pattern="#,##0" /></td>
									</tr>
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>