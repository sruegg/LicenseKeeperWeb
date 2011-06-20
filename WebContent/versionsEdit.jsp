<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>LicenseKeeper</title>
</head>
<body>
	<h1>Licenses</h1>

	<h2>Versions</h2>

	<html:errors />

	<html:form action="/versionsSave.do" method="POST">
		<html:hidden property="id" />
		<table>
			<tr>
				<td>Publisher:</td>
				<td><html:text property="minor" />
				</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><html:text property="major" />
				</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><html:text property="build" />
				</td>
			</tr>
			<tr>
				<td><html:submit value="Valider" />
				</td>
				<td><html:cancel value="Cancel" />
				</td>
			</tr>
		</table>
	</html:form>

</body>
</html>