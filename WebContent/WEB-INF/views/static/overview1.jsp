<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
<div class="col-12 grid-margin">
<div class="card">
<div class="card-body">
<div class="row" >

                      <div class="col-md-6 h-100">
                     
                      <div  class="bg-secondary p-4">
                          <h6 class="card-title">Hành Chính</h6>
                          <div id="profile-list-left" class="py-2">
                         	<c:forEach var="u" items="${overview1}"> 
                            <div class="card rounded mb-2">
                              <div class="card-body p-3">
                                <div class="media">
                        <img  class="img-sm mr-3 rounded-circle" src="<c:url value="/upload/${u[0]}"/>"
								width="80" height="70" />
                                  
                                  <div class="media-body">
                                 
                                    <h6 class="mb-1">${u[1] }</h6>
                                    <p class="mb-0 text-muted"> ${u[2] } </p>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </c:forEach> 
                            
                     
                             </div>
                        </div>
    
                </div>
                                        <div class="col-lg-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Bar chart</h4>
                    <div id="morris-bar-example" style="position: relative; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"><svg height="342" version="1.1" width="409" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="overflow: hidden; position: relative; left: -0.5px; top: -0.90625px;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.2.0</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><text x="32.859375" y="303" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">0</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.359375,303H383.5" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.859375" y="233.5" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">25</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.359375,233.5H383.5" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.859375" y="164" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">50</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.359375,164H383.5" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.859375" y="94.50000000000003" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan dy="4.000000000000028" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">75</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.359375,94.50000000000003H383.5" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="32.859375" y="25" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">100</tspan></text><path fill="none" stroke="#aaaaaa" d="M45.359375,25H383.5" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="359.3470982142857" y="315.5" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,7)"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2012</tspan></text><text x="262.73549107142856" y="315.5" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,7)"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2010</tspan></text><text x="166.12388392857144" y="315.5" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,7)"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2008</tspan></text><text x="69.51227678571428" y="315.5" text-anchor="middle" font-family="sans-serif" font-size="12px" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;" font-weight="normal" transform="matrix(1,0,0,1,0,7)"><tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2006</tspan></text><rect x="51.39760044642857" y="25" width="16.614676339285715" height="278" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="71.01227678571428" y="52.80000000000001" width="16.614676339285715" height="250.2" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="99.70340401785714" y="94.50000000000003" width="16.614676339285715" height="208.49999999999997" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="119.31808035714286" y="122.30000000000001" width="16.614676339285715" height="180.7" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="148.00920758928572" y="164" width="16.614676339285715" height="139" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="167.62388392857144" y="191.8" width="16.614676339285715" height="111.19999999999999" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="196.31501116071428" y="94.50000000000003" width="16.614676339285715" height="208.49999999999997" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="215.9296875" y="122.30000000000001" width="16.614676339285715" height="180.7" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="244.62081473214283" y="164" width="16.614676339285715" height="139" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="264.23549107142856" y="191.8" width="16.614676339285715" height="111.19999999999999" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="292.9266183035714" y="94.50000000000003" width="16.614676339285715" height="208.49999999999997" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="312.5412946428571" y="122.30000000000001" width="16.614676339285715" height="180.7" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="341.232421875" y="25" width="16.614676339285715" height="278" rx="0" ry="0" fill="#63cf72" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect><rect x="360.8470982142857" y="52.80000000000001" width="16.614676339285715" height="250.2" rx="0" ry="0" fill="#f36368" stroke="none" fill-opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); fill-opacity: 1;"></rect></svg><div class="morris-hover morris-default-style" style="left: 77.1306px; top: 137px;"><div class="morris-hover-row-label">2007</div><div class="morris-hover-point" style="color: #63CF72">
  Series A:
  75
</div><div class="morris-hover-point" style="color: #F36368">
  Series B:
  65
</div></div></div>
                  </div>
                </div>
             
              </div>
                </div>
                </div>
                </div>
                      </div>
                  </div>
              
</body>
</html>