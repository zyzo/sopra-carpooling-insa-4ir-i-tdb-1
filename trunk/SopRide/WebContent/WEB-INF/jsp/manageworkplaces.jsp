

<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h2 style="margin-bottom: 30px;"><strong>Administration des lieux de travail</strong></h2>
			<ul style="width : 900px">
				<c:forEach var="workplace" items="${list}">
					<li style="margin-bottom: 55px">
					 <span class="text-left text-primary" style="17px">${workplace.street}, ${workplace.postCode} ${workplace.city} </span>
						<span style="float:right">
						<a class="btn btn-info" href="/SopRide/modifyworkplace?id=${workplace.id }">
							<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier
						</a>
						<a class="btn btn-danger" href="/SopRide/deleteworkplace?id=${workplace.id }">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
						</a>
						<a type="button" class="btn btn-success" data-toggle="collapse"
								href="#${workplace.id}"
								aria-expanded="false"
								aria-controls="${workplace.id}">
							Google Map
						</a>
						</span>
						<div class="collapse" id="${workplace.id}" style="margin: 20px 0">
							<div id="${workplace.id}" class="well">
								<iframe width="600" height="450" src="
									<c:url value="https://www.google.com/maps/embed/v1/search">
										<c:param name="q" value="${workplace.street}, ${workplace.city}"/>
										<c:param name="key" value="${googleApiKey}"/>
									</c:url>">"/>
								</iframe>
							</div>
						</div>
						<script>
							$('[data-toggle="collapse"]').click('show.bs.collapse', function() {
								var mapFrame = $($(this).attr('href') + '#${workplace.id} > iframe');
								if (!$(mapFrame).hasClass('map-refreshed')) {
									mapFrame.attr('src', mapFrame.attr('src')+'');
									mapFrame.addClass('map-refreshed');
								}
							});
						</script>
						</li>
				</c:forEach>
			</ul>


			<p class="text-right"> 
			<a class="btn btn-default" href="addworkplace" role="button">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							Ajouter
			</a>
			</p>
			</div>
		</div>
	</div>




</t:baseLayout>
