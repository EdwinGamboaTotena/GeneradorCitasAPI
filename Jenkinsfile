/*
pipeline {
	//where and how to execute the Pipeline
	agent {
		label 'Slave_Induccion'
	}
	
	options {
		buildDiscarder(logRotator(numToKeepStr: '5')) 
		disableConcurrentBuilds() 
	}
	
	//A section defining tools to auto-install and put on the PATH
	tools {
		jdk 'JDK8_Centos'
		gradle 'Gradle4.5_Centos'
	}
	
	triggers {
		pollSCM('@hourly')
	}
	
	stages{
		
		stage('Checkout') {
			steps{
				echo "------------>Checkout<------------"
				checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [], gitTool: 'Git_Centos', submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub_EdwinGamboaTotena.hjs', url: 'https://github.com/EdwinGamboaTotena/GeneradorCitasAPI.git']]])
				sh 'gradle clean'
			}
		}
		
		stage('Compile') {
			steps{
				echo "------------>Compile<------------"
				sh 'gradle --b ./build.gradle compileJava'
			}
		}
		
		stage('Unit Tests And Coverage') {
			steps{
				echo "------------>Unit Tests<------------"
				sh 'gradle --b ./build.gradle test'
				junit '**/build/test-results/test/*.xml' //aggregate test results - JUnit
			    sh 'gradle --b ./build.gradle jacocoTestReport'
			}
		}
		
		stage('Static Code Analysis') {
			steps{
				echo '------------>Static Code Analysis<------------'
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
				}
			}
		}
		
		stage('Build') {
			steps {
				echo "------------>Build<------------"
				sh 'gradle build -x test'
			}
		}
	}
	
	post {
		always {
			echo 'This will always run'
		}
		success {
			echo 'This will run only if successful'
		}
		failure {
			echo 'This will run only if failed'
			//send notifications about a Pipeline to an email
			mail (to: 'edwin.gamboa@ceiba.com.co',
			      subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
			      body: "Something is wrong with ${env.BUILD_URL}")
		}
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example, if the Pipeline was previously failing but is now successful'
		}
	}
}
*/
