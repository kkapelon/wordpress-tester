# Description
This is a simple example for verifying a wordpress docker installation. It consists
of a Groovy/Gradle application based on

* The [Spock framework](http://spockframework.org/) for the tests
* The [Geb framework](http://www.gebish.org/) for running web tests using the Chromedriver

The test structure is running against a Wordpress installation and performs
browser request like a human would, by logging into the wordpress dashboard and creating
a new post.

The tests are written using the [Page Object Pattern](https://martinfowler.com/bliki/PageObject.html)

For the wordpress sample the [Bitnami docker image](https://github.com/bitnami/bitnami-docker-wordpress) is used. The default wordpress credentials
are (user,bitnami)

## Requirements

To run this example locally you need a Linux machine (or VM) with the following

 * Java 8+ (package openjdk-8-jdk)
 * Git
 * Docker
 * [Docker compose](https://docs.docker.com/compose/overview/)
 * Chrome Browser

It is best you use the native packages of your Linux distribution. In particular, make sure
that your Docker and Docker compose installations can work with each other.

Note that gradle, spock and geb are auto-downloaded so you **don't** need to install them beforehand

## Optional CI Requirements

A [Jenkinsfile](https://jenkins.io/doc/book/pipeline/syntax/) is also included for a simple [Jenkins 2](https://jenkins.io/2.0/) pipeline. In that case apart from a Jenkins 2 installation you also need [xvfb](https://en.wikipedia.org/wiki/Xvfb) if you wish to run the tests in a headless machine

## Running everything locally

Once all your requirements are ready you can run the tests as bellow

1. git clone https://github.com/kkapelon/wordpress-tester.git
1. cd wordpress-tester
1. sh ./run.sh

If everything goes well the following will happen

1. The docker compose distribution for Wordpress will be downloaded
1. Docker compose will start the Wordpress installation by Bitnami
1. Gradle will run and download its dependencies (and itself)
1. The wordpress tests will run in both headless and normal mode
1. You will see your Chrome browser open up and navigate on its own
1. Docker compose will tear down the wordpress installation.

![Chrome managed by Geb](/pictures/geb-automation.png)

Make sure that port 80 is free on your machine, as wordpress will try to bind there
once it is launched. 

## Getting reports

Two kinds of reports will be produced once everything is finished. The standard
Gradle reports can be found at `wordpress-tester/geb-tester/build/reports/tests/chromeTest`.
These are very basic and only say if a test passed or not.

![Gradle test reports](/pictures/gradle-report.png)

To see the detailed given/when/then descriptions of the Spock tests, look at the Spock reports
at `wordpress-tester/geb-tester/build/spock-reports`

![Spock test reports](/pictures/sample-test-report.png)

## Running the tests under Jenkins 2

A basic Jenkinsfile is included. You can create a Jenkins 2 pipeline with it that will
execute the same steps as the local installation in a completely automated manner.

![Jenkins 2 pipeline](/pictures/jenkins2-pipeline.png)

If you Jenkins machine has a screen (e.g. your local workstation) you need to define in Manage Jenkins -> Configure System -> Environment Variable the following:

 * DISPLAY (key)
 * 0:0 (value)

If your machine has no display, then install xvfb and create a screen with the command
 `Xvfb :0 -ac -screen 0 1024x768x24`

Test results are also available in Jenkins 

![Jenkins 2 test results](/pictures/jenkins2-test-results.png)

## Possible future improvements

To remove the requirement of JVM, a Gradle docker image could be used instead so that a JVM installation is not needed.

Also for more comprehensive docker tests a dedicated solution such as [testinfra](http://testinfra.readthedocs.io/en/latest/), [inspec](https://www.inspec.io/), [serverspec](http://serverspec.org/) etc.
