import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Pino pino1 = new Pino();
        Pino pino2 = new Pino();
        Pino pino3 = new Pino();

        // Adicionar discos ao pino1
        pino1.adicionarElemento(5);
        pino1.adicionarElemento(4);
        pino1.adicionarElemento(3);
        pino1.adicionarElemento(2);
        pino1.adicionarElemento(1);

        int tamanhoTorre = pino1.tamanho();

        // Se o número de discos for par, inverta a ordem dos pinos auxiliar e destino
        if (tamanhoTorre % 2 == 0) {
            Pino temp = pino2;
            pino2 = pino3;
            pino3 = temp;
        }

        int movimentosTotais = (int) Math.pow(2, tamanhoTorre) - 1;// o numero de movimentos é definido por 2^tamnhoTorre - 1

        for (int i = 1; i <= movimentosTotais; i++) {
            if (i % 3 == 1) {
                moverDisco(pino1, pino3);
            } else if (i % 3 == 2) {
                moverDisco(pino1, pino2);
            } else if (i % 3 == 0) {
                moverDisco(pino2, pino3);
            }
            imprimirTorres(pino1, pino2, pino3, tamanhoTorre);
        }

        System.out.println("Todos os discos foram movidos para o pino 3!");
    }

    public static void moverDisco(Pino origem, Pino destino) {
        if (origem.estaVazia() && !destino.estaVazia()) {
            origem.adicionarElemento(destino.removerElemento());
        } else if (!origem.estaVazia() && destino.estaVazia()) {
            destino.adicionarElemento(origem.removerElemento());
        } else if (!origem.estaVazia() && !destino.estaVazia()) {
            if (origem.verTopo() < destino.verTopo()) {
                destino.adicionarElemento(origem.removerElemento());
            } else {
                origem.adicionarElemento(destino.removerElemento());
            }
        }
    }

    public static void imprimirTorres(Pino pino1, Pino pino2, Pino pino3, int tamanhoTorre) {
        Stack<Integer> p1 = pino1.getElementos();
        Stack<Integer> p2 = pino2.getElementos();
        Stack<Integer> p3 = pino3.getElementos();

        System.out.println("\nEstado atual das torres:");

        for (int i = tamanhoTorre - 1; i >= 0; i--) {
            String linha1 = construirLinha(p1, i, tamanhoTorre);
            String linha2 = construirLinha(p2, i, tamanhoTorre);
            String linha3 = construirLinha(p3, i, tamanhoTorre);

            System.out.println(linha1 + " | " + linha2 + " | " + linha3);
        }

        String base = "-".repeat(tamanhoTorre * 2 + 2);
        System.out.println(base + "   " + base + "   " + base);
    }

    private static String construirLinha(Stack<Integer> pino, int nivel, int altura) {
        if (nivel < pino.size()) {
            int tamanho = pino.get(nivel);
            int espacos = altura - tamanho;
            String disco = "_".repeat(tamanho) + "--" + "_".repeat(tamanho);
            return " ".repeat(espacos) + disco + " ".repeat(espacos);
        } else {
            return " ".repeat(altura * 2 + 2);
        }
    }
}
