@Library('stratusjenkins-sharedlibrary') _
import com.albertsons.stratus.jenkins.MsgLogger

generalPurposePipeline(
[
	buildNode: 'digital-automation',
	jobParameters:
    [
    	choice(
                choices: 'parallel\ndistribute', 
                description: "Select test type", 
                name: 'TEST_TYPE',
                defaultValue: 'parallel'
        ),
    	choice(
                choices: 'android\oneplus',
                description: "Select device", 
                name: 'DEVICE',
                defaultValue: 'oneplus'
        ),
        choice(
            	choices: 'albertsons\ntomthumb\nsafeway', 
            	description: "Select banner", 
            	name: 'BANNER',
            	defaultValue: 'albertsons'
        ),
        choice(
            	choices: 'qa1\nqa2\nprod', 
            	description: "Select environment", 
            	name: 'ENVIRONMENT',
            	defaultValue: 'qa2'
        ),
        string(
        		name: 'CUCUMBER_OPTIONS', 
        		defaultValue: 'src/test/resources/Mobile/features'
        )
    ]
]) {

    addStage('show-name','yml-master:any') {
        MsgLogger.info([
            category: 'read-config',
            details: "name from configuration file ${env.CONFIG_NAME}"
        ],this)
    }

    addStage('check-out-app-code','yml-master:any') {
        sh "ls -al"
    }
    
    addStage('build', 'yml-master:any'){
        sh "mvn clean install -DskipTests"
    }
    
    addStage('execute', 'yml-master:any'){
        sh """
        	mvn test \
        	-Dtest=MobileRunner \
        	-Dcucumber.options=${env.CUCUMBER_OPTIONS}
        """
    }
}
