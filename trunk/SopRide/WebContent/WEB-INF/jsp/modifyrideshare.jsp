<t:baseLayout>
	<div class="jumbotron">
		<div class="container">	
		<h2> Modifier un trajet de covoiturage </h2>
		<br/> 		
		 <form id="modifyForm" class="form" role="form" method="POST">
		 
		  <div class="form-group">
       		<label for="HomeCity">Ville de votre domicile :  </label>
          	<input name="HomeCity" type="text" id="HomeCity" class="form-control" value="${ride.home.city}" required="required">       	
        </div>
       	 		 
		 <div class="form-group">
       		<label for="HomePostcode">Code postal de votre domicile :</label>
          	<input name="HomePostcode" type="text" id="HomePostcode" value="${ride.home.postCode}" class="form-control" required="required">       	
        </div>       
           
       <div class="form-group">
       		<label for="workplace">Lieu de travail : </label>
       <select name="workplace">	
       
       <c:set var="idselect" scope="session" value="${ride.car_pooling_workplace.id}"/>
       <c:forEach var="workplace" items="${list}">
       <c:choose>
	    <c:when test="${idselect == workplace.id}" >
		<option value="${workplace.id}" selected>  ${workplace.street} ${workplace.postCode} ${workplace.city} </option> 	   
	  </c:when>
	  <c:otherwise>
		 <option value="${workplace.id}">  ${workplace.street} ${workplace.postCode} ${workplace.city} </option> 	    
	  </c:otherwise>
	  </c:choose>
	    
	    </c:forEach>
	    </select>   
        </div>
     
      <div class="form-group">
       <label for="departDJ">Heure de départ (début de journée) "HH:MM" : </label>
       <input type="time" name="departDJ" value="<fmt:formatDate pattern="HH:mm" 
            value="${morningH}" />"> </div>
       
        <div class="form-group">
       <label for="departFJ">Heure de départ (fin de journée) "HH:MM" :</label>
       <input type="time" name="departFJ" value="<fmt:formatDate pattern="HH:mm" 
            value="${nightH}" />">
        </div>
       
       <div class="form-group">               
       <label for="jours">Jours applicables : &nbsp; </label>
       <strong> 
       <input type="checkbox" name="checkbox" value="lundi" <c:if test="${field.lundi}">checked="checked"</c:if>>  Lundi  &nbsp;               
       <input type="checkbox" name="checkbox" value="mardi" <c:if test="${field.mardi}">checked="checked"</c:if>>  Mardi   &nbsp;    
       <input type="checkbox" name="checkbox" value="mercredi" <c:if test="${field.mercredi}">checked="checked"</c:if>>  Mercredi  &nbsp;
       <input type="checkbox" name="checkbox" value="jeudi" <c:if test="${field.jeudi}">checked="checked"</c:if>>  Jeudi  &nbsp;
       <input type="checkbox" name="checkbox" value="vendredi" <c:if test="${field.vendredi}">checked="checked"</c:if>>  Vendredi   &nbsp;
       <input type="checkbox" name="checkbox" value="samedi" <c:if test="${field.samedi}">checked="checked"</c:if>>  Samedi  &nbsp;
       <input type="checkbox" name="checkbox" value="dimanche" <c:if test="${field.dimanche}">checked="checked"</c:if>>  Dimanche   &nbsp;     
       </strong>
       </div>
       
       <div class="form-group">               
       <label for="notify">Etre notifié par mail dès qu'un utilisateur informe un covoiturage similaire : &nbsp; </label>
       <strong> 
       <input type="checkbox" name="checkbox" value="notify" <c:if test="${ride.notify}">checked="checked"</c:if>>     
       </strong>
       </div>
       
        <div class="form-group">               
       <label for="notify">Pouvez-vous être conducteur ? &nbsp; </label>
       <strong> 
       <input type="checkbox" name="checkbox" value="driver" <c:if test="${ride.driver}">checked="checked"</c:if>>  Oui   
       </strong>
       </div>
       
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>   
      
		</div>
	</div>
	
</t:baseLayout>

