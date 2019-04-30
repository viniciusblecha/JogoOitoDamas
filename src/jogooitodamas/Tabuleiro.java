/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogooitodamas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinícius
 */
public final class Tabuleiro {
    private int [][] tabuleiro;
    private Integer heuristica;
    private List<Tabuleiro> vizinhos;
    private Tabuleiro pai;
    private boolean ehSolucao;
    
    public Tabuleiro(int[][]tabuleiro,Tabuleiro pai){
        this.tabuleiro = tabuleiro;
        this.heuristica = heuristica();
        this.ehSolucao = this.heuristica <= 0;
        this.pai = pai;
    }
    
    public Tabuleiro(Tabuleiro tab){
        this.tabuleiro = tab.tabuleiro;
        this.ehSolucao = tab.ehSolucao;
        this.heuristica = tab.heuristica;
        this.pai = tab.pai;
        this.vizinhos = tab.vizinhos;
    }
    
    @Override
    public Tabuleiro clone(){
        return new Tabuleiro(this);
    }
    
    
    
    public List<Tabuleiro> expandirVizinhos(){
        List<Tabuleiro> viz = new ArrayList<>();

        
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (tabuleiro[i][j] == 1){
                    
                    
                    for (int k = 0 ; k < 8 ; k++){
                        int[][] tab = new GeraTabuleiro().clonaTabuleiro(this.tabuleiro);
                       
                        if (tab[i][k] != 1){
                            tab[i][j] = 0;
                            tab[i][k] = 1;
                            viz.add(new Tabuleiro(tab,this));
                        }         
                        
                    }
                }
            }
        }
            
        
        this.vizinhos = viz;
        return viz;
    }
    
    public int heuristica(){
        int heuristic=0;
        for (int i = 0; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (tabuleiro[i][j] == 1){
                    // verifica se ataca a direita
                    for (int k = j+1 ; k < 8 ; k ++){
                        if (tabuleiro[i][k] == 1){
                            heuristic++;
                            break;
                        }
                    }
                    
                    // verifica se ataca a esquerda
                    for (int k = j-1 ; k >= 0 ; k --){
                        if (tabuleiro[i][k] == 1){
                            heuristic++;
                            break;
                        }
                    }
                    
                    // verifica se ataca para baixo
                    for (int k = i+1 ; k < 8 ; k ++){
                        if (tabuleiro[k][j] == 1){
                            heuristic++;
                            break;
                        }
                    }
                    
                    // verifica se ataca para cima
                    for (int k = i-1 ; k >= 0 ; k --){
                        if (tabuleiro[k][j] == 1){
                            heuristic++;
                            break;
                        }
                    }
                    
                    // verifica se ataca diagonal baixo/esquerda
                    for (int k = i+1,  l = j-1 ; k<8 && l>=0 ; k++,l--){
                        if (tabuleiro[k][l] == 1){
                                heuristic++;
                                break;
                        }
                    }
                    
                    // verifica se ataca diagonal cima/direita
                    for (int k = i-1,  l = j+1 ; k>=0 && l<8 ; k--,l++){
                        if (tabuleiro[k][l] == 1){
                                heuristic++;
                                break;
                        }
                    }
                    
                    // verifica se ataca diagonal baixo/direita
                    for (int k = i+1,  l = j+1 ; k<8 && l<8 ; k++,l++){
                        if (tabuleiro[k][l] == 1){
                                heuristic++;
                                break;
                        }
                    }
                    
                    // verifica se ataca diagonal cima/esquerda
                    for (int k = i-1,  l = j-1 ; k>=0 && l>=0 ; k--,l--){
                        if (tabuleiro[k][l] == 1){
                                heuristic++;
                                break;
                        }
                    }
                   
                }                   
            }
        }
        this.heuristica = heuristic;
        return heuristic;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Integer getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(Integer heuristica) {
        this.heuristica = heuristica;
    }

    public List<Tabuleiro> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Tabuleiro> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public Tabuleiro getPai() {
        return pai;
    }

    public void setPai(Tabuleiro pai) {
        this.pai = pai;
    }
    
    public boolean isEhSolucao() {
        return ehSolucao;
    }

    public void setEhSolucao(boolean ehSolucao) {
        this.ehSolucao = ehSolucao;
    }
    
    //"\033[44m","\033[47m"
    @Override
        public String toString(){
            int cor=0;
            String color[] = {"\033[41m","\033[47m"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8 ; i++){
                if (cor == 0)
                    cor = 1;
                else
                    cor = 0;
                for (int j = 0 ; j < 8 ; j++){
                    sb.append(color[cor]).append(tabuleiro[i][j]).append(color[cor]).append(" ");
                    if (cor == 0)
                        cor = 1;
                    else
                        cor = 0;
                }
            sb.append("\n");
            }  
            return sb.toString();
        }
    
}
