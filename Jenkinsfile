pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /tmp/.m2:/tmp/.m2 -u root'

        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                dir("server"){
                    sh "pwd"
		            sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir("server"){
                    sh 'mvn test -Dspring.profiles.active=test'
                }
            }
            post {
                always {
                    dir("server"){
                        junit 'target/surefire-reports/*.xml'
                    }
                }
            }
        }
        stage('Coverage') {
            steps {
                dir("server"){
                    sh 'mvn clean package jacoco:report'
                }
            }
            post {
                always {
                    dir("server"){
                        publishCoverage adapters: [jacoco('/target/site/jacoco/jacoco.xml')]
                    }
                } 
            }
        }
    }
}
