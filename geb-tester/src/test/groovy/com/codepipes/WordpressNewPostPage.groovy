package com.codepipes

import geb.Page

class WordpressNewPostPage extends Page {

    static at = { newPostTitleField.displayed  }

    static content = {
        newPostTitleField { $("input#title") }
        newPostBodyField { $("body#tinymce") }
        publishButton { $('input#publish') }
    }

    

    void publishPost() {
    	newPostTitleField = "Sample title"
    	withFrame(0){
			newPostBodyField << "Sample Content"
		}
        publishButton.click()
    }
}

