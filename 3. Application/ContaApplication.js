const genericRepository = require("../4. Infrastructure/GenericRepository.js");
const repository = require("../4. Infrastructure/ContaRepository.js");

 var ErroEnum = function(code){
      switch(code){
       case 0:
        return 'Ouve um erro ao realizar a operação,tente novamente mais tarde.';
       case 1:
        return 'Transferencia realizada com sucesso.';
       case -1:
        return 'Não há saldo suficiente';
       case 2:
        return 'Conta/Agencia inexistente.'
      }
  };

this.Consultar = function Consultar(conta,callback){
	genericRepository.AbrirConexao(function(err,db){
 	 repository.Consultar(conta,db,function(err,data) { 
 	 	genericRepository.FecharConexao(db); 
 	 	callback(!!data); 
 	 } );
	});
}

this.Transferir = function Transferir(info,callback){
	var objInfo = JSON.parse(info);	

	genericRepository.AbrirConexao(function(err,db){
 	repository.Consultar(JSON.stringify({Conta: objInfo.mConta,Agencia:objInfo.mAgencia}),db,function(err,data){
		
  	  	if(parseFloat(data.Valor) >= parseFloat(objInfo.Valor)){
	  	     var collection = db.collection('Conta');

	  	     repository.AtualizarValor({Agencia: objInfo.mAgencia,Conta: objInfo.mConta,Valor: objInfo.Valor},false,db,function(nMod){
	  	      if(nMod==null){
		  	     repository.AtualizarValor({Agencia: objInfo.rAgencia,Conta: objInfo.rConta,Valor: objInfo.Valor},true,db,function(nsMod){
	  	   	
		  	      if(nsMod==null){
		  	       callback(ErroEnum(1));      	
		  	      }
		  	      else{
		  	  	   callback(ErroEnum(0));
		  	      }
	  			  genericRepository.FecharConexao(db); 
		  	     });
		  	  }
		  	  else {
		  	    callback(ErroEnum(0));
		  	  }
		  	  
	  	    });
	  	}
	  	else{
     	 callback(ErroEnum(-1));
	  	}
	});
	});
}
   

this.Sacar = function Sacar(info,callback){
	var objInfo = JSON.parse(info);	

	genericRepository.AbrirConexao(function(err,db){
 	repository.Consultar(JSON.stringify({Conta: objInfo.mConta,Agencia:objInfo.mAgencia}),db,function(err,data){
		
  	  	if(parseFloat(data.Valor) >= parseFloat(objInfo.Valor)){
	  	     var collection = db.collection('Conta');

	  	     repository.AtualizarValor({Agencia: objInfo.mAgencia,Conta: objInfo.mConta,Valor: objInfo.Valor},false,db,function(){
		  	     callback(true);      	
	  	    });
	  	}
	  	else{
	  		callback(false);
	  	}
	  	genericRepository.FecharConexao(db); 
	});
	});
}


this.ConsultarSaldo = function Consultar(conta,callback){
	genericRepository.AbrirConexao(function(err,db){
	 repository.Consultar(conta,db,function(err,data) { 
	 	console.log(err);
	    if(err==null){
	     if(data!=null){
	      callback(data.Valor); 	
	 	 }
	 	 else{
	 	  callback(ErroEnum(2));
	 	 }
	    }
	    else{
	     callback(ErroEnum(0));
	    }
	 	genericRepository.FecharConexao(db); 
	 	
	 });
	});
}
