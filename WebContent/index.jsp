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
		f�rnamn:<input type="text" name="fnamn"><br>
		efternamn<input type="text" name="enamn"><br>
		personnummer:<input type="text" name="personnummer"><br>
		<input type="submit">
	</form>
	<br>
	<br>
	bok
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title"><br>
		f�rfattarens f�rnamn:<input type="text" name="skaparefnamn"><br>
		f�rfattarens efternamn:<input type="text" name="skapareenamn"><br>
		bokens id:<input type="text" name="bokId"><br>
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
		cdns id:<input type="text" name="cdId"><br>
		<input type="submit" name="submit" value="cd">
	</form>
	<br>
	<br>
	
	dvd
	<form action="registreringMedia" method="post">
		dvdns id:<input type="text" name="dvdId"><br>
		title:<input type="text" name="title"><br>
		regiss�r f�rnamn:<input type="text" name="skaparefnamn"><br>
		regiss�r efternamn:<input type="text" name="skapareenamn"><br>
		<input type="submit" name="submit" value="dvd">
	</form>
	
	
	
	
	
	
	
	<br>
	<br>
	l�na bok
	<form action="l�na" method="post">
		personnummer:<input type="text" name="elevId"><br>
		bokens serienummer:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="l�na bok">
	</form>
	
	<br>
	<br>
	l�na cd
	<form action="l�na" method="post">
		personnummer:<input type="text" name="elevId"><br>
		cdns serienummer:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="l�na cd">
	</form>
	
	<br>
	<br>
	l�na dvd
	<form action="l�na" method="post">
		personnummer:<input type="text" name="elevId"><br>
		dvdns serienummer:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="l�na dvd">
	</form>
	
	
	
	
	
	
	
</body>
</html>