package mk.ukim.finki.lab_group_b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> artists;

    public void addArtist(Artist artist){
        artists.add(artist);
    }
}
