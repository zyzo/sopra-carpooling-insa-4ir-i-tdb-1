<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h3>Trajets possibles le lundi :</h3>
			<ul>
				<c:if test="${empty list_lundi[0]}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_lundi[0] }">
					 <c:forEach var="i" begin="0" end="${nb_trajets}" step="1">
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_lundi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
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
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_mardi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
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
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_mercredi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
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
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_jeudi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
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
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_vendredi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
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
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_samedi[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
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
					 <p>Pour le trajet <c:out value="${trajets[i]}"/> :</p>
						<c:forEach var="ride" items="${list_dimanche[i]}">
								<li>${ride.first_name} ${ride.last_name}
									${ride.email} (${ride.email} / ${ride.phone})</li>
						</c:forEach>
					</c:forEach>
				</c:if>
			</ul>
			
		</div>
	</div>



</t:baseLayout>