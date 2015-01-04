<t:baseLayout>
<div class="jumbotron">
		<div class="container"></div>
		<br/>  <br/> 
		<div class="panel panel-default">
		
  			<div class="panel-heading"><h2>Nombre de connexion</h2></div>
  			  <div class="panel-body">
  			  		<p>Le nombre de Connexion total est : ${total}</p>
				</div>
  				<table class="table">
  				<tr><th>Nom</th><th>Adresse électronique</th><th>Nombre de connexion</th></tr>
  				<c:forEach var="user" items="${list}">
  				
  					<tr>
  					<td>${user.last_name}</td>
  					<td>${user.email}</td>
  					<td>${user.numberOfConnections}	</td>		
  					
  					</tr>
  				</c:forEach>
  				</table>
		</div>

</t:baseLayout>