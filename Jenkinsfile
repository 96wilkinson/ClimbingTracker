pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test the backend--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--Producing Surefire Report--') {
            steps {
                sh "mvn surefire-report:report"
                sh "mail -s Surefire 96wilkinson@sky.com -A ~/.jenkins/workspace/ClimbingTracker/target/site/surefire-report.html"
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
        stage('--testing environment creation--') {
            steps {
                sh "ssh -tt -i /home/ubuntu/myfirstVM.pem ubuntu@ec2-52-56-223-57.eu-west-2.compute.amazonaws.com ./script.sh"
                sh "exit"
                }
            }
        stage('--Test Front End--') {
            steps {
                sh "mvn test"
            }
        }
    }
}
