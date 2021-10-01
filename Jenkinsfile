pipeline {
    agent any 
    tools {
        maven 'Maven 3.8.1'
        jdk 'jdk8'
    }
    stages {
        stage ('Build') {
            steps {    
                sh ' mvn clean install -DskipTests'
            }
        }
        /*stage ('Test') {
            steps {    
                sh ' mvn test'
            }
        }*/       
        stage ('Imagem docker') {
            steps {
                sh 'docker build . -t vonex/api_sms-campanha:${BUILD_NUMBER}'
            }
        }
        stage ('Run docker') {
            steps {
                //sh ' docker stop api-sms-campanha' 
                //sh ' docker rm api-sms-campanha'
                sh ' docker container run --network intranet -h api-sms-campanha -d --name integra-api -p 8081:8081 vonex/api_sms-campanha:${BUILD_NUMBER}'
            }
        }        
    }
}


