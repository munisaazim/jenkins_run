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
    }
    post {
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
                archiveArtifacts artifacts: 'allure-report/**'
            }
        }
    }
}
