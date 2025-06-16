package estruturas;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class ArvoreBinariaPesquisa {
    private class Nodo {
        private int chave;
        private Nodo esquerda;
        private Nodo direita;
        private Nodo pai;

        public Nodo(int chave) {
            this.chave = chave;
        }
    }

    private Nodo raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public void adicionar(int chave) {
        Nodo n = new Nodo(chave);
        if (raiz == null) {
            raiz = n;
        } else {
            adicionarRecursivo(n, raiz);
        }
        tamanho++;
    }

    private void adicionarRecursivo(Nodo n, Nodo pai) {
        if (n.chave <= pai.chave) {
            if (pai.esquerda == null) {
                pai.esquerda = n;
                n.pai = pai;
            } else {
                adicionarRecursivo(n, pai.esquerda);
            }
        } else {
            if (pai.direita == null) {
                pai.direita = n;
                n.pai = pai;
            } else {
                adicionarRecursivo(n, pai.direita);
            }
        }
    }

    public List<Integer> preordem() {
        List<Integer> lista = new ArrayList<>();
        preordem(raiz, lista);
        return lista;
    }

    private void preordem(Nodo n, List<Integer> lista) {
        if (n == null) return;
        lista.add(n.chave);
        preordem(n.esquerda, lista);
        preordem(n.direita, lista);
    }

    public List<Integer> posordem() {
        List<Integer> lista = new ArrayList<>();
        posordem(raiz, lista);
        return lista;
    }

    private void posordem(Nodo n, List<Integer> lista) {
        if (n == null) return;
        posordem(n.esquerda, lista);
        posordem(n.direita, lista);
        lista.add(n.chave);
    }

    public List<Integer> emordem() {
        List<Integer> lista = new ArrayList<>();
        emordem(raiz, lista);
        return lista;
    }

    private void emordem(Nodo n, List<Integer> lista) {
        if (n == null) return;
        emordem(n.esquerda, lista);
        lista.add(n.chave);
        emordem(n.direita, lista);
    }

    public List<Integer> largura() {
        List<Integer> lista = new ArrayList<>();
        if (raiz == null) return lista;

        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Nodo n = fila.poll();
            lista.add(n.chave);

            if (n.esquerda != null) {
                fila.add(n.esquerda);
            }
            if (n.direita != null) {
                fila.add(n.direita);
            }
        }
        return lista;
    }

    public BuscaResultado buscar(int chave) {
        List<Integer> caminho = new ArrayList<>();
        Nodo atual = raiz;
        int visitados = 0;

        while (atual != null) {
            visitados++;
            caminho.add(atual.chave);
            if (atual.chave == chave) {
                return new BuscaResultado(true, visitados, caminho);
            } else if (chave < atual.chave) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }
        return new BuscaResultado(false, visitados, caminho);
    }

    public static class BuscaResultado {
        boolean achou;
        int visitados;
        List<Integer> caminho;

        BuscaResultado(boolean achou, int visitados, List<Integer> caminho) {
            this.achou = achou;
            this.visitados = visitados;
            this.caminho = caminho;
        }

        public boolean isAchou() {
            return achou;
        }

        public int getVisitados() {
            return visitados;
        }

        public List<Integer> getCaminho() {
            return caminho;
        }
    }
}
