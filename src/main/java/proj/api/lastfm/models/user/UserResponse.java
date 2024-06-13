package proj.api.lastfm.models.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
public class UserResponse {
    private User user;

    public UserResponse() {
    }

    public UserResponse(User user) {
        this.user = user;
    }
}
