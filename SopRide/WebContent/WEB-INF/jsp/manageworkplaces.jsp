

<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Administration des lieux de travail :</h1>
			<ul>
			<c:forEach var="workplace" items="${list}">
				<li>
					<c:out value="${workplace.city}" />
					<button type="button" class="btn btn-default">Modifier</button>
					<button type="button" class="btn btn-danger">Supprimer</button>
				</li>
				
			</c:forEach>
			<ul>
		</div>
	</div>


	<%-- 
			<button type="button" class="btn btn-default">Modify</button>
			
	--%>


</t:baseLayout>