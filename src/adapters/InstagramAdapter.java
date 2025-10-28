package adapters;

import api.InstagramAPI;
import api.TwitterAPI;
import interfaces.IRedeSocial;
import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;

public class InstagramAdapter implements IRedeSocial {
    private InstagramAPI api;
    private String token;

    public InstagramAdapter() {
        this.api = new InstagramAPI();
    }

    @Override
    public boolean autenticar(String token) {
        this.token = token;
        System.out.println("[Instagram Adapter] Autenticado com token: " + token.substring(0, 5) + "...");
        return true;
    }

    @Override
    public Publicacao publicar(Conteudo conteudo) {
        String id = api.createPost(conteudo.getTexto(), conteudo.getUrlImagem());
        return new Publicacao(id, "Instagram", conteudo.getTexto());
    }

    @Override
    public boolean deletar(String idPublicacao) {
        return api.removePost(idPublicacao);
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        InstagramAPI.InstagramInsights insights = api.getInsights(idPublicacao);
        return new Estatisticas(insights.likes, 0, insights.comments, insights.reach);
    }
}
