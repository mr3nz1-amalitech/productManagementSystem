def gv

CODE_CHANGES = getGitChanges()

pipeline {
    agent any

// specify build tools in jenkins, by default jenkins has access to maven, gradle, and jdk
    tools {
        maven
        gradle
        jdk
    }

//     parameters
    parameters {
        string(name: "VERSION", defualtValue: '', description: 'some description to know what the parameter is for')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executesTests', defaultValue: true, description: '')
    }

//     define custom environment variables
    environment {
        NEW_VERSION = '1.3.0'

//         get environment from jenkins. Examples would be credentials
        SERVER_CREDENTIALS = credentials('server-credentials')
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
                echo "Building new version : ${NEW_VERSION}"
            }
        }
        stage("test") {
//         conditionals
            when {
                expression {
                    BRANCH_NAME == 'dev' && CODE_CHANGES == true

// a parameter defined at the top
                    params.executesTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            steps {
                echo "Deploying..."
                withCredentials([
                    usernamePassword(credentials: "server-credentials", usernameVariable: USER, passwordVariable: PWD)
                ]) {
                    sh "Some script ${USER} ${PWD}"
                }
            }
        }
    }

// executes after the stages have complete
    post {
        always {

        }

        failure {

        }
    }
}


// Environment variables
got from jenkins-url/env-vars.html