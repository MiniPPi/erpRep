<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

							<c:if test="${totalcnt eq 0 }">
								<tr>
									<td colspan="9">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							
							<c:if test="${totalcnt > 0 }">
								<c:forEach items="${listSearch}" var="list">
								
									<tr >
										<td>${list.appro_no}</td>
										<td>${list.appro_type_cd}</td>
										<td>${list.dept_name}</td>	
										<td>${list.loginID}</td>
										<td>${list.name}</td>
										<td>${list.req_date}</td>
										<td>${list.appro_yn}</td>
										<td>${list.appro_date}</td>
										<td>${list.appro_bos}</td>
										<td><a class="btnType3 color1" href="javascript:fn_selectone('${list.appro_no}', '${list.appro_type_cd}')">결재</a></td>
									</tr>
								</c:forEach>
							</c:if>
							
							<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>