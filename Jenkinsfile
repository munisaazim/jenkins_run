pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
       sh 'mvn clean test'
       echo 'Compile and Unit Test Completed'
      }
    }

    stage('Generate Allure report') {
      steps {
        sh 'allure generate target/allure-results'
      }
    }

    stage('Serve Allure report') {
      steps {
        sh 'allure serve target/allure-results'
      }
    }
  }
}
