<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="welcome.css">

</head>
<body>
	<h1>Welcome, 
    <%

            String userName = (String) session.getAttribute("name");
	        
			if (userName == null){
		    	Cookie[] cookies = request.getCookies();
		    	if (cookies!=null){
		    		for (Cookie cookie:cookies){
		    			if (cookie.getName().equals("user")){
		    				userName = cookie.getValue();
		    			}
		    			
		    		}
		    	}
		    }
			
            out.println(userName != null ? userName : "Guest");
     %>
	</h1>
	
	<a href = "DisplayPatientsServlet">View Patients</a>
</body>
</html>