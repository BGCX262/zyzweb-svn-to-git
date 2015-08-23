<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.io.PrintWriter" %>

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%Exception ex=(Exception)request.getAttribute("exception");%>
<%=ex.getLocalizedMessage() %>
<!-- <H2>Exception:</H2> -->
<%-- <%ex.printStackTrace(new PrintWriter(out));%> --%>

</body>
</html>