pipeline {
  agent any
  tools {
    maven 'mvn'
  }
  options {
      timestamps()
      buildDiscarder(logRotator(numToKeepStr: '10'))
  }
  stages {
    stage('prepare'){
      steps{
        echo 'prepare'
        git 'https://github.com/PSEH-9/Vineet'
      }
    }
    stage('build'){
      steps{
        sh "mvn -Dmaven.test.failure.ignore clean package"
      }
    }
    stage('test'){
      steps{
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar'
      }
    }
    stage('dockerise'){
      steps{
        echo 'dockerise'
        script {
          dockerPath = tool 'docker'
          sh "'${dockerPath}/bin/docker' build -t vineetvermait/cricapi:${env.BUILD_ID} ."
        }
      }
    }
  }
  post {
    always {
      archiveArtifacts 'target/**/*.jar'
      junit 'target/**/*.xml'
    }
    success {
      withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        script {
          dockerPath = tool 'docker'
          sh "'${dockerPath}/bin/docker' login -u ${USERNAME} -p ${PASSWORD}"

          sh "'${dockerPath}/bin/docker' build -t vineetvermait/cricapi:${env.BUILD_ID} ."
          sh "'${dockerPath}/bin/docker' push vineetvermait/cricapi:${env.BUILD_ID}"

          sh "'${dockerPath}/bin/docker' tag vineetvermait/cricapi:${env.BUILD_ID} vineetvermait/cricapi:latest"
          sh "'${dockerPath}/bin/docker' push vineetvermait/cricapi:latest"
          sh "'${dockerPath}/bin/docker' run -d -p 8888:8080 vineetvermait/cricapi:latest"          }
        }
      }
    }
  }

