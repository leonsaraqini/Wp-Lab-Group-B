package mk.ukim.finki.lab_group_b.repository;

import mk.ukim.finki.lab_group_b.bootstrap.DataHolder;
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
                .get();
    }

    public void addArtistToSong(Artist artist, Song song){
        Song s = findById(song.getId());
        s.addArtist(artist);
    }


}
