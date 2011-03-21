<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title>Struts Movie List</title>
</head>
<body>
<table border="0" width="100%">
  <tr>
    <td><h2>Welcome to the Movie List Application</h2>
        <p>The current time is <%=new java.util.Date()%></p>
        <hr/>
    </td>
  </tr>
  <tr>
    <td><template:get name="content"/></td>
  </tr>
</table>
</body>
</html:html>