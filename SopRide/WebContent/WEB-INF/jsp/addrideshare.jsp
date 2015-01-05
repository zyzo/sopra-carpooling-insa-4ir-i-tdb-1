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
       		<label for="workplace">Lieu de travail :</label>
       <select name="workplace">	
       <c:forEach var="workplace" items="${list}">
		<option value="${workplace.id}"> ${workplace.postCode} ${workplace.city} : ${workplace.street}</option> 
	    </c:forEach>
	    </select>   
        </div>
     
       
       
        <button type="submit" class="btn btn-lg btn-primary">Valider</button>
      </form>   
      
		</div>
	</div>
</t:baseLayout>

