package model;

public class Conteudo {
    private String texto;
    private String urlImagem;
    private String urlVideo;

    public Conteudo(String texto) {
        this.texto = texto;
    }

    public Conteudo(String texto, String urlImagem) {
        this.texto = texto;
        this.urlImagem = urlImagem;
    }

    public String getTexto() { return texto; }
    public String getUrlImagem() { return urlImagem; }
    public String getUrlVideo() { return urlVideo; }
}
