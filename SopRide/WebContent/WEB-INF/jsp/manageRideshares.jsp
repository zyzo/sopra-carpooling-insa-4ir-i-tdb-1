<t:baseLayout>

	<div class="jumbotron">
		<div class="container">
			<br />
			<h2>Administration des trajets de covoiturage</h2>
			<br />
			<ul>
				<c:forEach var="rideshare" items="${list}">
					<li>${rideshare.home.street} ${rideshare.home.postCode}
						${rideshare.home.city} - ${rideshare.car_pooling_workplace.street}
						${rideshare.car_pooling_workplace.postCode}
						${rideshare.car_pooling_workplace.city} &nbsp; <a
						class="btn btn-info"
						href="/SopRide/modifyrideshare?id=${rideshare.id}"> <span
							class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
							Modifier
					</a> <a class="btn btn-danger"
						href="/SopRide/deleterideshare?id=${rideshare.id}"> <span
							class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							Supprimer
					</a> <br /> <br />
					</li>
								<a href="javascript:ReverseDisplay('gmap')"> Cacher la google map </a> <br />
					<iframe width="600" id="gmap" height="450" src="
<c:url value="https://www.google.com/maps/embed/v1/directions?">
<c:param name="origin" value="${rideshare.home.street}, ${rideshare.home.city}"/>
<c:param name="destination" value="${rideshare.car_pooling_workplace.street}, ${rideshare.car_pooling_workplace.city}"/>

<c:param name="key" value="AIzaSyAWtwnk0kNJlxITog0xf9y7EDYaywrnUDk"/>
</c:url>"></iframe>
							
								
				</body>
				
				</c:forEach>
				<p class="text-right">
	<a class="btn btn-default" href="/SopRide/addrideshare" role="button">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	Ajouter
	</a>
	</p>
			</ul>

			
			
			
			

		</div>
	</div>




</t:baseLayout>

<script type="text/javascript">
<!--
	function ReverseDisplay(d) {
		if (document.getElementById(d).style.display == "none") {
			document.getElementById(d).style.display = "block";
		} else {
			document.getElementById(d).style.display = "none";
		}
	}
//-->
</script>