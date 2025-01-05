package mk.ukim.finki.lab_group_b.service.impl;

import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.repository.ArtistRepository;
import mk.ukim.finki.lab_group_b.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).get();
    }
}
