<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Trajets possible le lundi avec :</h1>
			<ul>
				<c:if test="${empty list_lundi}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
				<c:if test="${!empty list_lundi }">
				<c:forEach var="rideshare" items="${list_lundi}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
						<h2>Trajets possible le mardi avec :</h2>
			<ul>
				
				<c:if test="${empty list_mardi}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
				<c:if test="${!empty list_mardi }">
				
				<c:forEach var="rideshare" items="${list_mardi}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
						<h3>Trajets possible le mercredi avec :</h3>
			<ul>
			
				<c:if test="${empty list_mercredi}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
			
			<c:if test="${!empty list_mercredi }">
				
				<c:forEach var="rideshare" items="${list_mercredi}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
						<h4>Trajets possible le jeudi avec :</h4>
			<ul>
			
			
				<c:if test="${empty list_jeudi}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
				<c:if test="${!empty list_lundi }">
				
				<c:forEach var="rideshare" items="${list_jeudi}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
						<h5>Trajets possible le vendredi avec :</h5>
			<ul>
			
			
				<c:if test="${empty list_vendredi}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
				<c:if test="${!empty list_lundi }">
				
				<c:forEach var="rideshare" items="${list_vendredi}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
						<h6>Trajets possible le samedi avec :</h6>
			<ul>
			
				<c:if test="${empty list_samedi}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
				<c:if test="${!empty list_lundi }">
				
				<c:forEach var="rideshare" items="${list_samedi}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
						<h7>Trajets possible le dimanche avec :</h7>
			<ul>
			
				<c:if test="${empty list_dimanche}">
					<p>
						Pas de trajets disponible ce jour la !
					</p>
				</c:if>
				<c:if test="${!empty list_dimanche }">
				
				<c:forEach var="rideshare" items="${list_dimanche}">
					<li> ${rideshare.first_name}  ${rideshare.last_name} ${rideshare.email} </li>

				</c:forEach>
				</c:if>
			</ul>
			
			
			
		</div>
	</div>



</t:baseLayout>