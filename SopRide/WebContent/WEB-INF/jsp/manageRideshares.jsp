<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Administration des trajets de covoiturage :</h1>
			<ul>
				<c:forEach var="rideshare" items="${list}">
					<li> ${rideshare.home} -  ${rideshare.car_pooling_workplace} ( ${rideshare.morning_hour} -${rideshare.night_hour} ) 
						<a class="btn btn-info" href="/SopRide/modifyrideshare?id=${rideshare.id_carpooling_infos}">
							<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier
						</a>
						<a class="btn btn-danger" href="/SopRide/deleterideshare?id=${rideshare.id_carpooling_infos}">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
						</a></li>

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