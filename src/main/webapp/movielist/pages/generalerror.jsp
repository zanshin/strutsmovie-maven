<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
<head>
<title>generalerror.jsp</title>
</head>
<body>
<h1>General Movielist Error</h1>
<p>Error Message: <bean:write name="movielist.exception" property="message"/></p>
<p>Try Logging on the the application <html:link page="/do/Logon">here</html:link>
</p>
<p>Retry your previous request <a href="javascript:history.back()">here</a></p>
</body>
</html>