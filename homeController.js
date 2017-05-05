app.controller("homeController", function ($scope) {

function validaAcesso(user)
{
	if(user.id != "" && user.cpf != "" && user.conta != "" && user.agencia != "")
	{
		location.href="#minhaconta";
	}

}

});