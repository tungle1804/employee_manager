<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="s"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/theme1/css/style.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />"
	rel="stylesheet">
</head>
<body>
<%-- <div class="content-wrapper">
					<div class="row" id="proBanner">
						<div class="col-12">
							<span class="d-flex align-items-center purchase-popup">
								<p>Get tons of UI components, Plugins, multiple layouts, 20+
									sample pages, and more!</p> <a
								href="https://www.bootstrapdash.com/product/purple-bootstrap-admin-template?utm_source=organic&utm_medium=banner&utm_campaign=free-preview"
								target="_blank"
								class="btn download-button purchase-button ml-auto">Upgrade
									To Pro</a> <i class="mdi mdi-close" id="bannerClose"></i>
							</span>
						</div>
					</div>
					<div class="page-header">
						<h3 class="page-title">
							<span class="page-title-icon bg-gradient-primary text-white mr-2">
								<i class="mdi mdi-home"></i>
							</span> Dashboard
						</h3>
						<nav aria-label="breadcrumb">
							<ul class="breadcrumb">
								<li class="breadcrumb-item active" aria-current="page"><span></span>Overview
									<i
									class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
								</li>
							</ul>
						</nav>
					</div>
					<div class="row">
						<div class="col-md-4 stretch-card grid-margin">
							<div class="card bg-gradient-danger card-img-holder text-white">
								<div class="card-body">
									<img src="resources/theme1/images/circle.svg"
										class="card-img-absolute" alt="circle-image" />
									<h4 class="font-weight-normal mb-3">
										Weekly Sales <i
											class="mdi mdi-chart-line mdi-24px float-right"></i>
									</h4>
									<h2 class="mb-5">$ 15,0000</h2>
									<h6 class="card-text">Increased by 60%</h6>
								</div>
							</div>
						</div>
						<div class="col-md-4 stretch-card grid-margin">
							<div class="card bg-gradient-info card-img-holder text-white">
								<div class="card-body">
									<img src="resources/theme1/images/circle.svg"
										class="card-img-absolute" alt="circle-image" />
									<h4 class="font-weight-normal mb-3">
										Weekly Orders <i
											class="mdi mdi-bookmark-outline mdi-24px float-right"></i>
									</h4>
									<h2 class="mb-5">45,6334</h2>
									<h6 class="card-text">Decreased by 10%</h6>
								</div>
							</div>
						</div>
						<div class="col-md-4 stretch-card grid-margin">
							<div class="card bg-gradient-success card-img-holder text-white">
								<div class="card-body">
									<img src="resources/theme1/images/circle.svg"
										class="card-img-absolute" alt="circle-image" />
									<h4 class="font-weight-normal mb-3">
										Visitors Online <i
											class="mdi mdi-diamond mdi-24px float-right"></i>
									</h4>
									<h2 class="mb-5">95,5741</h2>
									<h6 class="card-text">Increased by 5%</h6>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-12 grid-margin">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Recent Tickets</h4>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>NO.</th>
													<th>Photo</th>
													<th>Fullname</th>
													<th>Department</th>
													
												</tr>
											</thead>
											<tbody>
												 <c:forEach items="${top}" var="R" varStatus="status">											 		
						<tr>
						  <td>${status.index+1}</td>
						     <td><img src="upload/${R[1]}" width="80" height="70"></td>
						    <td>${R[0]}</td>
						             
                           <td>${R[2]}</td>
                         
                         
                             <td>${R[3]}</td>
                                       
                        </tr>                          
                      </c:forEach>  
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Recent Updates</h4>
									<div class="d-flex">
										<div
											class="d-flex align-items-center mr-4 text-muted font-weight-light">
											<i class="mdi mdi-account-outline icon-sm mr-2"></i> <span>jack
												Menqu</span>
										</div>
										<div
											class="d-flex align-items-center text-muted font-weight-light">
											<i class="mdi mdi-clock icon-sm mr-2"></i> <span>October
												3rd, 2018</span>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-6 pr-1">
											<img src="resources/theme1/images/img_1.jpg"
												class="mb-2 mw-100 w-100 rounded" alt="image"> <img
												src="resources/theme1/images/img_4.jpg"
												class="mw-100 w-100 rounded" alt="image">
										</div>
										<div class="col-6 pl-1">
											<img src="resources/theme1/images/img_2.jpg"
												class="mb-2 mw-100 w-100 rounded" alt="image"> <img
												src="resources/theme1/images/img_3.jpg"
												class="mw-100 w-100 rounded" alt="image">
										</div>
									</div>
									<div class="d-flex mt-5 align-items-top">
										<img src="resources/theme1/images/face1.jpg"
											class="img-sm rounded-circle mr-3" alt="image">
										<div class="mb-0 flex-grow">
											<h5 class="mr-2 mb-2">School Website - Authentication
												Module.</h5>
											<p class="mb-0 font-weight-light">It is a long
												established fact that a reader will be distracted by the
												readable content of a page.</p>
										</div>
										<div class="ml-auto">
											<i class="mdi mdi-heart-outline text-muted"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-7 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Project Status</h4>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>#</th>
													<th>Name</th>
													<th>Due Date</th>
													<th>Progress</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Herman Beck</td>
													<td>May 15, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-success"
																role="progressbar" style="width: 25%" aria-valuenow="25"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Messsy Adam</td>
													<td>Jul 01, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-danger"
																role="progressbar" style="width: 75%" aria-valuenow="75"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>3</td>
													<td>John Richards</td>
													<td>Apr 12, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-warning"
																role="progressbar" style="width: 90%" aria-valuenow="90"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>4</td>
													<td>Peter Meggik</td>
													<td>May 15, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-primary"
																role="progressbar" style="width: 50%" aria-valuenow="50"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>5</td>
													<td>Edward</td>
													<td>May 03, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-danger"
																role="progressbar" style="width: 35%" aria-valuenow="35"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>5</td>
													<td>Ronald</td>
													<td>Jun 05, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-info"
																role="progressbar" style="width: 65%" aria-valuenow="65"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title text-white">Todo</h4>
									<div class="add-items d-flex">
										<input type="text" class="form-control todo-list-input"
											placeholder="What do you need to do today?">
										<button
											class="add btn btn-gradient-primary font-weight-bold todo-list-add-btn"
											id="add-task">Add</button>
									</div>
									<div class="list-wrapper">
										<ul
											class="d-flex flex-column-reverse todo-list todo-list-custom">
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Meeting with
														Alisa
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li class="completed">
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox" checked> Call
														John
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Create invoice
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Print Statements
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li class="completed">
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox" checked> Prepare
														for presentation
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Pick up kids
														from school
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div> --%>
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">
							<span class="page-title-icon bg-gradient-primary text-white mr-2">
								<i class="mdi mdi-home"></i>
							</span> Dashboard
						</h3>
						<nav aria-label="breadcrumb">
							<ul class="breadcrumb">
								<li class="breadcrumb-item active" aria-current="page"><span></span>Overview
									<i
									class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
								</li>
							</ul>
						</nav>
					</div>
					<div class="row">
						<div class="col-md-4 stretch-card grid-margin">
							<div class="card bg-gradient-danger card-img-holder text-white">
								<div class="card-body">
									<img src="resources/theme1/images/circle.svg"
										class="card-img-absolute" alt="circle-image" />
									<h4 class="font-weight-normal mb-3">
										Tổng Số Đánh Giá <i
											class="mdi mdi-chart-line mdi-24px float-right"></i>
									</h4>
									<h2 class="mb-5">${totalstaffachievement[0]}</h2>
									<h6 class="card-text">Tăng 60%</h6>
								</div>
							</div>
						</div>
						<div class="col-md-4 stretch-card grid-margin">
							<div class="card bg-gradient-info card-img-holder text-white">
								<div class="card-body">
									<img src="resources/theme1/images/circle.svg"
										class="card-img-absolute" alt="circle-image" />
									<h4 class="font-weight-normal mb-3">
										Tổng Số Khen Thưởng <i
											class="mdi mdi-bookmark-outline mdi-24px float-right"></i>
									</h4>
									<h2 class="mb-5">${totalstaffachievement2[0]}</h2>
									<h6 class="card-text">Tăng 10%</h6>
								</div>
							</div>
						</div>
						<div class="col-md-4 stretch-card grid-margin">
							<div class="card bg-gradient-success card-img-holder text-white">
								<div class="card-body">
									<img src="resources/theme1/images/circle.svg"
										class="card-img-absolute" alt="circle-image" />
									<h4 class="font-weight-normal mb-3">
										Tổng Số Kỷ Luật<i
											class="mdi mdi-diamond mdi-24px float-right"></i>
									</h4>
									<h2 class="mb-5">${totalstaffachievement1[0]}</h2>
									<h6 class="card-text">Tăng 5%</h6>
								</div>
							</div>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-12 grid-margin">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Recent Tickets</h4>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>NO.</th>
													<th>Photo</th>
													<th>Fullname</th>
													<th>Department</th>
													
												</tr>
											</thead>
											<tbody>
																	 <c:forEach items="${top}" var="R" varStatus="status">											 		
						<tr>
						  <td>${status.index+1}</td>
						     <td><img src="upload/${R[1]}" width="80" height="70"></td>
						    <td>${R[0]}</td>
						             
                           <td>${R[2]}</td>
                         
                         
                             <td>${R[3]}</td>
                                       
                        </tr>                          
                      </c:forEach> 
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Recent Updates</h4>
									<div class="d-flex">
										<div
											class="d-flex align-items-center mr-4 text-muted font-weight-light">
											<i class="mdi mdi-account-outline icon-sm mr-2"></i> <span>jack
												Menqu</span>
										</div>
										<div
											class="d-flex align-items-center text-muted font-weight-light">
											<i class="mdi mdi-clock icon-sm mr-2"></i> <span>October
												3rd, 2018</span>
										</div>
									</div>
									<div class="row mt-3">
										<div class="col-6 pr-1">
											<img src="resources/theme1/images/img_1.jpg"
												class="mb-2 mw-100 w-100 rounded" alt="image"> <img
												src="resources/theme1/images/img_4.jpg"
												class="mw-100 w-100 rounded" alt="image">
										</div>
										<div class="col-6 pl-1">
											<img src="resources/theme1/images/img_2.jpg"
												class="mb-2 mw-100 w-100 rounded" alt="image"> <img
												src="resources/theme1/images/img_3.jpg"
												class="mw-100 w-100 rounded" alt="image">
										</div>
									</div>
									<div class="d-flex mt-5 align-items-top">
										<img src="resources/theme1/images/face1.jpg"
											class="img-sm rounded-circle mr-3" alt="image">
										<div class="mb-0 flex-grow">
											<h5 class="mr-2 mb-2">School Website - Authentication
												Module.</h5>
											<p class="mb-0 font-weight-light">It is a long
												established fact that a reader will be distracted by the
												readable content of a page.</p>
										</div>
										<div class="ml-auto">
											<i class="mdi mdi-heart-outline text-muted"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-7 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Project Status</h4>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>#</th>
													<th>Name</th>
													<th>Due Date</th>
													<th>Progress</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Herman Beck</td>
													<td>May 15, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-success"
																role="progressbar" style="width: 25%" aria-valuenow="25"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Messsy Adam</td>
													<td>Jul 01, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-danger"
																role="progressbar" style="width: 75%" aria-valuenow="75"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>3</td>
													<td>John Richards</td>
													<td>Apr 12, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-warning"
																role="progressbar" style="width: 90%" aria-valuenow="90"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>4</td>
													<td>Peter Meggik</td>
													<td>May 15, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-primary"
																role="progressbar" style="width: 50%" aria-valuenow="50"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>5</td>
													<td>Edward</td>
													<td>May 03, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-danger"
																role="progressbar" style="width: 35%" aria-valuenow="35"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
												<tr>
													<td>5</td>
													<td>Ronald</td>
													<td>Jun 05, 2015</td>
													<td>
														<div class="progress">
															<div class="progress-bar bg-gradient-info"
																role="progressbar" style="width: 65%" aria-valuenow="65"
																aria-valuemin="0" aria-valuemax="100"></div>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title text-white">Todo</h4>
									<div class="add-items d-flex">
										<input type="text" class="form-control todo-list-input"
											placeholder="What do you need to do today?">
										<button
											class="add btn btn-gradient-primary font-weight-bold todo-list-add-btn"
											id="add-task">Add</button>
									</div>
									<div class="list-wrapper">
										<ul
											class="d-flex flex-column-reverse todo-list todo-list-custom">
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Meeting with
														Alisa
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li class="completed">
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox" checked> Call
														John
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Create invoice
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Print Statements
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li class="completed">
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox" checked> Prepare
														for presentation
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
											<li>
												<div class="form-check">
													<label class="form-check-label"> <input
														class="checkbox" type="checkbox"> Pick up kids
														from school
													</label>
												</div> <i class="remove mdi mdi-close-circle-outline"></i>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
			
			</div>
</body>
</html>