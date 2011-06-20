<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>LicenseKeeper</title>
</head>
<body>
	<h1>Licenses</h1>

	<h2>Keys</h2>
	<table border="1" width="800">
		<tr>
			<th>Key</th>
		</tr>
		<logic:iterate id="licensedObjectsKey" name="licensedObjectsKeys">
			<tr>
				<td><bean:write name="licensedObjectsKey" property="licenseKey" />
				</td>
			</tr>
		</logic:iterate>

	</table>

	<html:link page="/licensesOSEdit.do" paramId="licensedObjectId"
		paramName="licensedObject" paramProperty="id">
        retour
        </html:link>

</body>
</html>

