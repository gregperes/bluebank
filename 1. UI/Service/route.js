const http = require('http');
const QString = require('querystring');

var criarRoteamento = function (porta){
  var rotas  = {};
  var api = {};
  var interceptors = [];
  var metodos = ['GET','POST','OPTIONS'];

  metodos.forEach( function(element) {
  	rotas[element] = {};
  	api[element.toLowerCase()] = function(path,fn){
  		rotas[element][path] = fn;
  	};
  });

  api.interceptor = function(interceptor){
  	interceptors.push(interceptor);
  };

  var executeInterceptors = function(number,request,response){
    var interceptor = interceptors[number];
    if(!interceptor) return;
    interceptor(request,response,function(){
    executeInterceptors(++number,request,response);
    });
 };

  var handleBody = function(request,response,next){
  	 var body = [];
  	 request.on('data',function(chunk){
        body.push(chunk);
  	 });
  	 request.on('end',function(){
        request.body = Buffer.concat(body).toString();
        next();
  	 });
  };

  http.createServer(function(request,response){
  	handleBody(request,response,function(){
  		executeInterceptors(0,request,response);
		if(!rotas[request.method][request.url]){
	 	  response.statusCode = 404;
		  return response.end();	
		} 
		rotas[request.method][request.url](request,response);	
		console.log("Requisição efetuada em "+ request.url + " " + request.body + " no metodo " + request.method);
	});
  }).listen(porta);
  console.log("Roteamento inicializado.");
  return api;
};

module.exports = criarRoteamento;
