import java.util.Stack;

public class Pino {

        // Declaração de uma pilha de inteiros
        private Stack<Integer> pilha;

        public Pino() {
            // Inicialização da pilha
            pilha = new Stack<>();
        }

    // Método para adicionar um elemento na pilha
    public void adicionarElemento(int elemento) {
        if (pilha.isEmpty() || verTopo() > elemento) {
            pilha.push(elemento);
        } else {
            throw new IllegalArgumentException("O elemento não pode ser maior que o elemento no topo da pilha.");
        }
    }

        // Método para remover o elemento do topo da pilha
        public int removerElemento() {
            if (!pilha.isEmpty()) {
                return pilha.pop();
            } else {
                throw new RuntimeException("A pilha está vazia!");
            }
        }

        // Método para ver o elemento do topo da pilha sem removê-lo
        public int verTopo() {
            if (!pilha.isEmpty()) {
                return pilha.peek();
            } else {
                throw new RuntimeException("A pilha está vazia!");
            }
        }

        // Método para verificar se a pilha está vazia
        public boolean estaVazia() {
            return pilha.isEmpty();
        }

        // Método para obter o tamanho da pilha
        public int tamanho() {
            return pilha.size();
        }

    public Stack<Integer> getElementos() {
        return pilha;
    }
}
