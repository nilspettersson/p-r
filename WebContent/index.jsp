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
		förnamn:<input type="text" name="fnamn"><br>
		efternamn<input type="text" name="enamn"><br>
		personnummer:<input type="text" name="personnummer"><br>
		<input type="submit">
	</form>
	<br>
	<br>
	bok
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title"><br>
		författarens förnamn:<input type="text" name="skaparefnamn"><br>
		författarens efternamn:<input type="text" name="skapareenamn"><br>
		bokens id:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="bok">
	</form>
	<br>
	<br>
	
	cd
	<form action="registreringMedia" method="post">
		title:<input type="text" name="title"><br>
		författarens förnamn:<input type="text" name="skaparefnamn"><br>
		författarens efternamn:<input type="text" name="skapareenamn"><br>
		uppläsarens förnamn:<input type="text" name="uppläsarefnamn"><br>
		uppläsarens efternamn:<input type="text" name="uppläsareenamn"><br>
		cdns id:<input type="text" name="cdId"><br>
		<input type="submit" name="submit" value="cd">
	</form>
	<br>
	<br>
	
	dvd
	<form action="registreringMedia" method="post">
		dvdns id:<input type="text" name="dvdId"><br>
		title:<input type="text" name="title"><br>
		regissör förnamn:<input type="text" name="skaparefnamn"><br>
		regissör efternamn:<input type="text" name="skapareenamn"><br>
		<input type="submit" name="submit" value="dvd">
	</form>
	
	
	
	
	
	
	
	<br>
	<br>
	låna bok
	<form action="låna" method="post">
		personnummer:<input type="text" name="elevId"><br>
		bokens serienummer:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="låna bok">
	</form>
	
	<br>
	<br>
	låna cd
	<form action="låna" method="post">
		personnummer:<input type="text" name="elevId"><br>
		cdns serienummer:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="låna cd">
	</form>
	
	<br>
	<br>
	låna dvd
	<form action="låna" method="post">
		personnummer:<input type="text" name="elevId"><br>
		dvdns serienummer:<input type="text" name="bokId"><br>
		<input type="submit" name="submit" value="låna dvd">
	</form>
	
	
	
	
	
	
	
</body>
</html>