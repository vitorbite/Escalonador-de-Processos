# Escalonar de Processos

Este projeto implementa um escalonador de processos utilizando uma lista encadeada simples como estrutura de dados principal. 
objetivo é simular o gerenciamento de processos em diferentes filas de prioridade, 
aplicando regras de anti-inanição e controle de bloqueio por recursos (ex.: DISCO).

##🚀 Funcionalidades

Adicionar e remover processos.
Escalonamento baseado em filas de prioridade (alta, média e baixa).
Regra de anti-inanição para evitar starvation.
Manipulação de processos bloqueados (ex.: solicitação do recurso DISCO).
Impressão do estado atual das filas.
Leitura de processos a partir de arquivo de entrada.

##⚙️ Estrutura de Dados

A estrutura escolhida foi a lista encadeada simples, por permitir inserções e remoções em tempo constante O(1) e pela simplicidade de implementação. 
Apesar da limitação de buscas em O(n), mostrou-se adequada ao problema, garantindo eficiência nas operações básicas do escalonador.

##💾 Como executar 



