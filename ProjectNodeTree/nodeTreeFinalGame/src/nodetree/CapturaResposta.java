
package nodetree;

import java.text.Normalizer;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class CapturaResposta {
    Scanner sc = new Scanner(System.in);
    
    public void pergunta(NodeTree no){
        
        String resp = null;
        System.out.println(no.value.toString());
        if(no.getFilhoEsquerdo() != null){
           resp = sc.nextLine();
           
           if(resp.equalsIgnoreCase("SIM") || resp.equalsIgnoreCase("S") || resp.equalsIgnoreCase("YES")){
           
            if(no.getFilhoEsquerdo() == null){
                
                 System.out.println(no.value.toString());
                 
            } else{
              
                NodeTree novaPergunta = no.getFilhoEsquerdo();
                pergunta(novaPergunta); 
            }
        }else{
               if(resp.equalsIgnoreCase("NÃO") || resp.equalsIgnoreCase("N") || resp.equalsIgnoreCase("NO") || resp.equalsIgnoreCase("NAO")|| resp.equalsIgnoreCase("NA?O") ){
                    if(no.getFilhoDireito() == null){
                        //System.out.println("Se 1");
                         System.out.println(no.value.toString());
                    }
                    else{
                       // System.out.println("SENAO" + no.getFilhoDireito());
                        pergunta(no.getFilhoDireito()); 
                    }
                } else{
                    System.out.println("Por Favor, digite uma resposta válida:");
                    pergunta(no);
                    }
            }
        }else{
            System.out.println("");
            System.out.println("Obrigado por jogar :)");
        }
  }
    
}

