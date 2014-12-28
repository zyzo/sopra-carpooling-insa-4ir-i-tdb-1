

<t:baseLayout>

	<c:forEach var="workplace" items="${list}">
		<p> <c:out value="${workplace.city}"/> </p>
	</c:forEach>

	<%-- 
			<button type="button" class="btn btn-default">Modify</button>
			<button type="button" class="btn btn-danger">Delete</button>
	--%>


</t:baseLayout>