# nucleus-api
BaseURL: http://localhost:8081

Lob API URL: http://localhost:8081/nucleus/lob
Mnemonic API URL: http://localhost:8081/nucleus/mnemonic 
				  http://localhost:8081/nucleus/mnemonic?lobName=lob1
App Components URL: http://localhost:8081/nucleus/appcomponents
					http://localhost:8081/nucleus/appcomponents?mnemonicsName=M1
Test Config URL: create - http://localhost:8081/nucleus/testConfig/create
						  request body: {
											"testName":"sa2",
											"scriptName":"test2",
											"gitRepoName":"test3",
											"appComponentName":"appcomponent1",
											"gitRepoURL":"test5",
											"env":"test6",
											"userid_users":"test7"
										}
				 search - http://localhost:8081/nucleus/testConfig/search
						  http://localhost:8081/nucleus/testConfig/search?appComponentsName=A12&mnemonicsName=M2&lobName=testing

Swagger UI URL: http://localhost:8081/nucleus/swagger-ui.html 