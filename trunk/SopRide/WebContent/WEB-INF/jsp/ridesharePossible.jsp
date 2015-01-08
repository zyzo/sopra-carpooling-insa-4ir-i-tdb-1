<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h3>Trajets possibles le lundi avec :</h3>
			<ul>
				<c:if test="${empty list_lundi}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_lundi }">
					<c:forEach var="rideshare" items="${list_lundi}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							${rideshare.email} (${rideshare.email} / ${rideshare.phone})</li>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le mardi avec :</h3>
			<ul>
				<c:if test="${empty list_mardi}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_mardi }">

					<c:forEach var="rideshare" items="${list_mardi}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							(${rideshare.email} / ${rideshare.phone})</li>

					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le mercredi avec :</h3>
			<ul>

				<c:if test="${empty list_mercredi}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>

				<c:if test="${!empty list_mercredi }">

					<c:forEach var="rideshare" items="${list_mercredi}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							(${rideshare.email} / ${rideshare.phone})</li>

					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le jeudi avec :</h3>
			<ul>
				<c:if test="${empty list_jeudi}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_lundi }">

					<c:forEach var="rideshare" items="${list_jeudi}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							(${rideshare.email} / ${rideshare.phone})</li>

					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le vendredi avec :</h3>
			<ul>
				<c:if test="${empty list_vendredi}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_lundi }">

					<c:forEach var="rideshare" items="${list_vendredi}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							(${rideshare.email} / ${rideshare.phone})</li>
					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le samedi :</h3>
			<ul>

				<c:if test="${empty list_samedi}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_lundi }">

					<c:forEach var="rideshare" items="${list_samedi}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							(${rideshare.email} / ${rideshare.phone})</li>

					</c:forEach>
				</c:if>
			</ul>
			<h3>Trajets possibles le dimanche avec :</h3>
			<ul>

				<c:if test="${empty list_dimanche}">
					<p>Pas de trajets disponibles ce jour la !</p>
				</c:if>
				<c:if test="${!empty list_dimanche }">

					<c:forEach var="rideshare" items="${list_dimanche}">
						<li>${rideshare.first_name} ${rideshare.last_name}
							${rideshare.email}</li>

					</c:forEach>
				</c:if>
			</ul>



		</div>
	</div>



</t:baseLayout>