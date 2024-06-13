package proj.api.lastfm.models.artists;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class ArtistResponse {

    private ArtistWrapper topArtists;

    public ArtistResponse() {
    }

    public ArtistResponse(ArtistWrapper topArtists) {
        this.topArtists = topArtists;
    }
}
