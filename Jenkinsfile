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
        docker.build("vineetvermait/cricapi:${env.BUILD_ID}")
        script {
          dockerPath = tool 'docker'

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
          docker.withRegistry('', 'docker-credentials') {
            def build = docker.build("vineetvermait/cricapi:${env.BUILD_ID}")
            def latest = docker.build("vineetvermait/cricapi:latest")
            build.push()
            latest.push()
            docker.image('vineetvermait/cricapi:latest').withRun('-p 8080:8080')
          }
        }
      }
    }
  }
}
