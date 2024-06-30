pipeline {
  agent any

  environment {
    DOCKER_HUB_REPO = 'abhigupta3'
  }

  stages {

    stage('Maven Build'){
      steps{
        dir('swiftcart-svc/service-registry') {
            sh 'mvn clean install'
        }
        dir('swiftcart-svc/api-gateway') {
            sh 'mvn clean install'
        }
        dir('swiftcart-svc/product-service') {
            sh 'mvn clean install'
        }
        dir('swiftcart-svc/user-service') {
            sh 'mvn clean install'
        }
        dir('swiftcart-svc/cart-service') {
            sh 'mvn clean install'
        }
        dir('swiftcart-svc/order-service') {
            sh 'mvn clean install'
        }
      }
    }

     stage('Docker Build') {
        steps {
             dir('swiftcart-svc/service-registry') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/service-registry .'
             }
             dir('swiftcart-svc/api-gateway') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/api-gateway .'
             }
             dir('swiftcart-svc/product-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/product-service .'
             }
             dir('swiftcart-svc/user-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/user-service .'
             }
             dir('swiftcart-svc/cart-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/cart-service .'
             }
             dir('swiftcart-svc/order-service') {
                sh 'docker build -t ${DOCKER_HUB_REPO}/order-service .'
             }
        }
     }
  }

}
