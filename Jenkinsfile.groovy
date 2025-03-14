pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-username/your-repo.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the application...'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'echo "Tests passed!"'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application (simulated)...'
            }
        }
    }
    post {
        success {
            mail to: 'your-college-email@example.com',
                 subject: "Jenkins Build Success",
                 body: "The build was successful!"
        }
        failure {
            mail to: 'your-college-email@example.com',
                 subject: "Jenkins Build Failed",
                 body: "The build failed. Check Jenkins logs for more details."
        }
    }
}