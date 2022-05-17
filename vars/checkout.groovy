def call(body) {
  call([:], body)
}

def call(pipelineParams, body) {
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    
    pipeline {
        agent any
        stages {
            stage ('Checkout') {
                steps {
                  script{
                        println "Approval."    

                        checkout changelog: true,
                                poll: true,
                                scm: [$class: 'GitSCM',                                        
                                        doGenerateSubmoduleConfigurations: false,                                       
                                        submoduleCfg: [],
                                        userRemoteConfigs: [[branch: pipilineParams.branch, url: pipelineParams.url]]
                                ]
                  }
                }
            }
        }
    }
}
