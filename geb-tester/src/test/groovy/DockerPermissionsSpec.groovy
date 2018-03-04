import geb.spock.GebSpec

class DockerPermissionsSpec extends GebSpec {

    def "checking Docker permissions"() {
        when: "docker is executed directly"
        int dockerExitValue = "docker --version".execute().waitFor()

        and: "docker compose is executed directly"
        int dockerComposeExitValue = "docker-compose --version".execute().waitFor()

        then: "we expect correct exit codes"
        dockerExitValue == 0
        dockerComposeExitValue == 0
    }

    //docker exec bitnamidockerwordpress_wordpress_1 stat -c %A%U%G /bitnami/wordpress/wp-config.php


    def "checking wp-config permissions"() {
        when: "docker is executed directly"
        String rights = "docker exec bitnamidockerwordpress_wordpress_1 stat -c %A%U%G /bitnami/wordpress/wp-config.php".execute().getText().trim()

        then: "we expect correct rights and user/group"
        rights == "-rw-r-----rootdaemon"

    }
}