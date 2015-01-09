
<t:baseLayout>
 <div class="jumbotron">
      <div class="container">
      <br/>
      <h1>SopRide</h1>
      <p>La plateforme de covoiturage des employés de Sopra </p>

	  <c:choose>
	  <c:when test="${userCtrl.isConnected()}" >
	 	<a class="btn btn-success" href="ridesharePossible">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							Chercher les covoiturages
	  	</a> <br/> <br/>
      	<a class="btn btn-info" href="modifyaccount">
		<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
		Modifier les informations de votre compte
	  	</a> <br/> <br/>
      	<a class="btn btn-warning" href="ridesharemanager">
							<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							Gérer vos trajets de covoiturage
	  	</a> <br/> <br/>
		<c:if test="${userCtrl.isAdmin()}">
			<h2>Espace Admin</h2>
			<p>
				<a class="btn btn-errror" href="manageworkplaces">
					<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
					Gérer les lieux de travail
				</a>
			</p>
			<p>
				<a class="btn btn-errror" href="manageaccount">
					<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
					Gérer les comptes utilisateurs
				</a>
			</p>
			<p>
				<a class="btn btn-errror" href="report">
					<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
					Récupérer les rapports
				</a>
			</p>


		</c:if>
	  </c:when>
	  <c:otherwise>
		  <p><a class="btn btn-primary btn-lg" href="inscription" role="button">Créer un compte »</a></p>
	  </c:otherwise>
	  </c:choose>
	
 </div>
    </div>
</t:baseLayout>