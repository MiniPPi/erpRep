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
    <c:forEach items="${saleYearSearchList}" var="list">
        <tr>
            <td>${list.sale_year}</td>
            <td>
                <fmt:formatNumber value="${list.total_sales_volume}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.order_year_tot_product_price}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.expense_total}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.year_total_profit}" type="number" pattern="#,###" />
            </td>
            <td>${list.percent_year}</td>
        </tr>
    </c:forEach>
</c:if>

<input type="hidden" id="totalcnt" name="totalcnt" value ="${totalcnt}"/>