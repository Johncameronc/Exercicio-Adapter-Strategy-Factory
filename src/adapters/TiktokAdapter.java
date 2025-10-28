package adapters;

import api.TiktokAPI;
import interfaces.IRedeSocial;
import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;

public class TiktokAdapter implements IRedeSocial {
    private TiktokAPI api;
    private String token;

    public TiktokAdapter() {
        this.api = new TiktokAPI();
    }

    @Override
    public boolean autenticar(String token) {
        this.token = token;
        System.out.println("[TikTok Adapter] Autenticado com token: " + token.substring(0, 5) + "...");
        return true;
    }

    @Override
    public Publicacao publicar(Conteudo conteudo) {
        String id = api.uploadVideo(conteudo.getTexto(), conteudo.getUrlVideo());
        return new Publicacao(id, "TikTok", conteudo.getTexto());
    }

    @Override
    public boolean deletar(String idPublicacao) {
        return api.deleteVideo(idPublicacao);
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        TiktokAPI.TikTokAnalytics analytics = api.getAnalytics(idPublicacao);
        return new Estatisticas(analytics.likes, analytics.shares, analytics.comments, analytics.views);
    }
}
