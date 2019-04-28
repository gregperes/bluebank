from django.test import TestCase
from django.urls import reverse
import unittest
from accounts.models import *
from accounts.forms import *

# models test
class AgencyTest(TestCase):

    def create_agency(self, name_agency="Presidente Kennedy", agency_code=9999):
        return Agency.objects.create(name_agency=name_agency, agency_code=agency_code)

    def test_agency_creation(self):
        a = self.create_agency()
        self.assertTrue(isinstance(a, Agency))
        self.assertEqual(a.__str__(), a.name_agency)

class AccountTest(TestCase):

    def create_agency(self, name_agency="Presidente Kennedy", agency_code=9999):
        return Agency.objects.create(name_agency=name_agency, agency_code=agency_code)

    def create_account(self, CPF='999.999.999-99', account_number='99999999-9'):
        return Account.objects.create(CPF=CPF,agency=self.create_agency(),account_number=account_number)

    def test_account_creation(self):
        a = self.create_account()
        self.assertTrue(isinstance(a, Account))
        self.assertEqual(a.__str__(), a.CPF)

