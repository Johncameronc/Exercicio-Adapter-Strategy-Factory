package adapters;

import api.LinkedinAPI;
import interfaces.IRedeSocial;
import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;

public class LinkedinAdapter implements IRedeSocial {
    private LinkedinAPI api;
    private String token;

    public LinkedinAdapter() {
        this.api = new LinkedinAPI();
    }

    @Override
    public boolean autenticar(String token) {
        this.token = token;
        System.out.println("[LinkedIn Adapter] Autenticado com token: " + token.substring(0, 5) + "...");
        return true;
    }

    @Override
    public Publicacao publicar(Conteudo conteudo) {
        String id = api.share(conteudo.getTexto(), conteudo.getUrlImagem());
        return new Publicacao(id, "LinkedIn", conteudo.getTexto());
    }

    @Override
    public boolean deletar(String idPublicacao) {
        return api.delete(idPublicacao);
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        LinkedinAPI.LinkedInStats stats = api.getStats(idPublicacao);
        return new Estatisticas(stats.reactions, stats.shares, stats.comments, stats.impressions);
    }
}
