<t:baseLayout>
  <div class="jumbotron">
    <div class="container">
      <form id="loginForm" class="form" role="form" action="login" method="post">
        <div class="form-group">
       		<label for="email">Email</label>
          	<input type="email" name="email" placeholder="Votre email" class="form-control" id="email" required="required">
        </div>
        <div class="form-group">
          <label for="passwd">Mot de passe</label>
          <input id="passwd" type="password" name="passwd" placeholder="Votre mot de passe" class="form-control" required="required">
        </div>
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>
    </div>
    
    <div class="container">
    	<div id="loginFormExternalLinks">
    		<a class="btn btn-default active" href="forgetPassword">Mot de passe oublié ? </a>
    		 <a class="btn btn-default active" href="inscription">Nouvel utilisateur </a>
    	</div> 
  	</div>
  </div>
</t:baseLayout>