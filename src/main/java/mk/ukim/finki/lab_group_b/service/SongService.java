package mk.ukim.finki.lab_group_b.service;

import mk.ukim.finki.lab_group_b.model.*;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    void addArtistToSong(Artist artist, Song song);
    Song findById(Long id);
    void deleteSongById(Long id);
    void saveSong(String id, String name, String genre, Integer releaseYear, Long albumId);
}
