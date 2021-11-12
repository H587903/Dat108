<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="no">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="icon" href="data:," />
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <title>P�melding</title>
  </head>
  <body>
    <h2>P�melding</h2>    

      <form method="post">
        <fieldset>
          <label for="fornavn">Fornavn:</label>
          <input type="text" name="fornavn" id="fornavn" value="${Paameldingsskjema.fornavn}"
               placeholder="Fyll inn fornavn"
               title="Fornavn m� starte med stor forbokstav og innholde kun bokstaver. Antall tegn m� v�re mellom 2 og 20."
               required pattern="\s*\p{Lu}\p{Ll}+(\s+\p{Lu}\p{Ll}+)*\s*"
           />
          <span class="melding">${Paameldingsskjema.fornavnFeil}</span>

          <label for="etternavn">Etternavn:</label>
          <input type="text" name="etternavn" id="etternavn" value="${Paameldingsskjema.etternavn}"
               placeholder="Fyll inn etternavn"
               title="Etternavn m� starte med stor forbokstav og innholde kun bokstaver. Antall tegn m� v�re mellom 2 og 20."
              required pattern="\s*\p{Lu}\p{Ll}+\s*"
           />
          <span class="melding">${Paameldingsskjema.etternavnFeil}</span>

          <label for="mobil">Mobil (8 siffer):</label>
          <input type="text" name="mobil" id="mobil" value="${Paameldingsskjema.mobil}"
              placeholder="Fyll inn telefonnummer"
              title="Mobilnummer m� best� av n�yaktig 8 siffre."
              required pattern="\s*\+?\s*(\d\s*){8}\s*"
           />
          <span class="melding">${Paameldingsskjema.mobilFeil}</span>

          <label for="passord">Passord:</label>
          <input type="password" name="passord" id="passord" value="${Paameldingsskjema.passord}"
              placeholder="Velg et passord"
              title="Passordet m� best� av minst ein stor og liten bokstav, eit tall, og m� ha minst 8 tegn, men b�r ha minst 14 tegn."
              required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}"
           />
         <span class="melding">${Paameldingsskjema.passordFeil}</span>

          <label for="passordRepetert">Passord repetert:</label>
          <input type="password" name="passordRepetert" id="passordRepetert" value="${Paameldingsskjema.passordRepetert}"
              placeholder="Gjenta passord"
              required  />
          <span class="melding">${Paameldingsskjema.passordRepetertFeil}</span>

          <span class="columnfirst">Kj�nn:</span>
          <span>
            <label>
                <input type="radio" name="kjonn" value="mann" checked="checked"/> mann</label>
            <label>
                <input type="radio" name="kjonn" value="kvinne"/>kvinne</label>
          </span>
          <span class="melding">${Paameldingsskjema.kjonnFeil}</span>

          <button type="submit">Meld meg p�</button>
        </fieldset>
      </form>
  </body>
</html>
