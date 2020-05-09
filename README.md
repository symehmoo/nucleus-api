# nucleus-api
BaseURL: http://localhost:8081

Lob API URL: http://localhost:8081/nucleus/lob
Mnemonic API URL: http://localhost:8081/nucleus/mnemonic 
				  http://localhost:8081/nucleus/mnemonic?lobName=lob1
App Components URL: http://localhost:8081/nucleus/appcomponents
					http://localhost:8081/nucleus/appcomponents?mnemonicsName=M1
Test Config URL: create - http://localhost:8081/nucleus/test/create
						  request body: {
											"testName":"sa2",
											"scriptName":"test2",
											"gitRepoName":"test3",
											"appComponentName":"appcomponent1",
											"gitRepoURL":"test5",
											"env":"test6",
											"userid_users":"test7"
										}
				 search - http://localhost:8081/nucleus/test/search
						  http://localhost:8081/nucleus/test/search?appComponentsName=A12&mnemonicsName=M2&lobName=testing
						  
Running a test: POST request
http://localhost:8081/nucleus/test/run 
body 	{
	 		"testName":"testing1"
		}

Test Execution list:
http://localhost:8081/nucleus/testExecution
http://localhost:8081/nucleus/testExecution?testName=testing1

Swagger UI URL: http://localhost:8081/nucleus/swagger-ui.html 