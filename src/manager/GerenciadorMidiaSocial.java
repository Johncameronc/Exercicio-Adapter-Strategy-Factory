package manager;

import interfaces.IRedeSocial;
import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;

public class GerenciadorMidiaSocial {
    private java.util.Map<String, IRedeSocial> redes;

    public GerenciadorMidiaSocial() {
        this.redes = new java.util.HashMap<>();
    }

    public void adicionarRede(String nome, IRedeSocial rede) {
        redes.put(nome, rede);
        System.out.println("> Rede " + nome + " adicionada ao gerenciador");
    }

    public void publicarEmTodas(Conteudo conteudo) {
        System.out.println("\n=== PUBLICANDO EM TODAS AS REDES ===");
        for (java.util.Map.Entry<String, IRedeSocial> entry : redes.entrySet()) {
            Publicacao pub = entry.getValue().publicar(conteudo);
            System.out.println("> Publicado em " + entry.getKey() + " - ID: " + pub.getId());
        }
    }

    public void exibirEstatisticasGerais() {
        System.out.println("\n=== ESTATÍSTICAS GERAIS ===");
        for (java.util.Map.Entry<String, IRedeSocial> entry : redes.entrySet()) {
            String nome = entry.getKey();
            Estatisticas stats = entry.getValue().obterEstatisticas("mock_id");
            System.out.printf("%s - Curtidas: %d | Compartilhamentos: %d | Comentários: %d | Visualizações: %d%n",
                    nome, stats.getCurtidas(), stats.getCompartilhamentos(),
                    stats.getComentarios(), stats.getVisualizacoes());
        }
    }
}
