<t:baseLayout>
<div class="jumbotron">
		<div class="container">	
		<h1>Inscription</h1>
		 <form id="inscription" class="form" role="form" method="POST">
        <div class="form-group">
       		<label for="email">Addresse électronique :</label>
          	<input name="email" type="text" id="email" class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="last_name">Nom : </label>
          	<input name="last_name" type="text" id="last_name" class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="first_name">Prénom : </label>
          	<input name="first_name" type="text" id="first_name"  class="form-control" required="required">       	
        </div>
        <div class="form-group">
       		<label for="phone">Numéro de Téléphone : </label>
          	<input name="phone" type="text" id="phone"  class="form-control" required="required">       	
        </div>
         <div class="form-group">
       		<label for="password">Mot de Passe : </label>
          	<input name="password" type="text" id="password"  class="form-control" required="required">       	
        </div>
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>
      
      <c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>


</t:baseLayout>