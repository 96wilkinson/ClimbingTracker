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
                sh "chmod 777 surefire-report.html"
                sh "mail -s Surefire 96wilkinson@sky.com -A 'surefire-report.html'"
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
