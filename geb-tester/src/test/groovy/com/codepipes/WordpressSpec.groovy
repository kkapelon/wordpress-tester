package com.codepipes

import geb.spock.GebSpec

class WordpressSpec extends GebSpec {

    def "can login to Wordpress"() {
        when:
        to WordpressHomePage

        and:
        goToLoginPage()

        then:
        at WordpressLoginPage

        when:
        enterLoginDetails()
        report "google home page"

        then:
        at WordpressDashboardPage

        when:
        editAPost()

        then:
        at WordpressPostsPage

        // when:
        // manualsMenu.links[0].click()

        // then:
        // at TheBookOfGebPage
    }
}