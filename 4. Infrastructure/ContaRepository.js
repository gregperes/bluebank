/*
this.Inserir = function Inserir(conta){ // Retrieve

 // Connect to the db
 MongoClient.connect("mongodb://localhost:27017/Bluebank", function(err, db) {
  if(err) { return console.log("deu ruim"); }


  var collection = db.collection('Conta');

  var doc1 = {'hello':'doc1'};

  collection.insert(doc1);
 });
}
*/

this.Consultar = function Consultar(conta,db,callback)
{  
	  var objConta = JSON.parse(conta);
	  var collection = db.collection('Conta');
	  collection.findOne({Agencia: objConta.Agencia,Conta: objConta.Conta},function(err,data){ 
	    callback(err,data);
	  });
}  

//Atualizar saldo deve incrementar valor a conta informada
this.AtualizarValor = function AtualizarValor(objInfo,increase,db,callback){

	  var nValor = increase?(+objInfo.Valor):(-objInfo.Valor);
	  var collection = db.collection('Conta');
	  collection.update({Agencia: objInfo.Agencia,Conta: objInfo.Conta}, {$inc: { Valor: nValor } }, function(err){
       callback(err);
	  });      
      
}

