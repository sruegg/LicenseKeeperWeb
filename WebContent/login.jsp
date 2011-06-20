<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>LicenseKeeper</title>
</head>
<body>

	<html:errors />

	<html:form action="" method="POST">

		username :
		<html:text property="username" />
		<br />
		password :
		<html:text property="password" />
		<br />

		<html:submit value="Login" />

	</html:form>

</body>
</html>