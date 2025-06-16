# Trabalho 2 - Alest 1
Trabalho 2 - Alest 1
Descrição
Este projeto implementa uma Árvore Binária de Pesquisa em Java, com métodos para inserção, caminhamentos (pré-ordem, pós-ordem, central e por largura) e busca de chaves.
A aplicação lê um arquivo de entrada com valores inteiros, constrói a árvore, executa os caminhamentos e realiza a busca de uma chave, gerando arquivos de saída conforme especificado.


Estrutura do Projeto
src/estruturas/ArvoreBinariaPesquisa.java: Implementação da árvore binária de pesquisa e seus métodos.
src/estruturas/App.java: Lê o arquivo de entrada, executa a lógica principal e gera os arquivos de saída.
src/estruturas/Main.java: Classe principal para execução da aplicação.
entrada.txt: Arquivo de entrada com os valores inteiros (um por linha, a última linha é a chave de busca).
dados/: Diretório gerado com os arquivos de saída.
Funcionamento
Leitura do arquivo de entrada
O arquivo entrada.txt deve conter, em cada linha, um número inteiro.


As primeiras linhas são as chaves a serem inseridas na árvore.
A última linha é a chave a ser pesquisada. 
Construção da árvore
As chaves são inseridas na ordem em que aparecem no arquivo.


Caminhamentos
São gerados arquivos .txt com os resultados dos seguintes caminhamentos:


preordem.txt: Pré-ordem
posordem.txt: Pós-ordem
central.txt: Em ordem (central)
largura.txt: Por largura (níveis)
Busca
A chave da última linha é pesquisada na árvore.
O arquivo resultado.txt contém:


O caminho percorrido na busca (chaves visitadas, uma por linha)
A quantidade de nós visitados
Mensagem indicando se encontrou ou não a chave
Como Executar
Preparar o arquivo de entrada
Crie um arquivo chamado entrada.txt no diretório do projeto, exemplo:


10
5
15
3
7
12
18
7
(Neste exemplo, a chave a ser buscada é 7)


Compilar o projeto
Compile os arquivos Java:


javac src/estruturas/*.java
Executar a aplicação
Execute a classe principal:


java -cp src estruturas.Main
Verificar os resultados
Os arquivos de saída serão gerados no diretório dados/:


preordem.txt
posordem.txt
central.txt
largura.txt
resultado.txt
Critérios de Avaliação
Leitura correta do arquivo de entrada
Implementação dos quatro tipos de caminhamento
Pesquisa correta da chave
Geração dos arquivos de saída conforme especificado
Qualidade e clareza do código
Documentação adequada
Observações
O projeto não utiliza bibliotecas externas.
O diretório dados/ será criado automaticamente se não existir.
Em caso de erro no arquivo de entrada, mensagens de erro serão exibidas no console.
Autor
Pedro Henrique de Oliveira Silveira<hr></hr>
