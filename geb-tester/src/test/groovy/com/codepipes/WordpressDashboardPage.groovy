package com.codepipes

import geb.Page

class WordpressDashboardPage extends Page {

    static at = { myAccountDetails.displayed  }

    static content = {
        myAccountDetails { $('li#wp-admin-bar-my-account') }
    }

    

    void editPosts() {
        getBrowser().go("/wp-admin/edit.php")
    }
}

