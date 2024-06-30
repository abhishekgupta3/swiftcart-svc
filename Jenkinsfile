pipeline {
  agent any

  tools {
      maven 'MAVEN_HOME'
  }

  stages {

    stage('Checkout SCM') {
        steps {
            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abhishekgupta3/swiftcart-svc/']])
        }
    }

    stage('Maven Build'){
      steps{
        dir('service-registry') {
            bat 'mvn clean install'
        }
        dir('api-gateway') {
            bat 'mvn clean install'
        }
        dir('product-service') {
            bat 'mvn clean install'
        }
        dir('user-service') {
            bat 'mvn clean install'
        }
        dir('cart-service') {
            bat 'mvn clean install'
        }
        dir('order-service') {
            bat 'mvn clean install'
        }
      }
    }

     stage('Docker Build') {
        steps {
             dir('service-registry') {
                bat 'docker build -t abhigupta3/service-registry .'
             }
             dir('api-gateway') {
                bat 'docker build -t abhigupta3/api-gateway .'
             }
             dir('product-service') {
                bat 'docker build -t abhigupta3/product-service .'
             }
             dir('user-service') {
                bat 'docker build -t abhigupta3/user-service .'
             }
             dir('cart-service') {
                bat 'docker build -t abhigupta3/cart-service .'
             }
             dir('order-service') {
                bat 'docker build -t abhigupta3/order-service .'
             }
        }
     }

     stage('Docker Push') {
          steps {
            withCredentials([usernamePassword(credentialsId: 'dbc50ab2-92a0-4da0-a229-08e0ad15c089', passwordVariable: 'password', usernameVariable: 'username')]) {
                    bat echo %password% | docker login -u %username% --password-stdin
                    bat 'docker push abhigupta3/service-registry'
                    bat 'docker push abhigupta3/api-gateway'
                    bat 'docker push abhigupta3/product-service'
                    bat 'docker push abhigupta3/user-service'
                    bat 'docker push abhigupta3/order-service'
                    bat 'docker push abhigupta3/cart-service'
             }
          }
      }
  }

}
