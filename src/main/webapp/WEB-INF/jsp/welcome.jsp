<!DOCTYPE html>

<html lang="en">
<head>


</head>
<body>

	

	

		
			<c:forEach var="jobs" items="${todos}" varStatus="i">
  
  
       <h1> ${jobs.title}</h1>
       
      <h3> ${jobs.description}</h3>
  
</c:forEach>
			
	


	

</body>

</html>