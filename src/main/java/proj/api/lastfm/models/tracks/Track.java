package proj.api.lastfm.models.tracks;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import proj.api.lastfm.models.artists.Artist;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class Track {

    private String name;

    private Artist artist;

    private String playCount;

    public Track() {
    }

    public Track(String name, String playCount, Artist artist) {
        this.name = name;
        this.playCount = playCount;
        this.artist = artist;
    }
}