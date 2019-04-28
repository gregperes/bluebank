from django.db import models


# id é criado automaticamente

class Agency(models.Model):
    name_agency = models.CharField(max_length=128)
    agency_code = models.IntegerField(unique=True)

    def __str__(self):
        return self.name_agency


class Account(models.Model):
    CPF = models.CharField(max_length=128, unique=True)
    balance = models.FloatField(default=650)
    account_number = models.CharField(max_length=128, unique=True)
    agency = models.ForeignKey(Agency, on_delete=models.CASCADE, related_name="accounts")

    def transfer(self, account, value):

        if (self.balance - value < 0):
            raise ValueError(str(self.balance))

        account.credit(value)
        self.debit(value)

    def debit(self, value):
        self.balance = self.balance - value
        self.save()


    def credit(self, value):
        self.balance = self.balance + value
        self.save()

    @property
    def agency_code(self):
        return self.agency.agency_code

    def __str__(self):
        return self.CPF