def call(Map stageParams) {
   pipeline {
        agent any
        stages {
            stage('Git Checkout') {
                steps {
                checkout(
                    branch: "main",
                    url: stageParams.url
                )
                }
            }
        }
   }
}
 
   
    
    
    
    

//     checkout([
//         $class: 'GitSCM',
//         branches: [[name:  stageParams.branch ]],
//         userRemoteConfigs: [[ url: stageParams.url ]]
//     ])
//   }
