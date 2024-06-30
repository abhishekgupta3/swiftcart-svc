pipeline {
  agent any

  environment {
    DOCKER_HUB_REPO = 'abhigupta3'
  }

  stages {
    stage('Clone') {
        steps {
            sh 'git clone https://github.com/abhishekgupta3/swiftcart-svc.git'
        }
    }

    stage('Maven Build'){
      steps{
        dir('service-registry') {
            sh 'mvn clean install'
        }
        dir('api-gateway') {
            sh 'mvn clean install'
        }
        dir('product-service') {
            sh 'mvn clean install'
        }
        dir('user-service') {
            sh 'mvn clean install'
        }
        dir('cart-service') {
            sh 'mvn clean install'
        }
        dir('order-service') {
            sh 'mvn clean install'
        }
      }
    }

     stage('Docker Build') {
        steps {
             dir('service-registry') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/service-registry .'
             }
             dir('api-gateway') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/api-gateway .'
             }
             dir('product-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/product-service .'
             }
             dir('user-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/user-service .'
             }
             dir('cart-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/cart-service .'
             }
             dir('order-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/order-service .'
             }
        }
     }
  }

}
