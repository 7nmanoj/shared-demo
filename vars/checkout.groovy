def call(Map pipelineParams) {
  
    pipeline {
        agent any
        stages {
            stage ('Checkout') {
                steps {
                      println "Approval."    

                      checkout[$class: 'GitSCM',
                                        branches: [[name: 'master']],
                                        url: pipelineParams.url]
                      println "Success"
                        
                }
            }
        }
    }
}
