import factory.RedeSocialFactory;
import interfaces.IRedeSocial;
import manager.GerenciadorMidiaSocial;
import model.Conteudo;
import model.Publicacao;

public class Main {

    public static void main(String[] args) {

        System.out.println("> SISTEMA DE GERENCIAMENTO DE REDES SOCIAIS");

        // Criar gerenciador
        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();

        // Configurar redes sociais usando Factory
        System.out.println("--- CONFIGURANDO REDES SOCIAIS ---");
        gerenciador.adicionarRede("Twitter", RedeSocialFactory.criar("twitter", "tw_token_12345"));
        gerenciador.adicionarRede("Instagram", RedeSocialFactory.criar("instagram", "ig_token_67890"));
        gerenciador.adicionarRede("LinkedIn", RedeSocialFactory.criar("linkedin", "li_token_abcde"));
        gerenciador.adicionarRede("TikTok", RedeSocialFactory.criar("tiktok", "tt_token_fghij"));

        // Publicar conteúdo
        Conteudo conteudo = new Conteudo(
                "Lançamento do novo produto! #Marketing #Digital",
                "https://exemplo.com/imagem.jpg"
        );

        gerenciador.publicarEmTodas(conteudo);

        // Exibir estatísticas
        gerenciador.exibirEstatisticasGerais();

        // Demonstrar uso individual
        System.out.println("\n=== OPERAÇÕES INDIVIDUAIS ===");
        IRedeSocial twitter = RedeSocialFactory.criar("twitter", "new_token");
        Publicacao pub = twitter.publicar(new Conteudo("Tweet individual de teste"));
        System.out.println("Tweet publicado com ID: " + pub.getId());
        twitter.deletar(pub.getId());

    }

}
