package proj.api.lastfm.models.albums;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class AlbumWrapper {
    private List<Album> album;
}
