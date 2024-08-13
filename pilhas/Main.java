class Pilha {
    private int capacidade;
    private int topo;
    private int[] dados;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.topo = -1; 
    }

    public boolean insere(int elemento) {
        if (cheia()) {
            return false;
        } else {
            dados[++topo] = elemento;
            return true;
        }
    }

    public boolean cheia() {
        return topo == capacidade - 1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public Integer remove() {
        if (!vazia()) {
            return dados[topo--];
        } else {
            return null; 
        }
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("A pilha está vazia.");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(dados[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
       
        Pilha pilha = new Pilha(5);
        
        
        System.out.println("Adicionando itens na pilha...");
        System.out.println();
        pilha.insere(10);
        pilha.insere(20);
        pilha.insere(30);
        pilha.insere(40);
        pilha.insere(50);

        
        if (pilha.cheia()) {
            System.out.println("A pilha está cheia.");
            System.out.println();   
        }

        
        pilha.imprime();

        
        pilha.remove();
        System.out.println();
        System.out.println("Removendo 1 item...");
        System.out.println();

        
        pilha.imprime();

        System.out.println();
        System.out.println("Removendo todos os itens ...");
        System.out.println();

        while (pilha.vazia() == false){
            pilha.remove();
            pilha.imprime();
            System.out.println();
        }
       
        if (pilha.vazia()) {
        } else {
            System.out.println("A pilha ainda possui elementos.");
        }
    }
}

