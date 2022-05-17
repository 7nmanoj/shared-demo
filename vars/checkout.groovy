def call(Map pipelineParams) {
  
    pipeline {
        agent any
        stages {
            stage ('Checkout') {
                steps {
                      println "Approval."    

                      checkout([$class: 'GitSCM',
                                        branch: 'master',
                                        url: pipelineParams.url])
                      println "Success"
                        
                }
            }
        }
    }
}
