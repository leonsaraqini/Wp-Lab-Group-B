package mk.ukim.finki.lab_group_b.service.impl;

import mk.ukim.finki.lab_group_b.model.Album;
import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import mk.ukim.finki.lab_group_b.repository.AlbumRepository;
import mk.ukim.finki.lab_group_b.repository.ArtistRepository;
import mk.ukim.finki.lab_group_b.repository.SongRepository;
import mk.ukim.finki.lab_group_b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private SongRepository songRepository;
    private AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void addArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteSongById(id);
    }

    @Override
    public void saveSong(String id, String title, String genre, Integer releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId);

        if (id.isBlank()) {
            songRepository.saveSong(title, genre, releaseYear, album);
        } else {
            Song song = songRepository.findById(Long.parseLong(id));
            songRepository.editSong(song, title, genre, releaseYear, album);
        }
    }
}
