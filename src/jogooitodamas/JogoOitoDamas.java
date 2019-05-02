/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogooitodamas;

import java.util.List;

/**
 * 
 * @author Vinicius Blecha
 * @author Pedro Consulo
 */
public class JogoOitoDamas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GeraTabuleiro gt = new GeraTabuleiro();
       
       int[][] tabuleiroInicial = gt.geraTabuleiroAleatorio();
       int profundidade;
       int filhosGerados;
       int filhosVisitados;
       
       List<Tabuleiro> solucao;
       Tabuleiro problemaInicial = new Tabuleiro(tabuleiroInicial,null);
       Heuristica hc = new Heuristica(problemaInicial);
       solucao = hc.run();
       
       filhosGerados = hc.filhosGerados;
       profundidade = hc.profundidade;
       filhosVisitados = hc.filhosVisitados;
       
       if (solucao == null){
            System.out.println("Não existe solução para esse problema");
        }
       
       try{
           if (solucao != null){
             
               for (int i = solucao.size()-1 ; i >= 0 ; i--){
                   System.out.println(solucao.get(i).toString() +"Total de ataques : "+solucao.get(i).getHeuristica());
                   solucao.remove(i);
               }
               
               System.out.println("\n \n" + "Profundidade do problema : " +profundidade+ "\n"+ "Filhos visitados : " +filhosVisitados+ "\n" + "Filhos Gerados : " +filhosGerados);
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
    
}
