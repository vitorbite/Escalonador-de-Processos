# Escalonador de Processos - iCEVOS
**Disciplina**: Algoritmos e Estrutura de Dados\
**Professor**: Dimmy Magalhães.

**Integrantes:**  
- Vítor Bitencourt de Andrade.
- Yan Magnum.
- Arthur Brito Carvalho.

Este projeto implementa um escalonador de processos utilizando uma lista encadeada simples como estrutura de dados principal. 
objetivo é simular o gerenciamento de processos em diferentes filas de prioridade, 
aplicando regras de anti-inanição e controle de bloqueio por recursos (ex.: DISCO).

## 🚀 Funcionalidades

- Adicionar e remover processos.
- Escalonamento baseado em filas de prioridade (alta, média e baixa).
- Regra de anti-inanição para evitar starvation.
- Manipulação de processos bloqueados (ex.: solicitação do recurso DISCO).
- Impressão do estado atual das filas.
- Leitura de processos a partir de arquivo de entrada.

## ⚙️ Estrutura de Dados

A estrutura escolhida foi a lista encadeada simples, por permitir inserções e remoções em tempo constante O(1) e pela simplicidade de implementação. 
Apesar da limitação de buscas em O(n), mostrou-se adequada ao problema, garantindo eficiência nas operações básicas do escalonador.

## 📁 Arquivos
```
EscalonadorDeProcessos
├─ src/
│  ├─ LerArquivo.java
│  ├─ ListaDeProcessos.java
│  ├─ Main.java
│  ├─ Processo.java
│  └─ Scheduler.java
├─ processo.txt  
├─ README.md
└─ Relatório do Escalonador de Processos.pdf
```

## 🖥️ Requisitos Mínimos
Para executar o projeto do escalonador de processos em Java, é necessário que o ambiente atenda aos seguintes requisitos:

✅ Sistema Operacional
Windows 10 ou superior

macOS 10.13 (High Sierra) ou superior

Distribuições Linux modernas (Ubuntu 18.04+, Fedora, etc.)

✅ Java
Java Development Kit (JDK) versão 11 ou superior

Recomendado: JDK 17 (versão LTS mais estável)

✅ Memória RAM
Mínimo: 2 GB

Recomendado: 4 GB ou mais

✅ IDE (opcional, mas recomendada)
IntelliJ IDEA

Eclipse

NetBeans

VS Code com extensão Java

✅ Editor de Texto
Qualquer editor que permita editar arquivos .txt (como Notepad, VS Code, Sublime Text)

✅ Terminal ou Prompt de Comando
Para compilar e executar o código manualmente, caso não use uma IDE
## 💾 Como executar 
### 1. 
Instalar o Java
Antes de rodar o projeto, é necessário ter o Java instalado em sua máquina.

🔧 Passos para instalar o Java:
Acesse o site oficial: https://www.oracle.com/java/technologies/javase-downloads.html

Baixe o JDK (Java Development Kit) mais recente para seu sistema operacional (Windows, macOS ou Linux)

Instale o JDK seguindo as instruções do instalador

Verifique se o Java foi instalado corretamente abrindo o terminal ou prompt de comando e digitando:
```
java -version
```
### 2.
1. Instale o arquivo .zip do repositorio 

2. extraia ele em sua máquina 

3. abra a pasta do projeto em uma IDE

4. crie um arquivo .txt chamado "processo.txt" na raiz do Projeto, onde está o README e o Relatório em pdf

5. adicione processos 

6. Execute o codigo
---
🧑‍💻 Executando o Projeto via Terminal (sem IDE)
1. Abra o terminal ou prompt de comando
Navegue até a pasta onde estão os arquivos .java do projeto. Exemplo:

```bash
cd C:\Users\SeuUsuario\Documentos\EscalonadorDeProcessos
```
2. Compile os arquivos .java
Use o comando abaixo para compilar todos os arquivos:

```bash
javac *.java
```
Isso vai gerar os arquivos .class (bytecode) para cada classe.

3. Execute o programa
Depois de compilado, rode o programa usando a classe principal (Main):

```bash
java Main
```
---
## ➕ Como adicionar mais processos 
Abra o arquivo .txt chamado "processo.txt" que está dentro da pasta junto com os arquivos do codigo

Cada linha é um processo e cada caracteristica do processo é dividido por virgula.

- ID, "Nome do Processo", Prioridade, Número de Ciclos, "Recurso"


O algoritmo identifica o que cada atributo é, então não precisa por o nome de cada atributo
basta colocar como esta no exemplo a seguir:


**Exemplos:**
```txt
1, "Acordar", 1, 8, "DisCo"
2, "Imprimir", 3, 5, "" 
```
- O campo **Recurso** pode ser vazio (`""`) se o processo não precisar de nenhum recurso.  
- O algoritmo identifica automaticamente os atributos, então não é necessário nomeá-los.



