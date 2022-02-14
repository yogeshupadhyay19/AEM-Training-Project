    var recaptcha_response = '';

    function submitUserForm() {
    	console.log("submitUserForm");
    	if (recaptcha_response.length == 0) {
            document.getElementById('g-recaptcha-error').innerHTML = '<span style="font-size: 20px; color:red;">This field is required.</span>';
    		return false;
    	}
    	return true;
    }

    function verifyCaptcha(token) {
    	console.log("verifyCaptcha");
    	recaptcha_response = token;
    	document.getElementById('g-recaptcha-error').innerHTML = '';
    }