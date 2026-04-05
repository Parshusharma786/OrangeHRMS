pipeline {
  agent any
  tools {
    maven 'Maven'
  }
  stages {
    stage('Build & Test') {
      steps {
        bat 'mvn clean test'
      }
    }
  }
}