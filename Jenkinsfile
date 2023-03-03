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
                steps {
                        script {
                          try {
                            allure([
                              includeProperties: false,
                              jdk: '',
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
