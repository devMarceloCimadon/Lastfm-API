package proj.api.lastfm.models.albums;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import proj.api.lastfm.models.artists.Artist;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class Album {
    private String name;
    private String playcount;
    private Artist artist;

    public Album() {
    }

    public Album(String name, String playcount, Artist artist) {
        this.name = name;
        this.playcount = playcount;
        this.artist = artist;
    }
}
