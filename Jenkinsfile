node {
  
   stage('Preparation') { 
      cleanWs()
      git 'https://github.com/kkapelon/wordpress-tester'
     
   }
   stage('Launch wordpress') { 
      sh 'git clone https://github.com/bitnami/bitnami-docker-wordpress.git'
      sh 'cd bitnami-docker-wordpress && docker-compose up -d'
      sleep 20
      sh 'cd ..'
      sh 'chmod +x ./wait-for-it.sh'
      sh './wait-for-it.sh -t 30 localhost:80 -- echo "wordpress is up"'
     
   }
   stage('Run Geb Tests') {
      sh 'chmod +x ./geb-tester/gradlew'
      sh "cd geb-tester && ./gradlew chromeHeadlessTest"
     
   }
   stage('Stop wordpress') { 
      sh 'cd bitnami-docker-wordpress && docker-compose down'
     
   }
   stage('Results') {
      junit '**/test-results/chromeHeadlessTest/TEST-*.xml'
      archive 'geb-tester/build/reports/tests/chromeHeadlessTest/*'
   }
}