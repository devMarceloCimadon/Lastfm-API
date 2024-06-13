package proj.api.lastfm.models.artists;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class Artist {
    private String name;
    private String url;

    public Artist() {
    }

    public Artist(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
