package mk.ukim.finki.lab_group_b.web.controller;

import jakarta.websocket.server.PathParam;
import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import mk.ukim.finki.lab_group_b.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{id}")
    public String addArtistToSong(@PathVariable Long songId, Model model) {
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("artists", artists);
        model.addAttribute("trackId", songId);
        return "artistsList";
    }
}
