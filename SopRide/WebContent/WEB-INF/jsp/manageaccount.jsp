

<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Administration des comptes :</h1>
			<ul>
				<c:forEach var="user" items="${list}">
					<li> ${user.email} ${user.password} ${user.first_name} ${user.last_name} ${user.phone}<%--  : ${user.last_connected_date}  --%>

						<a class="btn btn-danger" href="/SopRide/deleteuser?id=${user.id }">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
						</a></li>

				</c:forEach>
			</ul>
					
		</div>
	</div>




</t:baseLayout>