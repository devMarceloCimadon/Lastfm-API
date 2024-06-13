package proj.api.lastfm.models.tracks;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class TrackWrapper {

    private List<Track> track;

    public TrackWrapper() {
    }

    public TrackWrapper(List<Track> track) {
        this.track = track;
    }
}
