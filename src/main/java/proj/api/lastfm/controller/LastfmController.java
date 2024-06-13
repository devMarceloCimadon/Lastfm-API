package proj.api.lastfm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.api.lastfm.models.albums.Album;
import proj.api.lastfm.models.albums.AlbumResponse;
import proj.api.lastfm.models.albums.AlbumWrapper;
import proj.api.lastfm.models.artists.Artist;
import proj.api.lastfm.models.artists.ArtistResponse;
import proj.api.lastfm.models.artists.ArtistWrapper;
import proj.api.lastfm.models.artists.SimilarArtistsResponse;
import proj.api.lastfm.client.LastfmClient;
import proj.api.lastfm.config.LastfmConfig;
import proj.api.lastfm.models.tracks.SimilarTracksResponse;
import proj.api.lastfm.models.tracks.Track;
import proj.api.lastfm.models.tracks.TrackResponse;
import proj.api.lastfm.models.tracks.TrackWrapper;
import proj.api.lastfm.models.user.User;
import proj.api.lastfm.models.user.UserResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("lastfm/api")
public class LastfmController {

    private final LastfmClient lastfmClient;
    String apiKey = LastfmConfig.getApiKey();


    public LastfmController(LastfmClient lastfmClient) {
        this.lastfmClient = lastfmClient;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username){
        try{
            UserResponse response = lastfmClient.getUser(username, apiKey);

            User user = response.getUser();
            return ResponseEntity.ok(user);
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter usuário", e);
        }
    }

    @GetMapping("/{username}/top-albums")
    public ResponseEntity<List<Album>> topAlbums(@PathVariable("username") String username){
        try{
            AlbumResponse response = lastfmClient.getTopAlbums(username, apiKey);

            AlbumWrapper albumWrapper = response.getTopAlbums();
            List<Album> albums = albumWrapper.getAlbum();
            return ResponseEntity.ok(albums);
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter os top albuns", e);
        }
    }

    @GetMapping("/{username}/top-tracks")
    public ResponseEntity<List<Track>> topTracks(@PathVariable("username") String username) {
        try {
            TrackResponse response = lastfmClient.getTopTracks(username, 20,apiKey);

            TrackWrapper trackWrapper = response.getTopTracks();
            List<Track> tracks = trackWrapper.getTrack();
            return ResponseEntity.ok(tracks);
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter as faixas",e);
        }
    }

    @GetMapping("/{username}/top-artists")
    public ResponseEntity<List<Artist>> topArtists(@PathVariable("username") String username){
        try{
            ArtistResponse response = lastfmClient.getTopArtists(username, 20, apiKey);

            ArtistWrapper artistWrapper = response.getTopArtists();
            List<Artist> artists = artistWrapper.getArtist();
            return ResponseEntity.ok(artists);
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter os artistas", e);
        }
    }

    @GetMapping("/{artist}/{track}/similar-tracks")
    public ResponseEntity<List<Track>> similarTracks(@PathVariable("artist") String artistName, @PathVariable("track") String trackName){
        try {
            SimilarTracksResponse response = lastfmClient.getSimilarTracks(artistName, trackName, 5, apiKey);

            TrackWrapper trackWrapper = response.getSimilarTracks();
            List<Track> tracks = trackWrapper.getTrack();
            return ResponseEntity.ok(tracks);
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter as faixas similares", e);
        }
    }

    @GetMapping("/{artist}/similar-artists")
    public ResponseEntity<List<Artist>> similarArtists(@PathVariable("artist") String artistName){
        try{
            SimilarArtistsResponse response = lastfmClient.getSimilarArtists(artistName, 5, apiKey);

            ArtistWrapper artistWrapper = response.getSimilarArtists();
            List<Artist> artists = artistWrapper.getArtist();
            return ResponseEntity.ok(artists);
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter artistas similares", e);
        }
    }

    @GetMapping("/{username}/recommended-tracks")
    public ResponseEntity<List<Track>> recommendedTracks(@PathVariable("username") String username){
        try{
            // Obtém as faixas mais ouvidas pelo usuário
            ResponseEntity<List<Track>> topTracksResponse = topTracks(username);
            List<Track> topTracks = topTracksResponse.getBody();
            // Cria uma lista para armazenar todas as tracks similares
            List<Track> recommendedTracks = new ArrayList<>();
            // Para cada track mais ouvida, obtém tracks similares e as adiciona
            for (Track track : topTracks){
                ResponseEntity<List<Track>> similarTracksResponse = similarTracks(track.getArtist().getName(), track.getName());
                List<Track>similarTracks = similarTracksResponse.getBody();

                // Verifica se a track similar já não está na lista de tracks similares
                for(Track similarTrack : similarTracks) {
                    if(!recommendedTracks.contains(similarTrack)) {
                        recommendedTracks.add(similarTrack);
                    }
                }
            }
            // Remove trackhs que já estão entre as mais ouvidas pelo usuário
            recommendedTracks.removeAll(topTracks);
            return ResponseEntity.ok(recommendedTracks);
        } catch (Exception e){
            throw new RuntimeException("Erro ao recomendar faixas para o usuário", e);
        }
    }

    @GetMapping("/{username}/recommended-artists")
    public ResponseEntity<List<Artist>> recommendedArtists(@PathVariable("username") String username){
        try{
            // Obtém os artistas mais acompanhados pelo usuário
            ResponseEntity<List<Artist>> topArtistsResponse = topArtists(username);
            List<Artist> topArtists = topArtistsResponse.getBody();
            // Cria uma lista para armazenar todos os artistas similares
            List<Artist> recommendedArtists = new ArrayList<>();
            // Para cada artista mais acompanhado, obtém artistas similares e os adiciona
            for (Artist artist : topArtists){
                ResponseEntity<List<Artist>> similarArtistResponse = similarArtists(artist.getName());
                List<Artist> similarArtists = similarArtistResponse.getBody();

                // Verifica se o artista já não está na lista de artistas similares
                for (Artist similarArtist : similarArtists){
                    if(!recommendedArtists.contains(similarArtist)){
                        recommendedArtists.add(similarArtist);
                    }
                }
            }
            // Remove os artistas que já estão entre os que o usuário mais acompanha
            recommendedArtists.removeAll(topArtists);
            return ResponseEntity.ok(recommendedArtists);
        } catch (Exception e){
            throw new RuntimeException("Erro ao recomendar artistas para o usuário", e);
        }
    }
    
}
