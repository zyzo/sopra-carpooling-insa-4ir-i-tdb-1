

<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Administration des lieux de travail :</h1>
			<ul>
				<c:forEach var="workplace" items="${list}">
					<li> ${workplace.postCode} ${workplace.city} : ${workplace.street} 
						<a class="btn btn-info" href="/SopRide/modifyworkplace?id=${workplace.id }">
							<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier
						</a>
						<a class="btn btn-danger" href="/SopRide/deleteworkplace?id=${workplace.id }">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
						</a></li>

				</c:forEach>
			</ul>
			
			<p class="text-right"> 
			<a class="btn btn-default" href="/SopRide/addworkplace" role="button">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							Ajouter
			</a>
			</p>
						
		</div>
	</div>




</t:baseLayout>