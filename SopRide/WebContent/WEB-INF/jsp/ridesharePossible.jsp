<%@page import="com.sopride.web.servlet.SearchForRideshare"%>
<t:baseLayout>

	<div class="jumbotron">
	<h2 style="margin : 0 0 41px 168px">Tableau des conducteurs/passengers compatibles avec vos trajets :</h2> 
	<div class="well divRidesharePossible">
	<table class="table ridesharePossible">
				<thead>
					<th></th>
					<th>Lundi</th>
					<th>Mardi</th>
					<th>Mercredi</th>
					<th>Jeudi</th>
					<th>Vendredi</th>
					<th>Samedi</th>
					<th>Dimanche</th>
				</thead>
				<tbody>
					<tr class="success">
						<td class="firstCol">Depart</td>
						<c:forTokens var="jour" items="list_lundi list_mardi list_mercredi list_jeudi list_vendredi list_samedi list_dimanche" delims=" ">
							<c:set scope="page" var="list" value="${requestScope.rideInfoMap[jour]}"/>
							<td>
								<c:choose>
								<c:when test="${pageScope.list eq null}">
									<p style="font-size : 12px">aucun résultat</p>
								</c:when>
								<c:otherwise>
									<ul style="list-style : none">
									<c:forEach var="i" begin="0" end="${requestScope.mesTrajets.size()}" step="1">
										<c:if test="${!empty list[i]}">
							 				<div class="well">
							 				<li>
							 					<a href="modifyrideshare?id=${mesTrajets[i].id}">
							 						${mesTrajets[i].home.street} - <span class="text-info">${mesTrajets[i].car_pooling_workplace.street}</span>
						 						</a> 
							 				<ul style="list-style : none">
							 				<c:forEach var="rideInfo" items="${list[i]}">
							 					<c:set scope="page" var="user" value="${rideInfo.user}"/>
												<li>
												<button type="button" class="btn btn-default" data-toggle="modal" 
												data-target="#rideInfoModal" 
												data-useremail="${pageScope.user.email}"
												data-user="${pageScope.user.first_name} ${pageScope.user.last_name}"
												data-userphone="${pageScope.user.phone}"
												data-useraddress="${rideInfo.home.street} ${rideInfo.home.postCode} ${rideInfo.home.city}"
												data-userlastname="${pageScope.user.last_name}"
												data-userworkplace="${rideInfo.car_pooling_workplace.street} ${rideInfo.car_pooling_workplace.postCode} ${rideInfo.car_pooling_workplace.city}"
												data-myaddress="${mesTrajets[i].home.street} ${mesTrajets[i].home.postCode} ${mesTrajets[i].home.city}"
												data-morningtime="${rideInfo.morning_hour}"
												data-eveningtime="${rideInfo.night_hour}">
												${pageScope.user.first_name} ${pageScope.user.last_name}
												</button>
												</li>
											</c:forEach>
											</ul>
											</li>
											</div>
										</c:if>
									</c:forEach>
									</ul>
								</c:otherwise>
								</c:choose>
							</td>
						</c:forTokens>
					</tr>
					<%--
					<tr class="info">
						<td class="firstCol">Retour</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>	 
					--%>
				</tbody>
			</table>
			</div>
			
			<div class="modal fade" id="rideInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="rideInfoLabel">Info</h4>
		      </div>
		      <div class="modal-body">
		      		<div id="infoUser" class="info">
		        	<h3>Information utilisateur </h3>
		        	<div class="leftColumn">
		        	<p> Nom et prénom : <span id="fullname"></span></p>
		        	<p> Téléphone :<span id="userPhone"></span></p>
		        	</div>
		        	<div class="rightColumn">
		        	<p> Email :	<span id="userEmail"></span>
		        	<a href="#" style="text-decoration : none; color : white;" id="emailButton" type="button" class="btn btn-primary"></a>
		        	</p>
		        	<p> Adresse : <span id="userAddress"></span></p>
					</div>
		        	</div>
		        	<h3>Trajet</h3>
		        	<div id="infoRide" class="info">
		        	<div class="leftColumn">
		        		<p> Heure de départ : <span id="departuretime"></span></p>
		        	</div>
		        	<div class="rightColumn">
		        		<p> Heure de de retour : <span id="eveningtime"></span></p>
		        	</div>
		        	</div>
		        	<div id="googleMapFrame">
		        	<div id="notStraightPath" style="float:right; width : 50%; margin-bottom : 20px;">
		        		<h4>Avec détour</h4>
		        		<iframe  width="500" height="400"></iframe>
		        	</div>
		        	<div id="straightPath" style="float:left; width : 50%; margin-bottom : 20px;">
		        		<h4>Direct</h4>
			        	<iframe  width="500" height="400"></iframe>
		        	</div>
		        	</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		<script src="http://maps.google.com/maps/api/js?sensor=false"></script> 
		<script>
		function setUpMapFrame(modal, id, userAddress, userWorkplace, waypoint) {
			modal.find('.modal-body #'+ id +' > iframe')
		  	.attr('src', 'https://www.google.com/maps/embed/v1/directions?' +
		  			'origin=' + encodeURIComponent(userAddress) + 
		  			(waypoint == null ? '' : '&waypoints=' + encodeURIComponent(waypoint)) +
		  			'&destination=' + encodeURIComponent(userWorkplace) + 
		  			'&key=${googleApiKey}')
 		  var mapFrame = $($(this).attr('href') + '#'+ id + ' > iframe');
		  if (!$(mapFrame).hasClass('map-refreshed')) {
			mapFrame.attr('src', mapFrame.attr('src')+'');
			mapFrame.addClass('map-refreshed');
		  }
		}
		$('#rideInfoModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var user = button.data('user') 
			  var userEmail = button.data('useremail')
			  var userPhone = button.data('userphone')
			  var userAddress = button.data('useraddress')
			  var lastName = button.data('userlastname')
			  var userWorkplace = button.data('userworkplace')
			  var myAddress = button.data('myaddress')
			  var morningtime = button.data('morningtime')
			  var eveningtime = button.data('eveningtime')
			  var modal = $(this)
			  modal.find('.modal-title').text(user)
			  modal.find('.modal-body input').val(user)
			  modal.find('.modal-body #emailButton').attr('href', 'mailto:' + userEmail).text('Envoyer un email à ' + lastName)
			  modal.find('.modal-body #fullname').text(user)
			  modal.find('.modal-body #userPhone').text(userPhone)
			  modal.find('.modal-body #userEmail').text(userEmail)
			  modal.find('.modal-body #userAddress').text(userAddress)
			  modal.find('.modal-body #departuretime').text(morningtime)
			  modal.find('.modal-body #eveningtime').text(eveningtime)
			  setUpMapFrame(modal, 'straightPath', userAddress, userWorkplace, null);
			  setUpMapFrame(modal, 'notStraightPath', userAddress, userWorkplace, myAddress);
			  });
		</script>
		<%--
		<div class="container">
			<h3>Trajets possibles le lundi :</h3>
			<ul>
				<c:if test="${empty list_lundi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_lundi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_lundi[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					 </c:if>
						<c:forEach var="ride" items="${list_lundi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le mardi :</h3>
			<ul>
				<c:if test="${empty list_mardi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_mardi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_mardi[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					</c:if>
						<c:forEach var="ride" items="${list_mardi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le mercredi :</h3>
			<ul>
				<c:if test="${empty list_mercredi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_mercredi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_mercredi[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					</c:if>
						<c:forEach var="ride" items="${list_mercredi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le jeudi :</h3>
			<ul>
				<c:if test="${empty list_jeudi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_jeudi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_jeudi[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					</c:if>
						<c:forEach var="ride" items="${list_jeudi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le vendredi :</h3>
			<ul>
				<c:if test="${empty list_vendredi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_vendredi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_vendredi[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					</c:if>
						<c:forEach var="ride" items="${list_vendredi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le samedi :</h3>
			<ul>
				<c:if test="${empty list_samedi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_samedi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_samedi[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					</c:if>
						<c:forEach var="ride" items="${list_samedi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le dimanche :</h3>
			<ul>
				<c:if test="${empty list_dimanche[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_dimanche[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <c:if test="${!empty list_dimanche[i]}">
						 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
					</c:if>
						<c:forEach var="ride" items="${list_dimanche[i]}">
								<li>${ride.first_name} ${ride.last_name}
									(${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			
		</div>
		--%>
	</div>



</t:baseLayout>