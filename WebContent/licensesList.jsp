<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>LicenseKeeper</title>
</head>
<body>
	<h1>Licenses</h1>

	<h2>Operating Systems</h2>
	<table border="1" width="800">
		<tr>
			<th width="10%">Category</th>
			<th width="20%">Publisher</th>
			<th width="20%">Name</th>
			<th width="30%">Description</th>
			<th width="10%">Service Pack Version</th>
			<th width="10%">Actions</th>
		</tr>
		<logic:iterate id="licensedobjectOS" name="licensedObjectsOS">
			<tr>
				<td><bean:write name="licensedobjectOS" property="category.name" />
				<td><bean:write name="licensedobjectOS" property="publisher" />
				</td>
				<td><bean:write name="licensedobjectOS" property="name" /></td>
				<td><bean:write name="licensedobjectOS" property="description" />
				</td>
				<td><bean:write name="licensedobjectOS" property="servicePackVersion" />
				</td>
				<td><html:link page="/licensesOSEdit.do"
						paramId="licensedObjectId" paramName="licensedobjectOS"
						paramProperty="id">
        edit
        </html:link></td>

			</tr>
		</logic:iterate>

	</table>


	<ul>
		<li><html:link page="/licensesOSEdit.do">Ajout d'un license</html:link>
		</li>
	</ul>
	
	<h2>Softwares</h2>
	<table border="1" width="800">
		<tr>
			<th width="10%">Category</th>
			<th width="20%">Publisher</th>
			<th width="20%">Name</th>
			<th width="30%">Description</th>
			<th width="10%">Actions Limit</th>
			<th width="10%">Actions</th>
		</tr>
		<logic:iterate id="licensedobjectSW" name="licensedObjectsSW">
			<tr>
				<td><bean:write name="licensedobjectOS" property="category.name" />
				<td><bean:write name="licensedobjectSW" property="publisher" />
				</td>
				<td><bean:write name="licensedobjectSW" property="name" /></td>
				<td><bean:write name="licensedobjectSW" property="description" />
				<td><bean:write name="licensedobjectSW" property="activationsLimit" />
				</td>
				<td><html:link page="/licensesSWEdit.do"
						paramId="licensedObjectId" paramName="licensedobjectSW"
						paramProperty="id">
        edit
        </html:link></td>

			</tr>
		</logic:iterate>

	</table>


	<ul>
		<li><html:link page="/licensesSWEdit.do">Ajout d'un license</html:link>
		</li>
	</ul>

</body>
</html>

