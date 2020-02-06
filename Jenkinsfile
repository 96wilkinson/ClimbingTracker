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
                sh "mail -s Surefire 96wilkinson@sky.com -A ~/.jenkins/workspace/ClimbingTracker/target/site/surefire-report.html"
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
        stage('--testing environment creation--') {
            steps {
                sh "ssh -i "myfirstVM.pem" ubuntu@ec2-52-56-223-57.eu-west-2.compute.amazonaws.com"
                sh "docker stop climbingtracker:latest"
                sh "docker rm climbingtracker:latest"
                sh "mvn dependency:get -DremoteRepositories=http://3.11.84.155:8081/repository/mmamanagement-hosted -DgroupId=com.bae.ClimbingTracker -DartifactId=application -Dversion=0.0.1-SNAPSHOT -Dtransitive=false"
                sh "mvn dependency:copy -Dartifact=com.bae.ClimbingTracker:application:0.0.1-SNAPSHOT -DoutputDirectory=/home/ubuntu/"
                sh "cd /home/ubuntu/ && docker build -t climbingtracker ."
            }
        }
        }
    }
}
