
<%
	String view = request.getParameter("view");

if (view.startsWith("static/")) {

	pageContext.forward("home.jsp");

} else if (view.startsWith("login")) {
	pageContext.forward("login.jsp");
} else if (view.startsWith("client")) {

	pageContext.forward("client.jsp");
} else if (view.startsWith("index")) {

	pageContext.forward("index.jsp");
} else if (view.startsWith("register")) {

	pageContext.forward("register.jsp");
} else if (view.startsWith("successregister")) {

	pageContext.forward("successregister.jsp");
}
else if (view.startsWith("forgotpassword")) {

	pageContext.forward("forgotpassword.jsp");
}
else if (view.startsWith("successpassword")) {

	pageContext.forward("successpassword.jsp");
}
else if (view.startsWith("error")) {

	pageContext.forward("error.jsp");
}
%>