/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogooitodamas;

import java.util.List;

/**
 *
 * @author Vinícius
 */
public class JogoOitoDamas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GeraTabuleiro gt = new GeraTabuleiro();
       
       int[][] tabuleiroInicial = gt.geraTabuleiroAleatorio();
       
       List<Tabuleiro> solucao = null;
       Tabuleiro problemaInicial = new Tabuleiro(tabuleiroInicial,null);
       Heuristica hc = new Heuristica(problemaInicial);
       solucao = hc.run();
       
       if (solucao == null){
            System.out.println("Não existe solução para esse problema");
            System.out.println(tabuleiroInicial.toString());
        }
       
       try{
           if (solucao != null){
               while(!solucao.isEmpty()){
                   System.out.println(solucao.get(0).toString());
                   solucao.remove(0);
               }
           }
       }catch(Exception e){
           System.out.println("Erorr");
       }
    }
    
}
