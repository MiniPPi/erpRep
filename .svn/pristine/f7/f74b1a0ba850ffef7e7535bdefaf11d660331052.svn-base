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
    <c:forEach items="${saleMonthSearchList}" var="list">
        <tr>
            <td>${list.order_month}</td>

            <td>
                <fmt:formatNumber value="${list.order_month_dt_amt}" type="number" pattern="#,###"/>
            </td>
            <td>
                <fmt:formatNumber value="${list.order_month_tot_product_price}" type="number" pattern="#,###"/>
            </td>
            <td>
                <fmt:formatNumber value="${list.order_month_tot_product_unit_price}" type="number" pattern="#,###"/>
            </td>
            <td>
                <fmt:formatNumber value="${list.tot_profit}" type="number" pattern="#,###"/>
            </td>

        </tr>
    </c:forEach>
</c:if>

<input type="hidden" id="totalcnt" name="totalcnt" value="${totalcnt}"/>