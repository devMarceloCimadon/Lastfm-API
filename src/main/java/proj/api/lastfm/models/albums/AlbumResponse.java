package proj.api.lastfm.models.albums;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class AlbumResponse {
    private AlbumWrapper topAlbums;

    public AlbumResponse() {
    }

    public AlbumResponse(AlbumWrapper topAlbums) {
        this.topAlbums = topAlbums;
    }
}
