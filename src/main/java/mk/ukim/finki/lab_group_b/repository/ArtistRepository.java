package mk.ukim.finki.lab_group_b.repository;

import mk.ukim.finki.lab_group_b.bootstrap.DataHolder;
import mk.ukim.finki.lab_group_b.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artists;
    }

    public Optional<Artist> findById(Long id){
        return DataHolder.artists.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }
}
