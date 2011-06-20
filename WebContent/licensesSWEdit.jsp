<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>LicenseKeeper</title>
</head>
<body>
	<h1>Licenses</h1>

	<h2>Softwares</h2>
	
	<h3>Edit Object</h3>

	<html:errors />

	<html:form action="/licensesSWSave.do" method="POST">
		<html:hidden property="id" />

		<table>
			<tr>
				<td>Category:</td>
				<td><html:select property="category">
						<html:optionsCollection property="categories" label="name"
							value="id" />
					</html:select></td>
			</tr>
			<tr>
				<td>Publisher:</td>
				<td><html:text property="publisher" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><html:text property="name" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><html:text property="description" /></td>
			</tr>
			<tr>
				<td>Activations Limit:</td>
				<td><html:text property="activationsLimit" /></td>
			</tr>
			<tr>
				<td><html:submit value="Valider" /></td>
				<td><html:cancel value="Cancel" /></td>
			</tr>
		</table>
	</html:form>

	<logic:notEmpty name="licensedObjectsVersions">

		<h2>Versions</h2>
		<table border="1" width="800">
			<tr>
				<th width="20%">Major</th>
				<th width="20%">Minor</th>
				<th width="30%">Build</th>
				<th width="10%">Keys</th>
				<th width="20%">Actions</th>
			</tr>
			<logic:iterate id="licensedObjectsVersion"
				name="licensedObjectsVersions">
				<tr>
					<td><bean:write name="licensedObjectsVersion" property="major" />
					</td>
					<td><bean:write name="licensedObjectsVersion" property="minor" />
					</td>
					<td><bean:write name="licensedObjectsVersion" property="build" />
					</td>
					<td><html:link page="/keysList.do" paramId="versionId"
							paramName="licensedObjectsVersion" paramProperty="id">
        view key
        </html:link>
					</td>
					<td>edit</td>
				</tr>
			</logic:iterate>
		</table>

	</logic:notEmpty>

</body>
</html>