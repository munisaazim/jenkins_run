pipeline {
    agent {
        label 'mac'
    }
    stages {
        stage('Test') {
            steps {
                  sh 'mvn clean install -U'
                  echo 'Compile and Unit Test Completed'
            }
        }
    }
    post {
        always {
            script {
                sh 'mvn io.qameta.allure:allure-maven:2.21.0:serve target/allure-results'
            }
        }
    }
}