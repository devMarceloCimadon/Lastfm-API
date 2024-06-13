package proj.api.lastfm.models.artists;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class ArtistWrapper {
    private List<Artist> artist;

    public ArtistWrapper() {
    }

    public ArtistWrapper(List<Artist> artist) {
        this.artist = artist;
    }
}
