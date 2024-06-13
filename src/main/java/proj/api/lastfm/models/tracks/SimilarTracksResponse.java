package proj.api.lastfm.models.tracks;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class SimilarTracksResponse {
    private TrackWrapper similarTracks;

    public SimilarTracksResponse() {
    }

    public SimilarTracksResponse(TrackWrapper similarTracks) {
        this.similarTracks = similarTracks;
    }
}
