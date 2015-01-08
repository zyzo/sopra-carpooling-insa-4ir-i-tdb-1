
<t:baseLayout>
 <div class="jumbotron">
      <div class="container">
      <br/> <br/> 
      
      <label> Votre adresse mail : ${user.email} </label> <br/>
        
        
       <label for="lastname">Nom :  ${user.last_name} </label> <br/> 
              
      <label for="firstname">Pr�nom : ${user.first_name} </label> <br/> 
          	       
       <label for="phone">T�l�phone : ${user.phone}</label> <br/>  <br/>
       
      
      <a class="btn btn-info" href="modifyaccount">
							<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier les informations de votre compte
	  </a>
						
 </div>
    </div>
</t:baseLayout>