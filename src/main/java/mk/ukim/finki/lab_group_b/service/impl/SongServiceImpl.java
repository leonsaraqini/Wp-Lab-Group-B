package mk.ukim.finki.lab_group_b.service.impl;

import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import mk.ukim.finki.lab_group_b.repository.SongRepository;
import mk.ukim.finki.lab_group_b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
}
