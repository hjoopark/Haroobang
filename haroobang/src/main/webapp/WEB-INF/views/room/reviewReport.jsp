<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="/haroobang/resources/img/fav.png">
<meta name="author" content="CodePixar">
<meta name="description" content="">
<meta name="keywords" content="">
<meta charset="UTF-8">
<title>roomDetail</title>
<jsp:include page="/WEB-INF/views/include/css.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">

	
	$("#report").click(function(e){
		var content = prompt("신고하는 사유를 적어 주세요");
		var commentNo = $(this).attr('commentNo');
		if(${login != null}){
			$.ajax({
				url:"/haroobang/room/commentReport.action",
				data:{"content":content,"commentNo":commentNo},
				method:"get",
				success:function(data,status,xhr){
					alert("신고 완료되었습니다. 관리자의 확인후 후기가 삭제됩니다.")
				}	
			});
		}
		 
	});
});
			

</script>



</head>

<body>

	<jsp:include page="/WEB-INF/views/include/navbar.jsp" />
	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>후기 신고 리스트</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">숙소 설명</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">판매자 정보</a></li>
				<li class="nav-item"><a class="nav-link active" id="review-tab"
					data-toggle="tab" href="#review" role="tab" aria-controls="review"
					aria-selected="false">숙소 후기</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<p style="white-space: pre">${room.roomProfile}</p>
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="table-responsive">
						<div class="review_item">
							<div class="media">
								<div class="d-flex">
								<c:choose>
								<c:when test="${login ==null }">
								<a href="/haroobang/account/login.action" id="idCheck">
								</c:when>
								<c:otherwise>
								<a href="/haroobang/message/messageRoomBoxes.action?memberNo=${member.memberNo}&loginMemberNo=${login.memberNo}">
								</c:otherwise>
								</c:choose>
								<img src="/haroobang/resources/upload/default.jpg" class="rounded-circle" style="height: 60px;width:60px" alt=""></a>
								</div>

								<div class="media-body">
									<h4>${member.nickname}님에게 메세지 보내기</h4>
									<p>${member.profile}</p>
								</div>
							</div>

						</div>
					</div>
				</div>

				<div class="tab-pane fade show active" id="review" role="tabpanel"
					aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg-6">
							<div class="row total_rate">
				
								<div class="col-6">
									<div class="rating_list">
										<h3>Based on ${room.roomCommentList.size() } Reviews</h3>
										<ul class="list">
						
										</ul>
									</div>
								</div>
							</div>
							<div class="review_list">
								<div class="review_item" style="width: 1050px">
								<c:choose>
								<c:when test="${room.roomCommentList.size()>0 }">
								<hr>
							<c:forEach var="comment" items="${room.roomCommentList }">
								<div class="media">
										<div class="d-flex">
										<hr>
										<hr><hr><hr>
										<c:choose>
										<c:when test="${empty comment.member.savedFileName }">
										<img style="width:50px;height:50px;border-radius:50px" src="/haroobang/resources/upload/default.jpg"/>
										</c:when>
										<c:otherwise>
										<img style="width:50px;height:50px;border-radius:50px" src="/haroobang/resources/upload/${comment.member.savedFileName }">
										</c:otherwise>
										</c:choose>
											
										</div>
										<div class="media-body">
											<h4>${comment.nickName }</h4>
											
											<c:forEach var="y" begin="1" end="${comment.rates}">
											<i class="fa fa-star"></i>
											</c:forEach>
											<%-- <c:forEach var="z" begin="1" end="${5 - comment.rates}">
											<i class="fa fa-star"></i>	
											</c:forEach> --%>
										</div>
										
									</div>
								
									<div style="display: inline;width: 500px">
									<p style="white-space: pre">${comment.content }</p>
										<a class="reply_btn" href="javascript:" id="report" commentNo="${comment.commentNo }" style="color:gray;font-size: 10px;">신고하기</a>
										<hr>
									</div>
									
									<br>
								</c:forEach>
								</c:when>
								<c:otherwise>
								<hr>
								<div class="review_item">
									<p>&nbsp;&nbsp;&nbsp;등록된 후기가 없습니다.</p>
								</div>
								</c:otherwise>
								</c:choose>
						
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Product Description Area =================-->
	<jsp:include page="../include/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/include/js.jsp" />

</body>

</html>