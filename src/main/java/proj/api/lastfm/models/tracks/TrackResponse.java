package proj.api.lastfm.models.tracks;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class TrackResponse {

    private TrackWrapper topTracks;

    public TrackResponse() {
    }

    public TrackResponse(TrackWrapper topTracks) {
        this.topTracks = topTracks;
    }
}
