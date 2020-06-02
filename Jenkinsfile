pipeline {
    agent any
    stages {
        stage('BUILD') {
            steps {
                      git 'https://github.com/avietlobo/CucumberJenkinsReportProject.git'
                      bat label: '', script: 'mvn clean'
            }
        }
    stage('TEST') {
           steps {
             bat label: '', script: 'mvn test'
        } 
       
   }
   
   stage('Cucumber Reports') {
           steps {
            cucumber buildStatus: "UNSTABLE",
            fileIncludePattern: "**/cucumber.json"	
        } 
        }
       

   
   
    }
}