class Fila {
    private int capacidade;
    private int frente;
    private int tras;
    private int[] dados;
    private int tamanho;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.frente = 0; 
        this.tras = -1;  
        this.tamanho = 0; 
    }

    public boolean insere(int elemento) {
        if (cheia()) {
            return false;
        } else {
            tras = (tras + 1) % capacidade; 
            dados[tras] = elemento;
            tamanho++;
            return true;
        }
    }

    public boolean cheia() {
        return tamanho == capacidade;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public Integer remove() {
        if (!vazia()) {
            int elementoRemovido = dados[frente];
            frente = (frente + 1) % capacidade;
            tamanho--;
            return elementoRemovido;
        } else {
            return null; 
        }
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("A fila está vazia.");
        } else {
            int contador = tamanho;
            int indice = frente;
            while (contador > 0) {
                System.out.println(dados[indice]);
                indice = (indice + 1) % capacidade;
                contador--;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        Fila fila = new Fila(5);
        
        
        System.out.println("Adicionando itens na fila...");
        System.out.println();
        fila.insere(1);
        fila.insere(2);
        fila.insere(3);
        fila.insere(4);
        fila.insere(5);

       
        if (fila.cheia()) {
            System.out.println("A fila está cheia.");
            System.out.println();   
        }

        
        fila.imprime();

       
        fila.remove();
        System.out.println();
        System.out.println("Removendo 1 item...");
        System.out.println();

        
        fila.imprime();

        System.out.println();
        System.out.println("Removendo todos os itens ...");
        System.out.println();

        while (!fila.vazia()){
            fila.remove();
            fila.imprime();
            System.out.println();
        }

        
        if (fila.vazia()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("A fila ainda possui elementos.");
        }
    }
}
