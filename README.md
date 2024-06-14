# Lastfm-API
## 💻About the Project
The project is a study about API consumption with OpenFeign in Java. However, it also introduces new functionalities to the data obtained from the APIs. The aim of this project is not only to learn how to utilize SpringBoot functionalities, but also to understand and address user needs more effectively. An orientation to Object-Oriented Programming (OOP) was also applied.

## ⚙️Funcionalities
#### User:
  - The User class will receive the user data from the Lastfm API.
  - User data called username will be the param in some utilities on the program, like in the getTopArtists.
  - Will have one subclass:
    - UserResponse: To get "user" object in the json 
#### Artist:
  - The Artist class will receive the artist data from the Lastfm API. In this case, it has two functionalities: to retrieve the artist's name and the artist's profile URL on the Lastfm website.
  - Used to get the most played artists in the user's profile and to show which artists perform specific songs.
  - Will have three subclasses:
    - ArtistWrapper: Make a artists list.
    - ArtistResponse: To get the "topartists" object in the json response.
    - SimilarArtistResponse: To get the "similarartists" object in the json response.
#### Album:
  - The Album class will only be used to retrieve the top listened-to albums for the user.
  - Will have two subclasses:
    - AlbumWrapper: Make a albums list.
    - AlbumResponse: To get "topalbums" object in the json response. 
#### Tracks:
  - The tracks class will be used to get track data from Lastfm API.
  - Will be used to get most played tracks in user's profile.
  - Will have three subclasses:
    - TrackWrapper: Make a tracks list.
    - TrackResponse: To get the "toptracks" object in the json response.
    - SimilarTracksResponse: To get the "similartracks" object in the json response.
### TrackRecommender:
  - TrackRecommender is a functionality within the LastfmController class.
  - The recommender retrieves the user's top tracks and uses them to recommend new songs based on the user's preference.
### ArtistRecommender:
  - ArtistRecommender is a functionality within the LastfmController class.
  - The recommender retrives the user's top artists and uses them to recommend new songs based on the user's preference.

## 🛠️Technologies
The technologies used were:
- **[Java](https://www.java.com/)**
- **[SpringBoot](https://spring.io/)**

## ☝️🤓 Author
**[Marcelo Cimadon](https://github.com/devMarceloCimadon)**
