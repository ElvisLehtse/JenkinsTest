pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Jar') {
            steps {
                docker.image('maven:3.9.2-eclipse-temurin-21').inside {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t jenkinstest:latest .'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name jenkinstest -p 8080:8080 jenkinstest:latest'
            }
        }
    }
    post {
        success {
            echo '✅ Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}