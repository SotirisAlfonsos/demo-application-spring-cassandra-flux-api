def gitSHA

pipeline {
  agent {
    kubernetes {
      defaultContainer 'jnlp'
    }
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        script {
          gitSHA = sh(returnStdout: true, script: 'git rev-parse --short HEAD')
        }
      }
    }
    stage('Install') {
      steps {
        container('maven') {
          sh 'mvn clean install'
        }
      }
    }
    stage('Build') {
      environment {
        TAG = "$gitSHA"
      }
      steps {
        container('docker') {
          sh 'docker build -t $IMAGE_REGISTRY/demo-release-repo:$TAG .'
          sh 'docker push $IMAGE_REGISTRY/demo-release-repo:$TAG'
        }
      }
    }
    stage('Deploy Canary') {
      when { branch 'canary' }
      steps {
        container('kubectl') {
          sh 'apk update && apk add gettext'
          sh "export TAG=$gitSHA" + 'envsubst < deployment/canary.yaml | kubectl apply -f -'
          sh "export PROD_WEIGHT=95 CANARY_WEIGHT=5" + 'envsubst < deployment/istio.yaml | kubectl apply -f -'
        }
      }
    }
    stage('Deploy Production') {
      when { branch 'master' }
      steps {
        container('kubectl') {
          sh 'apk update && apk add gettext'
          sh "export TAG=$gitSHA" + 'envsubst < deployment/app.yaml | kubectl apply -f -'
          sh "export PROD_WEIGHT=100 CANARY_WEIGHT=0" + 'envsubst < deployment/istio.yaml | kubectl apply -f -'
        }
      }
    }
  }
}
