pipeline {
    environment {
        registry = "fluxrelease/demo-release-repo"
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
		script {
        	    docker.build registry + ":$BUILD_NUMBER"
	    	}
	    }
        }
    }
}
