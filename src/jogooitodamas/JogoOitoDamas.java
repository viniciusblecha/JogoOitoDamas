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
       
       List<Tabuleiro> solucao;
       Tabuleiro problemaInicial = new Tabuleiro(tabuleiroInicial,null);
       Heuristica hc = new Heuristica(problemaInicial);
       solucao = hc.run();
       
       if (solucao == null){
            System.out.println("Não existe solução para esse problema");
        }
       
       try{
           if (solucao != null){
               for (int i = solucao.size()-1 ; i >= 0 ; i--){
                   System.out.println(solucao.get(i).toString() +"Total de ataques : "+solucao.get(i).getHeuristica());
                   solucao.remove(i);
               }
           }
       }catch(Exception e){
           System.out.println("Erorr");
       }
    }
    
}
