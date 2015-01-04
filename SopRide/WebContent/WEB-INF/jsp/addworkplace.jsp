<t:baseLayout>
	<div class="jumbotron">
		<div class="container">	
		 <form id="modifyForm" class="form" role="form" method="POST">
        <div class="form-group">
       		<label for="postcode">Code postal :</label>
          	<input name="postcode" type="text" id="postcode" class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="city">Ville : </label>
          	<input name="city" type="text" id="city" class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="street">Rue : </label>
          	<input name="street" type="text" id="street"  class="form-control" required="required">       	
        </div>
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>
      
      
      
		</div>
	</div>
</t:baseLayout>