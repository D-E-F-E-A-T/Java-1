package nodetree;

public class NodeTree <E extends Comparable<E>>{
    public E value;
    private NodeTree filhoEsquerdo;
    private NodeTree filhoDireito;
    

    public NodeTree(){
       
    }
     
    @Override
    public String toString(){
        return value.toString();
    }
 
    public NodeTree(E valor){
        this.value = valor;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }
    
    public E getValue(){
        return value;
    }
    
    public void setValue(E value){
        this.value = value;
    }
        
    public NodeTree getFilhoEsquerdo(){
        return filhoEsquerdo;
    } 
    
    public void setFilhoEsquerdo(NodeTree filhoEsquerdo){
        this.filhoEsquerdo = filhoEsquerdo;
    }
    
    public NodeTree getFilhoDireito(){
        return filhoDireito;
    }
    
    public void setFilhoDireito(NodeTree filhoDireito){
        this.filhoDireito = filhoDireito;
    }
    

    //verifica se está vazio   
    public boolean isEmpty(){
        return(raiz == null);
    }
    //pega o menor a partir de um elemento
     public int alturaEsquerda = 0;
     public int alturaEsquerda(NodeTree node){
        if(isEmpty() || node == null){
            return alturaEsquerda;
        }
        if(node.getFilhoEsquerdo() == null){
            return alturaEsquerda;
        } else{
            alturaEsquerda++;
            return alturaEsquerda(node.getFilhoEsquerdo());
            
        }
    }
     public int alturaDireita = 0;
     public int alturaDireita(NodeTree node){
        if(isEmpty() || node == null){
            return alturaDireita;
        }
        if(node.getFilhoDireito() == null){
            return alturaDireita;
        } else{
            alturaDireita++;
            return alturaDireita(node.getFilhoDireito());
            
        }
    }
    
    public NodeTree noAnterior(NodeTree node, NodeTree noAtual){
            if(this.raiz.equals(node)){
                return node;
            }
            if(node.getFilhoEsquerdo().equals(noAtual) || node.getFilhoDireito().equals(noAtual)){
                
                
                return node;
            }
           //preOrdem           
            if(node!= null){
               noAnterior(node.getFilhoEsquerdo(), noAtual);
               noAnterior(node.getFilhoDireito(), noAtual);
            }
            return node;
    }
     
    
    
    
    public NodeTree getMenor(NodeTree node){
        if(isEmpty() || node == null){
            return null;
        }
        if(node.getFilhoEsquerdo() == null){
            return node;
        } else{
            return getMenor(node.getFilhoEsquerdo());
        }
    }
     public NodeTree getMaior(NodeTree node){
        if(isEmpty() || node == null){
            return null;
        }
        if(node.getFilhoDireito() == null){
            return node;
        } else{
            return getMaior(node.getFilhoDireito());
        }
    }
    
     
     
     
     
     
     
     // QUE COMECEM OS JOGOS
    public E inserir(E valor){
        try{
            NodeTree novo = new NodeTree(valor);
           
            this.inserir(raiz,novo);
        } catch(Exception exMemoria){
            System.out.println("" + exMemoria);
            return null;
        }
        return (valor);
    }
    
    public NodeTree raiz;
    
    public void inserir(NodeTree no, NodeTree novo){
        NodeTree noAtual = new NodeTree();
        if(raiz == null){
            raiz = novo;
            //System.out.println("*" + this.raiz + "*");
            //return raiz;
            
        }else{
            noAtual = no;
            this.alturaEsquerda = 0;
            this.alturaDireita = 0;
            
            int altEsq = alturaEsquerda(this.raiz);
            int altDir = alturaDireita(this.raiz);
            if(altEsq == altDir){
                int altEsqAnterior;
                int altDirAnterior;
                if(altEsq>0){
                    altEsqAnterior = altEsq-1;
                    altDirAnterior = altDir-1;
                }else{
                    altEsqAnterior = altEsq;
                    altDirAnterior = altDir;
                }
                
                if((altEsqAnterior-altDirAnterior)==1){
                   if(this.filhoEsquerdo.equals(no)){
                       //inserir a esquerda

                   } 
                   else{
                       NodeTree noAnt = noAnterior(novo,novo);
                       inserir(noAnt.getFilhoDireito(),novo);

                   }
                }
                else{
                    
                    if(no.getFilhoEsquerdo() != null){
                          inserir(noAtual.getFilhoEsquerdo(),novo);
                        
                    } else{
                        
                        noAtual.setFilhoEsquerdo(novo);
                    }
                } 
        }else{
           
            if(altEsq > altDir){
                    if(noAtual.getFilhoEsquerdo() == null && altEsq>altDir){
                        if(this.raiz.getFilhoDireito()==noAtual){
                            if(noAtual.getFilhoEsquerdo()==null){
                             noAtual.setFilhoEsquerdo(novo);
                            }else{
                                noAtual.setFilhoDireito(novo);
                            }
                            
                        } else{
                              inserir(raiz.getFilhoDireito(),novo);
                        }
                      
                    } else{
                        if(noAtual.getFilhoEsquerdo() != null && noAtual.getFilhoDireito() == null){
                        
                        noAtual.setFilhoDireito(novo);
                    
                    } else{
                        
                         inserir(noAtual.getFilhoEsquerdo(),novo);
                        }
                    }
                }
            }
        }
       
    }
}
