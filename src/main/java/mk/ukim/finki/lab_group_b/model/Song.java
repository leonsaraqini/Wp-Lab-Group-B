package mk.ukim.finki.lab_group_b.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> artists;
    private Album album;

    public Song(String title, String genre, int releaseYear, List<Artist> artists, Album album) {
        setArtists(artists);
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        if(artists == null)
            this.artists = new ArrayList<>();
        else
            this.artists = artists;
    }

    public void addArtist(Artist artist){
        boolean artistExists = getArtists().stream().anyMatch(a -> a.getId().equals(artist.getId()));

        if(!artistExists) artists.add(artist);
    }

    public void setSong(String title, String genre, int releaseYear, Album album) {
        setTitle(title);
        setGenre(genre);
        setReleaseYear(releaseYear);
        setAlbum(album);
    }
}
