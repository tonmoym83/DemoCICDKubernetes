pipeline {
    agent any
  tools {
        maven 'Maven3'   // matches the name in Global Tool Config
    }
environment {
    IMAGE_NAME = "demo-kubernetes"
    IMAGE_TAG  = "latest"
}

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/tonmoym83/DemoKubernetes.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
stage('Docker Build') {
    steps {
        bat """
            docker build -t %IMAGE_NAME%:%IMAGE_TAG% .
        """
    }
}


       stage('Deploy to Docker Desktop') {
    steps {
        bat """
            docker rm -f springboot-container || echo No old container
            docker run -d -p 8080:8080 --name springboot-container demo-kubernetes:latest
        """
    }
}
    }
}
