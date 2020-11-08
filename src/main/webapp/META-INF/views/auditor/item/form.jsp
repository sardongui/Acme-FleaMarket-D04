<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-moment code="auditor.item.form.label.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="auditor.item.form.label.ticker" path="ticker"/>
	<acme:form-textbox code="auditor.item.form.label.title" path="title"/>
	<acme:form-textbox code="auditor.item.form.label.description" path="description"/>
	<acme:form-url code="auditor.item.form.label.photo" path="photo"/>
	<acme:form-textbox code="auditor.item.form.label.itemCategory" path="itemCategory"/>
	<acme:form-money code="auditor.item.form.label.price" path="price"/>
	<acme:form-url code="auditor.item.form.label.link" path="link"/>
	
	<acme:form-submit method="get" code="auditor.audit-record.form.button.list"
	 	action="/auditor/auditor-record/list-mine"/>
	<acme:form-return code="auditor.item.form.button.return"/>
	
	<input id="audit-record" name="audit-record" value="${auditRecord}" type="hidden" />
    
</acme:form>