pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
    }
    
  }
  stages {
    stage('\'Example Build') {
      steps {
        sh 'mvn clean'
      }
    }
  }
}