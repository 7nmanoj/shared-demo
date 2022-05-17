def call(Map stageParams) {
   pipeline {
        agent any
        stages {
            stage('Git Checkout') {
                steps {
                checkout(
                    branch: "main",
                    url: "https://github.com/7nmanoj/shared-demo.git"
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
