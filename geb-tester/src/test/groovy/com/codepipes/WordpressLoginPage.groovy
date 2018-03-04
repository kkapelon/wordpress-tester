package com.codepipes

import geb.Page

class WordpressLoginPage extends Page {

    static at = { userField.displayed }

    static content = {
    	userField { $("input#user_login") }
    	passwordField { $("input#user_pass") }

    	loginButton { $('input#wp-submit') }
        
    }

     void enterLoginDetails() {
     	//These are the default credentials for the bitnami wordress image
		userField = "user"
		passwordField = "bitnami"

		

        loginButton.click()
    }
}