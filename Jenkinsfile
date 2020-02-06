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
                sh "wget -O myfirstVM.pem https://drive.google.com/u/0/uc?id=13qn2vPJS1z89MuSGWmyr2_x2Wf5Ypgqg&export=download && chmod 700 myfirstVM.pem"
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
