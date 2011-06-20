<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>LicenseKeeper</title>
</head>
<body>
	<h1>LicenseKeeper</h1>

	<ul>
		<li><html:link forward="login">Login</html:link></li>
		<li><html:link forward="licensesList">Liste Licenses</html:link></li>
	</ul>

</body>
</html>