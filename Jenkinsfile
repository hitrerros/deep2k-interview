pipeline {
    agent {
        docker {
            image 'maven:3.9.5-eclipse-temurin-17'
        }
    }

    environment {
        ROOT_DIR             = "${WORKSPACE}"
        CONTENT_ADM_DIR      = "${WORKSPACE}/content-adm"
        ADVERTISER_DIR       = "${WORKSPACE}/advertiser"
        CURRENCY_MONITOR_DIR = "${WORKSPACE}/currency-monitor"
    }

    stages {
        stage('Checkout repo') {
            steps {
                checkout scm
            }
        }

         stage('Build jars') {
            steps {
                dir("${env.CONTENT_ADM_DIR}") {
                    sh 'mvn clean package -DskipTests'
                }
                dir("${env.ADVERTISER_DIR}") {
                    sh 'mvn clean package -DskipTests'
                }
                dir("${env.CURRENCY_MONITOR_DIR}") {
                    sh 'mvn clean package -DskipTests'
                }
            }
         }

        stage('Build Docker') {
            steps {
             dir("${env.PROJECT_DIR}") {
                sh 'docker compose build'
            }
            }
        }

        stage('Deploy') {
            steps {
             dir("${env.PROJECT_DIR}") {
                sh 'docker compose down && docker compose up -d'
            }
            }
        }
    }
}