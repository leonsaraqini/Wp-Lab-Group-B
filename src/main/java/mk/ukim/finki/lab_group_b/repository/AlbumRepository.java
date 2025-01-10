package mk.ukim.finki.lab_group_b.repository;

import mk.ukim.finki.lab_group_b.bootstrap.DataHolder;
import mk.ukim.finki.lab_group_b.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }


}
