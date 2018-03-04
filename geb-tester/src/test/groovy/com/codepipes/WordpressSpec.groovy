package com.codepipes

import geb.spock.GebSpec

class WordpressSpec extends GebSpec {

    def "Can publish a new post"() {
        when: "at the homepage"
        to WordpressHomePage

        and: "the login link is clicked"
        goToLoginPage()

        then: "the login page appears"
        at WordpressLoginPage

        when: "Login details are entered"
        enterLoginDetails()

        then: "and the dashboard appears"
        at WordpressDashboardPage

        when: "The edit posts button is clicked"
        editPosts()

        then: "and all posts appear"
        at WordpressPostsPage

        when: "the add new post button is clicked"
        addNewPost()

        then: "and the editor appears"
        at WordpressNewPostPage

        when: "Sample content is entered"
        publishPost()

        then: "the post is published with success"
        at WordpressNewPostPage

    }
}