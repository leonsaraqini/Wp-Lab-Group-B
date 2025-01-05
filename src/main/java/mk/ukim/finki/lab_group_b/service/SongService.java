package mk.ukim.finki.lab_group_b.service;

import mk.ukim.finki.lab_group_b.model.*;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
}
