<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${totalcnt eq 0 }">
    <tr>
        <td colspan="5">데이터가 존재하지 않습니다.</td>
    </tr>
</c:if>

<c:if test="${totalcnt > 0 }">
    <c:forEach items="${productSearchList}" var="list">
        <tr>
            <td>${list.product_no}</td>
            <td>${list.pro_name}</td>
            <td>${list.splr_name}</td>
            <td>${list.product_name}</td>
            <td>${list.product_serial}</td>
            <td>
                <fmt:formatNumber value="${list.product_unit_price}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.product_price}" type="number" pattern="#,###" />
            </td>



        </tr>
    </c:forEach>
</c:if>

<input type="hidden" id="totalcnt" name="totalcnt" value="${totalcnt}"/>