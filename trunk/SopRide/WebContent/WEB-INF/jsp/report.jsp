<t:baseLayout>
<div class="jumbotron">
		<div class="container"></div>
		<br/>  <br/> 
		<div class="panel panel-default">
		
  			<div class="panel-heading"><h2>Nombre de connexion</h2></div>
  			  <div class="panel-body">
  			  		<p>Connexions depuis le lancement de l'application : ${total}</p>
				</div>
  				<table class="table">
  				<tr><th>Nom</th><th>Adresse électronique</th><th>Nombre de connexion</th><th>Dernière Connexion</tr>
  				<c:forEach var="user" items="${list}">
  				
  					<tr>
  					<td>${user.last_name}</td>
  					<td>${user.email}</td>
  					<td>${user.numberOfConnections}	</td>
  					<fmt:formatDate value="${user.lastConnected }" var="formattedDate" type="date" pattern="MM-dd-yyyy"/>	
  					<td><c:out value="${formattedDate}"/></td>	
  					
  					</tr>
  				</c:forEach>
  				</table>
  				
		</div>
		
</t:baseLayout>