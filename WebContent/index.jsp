<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="registreringElev" method="post">
		personnummer:<input type="text" name="personnummer"><br>
		f�rnamn:<input type="text" name="fnamn"><br>
		efternamn<input type="text" name="enamn"><br>
		<input type="submit">
	</form>
	<br>
	<br>
	bok
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title"><br>
		f�rfattarens f�rnamn:<input type="text" name="skaparefnamn"><br>
		f�rfattarens efternamn:<input type="text" name="skapareenamn"><br>
		<input type="submit" name="submit" value="bok">
	</form>
	<br>
	<br>
	
	cd
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title"><br>
		f�rfattarens f�rnamn:<input type="text" name="skaparefnamn"><br>
		f�rfattarens efternamn:<input type="text" name="skapareenamn"><br>
		uppl�sarens f�rnamn:<input type="text" name="uppl�sarefnamn"><br>
		uppl�sarens efternamn:<input type="text" name="uppl�sareenamn"><br>
		<input type="submit" name="submit" value="cd">
	</form>
	<br>
	<br>
	
	dvd
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title"><br>
		regiss�r f�rnamn:<input type="text" name="skaparefnamn"><br>
		regiss�r efternamn:<input type="text" name="skapareenamn"><br>
		<input type="submit" name="submit" value="dvd">
	</form>
	
	
	
</body>
</html>