package com.codepipes

import geb.Page

class WordpressDashboardPage extends Page {

    static at = { myAccountDetails.displayed  }

    static content = {
        myAccountDetails { $('li#wp-admin-bar-my-account') }
    }

    

    void editAPost() {
        getBrowser().go("/wp-admin/edit.php")
    }
}

