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
}