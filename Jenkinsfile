pipeline {
  agent {
    label 'mac'
  }
  environment {
    ALLURE_HOME = tool 'allure-commandline'
    PATH = "${env.ALLURE_HOME}/bin:${env.PATH}"
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
          allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/allure-results']]
          ])
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
  tools {
    // Define Allure Commandline installation
    install 'allure-commandline'
  }
}
