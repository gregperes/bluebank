<?php
abstract class Transacao
{
    // Apenas define os parametros obrigatórios para realizar qualquer transação
    // http://php.net/manual/en/language.oop5.abstract.php
    abstract protected function dados($id, $CPF, $conta, $agencia, $valor);

}