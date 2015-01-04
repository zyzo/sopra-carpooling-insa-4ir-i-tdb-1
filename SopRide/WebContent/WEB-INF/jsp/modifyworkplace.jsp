<t:baseLayout>
	<div class="jumbotron">
		<div class="container">	
		 <form id="modifyForm" class="form" role="form" method="POST">
        <div class="form-group">
        <br/> <br/> 
       		<label for="postcode">Code postal : ${ workplace.postCode }</label>
          	<input name="postcode" type="text" id="postcode" placeholder="Nouvelle valeur" class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="city">Ville : ${ workplace.city }</label>
          	<input name="city" type="text" id="city" placeholder="Nouvelle valeur" class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="street">Rue : ${ workplace.street }</label>
          	<input name="street" type="text" id="street" placeholder="Nouvelle valeur" class="form-control" required="required">       	
        </div>
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>
      
      
      
		</div>
	</div>



</t:baseLayout>