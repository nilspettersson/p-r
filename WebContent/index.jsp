<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="show" method="post">
		<input type="submit" name="submit" value="elever">
	</form>
	<br>
	<br>
	<form action="show" method="post">
		<input type="submit" name="submit" value="bok">
	</form>
	<form action="show" method="post">
		<input type="submit" name="submit" value="cd">
	</form>
	<form action="show" method="post">
		<input type="submit" name="submit" value="dvd">
	</form>
	
	<br>
	<br>
	<form action="show" method="post">
		<input type="submit" name="submit" value="l�nadeB�ker">
	</form>
	<form action="show" method="post">
		<input type="submit" name="submit" value="l�nadeCds">
	</form>
	<form action="show" method="post">
		<input type="submit" name="submit" value="l�nadeDvds">
	</form>
	
	

	<br>
	<br>
	<h2>registrera elev</h2>
	<form action="registreringElev" method="post">
		f�rnamn:<input type="text" name="fnamn" autocomplete="off"><br>
		efternamn<input type="text" name="enamn" autocomplete="off"><br>
		personnummer:<input type="text" name="personnummer" autocomplete="off"><br>
		<input type="submit" value="registrera ny elev">
	</form>
	<br>
	<br>
	
	
	<h2>registrera bok</h2>
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title" autocomplete="off"><br>
		f�rfattarens f�rnamn:<input type="text" name="skaparefnamn" autocomplete="off"><br>
		f�rfattarens efternamn:<input type="text" name="skapareenamn" autocomplete="off"><br>
		bokens id:<input type="text" name="bokId" autocomplete="off"><br>
		<input type="submit" name="submit" value="bok">
	</form>
	<br>
	<br>
	
	<h2>registrera cd</h2>
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title" autocomplete="off"><br>
		f�rfattarens f�rnamn:<input type="text" name="skaparefnamn" autocomplete="off"><br>
		f�rfattarens efternamn:<input type="text" name="skapareenamn" autocomplete="off"><br>
		uppl�sarens f�rnamn:<input type="text" name="uppl�sarefnamn" autocomplete="off"><br>
		uppl�sarens efternamn:<input type="text" name="uppl�sareenamn" autocomplete="off"><br>
		cdns id:<input type="text" name="cdId" autocomplete="off"><br>
		<input type="submit" name="submit" value="cd">
	</form>
	<br>
	<br>
	
	<h2>registrera dvd</h2>
	<form action="registreringMedia" method="post">
		
		title:<input type="text" name="title" autocomplete="off"><br>
		regiss�r f�rnamn:<input type="text" name="skaparefnamn" autocomplete="off"><br>
		regiss�r efternamn:<input type="text" name="skapareenamn" autocomplete="off"><br>
		dvdns id:<input type="text" name="dvdId" autocomplete="off"><br>
		<input type="submit" name="submit" value="dvd">
	</form>
	
	
	
	
	
	
	
	<br>
	<br>
	<h2>l�na bok</h2>
	<form action="l�na" method="post">
		personnummer:<input type="text" name="elevId" autocomplete="off"><br>
		bokens serienummer:<input type="text" name="bokId" autocomplete="off"><br>
		<input type="submit" name="submit" value="l�na bok" >
	</form>
	
	<br>
	<br>
	<h2>l�na cd</h2>
	<form action="l�na" method="post">
		personnummer:<input type="text" name="elevId" autocomplete="off"><br>
		cdns serienummer:<input type="text" name="cdId" autocomplete="off"><br>
		<input type="submit" name="submit" value="l�na cd">
	</form>
	
	<br>
	<br>
	<h2>l�na dvd</h2>
	<form action="l�na" method="post">
		personnummer:<input type="text" name="elevId" autocomplete="off"><br>
		dvdns serienummer:<input type="text" name="dvdId" autocomplete="off"><br>
		<input type="submit" name="submit" value="l�na dvd">
	</form>
	
	
	
	
	
	
	
</body>
</html>