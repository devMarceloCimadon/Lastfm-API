package proj.api.lastfm.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proj.api.lastfm.models.albums.AlbumResponse;
import proj.api.lastfm.models.artists.ArtistResponse;
import proj.api.lastfm.models.artists.SimilarArtistsResponse;
import proj.api.lastfm.models.tracks.SimilarTracksResponse;
import proj.api.lastfm.models.tracks.TrackResponse;
import proj.api.lastfm.models.user.UserResponse;

@FeignClient(
        name = "LastfmClient",
        url = "http://ws.audioscrobbler.com"
)
public interface LastfmClient {

    // User requests
    @GetMapping("/2.0/?method=user.getinfo&format=json")
    UserResponse getUser(@RequestParam("username") String username, @RequestParam("api_key") String apiKey);

    @GetMapping("/2.0/?method=user.gettopalbums&format=json")
    AlbumResponse getTopAlbums(@RequestParam("username") String username, @RequestParam("api_key") String apiKey);

    @GetMapping("/2.0/?method=user.gettoptracks&format=json")
    TrackResponse getTopTracks(@RequestParam("username") String username, @RequestParam("limit") int limit, @RequestParam("api_key") String apiKey);

    @GetMapping("/2.0/?method=user.gettopartists&format=json")
    ArtistResponse getTopArtists(@RequestParam("username") String username, @RequestParam("limit") int limit, @RequestParam("api_key") String apiKey);

    // Track requests
    @GetMapping("/2.0/?method=track.getsimilar&format=json")
    SimilarTracksResponse getSimilarTracks(@RequestParam("artist") String artistName, @RequestParam("track") String trackName, @RequestParam("limit") int limit, @RequestParam("api_key") String apiLey);

    // Artist requests
    @GetMapping("/2.0/?method=artist.getsimilar&format=json")
    SimilarArtistsResponse getSimilarArtists(@RequestParam("artist") String artistName, @RequestParam("limit") int limit, @RequestParam("api_key") String apiKey);

}
