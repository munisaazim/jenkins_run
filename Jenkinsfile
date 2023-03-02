pipeline {
    agent {
        label 'mac'
    }
    stages {
        stage('Test') {
            steps {
                  sh 'mvn clean test'
  		  echo 'Compile and Unit Test Completed'
            }
 
                    post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        reportDir: 'target/surefire-reports/',
                        reportFiles: 'emailable-report.html',
                        reportName: 'HTML Report',
                        reportTitles: 'Test Results'
                    ])
                }
            }
        }
    }
}
