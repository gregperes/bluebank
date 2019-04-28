from django.shortcuts import render, redirect

from django.contrib import messages

# Create your views here.
from accounts.forms import TransferenciaForm, AccountForm
from accounts.models import Account, Agency


def index(request):
    if request.method == 'POST':

        # Pega o formulario com os dados
        form_transferir = TransferenciaForm(request.POST)

        # Válida
        if form_transferir.is_valid():
            dados_form = form_transferir.cleaned_data

            try:
                make_transfer(request, dados_form)


                messages.success(request, "Transferencia concluida com sucesso!")

                return redirect('index')

            except ValueError as value:
                form_transferir.adiciona_erro(
                    "Você não tem %s em sua conta! (Seu saldo é %s)" % (str(dados_form['value']), str(value)))

        # Caso o formulario tenha erros ele manda com o erro
        return render(request, "index.html", {'form': form_transferir})

    # Metodo GET retorna o formulario limpo
    return render(request, "index.html")



def create_account(request):

    if request.method == 'POST':
        # Pega o formulario com os dados
        form_account = AccountForm(request.POST)

        # Válida
        if form_account.is_valid():

            # Pega os dados já validados

            dados_form = form_account.cleaned_data

            # Cria conta
            make_account(request, dados_form)

            messages.success(request, "Conta criada com sucesso!")

            return redirect('create_account')

        # Caso o formulario tenha erros ele manda com o erro
        return render(request, "create_account.html", {'form': form_account})

    # Metodo GET retorna o formulario limpo
    return render(request, "create_account.html", {'form': AccountForm()})


# Inicio da configuração da home alternativa

def index2(request):
    if request.method == 'POST':
        form_transferir = TransferenciaForm(request.POST)

        if form_transferir.is_valid():
            dados_form = form_transferir.cleaned_data

            try:
                make_transfer(request, dados_form)


                messages.success(request, "Transferencia concluida com sucesso!")

                return redirect('index2')

            except ValueError as value:
                form_transferir.adiciona_erro(
                    "Você não tem %s em sua conta! (Seu saldo é %s)" % (str(dados_form['value']), str(value)))


        return render(request, "index2.html", {'form': form_transferir})

    return render(request, "index2.html")




# Fim da configuração da home alternativa


def make_transfer(request, dados_form):

    # Pega as contas de acordo com os dados do formulario
    # Sem tratamento aqui porque o formulario já tem um "is.valid() -> dentro de forms.py"

    account1 = Account.objects.get(CPF=dados_form['cpf1'])
    account2 = Account.objects.get(CPF=dados_form['cpf2'])
    account1.transfer(account2, dados_form['value'])



def make_account(request, dados_form):

    # Cria uma conta nova

    Account.objects.create(CPF=dados_form['CPF'],
                           account_number=dados_form['account_number'],
                           agency=dados_form['agency'])