function validate_form() {
	valid = true;

        if ( document.contact_form.username.value == "" )
        {
                alert ( "Please fill in the 'Your name' box." );
                valid = false;
        }

        if ( document.contact_form.email.value == "" ||
        !(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.contact_form.email.value)))
        {
                alert ( "Please provide a valid email." );
                valid = false;
        }

        if ( document.contact_form.password.value == "" )
        {
                alert ( "Please fill in the 'Your password' box." );
                valid = false;
        }

        if ( document.contact_form.re_pass.value == "" )
        {
                alert ( "Please fill in the 'Repeat your password' box." );
                valid = false;
        }

        return valid;
}

function TDate() {

    var UserDate = document.getElementById("userdate").value;
    var ToDate = new Date();

    if (new Date(UserDate).getTime() <= ToDate.getTime()) {
          alert("The Date must be bigger or equal to today date");
          return false;
     }
    return true;
}



