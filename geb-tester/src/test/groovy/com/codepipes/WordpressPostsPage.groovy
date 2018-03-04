package com.codepipes

import geb.Page

class WordpressPostsPage extends Page {

    static at = { publishedTable.displayed }

    static content = {
        publishedTable { $('li[class="publish"]') }
        addNewPostButton { $('a[class*="page-title-action"]')}
    }

    void addNewPost() {
        addNewPostButton().click()
    }

    
}