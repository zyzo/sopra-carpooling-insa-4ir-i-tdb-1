<t:baseLayout>
	<div class="jumbotron">
		<div class="container">	
		
		<br/> <br/>
		
		 <form id="modifyForm" class="form" role="form" method="POST">
		 
		 <div class="form-group">
       		<label for="HomePostcode">Code postal de votre domicile :</label>
          	<input name="HomePostcode" type="text" id="HomePostcode" class="form-control" required="required">       	
        </div>
       
       <div class="form-group">
       		<label for="workplace">Lieu de travail : </label>
       <select name="workplace">	
       <c:forEach var="workplace" items="${list}">
		<option value="${workplace.id}">  ${workplace.street} ${workplace.postCode} ${workplace.city} </option> 
	    </c:forEach>
	    </select>   
        </div>
     
      <div class="form-group">
       <label for="departDJ">Heure de départ (début de journée) : </label>
       <input type="time" name="departDJ">
        </div>
       
        <div class="form-group">
       <label for="departFJ">Heure de départ (fin de journée) :</label>
       <input type="time" name="departFJ">
        </div>
       
       <div class="form-group">               
       <label for="jours">Jours applicables : &nbsp; </label>
       <strong> 
       <input type="checkbox" name="checkboxLundi" value="lundi">  Lundi  &nbsp;               
       <input type="checkbox" name="checkboxMardi" value="mardi">  Mardi   &nbsp;    
       <input type="checkbox" name="checkboxMercredi" value="mercredi">  Mercredi  &nbsp;
       <input type="checkbox" name="checkboxJeudi" value="jeudi">  Jeudi  &nbsp;
       <input type="checkbox" name="checkboxVendredi" value="vendredi">  Vendredi   &nbsp;
       <input type="checkbox" name="checkboxSamedi" value="samedi">  Samedi  &nbsp;
       <input type="checkbox" name="checkboxDimanche" value="dimanche">  Dimanche   &nbsp;     
       </strong>
       </div>
       
       <div class="form-group">               
       <label for="notify">Etre notifié par mail dès qu'un utilisateur informe un covoiturage similaire : &nbsp; </label>
       <strong> 
       <input type="checkbox" name="checkboxNotify" value="notify">     
       </strong>
       </div>
       
        <div class="form-group">               
       <label for="notify">Pouvez-vous être conducteur ? &nbsp; </label>
       <strong> 
       <input type="checkbox" name="checkboxNotify" value="notify">  Oui   
       </strong>
       </div>
       
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>   
      
		</div>
	</div>
	
</t:baseLayout>

