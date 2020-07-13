pipeline {
    agent any
     options {
        skipStagesAfterUnstable()
    }
    tools { 
        maven 'maven_3_5_0' 
        jdk 'JDK 11' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
                
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
               	sh 'mvn clean'
		    
            }
        } 
	    
		stage ('Testing Stage') {
			steps {
		           sh 'mvn test'
                
            }
     }
	 stage ('Build Results') {

            steps {
		           publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
      reportDir: 'reports',
      includes: '**/*, **/*.css',
      reportFiles: 'index.html',
      reportName: "HTML Report-Globomantics"
    ])
	junit 'target/surefire-reports/junitreports/**/*.xml'
                
            }
	     }
		 }
	
	post {
	success {
      script {
    if (env.BRANCH_NAME == 'master')
        currentBuild.result = 'SUCCESS'
		googleStorageUpload bucket: 'gs://deploymentbucket', credentialsId: 'TestProject1', pattern: 'reports/index.html', sharedPublicly: true
        //cleanWs();
  }
      
	 } 
	  }
	//
		}
	

