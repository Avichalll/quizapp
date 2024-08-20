pipeline {
    agent any

    stages {
        stage('Compilation') {
            steps {
                sh './mvnw clean install -DskipTests'
            }
        }

        stage('Tests and Deployment') {
            parallel {
                stage('Running unit tests') {
                    steps {
                        sh './mvnw test -Punit'
                    }
                }
                stage('Deployment') {
                    steps {
                        sshagent(['your-ssh-credentials-id']) {
                            sh '''
                            scp target/your-app.jar user@remote-server:/path/to/deploy/
                            ssh user@remote-server 'nohup java -jar /path/to/deploy/your-app.jar > /dev/null 2>&1 &'
                            '''
                        }
                    }
                }
            }
        }
    }
}