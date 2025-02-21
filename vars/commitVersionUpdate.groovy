#!/usr/bin/env groovy

def call() {
    withCredentials([usernamePassword(credentialsId: 'github-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        script {
            sh 'git config --global user.email "tsembenhoi@gmail.com"'
            sh 'git config --global user.name "TsembA"'
            sh 'git remote set-url origin https://${USER}:${TOKEN}@github.com/TsembA/module-9'
            sh '''
            if ! git diff --cached --exit-code > /dev/null; then
                git commit -m "Jenkins CI/CD"
                git push origin HEAD:jenkins-jobs
            else
                echo "No changes to commit."
            fi
            '''
        }
    }
}