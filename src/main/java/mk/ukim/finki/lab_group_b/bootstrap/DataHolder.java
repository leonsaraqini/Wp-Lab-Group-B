package mk.ukim.finki.lab_group_b.bootstrap;

import jakarta.annotation.PostConstruct;

import mk.ukim.finki.lab_group_b.model.Album;
import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    @PostConstruct
    public void init(){


        artists = new ArrayList<>();
        songs = new ArrayList<>();
        albums = new ArrayList<>();

        albums.add(new Album("Thriller", "Pop", "1982"));
        albums.add(new Album("Back in Black", "Rock", "1980"));
        albums.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973"));
        albums.add(new Album("Abbey Road", "Rock", "1969"));
        albums.add(new Album("Rumours", "Rock", "1977"));
        albums.add(new Album("21", "Pop", "2011"));


        artists.add(new Artist(1L, "John", "Doe", "A contemporary painter known for abstract works."));
        artists.add(new Artist(2L, "Jane", "Smith", "An accomplished sculptor specializing in marble."));
        artists.add(new Artist(3L, "Emily", "Johnson", "A digital artist focusing on futuristic themes."));
        artists.add(new Artist(4L, "Michael", "Brown", "A photographer renowned for capturing urban landscapes."));

        songs.add(new Song("Abstract Sounds", "Electronic", 2022, List.of(artists.get(0), artists.get(2)), albums.get(0)));
        songs.add(new Song("Marble Symphony", "Classical", 2020, List.of(artists.get(1)),albums.get(2)));
        songs.add(new Song( "Urban Beats", "Hip-Hop", 2023, List.of(artists.get(3)),albums.get(3)));
        songs.add(new Song( "Futuristic Vibes", "Pop", 2021, List.of(artists.get(2), artists.get(0)),albums.get(2)));
    }
}
