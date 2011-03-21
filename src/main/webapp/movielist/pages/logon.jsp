<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<head>
<title><bean:message key="logon.jsp.title"/></title>
</head>
<body>
<h2><bean:message key="logon.jsp.welcome"/></h2>

<html:form action="TryLogon">

<table border="0" cellspacing="0" cellpadding="1">
<tr>
  <td align="right"><bean:message key="logon.jsp.userid"/></td>
  <td><html:text property="userId"/></td>
  <td>See this application in: 
    <html:select property="language">
      <html:options property="languages"/>
    </html:select>
  </td>
</tr>
<tr>
  <td align="right"><bean:message key="logon.jsp.password"/></td>
  <td><html:password property="password"/></td>
  <td></td>
</tr>
</table>

<html:submit property="logon">
  <bean:message key="logon.jsp.logon"/>
</html:submit>
</html:form>
<p>Hint: try &quot;fred&quot; &quot;flintstone&quot;</p>
<html:errors/>

</body>
</html:html>
