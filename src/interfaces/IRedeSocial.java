package interfaces;

import model.*;

public interface IRedeSocial {
    Publicacao publicar(Conteudo conteudo);
    boolean deletar(String idPublicacao);
    Estatisticas obterEstatisticas(String idPublicacao);
    boolean autenticar(String token);
}
