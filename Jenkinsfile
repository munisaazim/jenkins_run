pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
       sh 'mvn clean test'
       echo 'Compile and Unit Test Completed'
      }
    }

    stage('Publish Allure report') {
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
    }
  }
}
