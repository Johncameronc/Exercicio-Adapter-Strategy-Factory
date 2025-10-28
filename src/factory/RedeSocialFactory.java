package factory;

import adapters.InstagramAdapter;
import adapters.LinkedinAdapter;
import adapters.TiktokAdapter;
import adapters.TwitterAdapter;
import interfaces.IRedeSocial;

public class RedeSocialFactory {
    public static IRedeSocial criar(String plataforma, String token) {
        IRedeSocial rede = null;

        switch (plataforma.toLowerCase()) {
            case "twitter":
                rede = new TwitterAdapter();
                break;
            case "instagram":
                rede = new InstagramAdapter();
                break;
            case "linkedin":
                rede = new LinkedinAdapter();
                break;
            case "tiktok":
                rede = new TiktokAdapter();
                break;
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + plataforma);
        }

        rede.autenticar(token);
        return rede;
    }
}
