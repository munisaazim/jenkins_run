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
                script {
                    try {
                    allure([
                        includeProperties: false,
                        jdk: 'allure-commandline', // use the name of the installation here
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                    } catch (NullPointerException e) {
                        // handle the exception
                        echo "Caught NullPointerException: ${e}"

                    }
                }
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
