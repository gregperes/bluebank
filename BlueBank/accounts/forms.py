from django import forms
from localflavor.br.forms import BRCPFField

from accounts.models import Account, Agency


class TransferenciaForm(forms.Form):
    cpf1 = forms.CharField(required=True)
    account_number1 = forms.CharField(required=True)
    agency_code1 = forms.IntegerField(required=True)

    cpf2 = forms.CharField(required=True)
    account_number2 = forms.CharField(required=True)
    agency_code2 = forms.IntegerField(required=True)

    value = forms.FloatField(required=True)

    def is_valid(self):
        valid = True

        # Adiciona erros padrão, campo number com string ou algo do genero.

        if not super(TransferenciaForm, self).is_valid():
            self.adiciona_erro('Por favor, verifique os dados informados')
            valid = False

        # Verifica se existe conta com tais parametros.

        account1_exists = Account.objects.filter(CPF=self.cleaned_data['cpf1'],
                                                 account_number=self.cleaned_data['account_number1'],
                                                 agency__agency_code=self.cleaned_data['agency_code1']).exists()

        account2_exists = Account.objects.filter(CPF=self.cleaned_data['cpf2'],
                                                 account_number=self.cleaned_data['account_number2'],
                                                 agency__agency_code=self.cleaned_data['agency_code2']).exists()

        # Se não existir adiciona erro no formulario.

        if not account1_exists:
            self.adiciona_erro('Dados da conta de origem incorretos')

        if not account2_exists:
            self.adiciona_erro('Dados da conta de destino incorretos')

        # Se for a mesma conta
        if self.cleaned_data['account_number1'] == self.cleaned_data['account_number2'] or self.cleaned_data['cpf1'] == \
                self.cleaned_data['cpf2']:
            self.adiciona_erro("Existem dados repetidos nos formularios!")
            valid = False

        # Se valor é menor/igual que 0
        if self.cleaned_data['value'] <= 0:
            self.adiciona_erro("Impossivel transferir valores negativos ou nulos!")
            valid = False

        return valid

    def adiciona_erro(self, mensagem):
        errors = self._errors.setdefault(forms.forms.NON_FIELD_ERRORS, forms.utils.ErrorList())
        errors.append(mensagem)


class AccountForm(forms.ModelForm):
    class Meta:
        model = Account
        fields = ["CPF", "account_number", "agency"]

        labels = {
            'account_number': 'Numero da Conta',
            'agency': 'Agencia'
        }

        error_messages = {
            'CPF': {
                'unique': 'CPF já cadastrado',
            },
            'account_number': {
                'unique': 'Numero de conta já existe'
            }
        }

        agency = forms.ModelChoiceField(required=True, queryset=Agency.objects.all(), empty_label=None)
        cpf = forms.CharField(required=True, error_messages={'unique': 'message'})
        account_number = forms.CharField(required=True)

        # cpf = BRCPFField

        widgets = {
            'CPF': forms.TextInput(attrs={'class': "form-control", 'placeholder': 'xxx.xxx.xxx-xx'}),
            'account_number': forms.TextInput(attrs={'class': "form-control", 'placeholder': 'xxxxxxxx-x'}),
            'agency': forms.Select(attrs={'class': 'form-control'}),

        }

    def is_valid(self):

        valid = True

        if not super(AccountForm, self).is_valid():
            return False

        # Tentei usar BRCPFField mas nao consegui e fiz minha propria validação de cpf

        if not self.is_valid_cpf():
            self.adiciona_erro("CPF inválido")
            valid = False

        # Validar numero da conta

        if not self.is_valid_account_number():
            self.adiciona_erro("Numero de conta inválido")
            valid = False

        return valid

    def is_valid_cpf(self):
        cpf = self.cleaned_data['CPF']

        if len(cpf) != 14:
            return False

        if cpf[3] != '.' or cpf[7] != '.':
            return False

        if cpf[11] != '-':
            return False

        # Faço esses tratamentos pq pode ser que venha uma string em um local que eu não esteja monitorando

        for i in range(len(cpf)):
            try:
                int(cpf[i])
            except ValueError:
                if i != 3 and i != 7 and i != 11:
                    return False
        return True

    def is_valid_account_number(self):
        account_number = self.cleaned_data['account_number']

        if len(account_number) != 10:
            return False

        if account_number[8] != '-':
            return False

        # Faço esses tratamentos pq pode ser que venha uma string em um local que eu não esteja monitorando
        for i in range(len(account_number)):
            try:
                int(account_number[i])
            except ValueError:
                if i != 8:
                    return False

        return True

    def adiciona_erro(self, mensagem):
        errors = self._errors.setdefault(forms.forms.NON_FIELD_ERRORS, forms.utils.ErrorList())
        errors.append(mensagem)
