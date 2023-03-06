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
        }
        stage('Generate Allure Report') {
            steps {
                   sh 'allure generate target/allure-results'
                 }
            post {
                always {
                    sh 'allure generate allure-results --clean'
                    archiveArtifacts artifacts: 'allure-report/**/*', fingerprint: true
                }
            }
        }
    }
}
