job('ejemplo-Nuevo-job-DSL') {
  description('Job DSL de ejemplo para el curso de Jenkins Veronica Tapia')
  scm {
    git('https://github.com/verot500/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('verot500')
      node / gitConfigEmail('verot500@yahoo.es')
    }
  }
  parameters {
   		stringParam('nombre', defaultValue = 'Veronica', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  triggers {
    		cron('H/6 * * * *')
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}
}
