package mk.ukim.finki.lab_group_b.service;

import mk.ukim.finki.lab_group_b.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist findById(Long id);
}
