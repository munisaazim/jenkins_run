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
                    script {
                        allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                        ])
                        sh 'allure generate --clean target/allure-results -o target/allure-report'
                        archiveArtifacts artifacts: 'target/allure-report'
                    }
            }
        }
    }
}
