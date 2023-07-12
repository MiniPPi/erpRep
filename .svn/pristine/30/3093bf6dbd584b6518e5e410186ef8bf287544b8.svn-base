<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <style type="text/css">
        .empty {
            height: 10px;
        }

        .emptySpace1 {
            display: inline-block;
            width: 100px;
        }

        .emptySpace2 {
            display: inline-block;
            width: 10px;
        }

        .emptySpace3 {
            display: inline-block;
            width: 10px;
        }

        .emptySpace5 {
            height: 10px;
        }

        .emptySpace6 {
            display: inline-block;
            width: 10px;
        }

        .inputCheck input[type="radio"] {
            width: 5px;
            height: 5px;
        }

        #appro_req_date {
            font-size: small;
        }

        #expen_date {
            font-size: small;
        }

        .label-font {
            font-size: 15px;
            font-weight: bold;
        }

        .border-line {
            display: flex;
            align-items: center;
            justify-content: center;
            padding-top: 20px;
            position: relative;
        }

        .inputSpace {
            position: absolute;
            margin-left: 10px;
        }

        .search-btn {
            font-weight: bold;
            font-size: 16px;
            color: black;
        }

        .btnTypegray {
            background-color: #c0c0c0;
            border-radius: 2px;
            width: 120px;
            height: 22px;
            position: relative;
            left: 485px;
            bottom: 27px;
            display: flex;
            align-items: center;
            justify-content: center;
            padding-top: 5px;
        }
    </style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>결재 관리</title>
    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<!-- 대광유통 Favicon -->
	<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

    <jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

    <script type="text/javascript">
        // 페이징 설정
        var pageSize = 10;
        var pageBlockSize = 5;

        /** OnLoad event */
        $(function () {
            // 버튼 이벤트 등록
            fRegisterButtonClickEvent();
            fn_approveSearch();
        });

        /** 버튼 이벤트 등록 */

        function fRegisterButtonClickEvent() {
            $('a[name=btn]').click(function (e) {
                // name 이 btn 인 놈들을 클릭했을때
                e.preventDefault();

                var btnId = $(this).attr('id');
                // 그 놈의 id 를 btnid 에 담고

                switch (btnId) {
                    case 'btnSearch':
                        fn_approveSearch();
                        break;
                    case 'btnSaveFile':
                        // btnid 가 btnSaveFile 와 같을때
                        fn_save();
                        break;
                    case 'btnClose':
                    case 'btnCloseFile':
                        gfCloseModal();
                        break;
                }
            });
        }

        function fn_approveSearch(pagenum) {
            console.log("fn_approveSearch called ");
            pagenum = pagenum || 1;
            /* 왼쪽 변수값에 오른쪽 변수값을 넣음*/
            var param = {
                from: $("#from").val(),
                to: $("#to").val(),
                appro_yn: $("#appro_yn_ask").val(),
                appro_type_cd: $("#appro_type_cd_ask").val(),
                sname: $("#sname").val(),
                pageSize: pageSize,
                pageBlockSize: pageBlockSize,
                pagenum: pagenum
            }


            /* pagenation */
            var listcallback = function (returnvalue) {
                console.log(returnvalue);

                $("#approManagement").empty().append(returnvalue);

                var totalcnt = $("#totalcnt").val();

                console.log("totalcnt : " + totalcnt);

                var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize,
                    pageBlockSize, 'fn_approveSearch');
                console.log("paginationHtml : " + paginationHtml);

                $("#listPagination").empty().append(paginationHtml);

                $("#pageno").val(pagenum);
            }

            callAjax("/empApm/approManagementList.do", "post", "text", false,
                param, listcallback);

        }

        /* 모달파트 */

        function fn_selectone(no, type,loginId) {

            var param = {
                appro_no: no,
                type: type
            }

            var selectoncallback;
            selectonecallback = function (returndata) {
            	$("#modalLoginID").val(loginId);
            	 // 결재 타입이 휴가/발주 구분
                if (type == '휴가') {
                    
                        console.log(JSON.stringify(returndata));
                        popupinitfile(returndata.listSearch);
                        gfModalPop("#layer2_va");
                    
                } else {
                   
                        console.log(JSON.stringify(returndata));
                        popupinitfile(returndata.listSearch);
                        gfModalPop("#layer2");
                    

                }
            }
           

            callAjax("/empApm/listSelectOneApm.do", "post", "json", false, param,
                selectonecallback);
        }

        /* 	function fn_Validate() {

         var chk = checkNotEmpty([ [ "appro_type_cd", "결재여부을 선택해주세요." ],
         [ "dept_cd", "부서를 선택해주세요." ]

         , [ "acnt_dt_sbject_cd", "계정상세를 선택해주세요" ]

         ]);

         if (!chk) {
         return;
         }

         return true;
         } */

        function fn_openpopupfile() {
            popupinitfile();

            // 모달 팝업
            gfModalPop("#layer2");
        }
        // 부서명 변환 함수
        function convertDeptCodeToName(deptCode) {
            switch (deptCode) {
                case '100':
                    return '관리자';
                case '200':
                    return '임원진';
                case '300':
                    return '회계팀';
                case '400':
                    return '영업팀';
                case '500':
                    return '인사팀';
                default:
                    return '';
            }
        }

        // popup init file  팝업화면 초기화 객체가 비어있지 않을경우
        // 그 객체 내에서 #appr_type_cd 부터 다운로드 값을 가져옴
        function popupinitfile(object) {

            if (object == "" || object == null || object == undefined) {
                $("#appro_no_modal").val("");
                $("#dlv_no_modal").val("");
                $("#splr_name").val("");
                $("#login_id").val("");

                $("#product_name").val("");
                $("#product_unit_price").val("");
                $("#dlv_amt").val("");
                $("#expen_price").val("");

                $("#appro_yn").val("");
                $("#budget_no").val("");
                $("#appro_rej_reason_dlv").val("");
                /* 휴가 */
                $("#appro_no_modal2").val("");
                $("#login_id_modal").val("");
                $("#vaca_no_modal").val("");
                $("#detail_name_modal").val("");
                $("#vaca_sdate_modal").val("");
                $("#vaca_edate_modal").val("");
                $("#appro_yn_modal").val("");
                $("#appro_rej_reason_vaca").val("");
                

                $("#btnSaveFile").show();
                $("#btnDeleteFile").hide();

                $("#action").val("I");
            } else {

                $("#appro_no_modal").val(object.appro_no);
                $("#dlv_no_modal").val(object.dlv_no);
                $("#splr_name").val(object.splr_name);
                $("#login_id").val(object.loginID);
                $("#product_name").val(object.product_name);
                $("#product_unit_price").val(object.product_unit_price);
                $("#dlv_amt").val(object.dlv_amt);
                $("#expen_price").val(object.expen_price);
                $("#appro_rej_reason_dlv").val(object.appro_rej_reason);
                
                /* 휴가 */
                $("#appro_no_modal2").val(object.appro_no);
                $("#login_id_modal").val(object.loginID);
                $("#vaca_no_modal").val(object.vaca_no);
                var deptName = convertDeptCodeToName(object.dept_cd);
                $("#detail_name_modal").val(deptName);
                $("#vaca_sdate_modal").val(object.vaca_sdate);

                $("#vaca_edate_modal").val(object.vaca_edate);
                $("#appro_yn_modal").val(object.appro_yn);
                $("#appro_rej_reason_vaca").val(object.appro_rej_reason);

                $("input[name='appro_yn'][value='" + object.appro_yn + "']").prop(
                    "checked", true);

                $("#appro_rej_reason").val(object.appro_rej_reason);
                $("#appro_no").val(object.appro_no);
                $("#budget_no").val(object.appro_no);

                if (object.appro_yn === "Y") {
                    $("#btnSaveFile").hide();
                } else {
                    $("#btnSaveFile").show();

                }

                var inserthtml = "<a href='javascript:fn_filedownload()'>";

                if (object.file_name == "" || object.file_name == null
                    || object.file_name == undefined) {
                    inserthtml += "";
                } else {
                    var selfile = object.file_name;
                    var selfilearr = selfile.split(".");
                    var lastindex = selfilearr.length - 1;
                    if (selfilearr[lastindex].toLowerCase() == "jpg"
                        || selfilearr[lastindex].toLowerCase() == "gif"
                        || selfilearr[lastindex].toLowerCase() == "jpeg"
                        || selfilearr[lastindex].toLowerCase() == "png") {
                        inserthtml += "<img src='" + object.logic_path + "' style='width:100px; height:80px' />";
                    } else {
                        inserthtml += object.file_name;
                    }
                }

                inserthtml += "</a>"

                $("#previewdiv").empty().append(inserthtml);

                $("#btnDeleteFile").hide();

                $("#action").val("U");
            }
        }


        function fn_save() {
            /* if ( ! fn_Validate() ) {
                return;
            }  */
            if($("input[name='appro_yn']:checked").val() == 'N') {
            	alert()
            }
            var param = {
                // 결재/반려 여부
                appro_yn: $("input[name='appro_yn']:checked").val(),
                // 결재 번호
                appro_no: $("#appro_no_modal").val(),
                // 결재자
                appro_bos: $("#appro_bos").val(),
                // 반려 사유
                /* dlv_no: $("#dlv_no_modal").val(), */
                appro_rej_reason: $("#appro_rej_reason_dlv").val(),
                appro_rej_reason: $("#appro_rej_reason_vaca").val(),
                action: $("#action").val(),
                loginID : $("#modalLoginID").val()

            }
            console.log($("#appro_rej_reason_modal").val());
            var savecallback = function (reval) {
                console.log(JSON.stringify(reval));

                if (reval.approStatus > 0) {
                	if(reval.dv >0 ) {
                		alert("결재 되었습니다.");
                		
                		if(reval.vu) {
                			alert("결재 되었습니다.");
                		}else {
                			alert("반려되었습니다");
                		}
                		
                	}else {
                		
                	}
                    
                    gfCloseModal();

                    if ($("#action").val() == "U") {
                        fn_approveSearch($("#pageno").val());
                    } else {
                        fn_approveSearch();
                    }
                } else {
                    alert("오류가 발생 되었습니다.");
                }
            }

            callAjax("/empApm/updateApmStatus.do", "post", "json", true, param,
                savecallback);

        }

    </script>

</head>

<body>
<form id="myForm" action="" method="">
    <input type="hidden" id="action" name="action"/> <input
        type="hidden" id="appro_no" name="appro_no"/> <input type="hidden"
                                                             id="pageno" name="pageno"/> <input type="hidden"
                                                                                                id="appro_type_cd"
                                                                                                name="appro_type_cd"/>
    <input type="hidden" id="no" name="no"/> <input
        type="hidden" id="dept_name" name="dept_name"/> <input
        type="hidden" id="loginID" name="loginID"/> <input type="hidden"
                                                           id="name" name="name"/> <input type="hidden" id="req_date"
                                                                                          name="req_date"/> <input
        type="hidden" id="appro_yn"
        name="appro_yn"/> <input type="hidden" id="appro_date"
                                 name="appro_date"/> <input type="hidden" id="appro_bos"
                                                            name="appro_bos"/> <input type="hidden" id="dept_name"
                                                                                      name="dept_name"/>


    <!-- 모달 뷰 -->
    <div id="mask"></div>

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
                            <a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a>
                            <span class="btn_nav bold">인사</span> <span class="btn_nav bold">결재
									관리 </span> <a href="../empApm/approManagement.do"
                                                  class="btn_set refresh">새로고침</a>
                        </p>

                        <p class="conTitle">
                            <span>결재 관리</span> <span class="fr">
                        </p>

                        <div
                                style="border: solid 3px #c0c0c0; height: 120px; border-radius: 10px;"
                                class="border-line">
                            <div>
                                <span class="label-font">신청일자: &nbsp; </span>
                                <input
                                        type="date" id="from" name="from"
                                        style="width: 120px; height: 25px; font-size: 15px">
                                <label for="to"> - </label>
                                <input type="date" id="to" name="to"
                                       style="width: 120px; height: 25px; font-size: 15px"> <span
                                    class="label-font">&nbsp;&nbsp;&nbsp;&nbsp;결재여부: &nbsp;</span>
                                <select id="appro_yn_ask" name="appro_yn_ask"
                                        style="width: 120px; height: 27px; font-size: 15px"">
                                <option value="">전체</option>
                                <option value="Y ">결재</option>
                                <option value="N ">반려</option>
                                </select> <span class="label-font ">&nbsp;&nbsp;&nbsp;&nbsp;결재유형:&nbsp;</span>
                                <select id="appro_type_cd_ask" name="appro_type_cd_ask"
                                        style="width: 120px; height: 27px; font-size: 15px"">
                                <option value="">전체</option>
                                <option value="발주">발주</option>
                                <option value="휴가">휴가</option>
                                </select>
                                <div class="emptySpace5"></div>

                                <span class="emptySpace1"></span><span class="label-font">&nbsp;&nbsp;&nbsp;&nbsp;사원명:
									</span> <input type="text"
                                                   style="width: 150px; height: 25px; font-size: 15px" id="sname"
                                                   name="sname" class="inputSpace">
                                <div class="btnTypegray"
                                     style="margin-top: 8px; margin-right: 12px;">
                                    <a href="" id="btnSearch" name="btn"><span
                                            class="search-btn" style="margin-top: 100px;">검 색</span> </a>
                                </div>

                            </div>
                        </div>
                        <div class="empty"></div>

                        <!-- 메인페이지 전체 리스트 -->
                        <div class="noticeList">
                            <table class="col">
                                <caption>caption</caption>
                                <colgroup>

                                    <col width="5%">
                                    <col width="10%">
                                    <col width="10%">
                                    <col width="10%">
                                    <col width="10%">
                                    <col width="15%">
                                    <col width="5%">
                                    <col width="15%">
                                    <col width="10%">
                                    <col width="10%">

                                </colgroup>

                                <thead>
                                <tr>
                                    <th scope="col">결재번호</th>
                                    <th scope="col">결재유형</th>
                                    <th scope="col">부서명</th>
                                    <th scope="col">사번</th>
                                    <th scope="col">이름</th>
                                    <th scope="col">결재요청일</th>
                                    <th scope="col">결재여부</th>
                                    <th scope="col">결재일</th>
                                    <th scope="col">결재자</th>
                                    <th scope="col">결재</th>

                                </tr>
                                </thead>
                                <tbody id="approManagement"></tbody>
                            </table>
                        </div>

                        <div class="paging_area" id="listPagination"></div>


                    </div> <!--// content -->

                    <h3 class="hidden">풋터 영역</h3>
                    <jsp:include
                            page="/WEB-INF/view/common/footer.jsp"></jsp:include>
                </li>
            </ul>
        </div>
    </div>


    <!-- 모달팝업 -->

    <div id="layer2" class="layerPop layerType2" style="width: 600px;">
    <input type="hidden" id="modalLoginID"/>
        <dl>
            <dt>
                <strong>결재</strong>
            </dt>
            <dd class="content">
                <!-- s : 여기에 내용입력 -->
                <table class="row">
                    <caption>caption</caption>
                    <colgroup>
                        <col width="120px">
                        <col width="*">
                        <col width="120px">
                        <col width="*">
                    </colgroup>

                    <tbody>
                    <tr>
                        <th scope="row">결재번호</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="appro_no_modal" id="appro_no_modal"/></td>
                        <th scope="row">발주번호</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="dlv_no_modal" id="dlv_no_modal"/></td>
                    </tr>
                    <tr>
                        <th scope="row">공급업체명</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="splr_name" id="splr_name"/></td>
                        <th scope="row">사번</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="login_id" id="login_id"/></td>
                    </tr>
                    <tr>
                        <th scope="row">제품명</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="product_name" id="product_name"/></td>
                        <th scope="row">제품 단가</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="product_unit_price" id="product_unit_price"/></td>
                    </tr>
                    <tr>
                        <th scope="row">제품 주문 수량</th>
                        <td><input type="text" class="inputTxt p100" name="dlv_amt"
                                   id="dlv_amt"/></td>
                        <th scope="row">총 금액</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="expen_price" id="expen_price"/></td>
                    </tr>
                    <tr>
                        <th scope="row">결재</th>
                        <td><input type="radio" class="inputCheck" name="appro_yn"
                                   value="Y"/>&nbsp;결재
                        </td>
                        <th scope="row">반려</th>
                        <td><input type="radio" class="inputCheck" name="appro_yn"
                                   value="N"/>&nbsp;반려
                        </td>
                    </tr>


                    <tr>
                        <th scope="row">반려사유</th>
                        <td colspan="3"><textarea id="appro_rej_reason_dlv"
                                                  name="appro_rej_reason_dlv"> </textarea></td>
                    </tr>

                    </tbody>
                </table>

                <!-- e : 여기에 내용입력 -->

                <div class="btn_areaC mt30">
                    <a href="" class="btnType blue" id="btnSaveFile" name="btn"><span>저장</span></a>
                    <a href="" class="btnType blue" id="btnDeleteFile" name="btn"><span>삭제</span></a>
                    <a href="" class="btnType gray" id="btnCloseFile" name="btn"><span>취소</span></a>
                </div>
            </dd>
        </dl>
        <a href="" class="closePop"><span class="hidden">닫기</span></a>
    </div>


    <!--// 모달팝업 -->
    <!-- 결재 - 휴가 타입 모달  -->
    <div id="layer2_va" class="layerPop layerType2" style="width: 600px;">
        <dl>
            <dt>
                <strong>결재</strong>
            </dt>
            <dd class="content">
                <!-- s : 여기에 내용입력 -->
                <table class="row">
                    <caption>caption</caption>
                    <colgroup>
                        <col width="120px">
                        <col width="*">
                        <col width="120px">
                        <col width="*">
                    </colgroup>

                    <tbody>
                    <tr>
                        <th scope="row">결재번호</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="appro_no_modal2" id="appro_no_modal2"/></td>
                        <th scope="row">휴가번호</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="vaca_no_modal" id="vaca_no_modal"/></td>
                    </tr>
                    <tr>
                        <th scope="row">부서명</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="detail_name_modal" id="detail_name_modal"/></td>
                        <th scope="row">사번</th>
                        <td><input type="text" class="inputTxt p100"
                                   name="login_id_modal" id="login_id_modal"/></td>
                    </tr>

                    <tr>
                        <th scope="row">휴가시작일</th>
                        <td><input type="text" id="vaca_sdate_modal" name="vaca_sdate_modal"
                                   style="width: 130px; height:30px"></td>
                        <th scope="row">휴가종료일</th>
                        <td><input type="text" id="vaca_edate_modal" name="vaca_edate_modal"
                                   style="width: 130px; height:30px"></td>
                    </tr>

                    <tr>
                        <th scope="row">결재</th>
                        <td><input type="radio" class="inputCheck" name="appro_yn"
                                   value="Y"/>&nbsp;결재
                        </td>
                        <th scope="row">반려</th>
                        <td><input type="radio" class="inputCheck" name="appro_yn"
                                   value="N"/>&nbsp;반려
                        </td>
                    </tr>


                    <tr>
                        <th scope="row">반려사유</th>
                        <td colspan="3"><textarea id="appro_rej_reason_vaca"
                                                  name="appro_rej_reason_vaca"> </textarea></td>
                    </tr>

                    </tbody>
                </table>

                <!-- e : 여기에 내용입력 -->

                <div class="btn_areaC mt30">
                    <a href="" class="btnType blue" id="btnSaveFile" name="btn"><span>저장</span></a>
                    <!-- <a href="" class="btnType blue" id="btnDeleteFile" name="btn"><span>삭제</span></a> -->
                    <a href="" class="btnType gray" id="btnCloseFile" name="btn"><span>취소</span></a>
                </div>
            </dd>
        </dl>
        <a href="" class="closePop"><span class="hidden">닫기</span></a>
    </div>


</form>
</body>

</html>