<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<head>
<title>Movie List</title>
</head>
<body>
<p><img align="bottom" alt="Bang the Bongos" src="../images/a032ani.gif"/>
<big><strong>Current Movie List</strong></big></p>

<logic:equal name="movieList" scope="request" property="empty" value="true">
<p>No Movies Currently...</p>
</logic:equal>

<logic:equal name="movieList" scope="request" property="empty" value="false">
<table border="1" cellspacing="0" cellpadding="1" width="100%">
<tr>
  <th width="20%">Movie Name</th>
  <th width="10%">Rating</th>
  <th width="10%">Worth Seeing Again</th>
  <th width="10%">Scale (1 - 10)</th>
  <th width="40%">Comment</th>
</tr>
<logic:iterate name="movieList" scope="request" id="movie">
<tr>
  <td>
    <html:link page="/do/ChangeMovie" paramId="id" paramName="movie" paramProperty="id">
      <bean:write name="movie" property="name"/>
    </html:link>
  </td>
  <td><bean:write name="movie" property="rating.description"/></td>
  <td><bean:write name="movie" property="worthSeeingAgain"/></td>
  <td><bean:write name="movie" property="scale"/></td>
  <td><bean:write name="movie" property="comment"/></td>
</tr>
</logic:iterate>
</table>
</logic:equal>

<html:link page="/do/AddMovie">Add New Movie</html:link>
<logic:equal name="movieList" scope="request" property="empty" value="false">
<html:link page="/do/ClearList">Clear List</html:link>
</logic:equal>
<html:link page="/do/Logon">Logoff</html:link>

</body>
</html:html>
