<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<br/> <h2>Administration des trajets de covoiturage </h2> <br/>
			<ul>
				<c:forEach var="rideshare" items="${list}">
					<li> ${rideshare.home.postCode} ${rideshare.home.city} - ${rideshare.car_pooling_workplace.street} ${rideshare.car_pooling_workplace.postCode} ${rideshare.car_pooling_workplace.city} &nbsp; 
						<a class="btn btn-info" href="/SopRide/modifyrideshare?id=${rideshare.id}">
							<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier
						</a>
						<a class="btn btn-danger" href="/SopRide/deleterideshare?id=${rideshare.id}">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
						</a>
					<br/>	<br/>
					</li>
			</c:forEach>
			</ul>
			
			<p class="text-right"> 
			<a class="btn btn-default" href="/SopRide/addrideshare" role="button">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							Ajouter
			</a>
			</p>
						
		</div>
	</div>




</t:baseLayout>