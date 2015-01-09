<t:baseLayout>
<div id="reportPage" class="jumbotron">
		<div class="container"></div>
		<br/>  <br/> 
		<div class="panel panel-primary">
		
  			<div class="panel-heading"><strong>Rapport d'informations</strong></div>
  			  <div class="panel-body">
  			  		Connexions depuis le lancement de l'application : <span class="badge">${total}</span><br/>
  			  		Nombre d'utilisateurs : <span class="badge">${nombreutilisateur}</span>
				</div>
  				<table class="table">
  				<tr><th>Nom</th><th>Adresse électronique</th><th>Nombre de connexions</th><th>Dernière Connexion</tr>
  				<c:forEach var="user" items="${list}">
  				
  					<tr>
  					<td>${user.last_name}</td>
  					<td>${user.email}</td>
  					<td><span class="badge">${user.numberOfConnections}</span>	</td>
  					<fmt:formatDate value="${user.lastConnected }" var="formattedDate" type="date" pattern="MM-dd-yyyy"/>	
  					<td><c:out value="${formattedDate}"/></td>	
  					
  					</tr>
  				</c:forEach>
  				</table>
  				
		</div>
		
</t:baseLayout>
