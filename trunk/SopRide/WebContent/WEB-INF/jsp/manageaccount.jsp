

<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<h1>Administration des comptes :</h1>
			<ul>
				<c:forEach var="user" items="${list}">
					<li> ${user.email}  ${user.first_name}   ${user.last_name}   ${user.phone}

						<a class="btn btn-danger" href="/SopRide/deleteuser?id=${user.id }">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
						</a></li>

				</c:forEach>
			</ul>
					
		</div>
	</div>




</t:baseLayout>