# Projeto

O projeto foi baseado na UML representada em: _contaCorrentista.pdf_

## 1ª Camada
Na 1ª Camada com 1 Classe Abstrata(Conta) e 3 Classes Normais(ContaCorrente, ContaPoupança e Correntista).

A classe _Conta_ foi criada como Modelo para que seus atributos e métodos fossem herdados nas classes implementáveis _ContaCorrente_ e _ContaPoupança_

Essass Classes implementáveis servem de referência para os métodos e atributos das classes presentes na 2ª Camada

## 2ª Camada

Na 2ª Camada temos 3 tipos de classe:

1. Fabrica de Repositório(FábricaRepositorio)
  * Tem como objetivo criar objetos do tipo repositórioCorrentista e repositorioConta.
2. Repositórios(Conta e Correntista)
  * Isolam os atributos dos Objetos no Banco de Dados
3. Mediador(Conta e Correntista)
  * Facilita a comunicação de diversas classes dentro do programa.

## 3ª Camada

Na 3ª Camada tem função de mostrar a tela principal do sistema. Nesta camada se encontra a main
