pipeline {
    environment {
        registry = "fluxrelease/demo-release-repo:0.0.1"
        registryCredential = 'dockerhub'
    }
    agent any
    tools {
        maven 'Maven 3.6.1'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean install' 
            }
        }
	stage ('Build image') {
            steps {
	        sh 'docker build -t ${registry} .'
            }
        }
    }
}
