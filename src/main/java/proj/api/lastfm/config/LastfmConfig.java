package proj.api.lastfm.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;

@Data
public class LastfmConfig {
    static Dotenv dotenv = Dotenv.load();
    private static String api_key = dotenv.get("LASTFM_API_KEY");

    public static String getApiKey(){
        if (api_key == null || api_key.isEmpty()){
            throw new IllegalStateException("Chave não definida");
        }
        return api_key;
    }

}
