
    angular.module("contaApp").controller("ExtratoCtrl",function($scope,$http) {

    $scope.Saldo = 0;

    $scope.consultarSaldo = function(Info){
      $http.post("http://localhost:3412/ConsultarSaldo", Info ).then( 
        function (response) { 
           $scope.Saldo = response.data.Valor;
        });
    }

    });//Fecha Controller
