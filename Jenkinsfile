pipeline {
    agent any

    stages {
        stage('git pull') {
            steps {
                git url: 'https://github.com/saminaik/SPE-Major-Back-end-final.git', branch: 'finalproject',
                credentialsId:'githubID'
            }
        }
           stage('Maven Build and Run Tests'){
            steps{
                sh "mvn clean install -DskipTests"
            }
        }    
   
      stage('Image Build'){
            steps{
                sh "docker build -t saminaik/spe_back-end:latest ."
            }
        }
      
        
    
}
}
