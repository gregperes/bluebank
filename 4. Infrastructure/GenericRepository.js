
this.AbrirConexao = function AbrirConexao(callback){
	var MongoClient = require('mongodb').MongoClient;
  	//Conecta ao DB
	MongoClient.connect("mongodb://localhost:27017/Bluebank", function(err, db) {
    if(err) { return console.log("Não foi possivel conectar ao DB."); } 
	    callback(err,db);
	});
}

this.FecharConexao = function FecharConexao(db){
	db.close();
}
