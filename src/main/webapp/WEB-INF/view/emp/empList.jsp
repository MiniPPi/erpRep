<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>인사관리</title>
  <jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<link rel="icon" type="image/png" sizes="16x16" href="${CTX_PATH}/images/admin/comm/favicon-16x16.png">

  <script type="text/javascript">

    // 페이징 설정
    var pageSize = 10;
    var pageBlockSize = 5;

//

    /** OnLoad event */
    $(function() {
      // 버튼 이벤트 등록
      fRegisterButtonClickEvent();

      fn_emplist();
      
      comcombo("dep_cd","depcombo","all","");
      comcombo("level_cd","levcombo","all","");


    });


    /** 버튼 이벤트 등록 */

    function fRegisterButtonClickEvent() {
      $('a[name=btn]').click(function(e) {
        e.preventDefault();

        var btnId = $(this).attr('id');

        switch (btnId) {
          case 'btnSearch' :
            fn_emplist();
            break;
          case 'btnSave' :
            fn_save();
            break;
          case 'btnDelete' :
            $("#action").val("D");
            fn_save();
            break;
          case 'btnSaveFile' :
            fn_savefile();
            break;
          case 'btnClose' :
          case 'btnCloseFile' :
        	  
            gfCloseModal();
            break;
        }
      });
    }


    function fn_emplist(pagenum) {

      pagenum = pagenum || 1;

      var param = {
        deptcd : $("#deptcd").val()
        ,   lvcd : $("#lvcd").val()
        ,	searchKey : $("#searchKey").val()
        , 	ename : $("#ename").val()
        , pageSize : pageSize
        , pageBlockSize : pageBlockSize
        , pagenum : pagenum
      }

      var listcollabck = function(returnvalue) {
        console.log(returnvalue);

        $("#listemp").empty().append(returnvalue);

        var  totalcnt = $("#totalcnt").val();

        console.log("totalcnt : " + totalcnt);

        var paginationHtml = getPaginationHtml(pagenum, totalcnt, pageSize, pageBlockSize, 'fn_emplist');
        console.log("paginationHtml : " + paginationHtml);

        $("#empPagination").empty().append( paginationHtml );

        $("#pageno").val(pagenum);
      }

      callAjax("/empEpm/emplist.do", "post", "text", false, param, listcollabck) ;

    }

    function fn_openpopup() {

      popupinit();

      // 모달 팝업
      gfModalPop("#layer1");


    }

    function popupinit(object) {

      if(object == "" || object == null || object == undefined) {

        $("#loginID").val("");
        $("#loginID").attr("readonly",true);
        $("#emp_birth").val("");
        $("#user_type").val("");
        
        $("#name").val("");
        $("#emp_sex").val("");
        $("input:radio[name='user_type']").removeAttr("checked");
        $("input:radio[name='emp_sex']").removeAttr("checked");
        $("#emp_edu").val("");
        $("#emp_email").val("");
        $("#emp_hp").val("");
        $("#emp_zip").val("");
        $("#emp_addr").val("");
        $("#emp_dt_addr").val("");
        $("#bk_cd").val("");
        $("#emp_account").val("");
        $("#dept_cd").val("");
        $("#level_cd").val("");
        $("#emp_yr_sal").val("");
        $("#emp_yr_sal").attr("readonly",true);
        $("#emp_sdate").val("");
        $("#emp_sdate").attr("readonly",true);
        $("#emp_edate").val("");
        $("#emp_edate").attr("readonly",true);
        $("#retire_reason").val("");

        $("#btnDelete").hide();
        $("#upfile").val("");

        $("#action").val("I");
      } else {
       
        $("#loginID").val(object.loginId);
        $("#loginID").attr("readonly",true);
        $("#emp_birth").val(object.emp_birth);
        $("#user_type").val(object.user_type);
        
        var user_type = object.user_type;
        if(user_type == "A"){
       	 $("#type_A").prop("checked", true);
       	 
        } else if(user_type == "B"){
       	 
       	 $("#type_B").prop("checked", true);
        }else if(user_type == "C"){
          	 
          	 $("#type_C").prop("checked", true);
        }else if(user_type == "D"){
        	$("#type_D").prop("checked", true);
        		
        	}else {
        	$("#type_E").prop("checked", true);
        	}
        
        
        $("#password").val(object.password);
        $("#name").val(object.name);
        $("#emp_sex").val(object.emp_sex);
           
         var emp_sex = object.emp_sex;
         if(emp_sex == 1){
        	 $("#sex_M").prop("checked", true);
        	 
         } else {
        	 
        	 $("#sex_W").prop("checked", true);
         }
        
        $("#emp_edu").val(object.emp_edu);
        $("#emp_email").val(object.emp_email);
        $("#emp_hp").val(object.emp_hp);
        $("#emp_zip").val(object.emp_zip);
        $("#emp_addr").val(object.emp_addr);
        $("#emp_dt_addr").val(object.emp_dt_addr);
        $("#bk_cd").val(object.bk_cd);
        $("#emp_account").val(object.emp_account);
        $("#dept_cd").val(object.dept_cd);
        $("#level_cd").val(object.level_cd);
        $("#emp_yr_sal").val(object.emp_yr_sal);
        $("#emp_yr_sal").attr("readonly",true);
        $("#emp_sdate").val(object.emp_sdate);
        $("#emp_sdate").attr("readonly",true);
        $("#emp_edate").val(object.emp_edate);
        $("#emp_edate").attr("readonly",true);
        $("#retire_reason").val(object.retire_reason);

        $("#upfile").val("");


        $("#btnDelete").show();

        $("#action").val("U");
      }
    }

    function fn_empSelectOne(login) {

      //alert(no);

      var param = {
        loginID : login
      }

      var selectoncallback = function(returndata) {
        console.log( JSON.stringify(returndata) );

        popupinit(returndata.empSearch);

        // 모달 팝업
        gfModalPop("#layer1");

      }

      callAjax("/empEpm/empSelectOne.do", "post", "json", false, param, selectoncallback) ;

    }

    function fn_save() {

      if ( ! fn_Validate() ) {
        return;
      }
      
//       var fileCheck = document.getElementById("upfile").value;
//       if(!fileCheck){
//     	  swal("파일을 첨부해 주세요");
//           return false;
//       }
      
      var emp_sex = $('input[name=sex]:checked').val();
      $("#emp_sex").val(emp_sex);
      
      var user_type = $('input[name=type]:checked').val();
      $("#user_type").val(user_type);
      
		var frm = document.getElementById("myForm2");
		frm.enctype = 'multipart/form-data';
		var fileData = new FormData(frm);
		
		var filesavecallback = function(returnval) {
			console.log( JSON.stringify(returnval) );
			
			if(returnval.returncval > 0) {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					fn_emplist($("#pageno").val());
				} else {
					fn_emplist();
				}
			}  else {
				alert("오류가 발생 되었습니다.");				
			}
		}
      
		callAjaxFileUploadSetFormData("/empEpm/empSave.do", "post", "json", true, fileData, filesavecallback);
    }
    
    
    function fn_Validate() {
      var chk = checkNotEmpty(
              [
                [ "emp_birth", "생년월일을 입력해 주세요." ]
                ,	[ "name", "이름을 입력해 주세요." ]
                ,	[ "emp_sex", "성별을 입력해 주세요." ]
                ,	[ "emp_edu", "학력을 입력해 주세요." ]
                ,	[ "emp_email", "이메일을 입력해 주세요." ]
                ,	[ "emp_hp", "전화번호를 선택해 주세요." ]
                ,	[ "user_type", "권한을 선택해 주세요." ]
                ,	[ "emp_zip", "우편번호를 선택해 주세요." ]
                ,	[ "emp_addr", "주소를 선택해 주세요." ]
                ,	[ "emp_dt_addr", "상세주소를 선택해 주세요." ]
                ,	[ "bk_cd", "은행을 선택해 주세요." ]
                ,	[ "emp_account", "계좌번호를 선택해 주세요." ]
                ,	[ "dept_cd", "부서를 선택해 주세요." ]
                ,	[ "level_cd", "직급을 선택해 주세요." ]

              ]
      );
      if (!chk) {
        return;
      }
      return true;
    }




  </script>

</head>
<body>
<form id="myForm" >
  <input type="hidden" id="pageno"  name="pageno"  />

  <!-- 모달 배경 -->
  <div id="mask"></div>

  <div id="wrap_area">

    <h2 class="hidden">header 영역</h2>
    <jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

    <h2 class="hidden">컨텐츠 영역</h2>
    <div id="container">
      <ul>
        <li class="lnb">
          <!-- lnb 영역 --> <jsp:include
                page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
        </li>
        <li class="contents">
          <!-- contents -->
          <h3 class="hidden">contents 영역</h3> <!-- content -->
          <div class="content">

            <p class="Location">
              <a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> 
              <span class="btn_nav bold">인사</span>
              <span class="btn_nav bold">인사관리</span> 
			 <a href="../empEpm/empmanagement.do" class="btn_set refresh">새로고침</a>
            </p>
            <p class="conTitle">
              <span>인사관리</span> <span class="fr">
							 <a class="" href="javascript:fn_openpopup();" name="modal">
							 	<span style=" color: black; display: inline-block; border: 3px solid #c0c0c0; padding: 7px 30px 7px 30px; font-weight: bold; font-size: 15px; background: #c0c0c0; border-radius: 2px;">신규등록</span>
							 </a>
			<div style="border : solid 3px #c0c0c0; height: 40px; border-radius: 10px; text-align: center; padding-top: 14px; padding-bottom: 10px; margin-bottom: 20px; margin-top: 20px;"">
							<select id="deptcd" name="deptcd" style="width: 100px; margin-right: 10px;">
							        <option value="" >부서</option>
									<option value="100" >관리자</option>
									<option value="200" >임원직</option>
                                    <option value="300" >회계팀</option>
                                    <option value="400" >영업팀</option>
                                    <option value="500" >인사팀</option>
							</select>

                            <select id="lvcd" name="lvcd" style="width: 100px; margin-right: 10px;">
							        <option value="" >직급</option>
									<option value="10" >사원</option>
									<option value="20" >주임</option>
                                    <option value="30" >대리</option>
                                    <option value="40" >과장</option>
                                    <option value="50" >부장</option>
                                    <option value="60" >상무</option>
                                    <option value="70" >전무</option>
                                    <option value="80" >이사</option>
                                    <option value="90" >대표</option>
							</select>
							 <select id="searchKey" name="searchKey" style="width: 100px; margin-right: 10px;" >
							        <option value="" >사번/사원명</option>
									<option value="loginId" >사번</option>
									<option value="name" >사원명</option>
							</select>
							<input type="text" style="width: 200px; height: 25px; margin-right: 20px;" id="ename" name="ename">
							<div style="display: inline-block; border: 3px solid #c0c0c0; padding: 5px 40px 5px 40px; font-weight: bold; font-size: 15px; background: #c0c0c0; border-radius: 2px;">
								<a href="" id="btnSearch" name="btn"><span style=" color: black;">검  색</span></a>
							</div>

            </div>
			</span>
            </p>

            <div class="empList">
              <table class="col">
                <caption>caption</caption>
                <colgroup>
                  <col width="15%">
                  <col width="25%">
<%--                   <col width="10%"> --%>
                  <col width="15%">
                  <col width="15%">
                  <col width="15%">
                  <col width="15%">
                  
                </colgroup>

                <thead>
                <tr>
                  <th scope="col">사번</th>
                  <th scope="col">이름</th>
<!--                   <th scope="col">부서코드</th> -->
                  <th scope="col">부서명</th>
                  <th scope="col">직급</th>
                  <th scope="col">입사일자</th>
                  <th scope="col">재직구분</th>
                  
                </tr>
                </thead>
                <tbody id="listemp"></tbody>
              </table>
            </div>

            <div class="paging_area"  id="empPagination"> </div>


          </div> <!--// content -->

          <h3 class="hidden">풋터 영역</h3>
          <jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
        </li>
      </ul>
    </div>
  </div>

  <!-- 모달팝업 -->
  <form id="myForm2" >
    <input type="hidden" id="action"  name="action"  />
  <div id="layer1" class="layerPop layerType2" style="width: 600px;">
    <dl>
      <dt>
        <strong>인사관리</strong>
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
            <th scope="row">사번 </th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="loginID" id="loginID" placeholder="인사 등록 후 확인 가능합니다." style="text-align: center;"/></td>
          </tr>
          <tr>
          
          <th scope="row">생년월일 <span class="font_red">*</span></th>
            <td><input type="text" class="inputTxt p100" name="emp_birth" id="emp_birth" placeholder="0000-00-00"  style="text-align: center;"/></td>
            <th scope="row">권한 <span class="font_red">*</span></th>
            <td colspan="3">
            <input type="radio" name="user_type" id="type_A" value="A" style="margin-right: 2px;" />&nbsp;A
            <input type="radio" name="user_type" id="type_B" value="B" style="margin-right: 2px;"/>&nbsp;B
            <input type="radio" name="user_type" id="type_C" value="C" style="margin-right: 2px;"/>&nbsp;C
            <input type="radio" name="user_type" id="type_D" value="D" style="margin-right: 2px;"/>&nbsp;D   
            <input type="radio" name="user_type" id="type_E" value="E"/>&nbsp;E   
            </td>                     
          </tr>
          <tr>
            <th scope="row">이름 <span class="font_red">*</span></th>
            <td><input type="text" class="inputTxt p100" name="name" id="name" style="text-align: center;"/></td>          
            <th scope="row">성별 <span class="font_red">*</span></th>
            <td colspan="3">
            
            &nbsp&nbsp&nbsp<input type="radio" name="emp_sex" id="sex_M" value="1"/>&nbsp&nbsp남자 
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <input type="radio" name="emp_sex" id="sex_W" value="2"/>&nbsp&nbsp여자 
            </td>            
          </tr>
          <tr>
            <th scope="row">비밀번호 </th>
            <td><input type="text" class="inputTxt p100" name="password" id="password" placeholder="자동등록(0000)"style="text-align: center;"/></td>          
            <th scope="row">학력 <span class="font_red">*</span></th>
            <td><input type="text" class="inputTxt p100" name="emp_edu" id="emp_edu"  style="text-align: center;"/></td>
          </tr>
          <tr>
            <th scope="row">이메일 <span class="font_red">*</span></th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_email" id="emp_email" placeholder="______@______.___"/ style="text-align: center;"></td>
          </tr>
          <tr>
            <th scope="row">전화번호 <span class="font_red">*</span></th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_hp" id="emp_hp" placeholder="000-0000-0000"/ style="text-align: center;"></td>
          </tr>
          <tr>
            <th scope="row">우편번호 <span class="font_red">*</span></th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_zip" id="emp_zip" placeholder="00000" / style="text-align: center;"></td>
          </tr>
          <tr>
            <th scope="row">주소 <span class="font_red">*</span></th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_addr" id="emp_addr" / style="text-align: center;"></td>
          </tr>
          <tr>
            <th scope="row">상세주소 <span class="font_red">*</span></th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_dt_addr" id="emp_dt_addr" / style="text-align: center;"></td>
          </tr>
          <tr>
            <th scope="row">은행 <span class="font_red">*</span></th>
            <td colspan="3">
<!--             <input type="text" class="inputTxt p100" name="bk_cd" id="bk_cd" /> -->
                        <select id="bk_cd" name="bk_cd" style="margin-right:5px; width: 430px; text-align: center;">
							        <option value="" >전체</option>
									<option value="1" >우리</option>
									<option value="2" >하나</option>
                                    <option value="3" >신한</option>
                                    <option value="4" >국민</option>
                                    <option value="5" >기업</option>
                                    <option value="6" >농협</option>
            </select>
            </td>
          </tr>
          <tr>
            <th scope="row">계좌번호 <span class="font_red">*</span></th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_account" id="emp_account" style="text-align: center;"/></td>
          </tr>          
          <tr>
            <th scope="row">부서 <span class="font_red">*</span></th>
            <td colspan="3">
            <select id="dept_cd" name="dept_cd" style="margin-right:5px; width: 430px; text-align: center;">
							        <option value="" >전체</option>
									<option value="100" >관리자</option>
									<option value="200" >임원직</option>
                                    <option value="300" >회계팀</option>
                                    <option value="400" >영업팀</option>
                                    <option value="500" >인사팀</option>
            </select>
            </td>
          </tr>
          <tr>
            <th scope="row">직급 <span class="font_red">*</span></th>
            <td colspan="3">
            <select id="level_cd" name="level_cd" style="margin-right:5px; width: 430px; text-align: center;">
            <option value="" >전체</option>
									<option value="10" >사원</option>
									<option value="20" >주임</option>
                                    <option value="30" >대리</option>
                                    <option value="40" >과장</option>
                                    <option value="50" >부장</option>
                                    <option value="60" >상무</option>
                                    <option value="70" >전무</option>
                                    <option value="80" >이사</option>
                                    <option value="90" >대표</option>
							
            </select>
            </td>
          </tr>
          <tr>
            <th scope="row">연봉 </th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_yr_sal" id="emp_yr_sal" placeholder="작성 불필요" style="text-align: center;"/></td>
          </tr>
          <tr>
            <th scope="row">입사일</th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_sdate" id="emp_sdate" placeholder="작성 불필요" style="text-align: center;"/></td>
          </tr>
          <tr>
            <th scope="row">퇴사일 </th>
            <td colspan="3"><input type="text" class="inputTxt p100" name="emp_edate" id="emp_edate" placeholder="작성 불필요" style="text-align: center;"/></td>
          </tr>
          <tr>
            <th scope="row">퇴사내용 </th>
            <td colspan="3">
              <textarea id="retire_reason" name="retire_reason"> </textarea>
            </td>
          </tr>
          <tr>
            <th scope="row">신규사원 증명사진 </th>
            <td colspan="3">
<!--                <input type="file" id="upfile"  name="upfile"  onchange="javascript:preview(event)" /> -->
               <input type="file" id="upfile"  name="upfile"  />
            </td>
          </tr>
          </tbody>
        </table>

        <!-- e  여기에 내용입력 -->

        <div class="btn_areaC mt30">
          <a href="" class="btnType blue" id="btnSave" name="btn"><span>저장</span></a>
          <a href="" class="btnType blue" id="btnDelete" name="btn"><span>삭제</span></a>
          <a href=""	class="btnType gray"  id="btnClose" name="btn"><span>취소</span></a>
        </div>
      </dd>
    </dl>
    <a href="" class="closePop"><span class="hidden">닫기</span></a>
  </div>

  <div id="layer2" class="layerPop layerType2" style="width: 600px;">
    <dl>
      <dt>
        <strong>상세코드 관리</strong>
      </dt>
      <dd class="content">

        <!-- s : 여기에 내용입력 -->



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
  </form>
  <!--// 모달팝업 -->
</form>
</body>
</html>
