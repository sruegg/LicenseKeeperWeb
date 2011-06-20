<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<html:errors />

<html:form action="/licensesOSSave.do" method="POST">
	<html:hidden property="id" />
	<p>
		Publisher:
		<html:text property="publisher" />
	<p>
		Name:
		<html:text property="name" />
	<p>
		Description:
		<html:text property="description" />
	<p>
		Service pack version:
		<html:text property="servicePackVersion" />
		
		<html:submit value="Valider" />
</html:form>

