<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>P?melding</title>
</head>
<body>
	<h2>P?melding</h2>
	
	<a href="Login">Tilbake</a>
	
	<form action="Paameldingsskjema" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" value="${Paameldingsskjema.fornavn}" /> 
					<font color="red">${Paameldingsskjema.fornavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value="${Paameldingsskjema.etternavn}" /> 
					<font color="red">${Paameldingsskjema.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" value="${Paameldingsskjema.mobil}" /> 
					<font color="red">${Paameldingsskjema.mobilFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="${Paameldingsskjema.passord}" /> 
					<font color="red">${Paameldingsskjema.passordFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					value="${Paameldingsskjema.passordRepetert}" /> 
					<font color="red">${Paameldingsskjema.passordRepetertFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kj?nn:</label> <input type="radio" name="kjonn"
					value="mann"
					${Paameldingsskjema.kjonn == 'mann' ? 'checked' : ''}
					 />mann
				<input type="radio" name="kjonn" value="kvinne"
					${Paameldingsskjema.kjonn == 'kvinne' ? 'checked' : ''}
					 />kvinne
				<font color="red">${Paameldingsskjema.kjonnFeil}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg p?</button>
			</div>
		</fieldset>
	</form>
</body>
</html>