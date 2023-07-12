<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <c:forEach items="${selectedDaySearchList}" var="list">
        <tr>
            <td>${list.order_date}</td>
            <td>
                <fmt:formatNumber value="${list.total_order_dt_amt}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.total_order_tot_price}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.total_product_unit_price}" type="number" pattern="#,###" />
            </td>
            <td>
                <fmt:formatNumber value="${list.net_profit}" type="number" pattern="#,###" />
            </td>
        </tr>
    </c:forEach>
