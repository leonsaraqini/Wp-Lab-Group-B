package mk.ukim.finki.lab_group_b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Song {
    String trackId;
    String title;
    String genre;
    int releaseYear;
    List<Artist> artists;

    public void addArtist(Artist artist){
        artists.add(artist);
    }
}
