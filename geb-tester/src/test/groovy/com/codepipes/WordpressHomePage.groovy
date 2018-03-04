package com.codepipes

import geb.Page

class WordpressHomePage extends Page {

    static at = { goToLogin.displayed }

    static content = {
        goToLogin { $('a[href*="wp-login.php"') }
    }

    void goToLoginPage() {
        goToLogin.click()
    }
}