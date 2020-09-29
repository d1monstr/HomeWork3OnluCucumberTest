pipeline{
    agent any
    stages{
        stage('Git'){
            steps{
                git branch: '${BRANCH}', url: 'https://github.com/d1monstr/HomeWork3OnlyCucumberTest'
            }
        }
        stage('Run Tests'){
            steps{
                withMaven(maven: 'mvn_3.6.3') {
                    bat "mvn clean test -Dcucumber.filter.tags=${TAGS}"
                }
            }
        }
        stage('Allure Report Generation'){
            steps{
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/reports/allure-results']]
            }
        }
    }
    post {
        always {
            cleanWs notFailBuild: true
        }
    }
}