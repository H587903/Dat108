class validator {

	sjekkPassordStyrke(event) {
		const validity = event.target.validity;
		if (validity.valid) {
			// Sjekk for middels eller sterkt passord
			let password = document.getElementById('passord');
			let mediumPassword = new RegExp('(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}');
		}
	}
}