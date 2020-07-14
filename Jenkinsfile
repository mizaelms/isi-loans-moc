pipeline {
  agent { label 'maven' }
  options { timeout(time: 20, unit: 'MINUTES') }
  stages {
    stage('Initialise') {
      steps {
        stepInitialise()
      }
    }
    stage('Maven build') {
      steps {
        sh "mvn clean package"
      }
    }
    stage('Sonar analysis') {
      steps {
        stepMavenSonarAnalysis()
      }
    }
    stage('Build container image') {
      steps {
        stepContainerImageBuild()
      }
    }
    stage('Build ECS deployment image') {
      when { environment name: 'LS_GIT_BRANCH', value: 'master' }
      steps {
        stepEcsDeploymentImageBuild()
      }
    }
    stage('Test Deployment') {
      when { environment name: 'LS_GIT_BRANCH', value: 'master' }
      steps {
        stepEcsDeploy()
      }
    }
    stage('Publish to uDeploy') {
      when { environment name: 'LS_GIT_BRANCH', value: 'master' }
      steps {
        stepEcsUdeployPublish()
      }
    }
  }
  post {
    always {
      stepFinalise()
    }
  }
}
