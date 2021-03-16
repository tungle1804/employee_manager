<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
 <link href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/auth.scss" />" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js">
 
</script> 
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title mb-4">Gửi Phản Hồi Thành Công</h4>
			<div class="email">
				<div class="table-responsive mb-4">
					<table style="background: #f3f3f3; width: 100%; height: 100%;"
						cellpadding="0" cellspacing="0" border="0">
						<tbody>
							<tr>
								<td style="padding: 50px;">
									<table style="width: 550px; margin: 0 auto" cellpadding="0"
										cellspacing="0" border="0">
																
										<tbody>
											<tr style="border-bottom: 1px dashed #ddd">
												<td
													style="width: 175px; height: 20px; font-family: Roboto; font-size: 18px; font-weight: 500; font-style: normal; font-stretch: normal; line-height: 1.11; letter-spacing: normal; text-align: center; color: #001737; padding-bottom: 22px">
													Cảm Ơn Bạn Đã Quan Tâm</td>
											</tr>
					
											<tr>
											
												<td style="padding-top: 20px;"><img
													style="float: left; width: 170px;"
													src="resources/theme1/images/logo.svg" alt="Logo">
													</td>
											</tr>
											<tr>
												<td
													style="border-radius: 10px; background: #fff; padding: 30px 60px 20px 60px; margin-top: 10px; display: block;">
													<p
														style="font-family: Roboto; font-size: 14px; font-weight: 500; font-style: normal; font-stretch: normal; line-height: 1.71; letter-spacing: normal; color: #001737; margin-bottom: 10px;">
														Hi ${fullname}</p>
													<p
														style="font-family: Roboto; font-size: 14px; font-weight: normal; font-style: normal; font-stretch: normal; line-height: 1.71; letter-spacing: normal; color: #001737;">
														 Để trở thành nhân viên . Tài khoản của bạn hiện đang trong thời gian xác minh</p>
													<p
														style="font-family: Roboto; font-size: 14px; font-weight: normal; font-style: normal; font-stretch: normal; line-height: 1.71; letter-spacing: normal; color: #001737;">
														Hy vọng bạn sẽ thích trải nghiệm, chúng tôi ở đây nếu bạn có bất kỳ câu hỏi nào, hãy gửi cho chúng tôi theo địa chỉ tungbeng@gmail.com bất cứ lúc nào.</p>
													<p
														style="font-family: Roboto; font-size: 14px; font-weight: normal; font-style: normal; font-stretch: normal; line-height: 1.71; letter-spacing: normal; color: #001737; margin-bottom: 0px;">
														Chúc may mắn! Hy vọng nó hoạt động.</p>
													<p
														style="font-family: Roboto; font-size: 14px; font-weight: 500; font-style: normal; font-stretch: normal; line-height: 2.5; letter-spacing: normal; color: #001737; margin-bottom: 0px;">
														Lê Anh Tùng</p>
														<a href="home/login.htm" style=" height: 34px;background: linear-gradient(to right, #da8cff, #9a55ff);border: none;color: #fff;padding:
                                      8px 20px;border-radius: 4px;display: inline-block;margin-left: 10px;margin-bottom:
                                      20px;">Sign up for free now</a>
												</td>
											</tr>
										</tbody>
									</table>
									<table style="width: 245px; margin: 20px auto 0 auto;"
										cellpadding="0" cellspacing="0" border="0">
										<tbody>
											<tr>
												<td>
													<table style="float: left; margin-right: 15px;"
														cellpadding="0" cellspacing="0" border="0">
														<tbody>
															<tr>
																<td
																	style="background: #e6e6e6; color: #2b80ff; border-radius: 100%; height: 35px; width: 35px; margin-right: 20px;">
																	<img
																	style="display: block; margin: auto; max-width: 8px;"
																	src="resources/theme1/images/fb.png"
																	alt="facebook">
																</td>
															</tr>
														</tbody>
													</table>
													<table style="float: left; margin-right: 15px;"
														cellpadding="0" cellspacing="0" border="0">
														<tbody>
															<tr>
																<td
																	style="background: #e6e6e6; color: #2b80ff; border-radius: 100%; height: 35px; width: 35px; margin-right: 20px;">
																	<img
																	style="display: block; margin: auto; max-width: 15px;"
																	src="resources/theme1/images/twitter.png"
																	alt="facebook">
																</td>
															</tr>
														</tbody>
													</table>
													<table style="float: left; margin-right: 15px;"
														cellpadding="0" cellspacing="0" border="0">
														<tbody>
															<tr>
																<td
																	style="background: #e6e6e6; color: #2b80ff; border-radius: 100%; height: 35px; width: 35px; margin-right: 20px;">
																	<img
																	style="display: block; margin: auto; max-width: 15px;"
																	src="resources/theme1/images/youtube.png"
																	alt="facebook">
																</td>
															</tr>
														</tbody>
													</table>
													<table style="float: left; margin-right: 15px;"
														cellpadding="0" cellspacing="0" border="0">
														<tbody>
															<tr>
																<td
																	style="background: #e6e6e6; color: #2b80ff; border-radius: 100%; height: 35px; width: 35px; margin-right: 20px;">
																	<img
																	style="display: block; margin: auto; max-width: 15px;"
																	src="resources/theme1/images/medium.png"
																	alt="facebook">
																	
																</td>
															</tr>
														</tbody>
													</table>
													<table style="float: left;" cellpadding="0" cellspacing="0"
														border="0">
														<tbody>
															<tr>
																<td
																	style="background: #e6e6e6; color: #2b80ff; border-radius: 100%; height: 35px; width: 35px; margin-right: 20px;">
																	<img
																	style="display: block; margin: auto; max-width: 15px;"
																	src="resources/theme1/images/slack.png"
																	alt="facebook">
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<table style="margin: 20px auto 10px auto;" cellpadding="0"
										cellspacing="0" border="0">
										<tbody>
											<tr>
												<td
													style="font-family: Roboto; font-size: 14px; font-weight: normal; font-style: normal; font-stretch: normal; line-height: normal; letter-spacing: normal; color: #001737;">
													Copyright © 2019 Bootstrapdash. All rights reserved.</td>
											</tr>
											<tr>
												<td
													style="font-family: Roboto; font-size: 14px; font-weight: normal; font-style: normal; font-stretch: normal; line-height: normal; letter-spacing: normal; color: #bbb; text-align: center; padding-top: 15px;">
													Don't like these emails? <a style="color: inherit;"
													href="#">Unsubscribe</a>
													
												</td>
											</tr>
											
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				
				
			
			</div>
		</div>
	</div>
	 <script src="<c:url value="/resources/theme1/js/off-canvas.js" />"></script>
    <script src="<c:url value="/resources/theme1/js/misc.js" />"></script>
    <script src="<c:url value="/resources/theme1/js/hoverable-collapse.js" />"></script> 
    <script src="<c:url value="/resources/theme1/js/vendor.bundle.base.js" />"></script>  --%>
	
</body>
</html>