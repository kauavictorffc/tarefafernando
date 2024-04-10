
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Violao {
    private String tipo;
    private int numCordas;

    public Violao(String tipo, int numCordas) {
        this.tipo = tipo;
        this.numCordas = numCordas;
    }

    public Violao clonar() {
        return new Violao(this.tipo, this.numCordas);
    }

    public void exibirDetalhes() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Número de cordas: " + numCordas);
    }
}

class FabricaVioloes {
    private Map<String, Violao> prototipos = new HashMap<>();

    public FabricaVioloes() {
        prototipos.put("clássico", new Violao("Clássico", 6));
        prototipos.put("folk", new Violao("Folk", 6));
        prototipos.put("flet", new Violao("Flet", 6));
        prototipos.put("jumbo", new Violao("Jumbo", 6));
        prototipos.put("7 cordas", new Violao("7 Cordas", 7));
        prototipos.put("12 cordas", new Violao("12 Cordas", 12));
    }

    public Violao criarViolao(String tipo) {
        Violao prototipo = prototipos.get(tipo.toLowerCase());
        if (prototipo != null) {
            return prototipo.clonar();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        FabricaVioloes fabrica = new FabricaVioloes();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de violão que deseja criar:");
        System.out.println("Opções disponíveis: Clássico, Folk, Flet, Jumbo, 7 Cordas, 12 Cordas");
        String tipoViolao = scanner.nextLine().toLowerCase();

        Violao violao = fabrica.criarViolao(tipoViolao);

        if (violao != null) {
            System.out.println("Violão criado com sucesso:");
            violao.exibirDetalhes();
        } else {
            System.out.println("Tipo de violão não reconhecido.");
        }

        scanner.close();
    }
}