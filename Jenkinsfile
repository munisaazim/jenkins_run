pipeline {
    agent {
        label 'mac'
    }
    environment {
        ALLURE_HOME = tool name: 'my-allure-commandline', type: 'ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation'
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
            node('mac') {
                script {
                    allure([
                        includeProperties: false,
                        jdk: 'my-jdk',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                    archiveArtifacts artifacts: 'allure-results/**'
                }
            }
        }
    }
}
