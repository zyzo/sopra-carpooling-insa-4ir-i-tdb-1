<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Trajets possible avec :</h1>
			<ul>
				<c:forEach var="rideshare" items="${list}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
			</ul>
			
			
		</div>
	</div>



</t:baseLayout>