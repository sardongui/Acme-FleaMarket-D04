<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-moment code="authenticated.message.form.label.creation" path="creation"/>
	<acme:form-textbox code="authenticated.message.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.message.form.label.body" path="body"/>
	<acme:form-textbox code="authenticated.message.form.label.tags" path="tags"/>
	
	<acme:form-submit test="${command == 'create' }" method="post"
		code="authenticated.message.form.button.create" 
		action="/authenticated/message/create"/>
	
	<acme:form-return code="authenticated.message.form.button.return"/>
</acme:form>


