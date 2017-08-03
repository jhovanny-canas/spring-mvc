<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
<script src="<spring:url value="/resources/js/resource.js"/>"></script>
</head>
<body>

	<jsp:include page="../views/layout/header.jsp"></jsp:include>

	<div class="container">

		<div class="row">
			<h1>Resource</h1>
		</div>

		<spring:url value="/resource/review" var="formUrl" />
		<form:form method="POST" action="${formUrl}" modelAttribute="resource">

			<div class="row">

				<div class="form-group">
					<label for="resource-name">Name</label>
					<form:input path="name" cssClass="form-control" id="resource-name" />
					<!-- 					<input type="text" -->
					<!-- 						id="resource-name" class="form-control" name="name" /> -->
				</div>

				<div class="form-group">
					<label for="resource-type">Type</label>

					<form:select id="resource-type" path="type" items="${typeOptions}"
						cssClass="selectpicker" />
					<!-- 
					<select id="resource-type" name="type" class="selectpicker">
						<option></option>
						<option value="material">Material</option>
						<option value="other">Other</option>
						<option value="staff">Staff</option>
						<option value="tech">Technical Equipment</option>
					</select>  -->

				</div>

				<div class="form-group">
					<label for="unit">Unit of Measure</label>
					<form:radiobuttons id="unit" path="unitOfMeasure"
						items="${radioOptions}" />

					<!-- 					<input id="unit" -->
					<!-- 						type="text" class="form-control" name="unitOfMeasure" /> -->
				</div>

				<div class="form-group">
					<label for="indicators">Indicators</label>
					<form:checkboxes id="indicators" path="indicators"
						items="${checkOptions}" />
					<a id="request-link"
						href="<spring:url value="/resource/request" />">Send Request</a>
				</div>

				<div class="form-group">
					<label for="notes">Notes</label>
					<form:textarea id="notes" path="notes" class="form-control"
						rows="3" />
				</div>


				<button type="submit" class="btn btn-default">Submit</button>

			</div>

		</form:form>

	</div>
</body>
</html>
