pipeline {
    agent any
    stages {
        stage('git pull') {
            steps {
                git(
                    url: 'https://github.com/saminaik/SPE-Major-Back-end-final.git',
                    branch: 'finalproject',
                    credentialsId: 'githubID'
                )
            }
        }
        stage('Maven Build and Run Tests') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Image Build') {
            steps {
                sh 'docker build -t saminaik/spe_back-end:latest .'
            }
        }
        stage('Image Deploy') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub_id', usernameVariable: 'docker_username', passwordVariable: 'docker_password')]) {
                    sh "echo $docker_password | docker login --username $docker_username --password-stdin"
                    sh 'docker push saminaik/spe_back-end:latest'
                }
            }
        }
        stage('Ansible Deploy') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub_id', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    ansiblePlaybook(
                        installation: 'Ansible',
                        inventory: 'inventory',
                        playbook: 'playbook.yml',
                        colorized: true,
                        disableHostKeyChecking: true,
                        extraVars: [
                            'jenkins_credentials_username': "${DOCKERHUB_USERNAME}",
                            'jenkins_credentials_password': "${DOCKERHUB_PASSWORD}"
                        ]
                    )
                }
            }
            
    }
}

