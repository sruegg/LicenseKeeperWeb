<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>Liste des licenses</title>
</head>
<body>
	<h1>Licenses</h1>

	<table border="1">
		<logic:iterate id="licensedobject" name="licensedObjects">
			<tr>
				<td><bean:write name="licensedobject" property="publisher" />
				</td>
				<td><bean:write name="licensedobject" property="name" /></td>
				<td><bean:write name="licensedobject" property="description" />
				</td>
				<td><html:link page="/licensesEdit.do"
						paramId="licensedObjectId" paramName="licensedobject"
						paramProperty="id">
        edit
        </html:link></td>

			</tr>
		</logic:iterate>

	</table>


	<ul>
		<li><html:link forward="licensesAdd">Ajout d'un license</html:link>
		</li>
	</ul>

</body>
</html>

