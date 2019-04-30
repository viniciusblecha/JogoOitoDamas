/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogooitodamas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Vinícius
 */
public class Heuristica {
    private final Tabuleiro tabuleiroInicial;
    private final List<Tabuleiro> solucao;
    private int profundidade;
    private final int filhosGerados;
    
    public Heuristica(Tabuleiro tabuleiroInicial){
        this.tabuleiroInicial = tabuleiroInicial;
        this.solucao = new ArrayList<>();
        this.profundidade = 0;
        this.filhosGerados = 0;
    }
    
    public List<Tabuleiro> run(){
        List<Tabuleiro> fechados = new ArrayList<>();
        List<Tabuleiro> abertos = new ArrayList<>();
        Tabuleiro atual = this.tabuleiroInicial.clone();
        atual.setHeuristica(atual.getHeuristica());
        fechados.add(atual);
        
        while (!atual.isEhSolucao()){
            for (Tabuleiro vizinho : atual.expandirVizinhos()){
                if (!fechados.contains(vizinho) && !abertos.contains(vizinho)){
                    vizinho.setHeuristica(vizinho.getHeuristica());
                    abertos.add(vizinho);
                }
            }
            
            
            sort(abertos);
            atual = abertos.get(0).clone();
            abertos.remove(0);
            fechados.add(atual);
            
        }
        
        if (atual.isEhSolucao()){
            //usei para testar se estava correto
            //for (int i = fechados.size()-1 ; i >= 0 ; i--)
            //    System.out.println(fechados.get(i).toString());
            
            while (atual.getPai() != null){
                this.solucao.add(atual);
                atual = atual.getPai();
            }
            
            this.solucao.add(this.tabuleiroInicial);
            this.profundidade = this.solucao.size();
            return this.solucao;
        }
        return null;
    }
    
    public List<Tabuleiro> getSolucao(){
        return this.solucao;
    }
    
    public Tabuleiro getTabuleiroInicial() {
        return tabuleiroInicial;
    }
    
    public void sort(List<Tabuleiro> tabuleiros){ 
	Collections.sort(tabuleiros, (Tabuleiro o1, Tabuleiro o2) -> o1.getHeuristica().compareTo(o2.getHeuristica()));
    }
    
}
