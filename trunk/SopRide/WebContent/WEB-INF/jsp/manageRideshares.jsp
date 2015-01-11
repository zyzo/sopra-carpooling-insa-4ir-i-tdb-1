<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<br />
			<h2>Administration des trajets de covoiturage</h2>
			<br /> <br />
			<ul>

				<c:forEach var="rideshare" items="${list}">
					<li style="margin-bottom: 43px">
						<span class="text-left text-primary" style="17px">${rideshare.home.street} ${rideshare.home.postCode}
						${rideshare.home.city} - ${rideshare.car_pooling_workplace.street}
						${rideshare.car_pooling_workplace.postCode}
						${rideshare.car_pooling_workplace.city} 
						</span>
						<span style="float:right">
						<a class="btn btn-info"
						href="/SopRide/modifyrideshare?id=${rideshare.id}"> <span
							class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier
					</a>
					 <a class="btn btn-danger"
						href="/SopRide/deleterideshare?id=${rideshare.id}"> <span
							class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
					</a> 
					<a type="button" class="btn btn-success" data-toggle="collapse"
						href="#${rideshare.id}"
						aria-expanded="false"
						aria-controls="${rideshare.id}"> 					
						Google Map 
					</a>
					</span>
					</li>
					<div id="${rideshare.id}" class="collapse googleMapPanel">   
					<div id="${rideshare.id}" class="well" style="width : 640px">
					<iframe  width="600" height="450"
						src="
						<c:url value="https://www.google.com/maps/embed/v1/directions?">
						<c:param name="origin" value="${rideshare.home.street}, ${rideshare.home.city}"/>
						<c:param name="destination" value="${rideshare.car_pooling_workplace.street}, ${rideshare.car_pooling_workplace.city}"/>
						<c:param name="key" value="${googleApiKey}"/>
						</c:url>">
					</iframe> 
					</div>
					</div>
					<script>
						$('[data-toggle="collapse"]').click('show.bs.collapse', function() {
							var mapFrame = $($(this).attr('href') + '#${rideshare.id} > iframe');
							if (!$(mapFrame).hasClass('map-refreshed')) {
								mapFrame.attr('src', mapFrame.attr('src')+'');
								mapFrame.addClass('map-refreshed');
							}
						});
					</script>
					

				</c:forEach>
			</ul>

			<p class="text-right">
				<a class="btn btn-default" href="/SopRide/addrideshare"
					role="button"> <span class="glyphicon glyphicon-plus"
					aria-hidden="true"></span> Ajouter
				</a>
			</p>
		</div>
	</div>

</body>


</t:baseLayout>



    
