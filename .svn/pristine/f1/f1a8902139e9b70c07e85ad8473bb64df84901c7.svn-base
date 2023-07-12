<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Job Korea</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<script src="https://unpkg.com/axios@0.12.0/dist/axios.min.js"></script>
<script src="https://unpkg.com/lodash@4.13.1/lodash.min.js"></script>
<!-- D3 -->
<style>
//
click-able rows
	.clickable-rows {tbody tr td { cursor:pointer;
	
}

.el-table__expanded-cell {
	cursor: default;
}
}


/*메인베너 영역 시작*/
.banner {
    margin-top: 10px;
    width: 100%; 
    text-align: center;
    overflow: hidden;
    position: relative;
}
.slider{
    width: 630%;
    height:100%
    overflow: hidden;
    position: relative;
}
.slider_image {
    width: 20%;
    float: left;
    margin: 0;
}
.control {
	display: inline-block;
    position: absolute;
    bottom: 5%;
    left: 45%;
    height: 20px;
    overflow: hidden;
}
.control_button {
    position: relative;
    font-size: 1.5em;
    margin: 0 10px;
    cursor: pointer;
    color: #777;
    float: left;
}
.control_button:hover {
    color: #000;
}
.control_button.active {
    color: #000;
}
/* 좌우방향키 */
.left_right_control {
    position: absolute;
    width: 100%;
    height: 100px;
    top: 250px;
    
}
.left_control {
    float: left;
    
}
.right_control {
    float: right;
    
    
    
}
/*메인베너 영역 종료*/



</style>





<script type="text/javascript">
        var pageSizeinf  = 3;
        var pageBlockSizeinquiry  = 10;

        var noticeareavar;
        var noticeeditvue;
        var vuevar;
        var vuebind;
        var vuecheck;
        var vueradio;
        var vueprop1;
        var vueprop2;
        var vueoption;
        var vuecompute;
        var watchExampleVM;
        var divComGrpCodList;
        var divComGrpCoddetail;
        
      //슬라이드
        $(function () {
            //banner slide start
            $('.slider').append($('.slider_image').first().clone());
            $('.slider').prepend($('.slider_image').eq(-2).clone());
            let index=1;
            let auto;
            moveSlider(index);
            autoSlider();
            $('.control_button').click(function (){
                index=$(this).index();
                moveSlider(index+1);
            });
            $('.left_control').click(function () {
                if(index > 1 ) {
                    index--;
                    moveSlider(index);
                }else {
                    $('.slider').css('left',-5200);
                    index=3;
                    moveSlider(index);
                }
            });
            $('.right_control').click(function () {
                if(index < 3 ) {
                    index++;
                    moveSlider(index);
                }else {
                    $('.slider').css('left',0);
                    index=1;
                    moveSlider(index);
                }
            });
            $('.banner').hover(function () {
                clearInterval(auto);
            },function () {
                autoSlider();
            });
            function moveSlider(index) {
                $('.slider').animate({
                    left:-(index*1300)
                },'slow');
                $('.control_button').removeClass('active');
                $('.control_button').eq(index-1).addClass('active');
            }
            //자동슬라이드
            function autoSlider () {
                auto=setInterval(function () {
                    $('.right_control').trigger('click'); 
                },3000);
            }
            //banner slide finish
        });
        
		/* onload 이벤트  */
		$(document).ready(function() {
			
			init();
			
			// 공지사항 조회
			fListInf();
			
			fListComnGrpCod();
			
			// 버튼 이벤트 등록
			fRegisterButtonClickEvent();
	    });
		
		function init() {
			Vue.component('my-component',{
                template : '<div>전역 컴포넌트</div>'
            });
			
			noticeareavar = new Vue({
				  el: '#divNoticeList',
				  components: {
					                   'bootstrap-table': BootstrapTable
					                },
				  data: {
					  			   listitem:[]
				  }, 
				  methods:{					
					  detailview:function(no){
						  alert(no);
						  fNoticeModal(no);  
					  }
				  }  
				  
				});		
			
			noticeeditvue = new Vue({
				  el: '#notice',
				  data: {
							  loginId:"",
							  noticeTitle:"",
							  noticeContent:"",
							  loginIdread:"",
							  noticeTitleread:"",
							  noticeContentread:""
				  }
				});	
			
			vuevar = new Vue({
				  el: '#vuevar',
				  data: {
					           inputtext:"",
							  inputnum:99,
							  disflag:true,
							  vhtmlvar:""
				  },
				  methods:{					
					  inputkey:function(event){
						  console.log(event.target.value);
					  },
					  disflagchane:function(event) {
						  if(this.disflag) {
							  this.disflag = false;
							  this.vhtmlvar="<input id='trueinput'   type='text' /> <br>  <input id='trueinput2'   type='text' />";
						  } else {
							  this.disflag = true;
							  this.vhtmlvar="<select id='falseselect'><option value='11'>11</option> <option value='22'>22</option></select>";
						  }
					  }
				  }  
				});	
			
			vuebind = new Vue({
				  el: '#vuebind',
				  data: {
							  imgpath:""
				  }, 
				  methods:{					
					  selimg:function(event){
						  var image = event.target;
						  
						  if(image.files[0]){
							  alert(window.URL.createObjectURL(image.files[0]));
							  vuevar.inputtext="asdfghj";
							  this.imgpath =  window.URL.createObjectURL(image.files[0]);
						  }
					  }
				  }  
				});	
			
			vuecheck = new Vue({
											  el: '#vuecheck',
											  data: {
											    checkedNames: [],
											    checklistitem:[
											                         { "vueid" : "checkid1", "vuename" : "첫번째"  },
											                         { "vueid" : "checkid2", "vuename" : "두번째 "  },
											                         { "vueid" : "checkid3", "vuename" : "세번째 "  }
											                     ]
											  }
				                       });
			
			vueradio = new Vue({
											  el: '#vueradio',
											  data: {
											    radioName: "",
											    radiolistitem:[
											                         { "vueid" : "radioid", "vuename" : "첫번째"  }, 
											                         { "vueid" : "radioid", "vuename" : "두번째 "  }
											                     ]
											  }
							           });
			
			new Vue({
		        el : '#vueprop1',
		    });
			
			vueprop2 = new Vue({
								                el : '#vueprop2',
								                components:{
								                    'my-component-child':{
								                        props:['msg'],
								                        template : '<div>지역 컴포넌트 {{ msg }} </div>'
								                    },
								 
								                }
								            });		
			
			vuecompute = new Vue({
											  data: { a: 1 },
											  computed: {
														    // get only, just need a function
														    aDouble: function () {
														      return this.a * 2
														    },
														    // both get and set
														    aPlus: {
																	      get: function () {
																	        return this.a + 1
																	      },
																	      set: function (v) {
																	        this.a = v - 1
																	      }
														          }
											             }
											});			
			
			
			
			
			vueoption = new Vue({
											  el: "#vueoption",
											  data: {
											    selectList: [
															  {value:"1", text:"one"},
														      {value:"2", text:"two"},
														      {value:"3", text:"three"}
											                ],
							                   options: [
													    	  {value:"option1", text:"항목1"},
													          {value:"option2", text:"항목2"},
													          {value:"option3", text:"항목3"}
										                  ]             
											  },
											  methods: {
											  	toggle: function(todo){
											    	todo.done = !todo.done
											    }
											  }
											});
			


			watchExampleVM = new Vue({
													  el: '#watch-example',
													  data: {
													    question: '',
													    answer: '질문을 하기 전까지는 대답할 수 없습니다.'
													  },
													  watch: {
													    // 질문이 변경될 때 마다 이 기능이 실행됩니다.
													    question: function (newQuestion) {
													      this.answer = '입력을 기다리는 중...';
													      this.debouncedGetAnswer();
													    }
													  },
													  created: function () {
													    // _.debounce는 lodash가 제공하는 기능으로
													    // 특히 시간이 많이 소요되는 작업을 실행할 수 있는 빈도를 제한합니다.
													    // 이 경우, 우리는 yesno.wtf/api 에 액세스 하는 빈도를 제한하고,
													    // 사용자가 ajax요청을 하기 전에 타이핑을 완전히 마칠 때까지 기다리길 바랍니다.
													    // _.debounce 함수(또는 이와 유사한 _.throttle)에 대한
													    // 자세한 내용을 보려면 https://lodash.com/docs#debounce 를 방문하세요.
													    this.debouncedGetAnswer = _.debounce(this.getAnswer, 500)
													  },
													  methods: {
													    getAnswer: function () {
													      if (this.question.indexOf('?') === -1) {
													        this.answer = '질문에는 일반적으로 물음표가 포함 됩니다. ;-)'
													        return
													      }
													      this.answer = '생각중...'
													      var vm = this
													      axios.get('https://yesno.wtf/api')
													        .then(function (response) {
													          vm.answer = _.capitalize(response.data.answer)
													        })
													        .catch(function (error) {
													          vm.answer = '에러! API 요청에 오류가 있습니다. ' + error
													        })
													    }
													  }
													});
													
			divComGrpCodList = new Vue({
				                                         el : "#divComGrpCodList",
				                                     data : {
				                                    	          grouplist : [],
				                                    	          pagenavi : ""
				                                     },
				                                     methods : {
				                                    	 grpdetail : function(grpcod) {
				                                               //alert(grpcod);
				                                               fSelectGrpCod(grpcod);
				                                               
				                                    	 } ,
				                                     }
			});
			
			divComGrpCoddetail = new Vue({
	                   el : "#layer2",
	               data : {
	                            grp_cod : "",
	                                   grp_cod_nm : "",
	                                   grp_cod_eplti : "",
	                                   mp_fld_01 : "",
	                                   mp_fld_02 : "",
	                                   mp_fld_03 : "",
	                                   use_poa : "",
	                                   fst_enlm_dtt : "",
	                                   reg_date : "",
	                                   fst_rgst_sst_id : "",
	                                   fnl_mdfd_dtt : "",
	                                   fnl_mdfr_sst_id : "",
	                                   detailcnt : 0,
	                                   delshow : false,
           	            }    
            });										
			
			
		}	
		
		function selimg() {
			alert("JavaScript Function");			
		}
		
		
		/** 버튼 이벤트 등록 */
		function fRegisterButtonClickEvent() {
			$('a[name=btn]').click(function(e) {
				e.preventDefault();

				var btnId = $(this).attr('id');
				switch (btnId) {
					case 'btnClose' :
					gfCloseModal();
					break;
					case 'btnCloseGrpCod' :
						gfCloseModal();
						break;					
					case 'btnSaveGrpCod' :
						fSaveGrpCod();
						break;							
						
			}
		});
	}
				  
				
	/** 공지사항 조회 */
	function fListInf(currentPage) {
		
		currentPage = currentPage || 1;
		
		//console.log("currentPage : " + currentPage);
						    
		var param = {
					currentPage : currentPage
				,	pageSize : pageSizeinf
		}
		
		var resultCallback = function(data) {
			fListInfResult(data, currentPage);
		};
		
		//Ajax실행 방식
		//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
		//html로 받을거라 text
		callAjax("/inf/listinfvue.do", "post", "json", true, param, resultCallback);
	}
	
	
	/** 공지사항 조회 콜백 함수 */
	function fListInfResult(data, currentPage) {

		//console.log(data);		
		noticeareavar.listitem = data.notice;
		
		// 총 개수 추출
		var totalCntlistInf = data.noticeCnt;
		var list = $("#selectedInfNo").val();
		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCntlistInf, pageSizeinf, pageBlockSizeinquiry, 'fListInf',[list]);
		//console.log("paginationHtml : " + paginationHtml);
	
		$("#listInfPagination").empty().append( paginationHtml );
	 
	}
		
	 /*공지사항 상세 조회*/
	 function fNoticeModal(noticeNo) {
	
		 var param = {noticeNo : noticeNo};
		 var resultCallback2 = function(data){
			 fdetailResult(data);
		 };
		 
		 callAjax("/system/detailNotice.do", "post", "json", true, param, resultCallback2);
	 }
	
	 /*  공지사항 상세 조회 -> 콜백함수   */
	 function fdetailResult(data){

		 if(data.resultMsg == "SUCCESS"){
			 //모달 띄우기 
			 gfModalPop("#notice");
			 
			// 모달에 정보 넣기 
			frealPopModal(data.result);
		 
		 }else{
			 alert(data.resultMsg);
		 }
	 }
	
	 /* 팝업 _ 초기화 페이지(신규) 혹은 내용뿌리기  */
	 function frealPopModal(object){
		 
		 noticeeditvue.loginId = object.loginId;
		 noticeeditvue.noticeTitle = object.noticeTitle;
		 noticeeditvue.noticeContent = object.noticeContent;
		 
		 noticeeditvue.loginIdread = "readonly";
		 noticeeditvue.noticeTitleread = "readonly";
		 noticeeditvue.noticeContentread = "readonly";
		 
		 $("#noticeNo").val(object.noticeNo); // 중요한 num 값도 숨겨서 받아온다. 
		 
	 }

	 function fn_valuedis(parm) {
		 // alert(parm);
		 if(parm == 'inputnum') {
			 alert("inputnum : " + vuevar.inputnum);
		 } else {
			 alert("inputtext : " + vuevar.inputtext);
		 }
	 }
	 
	 function fn_compute1() {
		 alert("vuecompute.a : " + vuecompute.a + " vuecompute.aPlus : " + vuecompute.aPlus);
	 }
	 
	 function fn_compute2() {
		 vuecompute.aPlus = 3
		 alert("vuecompute.a : " + vuecompute.a);
	 }
	 
	 function fn_compute3() {
		 alert("vuecompute.a : " + vuecompute.a);
	 }
	 
	 function fn_compute4() {
		 alert("vuecompute.a" + vuecompute.a + " vuecompute.aDouble : " + vuecompute.aDouble);
	 }	 
	 
	 function fn_changesel() {
		 vueoption.options = vueoption.selectList;
	 }	 
	 
	 function inputkey(event) {
		 alert("inputkey");
	 }
	
		/** 그룹코드 조회 */
		function fListComnGrpCod(currentPage) {
			
			currentPage = currentPage || 1;
			
			var sname = "";
			var oname = "";
			
			console.log("currentPage : " + currentPage);
			
			var param = {	
						sname : sname
					,	oname : oname
					,	currentPage : currentPage
					,	pageSize : pageSizeinf
			}
			
			var resultCallback = function(data) {
				flistGrpCodResult(data, currentPage);
			};
			//Ajax실행 방식
			//callAjax("Url",type,return,async or sync방식,넘겨준거,값,Callback함수 이름)
			callAjax("/system/vueListComnGrpCod.do", "post", "json", true, param, resultCallback);
		}
		
		
		/** 그룹코드 조회 콜백 함수 */
		function flistGrpCodResult(data, currentPage) {
			
			console.log(JSON.stringify(data));
			
			divComGrpCodList.grouplist = data.listComnGrpCodModel;
			
			var totalCntComnGrpCod = data.totalCntComnGrpCod;
			
			// 총 개수 추출
			
			//var totalCntComnGrpCod = $("#totalCntComnGrpCod").val();
			
			
			//swal(totalCntComnGrpCod);
			
			// 페이지 네비게이션 생성
			
			var paginationHtml = getPaginationHtml(currentPage, totalCntComnGrpCod, pageSizeinf, pageBlockSizeinquiry, 'fListComnGrpCod');
			console.log("paginationHtml : " + paginationHtml);
			
			divComGrpCodList.pagenavi = paginationHtml;
			//swal(paginationHtml);
			//$("#comnGrpCodPagination").empty().append( paginationHtml );
			
			// 현재 페이지 설정
			//$("#currentPageComnGrpCod").val(currentPage);
		}


		/** 그룹코드 단건 조회 */
		function fSelectGrpCod(grp_cod) {
			
			var param = { grp_cod : grp_cod };
			
			var resultCallback = function(data) {
				fSelectGrpCodResult(data);
			};
			
			callAjax("/system/selectComnGrpCod.do", "post", "json", true, param, resultCallback);
		}
		
		
		/** 그룹코드 단건 조회 콜백 함수*/
		function fSelectGrpCodResult(data) {
			console.log(JSON.stringify(data));
			 
			if (data.result == "SUCCESS") {

				// 모달 팝업
				gfModalPop("#layer2");
				
				// 그룹코드 폼 데이터 설정
				fInitFormGrpCod(data.comnGrpCodModel);
				
			} else {
				swal(data.resultMsg);
			}	
		}
		
		function fInitFormGrpCod(object) {
			console.log(JSON.stringify(object));
			console.log(JSON.stringify(object.grp_cod));
			
			divComGrpCoddetail.grp_cod = object.grp_cod;
			divComGrpCoddetail.grp_cod_nm = object.grp_cod_nm;
			divComGrpCoddetail.grp_cod_eplti = object.grp_cod_eplti;
			divComGrpCoddetail.mp_fld_01 = object.mp_fld_01;
			divComGrpCoddetail.mp_fld_02 = object.mp_fld_02;
			divComGrpCoddetail.mp_fld_03 = object.mp_fld_03;
			divComGrpCoddetail.use_poa = object.use_poa;
			divComGrpCoddetail.fst_enlm_dtt = object.fst_enlm_dtt;
			divComGrpCoddetail.reg_date = object.reg_date;
			divComGrpCoddetail.fst_rgst_sst_id = object.fst_rgst_sst_id;
			divComGrpCoddetail.fnl_mdfd_dtt = object.fnl_mdfd_dtt;
			divComGrpCoddetail.fnl_mdfr_sst_id = object.fnl_mdfr_sst_id;
			divComGrpCoddetail.detailcnt = object.detailcnt;
			
			if(divComGrpCoddetail.detailcnt == 0) {
				console.log("0000000000000");
				divComGrpCoddetail.delshow = false;
			} else {
				console.log("over");
				divComGrpCoddetail.delshow = true;
			}
			
			
		}
				
		function fSaveGrpCod() {
			
			var param = {
					grp_cod : divComGrpCoddetail.grp_cod,
					grp_cod_nm : divComGrpCoddetail.grp_cod_nm,
					grp_cod_eplti : divComGrpCoddetail.grp_cod_eplti,
					mp_fld_01 : divComGrpCoddetail.mp_fld_01,
					mp_fld_02 : divComGrpCoddetail.mp_fld_02,
					mp_fld_03 : divComGrpCoddetail.mp_fld_03,
					use_poa : divComGrpCoddetail.use_poa,
					fst_enlm_dtt : divComGrpCoddetail.fst_enlm_dtt,
					reg_date : divComGrpCoddetail.reg_date,
					fst_rgst_sst_id : divComGrpCoddetail.fst_rgst_sst_id,
					fnl_mdfd_dtt : divComGrpCoddetail.fnl_mdfd_dtt,
					fnl_mdfr_sst_id : divComGrpCoddetail.fnl_mdfr_sst_id,
					detailcnt : divComGrpCoddetail.detailcnt,
					action : "U"
			}

			
			
			var resultCallback = function(data) {
				fSaveGrpCodResult(data);
			};
			
			callAjax("/system/saveComnGrpCod.do", "post", "json", true, param, resultCallback);
		}
		
		
		/** 그룹코드 저장 콜백 함수 */
		function fSaveGrpCodResult(data) {
			
			// 목록 조회 페이지 번호
			var currentPage = "1";
			if ($("#action").val() != "I") {
				currentPage = $("#currentPageComnGrpCod").val();
			}
			
			if (data.result == "SUCCESS") {
				
				// 응답 메시지 출력
				swal(data.resultMsg);
				
				// 모달 닫기
				gfCloseModal();
				
				// 목록 조회
				fListComnGrpCod(currentPage);
				
			} else {
				// 오류 응답 메시지 출력
				swal(data.resultMsg);
			}
			
			// 입력폼 초기화
			//fInitFormGrpCod();
		}
		
</script>

</head>






<body>
<form id="myForm" action=""  method="">

<input type="hidden" id="currentPage" value="1">
<input type="hidden" id="selectedInfNo" value="">
	<!-- 모달 배경 -->
	<div id="mask"></div>

	<div id="wrap_area">

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
	               
					<div class="content" style="margin-bottom:20px;">
                       
						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> <span
								class="btn_nav bold">메인</span> <a href="../dashboard/dashboard.do"
								class="btn_set refresh">새로고침</a>
						</p>
                         <div >
						        <p class="conTitle" style="margin-bottom: 1%;">
									<span>대광물산</span>
																	<!--메인베너영역시작-->
						      	<div class="banner">
						        	<div class="slider">
						              <img class="slider_image" src="/images/admin/login/2.png" alt="sale" >
						              <img class="slider_image" src="/images/admin/login/3.png" alt="banner" >
						              <img class="slider_image" src="/images/admin/login/1.png" alt="banner" >
						        	</div>
						        	<!--컨트롤 버튼 영역-->
						        	<div class="control">
						            	<div class="control_button">●</div>
						            	<div class="control_button">●</div>
						            	<div class="control_button">●</div>
						         	</div>
						          <!--좌우 컨트롤 버튼 패널-->
						          	<div class="left_right_control">
						            	<img class="left_control" src="/images/admin/login/8.png" alt="leftControl">
						            	<img class="right_control" src="/images/admin/login/7.png" alt="rightControl">
						          	</div>
						      	</div>
						      	<!--메인베너영역종료--> 


      
						</div>
					</div> 
				</li>
			</ul>
		</div>
	</div>  
</form>

</body>
</html>