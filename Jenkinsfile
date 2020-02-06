pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--Producing Surefire Report--') {
            steps {
                sh "mvn surefire-report:report"
                sh "cd target/site && ls -la"
                sh "whoami"
                sh "chmod 777 ~/.jenkins/workspace/ClimbingTracker/target/site/surefire-report.html"
                sh "mail -s Surefire 96wilkinson@sky.com -A "~/.jenkins/workspace/ClimbingTracker/target/site/surefire-report.html""
                sh "cd "
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
        stage('--information before deployment--') {
            steps {
                sh "mvn -v"
            }
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy"
            }
        }
    }
}
