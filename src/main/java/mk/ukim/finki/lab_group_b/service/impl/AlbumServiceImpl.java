package mk.ukim.finki.lab_group_b.service.impl;

import mk.ukim.finki.lab_group_b.model.Album;
import mk.ukim.finki.lab_group_b.repository.AlbumRepository;
import mk.ukim.finki.lab_group_b.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
}
