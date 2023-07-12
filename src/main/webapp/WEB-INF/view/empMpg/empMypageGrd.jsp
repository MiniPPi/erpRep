<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

							<c:if test="${totalcnt eq 0 }">
								<tr>
									<td colspan="12">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalcnt > 0 }">
								<c:forEach items="${listSearch}" var="list">
									<tr onclick="javascript:fn_selectone('${list.loginID}')">
										<td>${list.loginID}</td>
										<td>${list.name}</td>
										<td>${list.emp_hp}</td>
										<td>${list.emp_email}</td>
										<td>${list.emp_zip}</td>
										<td>${list.emp_addr}</td>
										<td>${list.emp_dt_addr}</td>
									</tr>
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>