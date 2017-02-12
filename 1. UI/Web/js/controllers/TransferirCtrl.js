 angular.module("contaApp").controller("TransferirCtrl",function($scope,$http) {

    $scope.statusMinhaConta = true;
    $scope.statusContaTransferencia = true;

     var validarConta =  function(Conta,callback){
       $http.post("http://localhost:3412/Consultar",Conta).then( function (response) { 
           callback(response.data.Status);
        });
     }

     $scope.transferirConta =  function(Info){
        validarConta({Conta: Info.mConta,Agencia: Info.mAgencia},function(first_status) { 
          $scope.statusMinhaConta = first_status;
            validarConta({Conta: Info.rConta,Agencia: Info.rAgencia},function(second_status){
              $scope.statusContaTransferencia = second_status;
              if(second_status && first_status){
                $http.post("http://localhost:3412/Transferir",Info).then( function (response) { 
                  var mensagem = response.data.Status;/* ? 'Transferência realizada com sucesso.' : 'Houve um problema na transferência,verifique seu saldo ou tente novamente mais tarde'; */
                  $('#mdlAlerta .modal-body').html(mensagem);
                  $('#mdlAlerta').modal('show');
                });
              }
            });
        });
    };
    });