var route = require('./route.js');
var app = route(3412);

app.interceptor(function(request,response,next){
	response.setHeader('Access-Control-Allow-Origin','*');
	response.setHeader('Access-Control-Allow-Headers','Content-Type');
	next();
});

app.interceptor(function(request,response,next){
	response.setHeader('Content-Type','application/json;charset=utf-8');
	next();
});


app.options('/Consultar',function(request,response){response.end()});
app.post('/Consultar',function(request,response){ 
	try {
     const application = require("../../3. Application/ContaApplication.js");
     application.Consultar(request.body,function(status){
     response.write(JSON.stringify({Status: status}));
	 response.end();
	});
	} catch(e) {
	  console.log(e);
	  response.end();
	} 

});


app.post('/Transferir',function(request,response){
	try {
     const application = require("../../3. Application/ContaApplication.js");
     application.Transferir(request.body,function(status){
     console.log(status);
     response.write(JSON.stringify({Status: status}));
	 response.end();
	});
	} catch(e) {
	  console.log(e);
	  response.end();
	} 
});

app.options('/Transferir',function(request,response){
   response.end();
});


app.post('/ConsultarSaldo',function(request,response){try {
     const application = require("../../3. Application/ContaApplication.js");
     application.ConsultarSaldo(request.body,function(valor){
     response.write(JSON.stringify({Valor: valor}));
	 response.end();
	});
	} catch(e) {
	  console.log(e);
	  response.end();
	} 
});

app.options('/ConsultarSaldo',function(request,response){
   response.end();
});
