package com.codepipes

import geb.spock.GebSpec
import spock.lang.*

import groovyx.net.http.*

@Stepwise
@Title("Check valid Wordpress functioning")
class WordpressSpec extends GebSpec {


    def "Port 80 should accept connections"(){
        given: "a running wordpress installation"
        boolean connected = false

        when: "we connect with http"
        HttpBuilder.configure {
            request.uri = 'http://localhost'
            }.head {
                response.when(200){ 
                    connected = true
                }
            }

        then: "then we should get a valid response"
        connected

        }

    
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