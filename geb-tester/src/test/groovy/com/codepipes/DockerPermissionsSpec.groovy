package com.codepipes


import spock.lang.*

@Stepwise
@Title("Check correct permissions of file wp-config")
class DockerPermissionsSpec extends Specification {

    def "Checking Docker permissions"() {
        when: "docker is executed directly"
        int dockerExitValue = "docker --version".execute().waitFor()

        and: "docker compose is executed directly"
        int dockerComposeExitValue = "docker-compose --version".execute().waitFor()

        then: "we expect correct exit codes"
        dockerExitValue == 0
        dockerComposeExitValue == 0
    }

    //docker exec bitnamidockerwordpress_wordpress_1 stat -c %A%U%G /bitnami/wordpress/wp-config.php


    def "Checking wp-config permissions"() {
        when: "docker is executed directly"
        String rights = "docker exec bitnamidockerwordpress_wordpress_1 stat -c %A%U%G /bitnami/wordpress/wp-config.php".execute().getText().trim()

        then: "we expect correct rights and user/group"
        rights == "-rw-r-----rootdaemon"

    }
}