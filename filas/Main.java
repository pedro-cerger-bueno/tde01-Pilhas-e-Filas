class Fila {
    private int capacidade;
    private int frente;
    private int tras;
    private int[] dados;
    private int tamanho;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.frente = 0; // Índice inicial do primeiro elemento
        this.tras = -1;  // Índice inicial onde o próximo elemento será inserido
        this.tamanho = 0; // Inicialmente a fila está vazia
    }

    public boolean insere(int elemento) {
        if (cheia()) {
            return false;
        } else {
            tras = (tras + 1) % capacidade; // Move para o próximo índice de forma circular
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
            frente = (frente + 1) % capacidade; // Move para o próximo índice de forma circular
            tamanho--;
            return elementoRemovido;
        } else {
            return null; // Ou lançar uma exceção
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
        // Criando uma fila com capacidade para 5 elementos
        Fila fila = new Fila(5);
        
        // Inserindo elementos na fila
        System.out.println("Adicionando itens na fila...");
        System.out.println();
        fila.insere(1);
        fila.insere(2);
        fila.insere(3);
        fila.insere(4);
        fila.insere(5);

        // Verificando se a fila está cheia
        if (fila.cheia()) {
            System.out.println("A fila está cheia.");
            System.out.println();   
        }

        // Imprimindo todos os elementos da fila
        fila.imprime();

        // Removendo um elemento da fila
        fila.remove();
        System.out.println();
        System.out.println("Removendo 1 item...");
        System.out.println();

        // Imprimindo todos os elementos da fila após a remoção
        fila.imprime();

        System.out.println();
        System.out.println("Removendo todos os itens ...");
        System.out.println();

        while (!fila.vazia()){
            fila.remove();
            fila.imprime();
            System.out.println();
        }

        // Verificando se a fila está vazia
        if (fila.vazia()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("A fila ainda possui elementos.");
        }
    }
}
