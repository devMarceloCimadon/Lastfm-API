package proj.api.lastfm.models.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class User {
    private String name;
    private String url;
    private String country;
    private String playcount;

    public User() {
    }

    public User(String name, String url, String country, String playcount) {
        this.name = name;
        this.url = url;
        this.country = country;
        this.playcount = playcount;
    }
}
