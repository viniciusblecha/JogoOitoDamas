/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogooitodamas;

import java.util.Random;

/**
 *
 * @author Vinícius
 */
public class GeraTabuleiro {
    
    public GeraTabuleiro (){
        
    }
    
    public int [][] geraTabuleiroAleatorio(){
        int[][] tabAtual = new int[8][8];
        
        for (int i = 0 ; i < 8 ; i ++){
            tabAtual[i][new Random().nextInt(8)] = 1;
        }
        
        return tabAtual;
    }
    
    public int [][] clonaTabuleiro(int[][] tabuleiro){
        int[][] tabAtual = new int [8][8];
         for (int i = 0 ; i < 8 ; i++){
            System.arraycopy(tabuleiro[i], 0, tabAtual[i], 0, 8);
         }
        return tabAtual;
    }
}
