<t:baseLayout>
	<div class="jumbotron">
		<div class="container">	
		
		<form id="modifyForm" class="form" role="form" method="POST">
        <br/> <br/> 
        
        <label> Votre adresse mail : ${user.email} </label> <br/>
        
        <div class="form-group">        
       		<label for="lastname">Nom : </label>
          	<input name="lastname" type="text" id="lastname" value="${user.last_name}" class="form-control" required="required">       	
        </div>
        
        <div class="form-group">        
       		<label for="firstname">Prénom : </label>
          	<input name="firstname" type="text" id="firstname" value="${user.first_name}" class="form-control" required="required">       	
        </div>
        
        <div class="form-group">        
       		<label for="phone">Téléphone : </label>
          	<input name="phone" type="text" id="phone" value="${user.phone}" class="form-control" required="required">       	
        </div>
          
          
      <a href="javascript:ReverseDisplay('mdpBlock')"> Changement du  mot de passe </a> <br/>          
                 
        <div class="block" id="mdpBlock" style="display: none;">  
        <label> Si vous ne voulez pas changer votre mot de passe, laissez les champs suivants intactes </label>
        
        <div class="form-group">     
       		<label for="prevpwd">Ancien mot de passe : </label>
          	<input name="prevpwd" type="password" id="prevpwd" value="" class="form-control" >       	
        </div>        
        
        <div class="form-group">
       		<label for="newpwd">Nouveau mot de passe : </label>
          	<input name="newpwd" type="password" id="newpwd" value="${user.password}" class="form-control" required="required">       	
        </div>
        
        <div class="form-group">
       		<label for="newpwdconf">Confirmez votre nouveau mot de passe : </label>
          	<input name="newpwdconf" type="password" id="newpwdconf" value="${user.password}"  class="form-control" required="required">       	
        </div>
     </div> 
          
      <br/>   
         
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>         
      
		</div>
	
	<ul>  <c:if test="${ !empty erreur }">
	              <p style="color:red;"><c:out value="${ erreur }" /></p>
	              <script type="text/javascript" > 
	              $(document).ready(function() { document.getElementById('mdpBlock').style.display = "block" }) ;
	              </script>

	</c:if>  </ul>
	
	
	</div>
	  <c:if test="${ !empty erreur1 }"><p style="color:red;"><c:out value="${ erreur1 }" /></p></c:if>
      <c:if test="${ !empty erreur2 }"><p style="color:red;"><c:out value="${ erreur2 }" /></p></c:if>
	
</t:baseLayout>

<script type="text/javascript" > <!--
function ReverseDisplay(d) {
if(document.getElementById(d).style.display == "none") { document.getElementById(d).style.display = "block"; }
else { document.getElementById(d).style.display = "none"; }
}
//--></script>


