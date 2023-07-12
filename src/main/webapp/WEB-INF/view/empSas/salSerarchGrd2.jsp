<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
						
							
							<c:if test="${totalcount eq 0}">
								<tr>
									<td colspan="3">데이터가 없습니다</td>
								</tr>
							</c:if>
							
							<c:if test="${totalcount eq 1 }">
								<tr>
									<td>${empSasSearchList2.list2[0]}</td>
									<td><fmt:formatNumber value="${empSasSearchList2.sal_pre}" type="number" pattern="#,###" /></td>
								</tr>
								<tr>
									<td>${empSasSearchList2.list2[1]}</td>
									<td><fmt:formatNumber value="${empSasSearchList2.sal_after}" type="number" pattern="#,###" /></td>
								</tr>
								<tr>
									<td>${empSasSearchList2.list2[2]}</td>
									<td><fmt:formatNumber value="${empSasSearchList2.emp_yr_sal}" type="number" pattern="#,###" /></td>
								</tr>
								
									
							</c:if>
							
						
						
							