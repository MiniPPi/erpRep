<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>연별 매출 현황</title>
    <jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <script type="text/javascript">

        // 페이징 설정
        var pageSize = 5;
        var pageBlockSize = 5;
        function fn_aa(labels, dataVar) {

            new Chart(document.getElementById("bar-chart"), {
                type: 'bar',
                data: {
                    labels: ["2023", "2022", "2021", "2020"],
                    datasets: [
                        {
                            label: "매출",
                            backgroundColor: getColors(labels.length),
                            data: dataVar,
                        }
                    ]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: true,
                        text: '연별 매출 순이익'
                    },
                    tooltips: {
                        callbacks: {
                            label: function (tooltipItem, data) {
                                var value = data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index];
                                return value.toLocaleString() + "원"; // 라벨 (날짜)와 값을 함께 표시합니다.
                            }
                        }
                    }
                }
            });
        }

        function hsvToRgb(h, s, v) {
            var r, g, b;
            var i;
            var f, p, q, t;

            h = h / 360;
            s = s / 100;
            v = v / 100;

            i = Math.floor(h * 6);
            f = h * 6 - i;
            p = v * (1 - s);
            q = v * (1 - f * s);
            t = v * (1 - (1 - f) * s);

            switch (i % 6) {
                case 0:
                    r = v, g = t, b = p;
                    break;
                case 1:
                    r = q, g = v, b = p;
                    break;
                case 2:
                    r = p, g = v, b = t;
                    break;
                case 3:
                    r = p, g = q, b = v;
                    break;
                case 4:
                    r = t, g = p, b = v;
                    break;
                case 5:
                    r = v, g = p, b = q;
                    break;
            }

            return '#' + toHex(r * 255) + toHex(g * 255) + toHex(b * 255);
        }

        function toHex(value) {
            var hex = Math.round(value).toString(16);
            return hex.length == 1 ? '0' + hex : hex;
        }

        function getColors(length) {
            var colors = [];
            for (var i = 0; i < length; i++) {
                var hue = Math.floor(360 * i / length);
                colors.push(hsvToRgb(hue, 100, 100));
            }
            return colors;
        }

        // 날짜를 'YYYY-MM-DD' 형식으로 포맷팅하는 함수
        function formatDate(date) {
            var year = date.getFullYear();
            var month = ('0' + (date.getMonth() + 1)).slice(-2);
            var day = ('0' + date.getDate()).slice(-2);
            return year + '-' + month + '-' + day;
        }

        /** OnLoad event */
        $(function () {
            // 버튼 이벤트 등록
            fRegisterButtonClickEvent();
            fn_saleYearList();
        });


        /** 버튼 이벤트 등록 */
        function fRegisterButtonClickEvent() {
            $('a[name=btn]').click(function (e) {
                e.preventDefault();
                var btnId = $(this).attr('id');
                switch (btnId) {
                    case 'btnSearch':
                        var orderYear = $("#order_Year").val();
                        if (orderYear === "") {
                            alert("날짜를 선택해주세요.");
                            return;
                        }
                        fn_saleYearList();
                        break;
                }
            });
        }

        function fn_saleYearList(pagenum) {

            pagenum = pagenum || 1;

            var param = {
                order_year: $("#order_year").val(),
                pageSize: pageSize,
                pageBlockSize: pageBlockSize,
                pagenum: pagenum
            };

            var listCallBack = function (returnValue) {
                console.log(returnValue);
                $("#listSaleYear").empty().append(returnValue);
                var totalcnt = $("#totalcnt").val();
                console.log("totalcnt: " + totalcnt);
                if (totalcnt == 0) {
                    alert("해당 연도에는 데이터가 존재하지 않습니다.");
                    $(".bar_items").css("display", "none");
                    console.log("pagenum:" + pagenum);
                    var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_saleYearList');
                    console.log("paginationHtml: " + paginationHtml);
                    $("#saleYearPagination").empty().append(paginationHtml);
                    $("#pageno").val(pagenum);
                    return;
                }
                console.log("pagenum:" + pagenum);
                var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_saleYearList');
                console.log("paginationHtml: " + paginationHtml);
                $("#saleYearPagination").empty().append(paginationHtml);
                $("#pageno").val(pagenum);

                fn_chart();
            };

            callAjax("/selSaY/saleYearList.do", "post", "text", false, param, listCallBack);
        }

        function fn_chart() {
            var check = false;
            // 그래프 초기화
            $("#bar-chart").remove();
            $(".bar_items").empty().append('<canvas id="bar-chart" width="300" height="250"></canvas>');
            var param = {
                order_year: $("#order_year").val()
            };
            var listCallBack = function (returnValue) {
                for (var i in returnValue) {
                    console.log(returnValue[i].order_year);
                    if (returnValue[i].order_year == $("#order_year").val()) {
                        check = true;
                        break;
                    }else {

                    }
                }
                if (check) {
                    var labels = [];
                    var dataVar = [];


                    for (var i = 0; i < returnValue.length; i++) {
                        console.log(returnValue[i].order_year);
                        labels.push(returnValue[i].order_year);
                        dataVar.push(returnValue[i].year_total_profit);
                    }
                    console.log("labels" + labels);
                    console.log("dataVar" + dataVar);
                    fn_aa(labels, dataVar);
                    $(".bar_items").css("display", "block");
                }
            };
            callAjax("/selSaY/selectedYearChart.do", "post", "json", false, param, listCallBack);
        }

    </script>

</head>
<body>
<form id="myForm" action="" method="">
    <input type="hidden" id="action" name="action"/>
    <input type="hidden" id="order_no" name="order_no"/>
    <input type="hidden" id="pageno" name="pageno"/>

    <div id="wrap_area">
        <h2 class="hidden">header 영역</h2>
        <jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
        <h2 class="hidden">컨텐츠 영역</h2>
        <div id="container">
            <ul>
                <li class="lnb">
                    <!-- lnb 영역 -->
                    <jsp:include
                            page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
                </li>
                <li class="contents">
                    <!-- contents -->
                    <h3 class="hidden">contents 영역</h3> <!-- content -->
                    <div class="content">
                        <p class="Location">
                            <a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> <span
                                class="btn_nav bold">매출</span> <span class="btn_nav bold">연별 매출 현황
								</span> <a href="../selSaY/saleYearList.do" class="btn_set refresh">새로고침</a>
                        </p>


                        <p class="conTitle">
                            <span>연별 매출 현황</span> <span class="fr"></span>
                        </p>

                        <!-- 검색창 영역 시작 -->

                        <div style="display:flex; justify-content:center; align-content:center; border:1px solid DeepSkyBlue; padding:10px 10px;">
                            <label for="order_year"
                                   style="font-size:15px; font-weight:bold; margin-right:10px; margin-top:6px; ">연 조회
                                : </label>
                            <input type="number" id="order_year" name="order_year" min="2020" placeholder="연도 입력"
                                   style="height: 25px; width: 120px; margin-right: 15px;">
                            <a href="" class="btnType blue" id="btnSearch" name="btn"><span>검  색</span></a>
                        </div>

                        <!-- 검색창 영역 끝 -->

                        <div class="bar_items"
                             style="width: 60%; display: none; margin-left: auto; margin-right: auto;">
                            <canvas id="bar-chart" width="300" height="250"></canvas>
                        </div>
                        <div class="saleYearList">
                            <div style="display:flex; flex-grow: 1; justify-content: space-evenly;">
                                <div style="display:flex; flex-grow: 1; justify-content: space-evenly;">
                                </div>
                            </div>
                            <table class="col">
                                <caption>caption</caption>
                                <colgroup>
                                    <col width="10%">
                                    <col width="15%">
                                    <col width="15%">
                                    <col width="15%">
                                    <col width="15%">
                                    <col width="15%">
                                </colgroup>

                                <thead>
                                <tr>
                                    <th scope="col">연도</th>
                                    <th scope="col">총 판매량</th>
                                    <th scope="col">총 매출</th>
                                    <th scope="col">총 지출</th>
                                    <th scope="col">총 순이익</th>
                                    <th scope="col">전년대비 성장률</th>
                                </tr>
                                </thead>
                                <tbody id="listSaleYear"></tbody>
                            </table>
                            <div class="paging_area" id="saleYearPagination"></div>
                        </div> <!--// content -->
                        <h3 class="hidden">풋터 영역</h3>
                        <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
                </li>
            </ul>
        </div>
    </div>


</form>
</body>
</html>