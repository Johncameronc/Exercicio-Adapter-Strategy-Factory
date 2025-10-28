package adapters;

import api.TwitterAPI;
import interfaces.IRedeSocial;
import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;

public class TwitterAdapter implements IRedeSocial {
    private TwitterAPI api;
    private String token;

    public TwitterAdapter() {
        this.api = new TwitterAPI();
    }

    @Override
    public boolean autenticar(String token) {
        this.token = token;
        System.out.println("[Twitter Adapter] Autenticado com token: " + token.substring(0, 5) + "...");
        return true;
    }

    @Override
    public Publicacao publicar(Conteudo conteudo) {
        String id = api.tweet(conteudo.getTexto(), conteudo.getUrlImagem());
        return new Publicacao(id, "Twitter", conteudo.getTexto());
    }

    @Override
    public boolean deletar(String idPublicacao) {
        return api.deleteTweet(idPublicacao);
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        TwitterAPI.TwitterMetrics metrics = api.getMetrics(idPublicacao);
        return new Estatisticas(metrics.likes, metrics.retweets, metrics.replies, 0);
    }
}
