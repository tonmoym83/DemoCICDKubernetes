pipeline {
    agent any
  tools {
        maven 'Maven3'   // matches the name in Global Tool Config
    }
environment {
        IMAGE_NAME = "demo-cicdkubernetes"
        IMAGE_TAG  = "latest"
        REGISTRY   = "docker.io/tonmoym83"   // or ghcr.io/your-org
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/tonmoym83/DemoCICDKubernetes.git'
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
            docker build -t demo-cicdkubernetes:latest .
        """
    }
}

       stage('Deploy to Kubernetes') {
    steps {
        bat """
            kubectl delete deployment demo-cicdkubernetes --ignore-not-found
            kubectl apply -f k8s/deployment.yaml
            kubectl apply -f k8s/service.yaml
        """
    }
}
    }
}
