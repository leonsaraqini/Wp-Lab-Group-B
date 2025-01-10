package mk.ukim.finki.lab_group_b.repository;

import mk.ukim.finki.lab_group_b.bootstrap.DataHolder;
import mk.ukim.finki.lab_group_b.model.Album;
import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Song findById(Long id){
        return DataHolder.songs.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addArtistToSong(Artist artist, Song song){
        Song s = findById(song.getId());
        s.addArtist(artist);
    }

    public void deleteSongById(Long id){
        Song s = findById(id);
        DataHolder.songs.remove(s);
    }

    public void saveSong(Song song){
        DataHolder.songs.add(song);
    }

    public void saveSong(String title, String genre, Integer releaseYear, Album album){
        DataHolder.songs.add(new Song(title, genre, releaseYear, null, album));
    }

    public void editSong(Song song, String title, String genre, Integer releaseYear, Album album){
        song.setSong(title, genre, releaseYear, album);
    }


}
