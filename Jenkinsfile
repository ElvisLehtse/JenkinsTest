pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo "🔄 Checking out source..."
                checkout scm
                echo "✅ Checkout complete"
            }
        }
        stage('Build Jar') {
            steps {
                echo "🔨 Building JAR..."
                sh 'mvn clean package -DskipTests'
                echo "✅ JAR build complete"
            }
        }
        stage('Build Docker Image') {
            steps {
                echo "🐳 Building Docker image..."
                sh 'docker build -t jenkinstest:latest .'
                echo "✅ Docker image built"
            }
        }
        stage('Run Docker Container') {
            steps {
                echo "▶️ Running Docker container..."
                sh 'docker run -d --name jenkinstest -p 8080:8080 jenkinstest:latest || true'
                echo "✅ Docker container started"
            }
        }
    }
    post {
        success {
            echo '🎉 Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}