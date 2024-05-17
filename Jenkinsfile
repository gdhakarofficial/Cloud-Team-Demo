pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'c62713ac-7f60-4247-a6e0-8ba258d430e9', url: 'https://github.com/gdhakar09/Cloud-Team-Demo.git']])
                sh 'mvn clean compile install'
            }
        }
        
        stage('SonarQube analysis') {
            steps {
                script {
                    scannerHome = tool 'Sonarqube'// must match the name of an actual scanner installation directory on your Jenkins build agent
                }
                withSonarQubeEnv(installationName: 'Sonarqube') {// If you have configured more than one global server connection, you can specify its name as configured in Jenkins
                sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=cloud-project-demo -Dsonar.projectName='cloud project demo' -Dsonar.java.binaries='target/classes'"
                // sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=cloud-project-demo -Dsonar.projectName='cloud project demo' -Dsonar.java.binaries='target/classes'"
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t gdhakar/cloud-team-demo .'
                // sh 'docker build -t gdhakar/cloudteamdemo:latest .'
                // sh 'docker build -t gdhakar09/Cloud-Team-Demo:latest .'
            }

        }
        stage('Push Docker Image To Hub') {
            steps {
                withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhubpwd')]) {
                sh 'docker login -u gdhakar -p ${dockerhubpwd}'
                }
                sh 'docker push gdhakar/cloud-team-demo'
            }

        }
    }
}
