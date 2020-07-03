
package nodetree;

public class GamePlay {

     public static void main(String[] args) {
         
        NodeTree arvore = new NodeTree();
        arvore.inserir("1. O animal come carne?");
        
        arvore.inserir("2. O animal tem listras?");
        arvore.inserir("2. O animal tem listras?");
         
        arvore.inserir("O animal é TIGRE");
        arvore.inserir("O animal é um LEOPARDO");
        
        arvore.inserir("O animal é uma ZEBRA");
        arvore.inserir("O animal é um CAVALO");
        
     
        System.out.println("SEJA BEM VINDO AO GAME! :) ");
         System.out.println("");
        
        CapturaResposta pergunta = new CapturaResposta();
        pergunta.pergunta(arvore.raiz);
        
        
    }

   

}