package estruturas;
//Pedro Henrique de Oliveira Silveira ;)

import java.io.*;
import java.util.*;

public class App {

    //  configurar o caminho do arquivo de entrada
    private static final String ENTRADA_PATH = "entrada.txt";
    private static final String SAIDA_DIR = "dados";

    public void rodarAplicacao() {
        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();
        List<Integer> chaves = new ArrayList<>();
        int chaveBuscada;

        // le o arquivo de entrada e trata possiveis erros de formato
        try (BufferedReader br = new BufferedReader(new FileReader(ENTRADA_PATH))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    try {
                        chaves.add(Integer.parseInt(linha));
                    } catch (NumberFormatException e) {
                        System.err.println("Linha ignorada (não numerica): " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        if (chaves.isEmpty()) {
            System.err.println("Arquivo de entrada vazio ou invalido.");
            return;
        }

        // ultima chave e a de busca
        chaveBuscada = chaves.remove(chaves.size() - 1);

        // coloca as chaves na árvore
        for (Integer chave : chaves) {
            arvore.adicionar(chave);
        }

        // garante que o diretorio de saida existe
        File dirSaida = new File(SAIDA_DIR);
        if (!dirSaida.exists()) dirSaida.mkdirs();

        // grava os caminhamentos
        gravarArquivo(SAIDA_DIR + "/preordem.txt", arvore.preordem());
        gravarArquivo(SAIDA_DIR + "/posordem.txt", arvore.posordem());
        gravarArquivo(SAIDA_DIR + "/central.txt", arvore.emordem());
        gravarArquivo(SAIDA_DIR + "/largura.txt", arvore.largura());

        // realiza a busca e grava o resultado
        ArvoreBinariaPesquisa.BuscaResultado resultado = arvore.buscar(chaveBuscada);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SAIDA_DIR + "/resultado.txt"))) {
            for (Integer no : resultado.getCaminho()) {
                bw.write(no.toString());
                bw.newLine();
            }
            bw.write("Quantidade de visitados: " + resultado.getVisitados());
            bw.newLine();
            bw.write(resultado.isAchou() ? "Valor encontrado!" : "Nao Achou.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo de resultado: " + e.getMessage());
        }
    }

    // netodo generico para gravar listas em arquivos
    private void gravarArquivo(String nome, List<Integer> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nome))) {
            for (Integer item : lista) {
                bw.write(item.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo " + nome + ": " + e.getMessage());
        }
    }
}