package mk.ukim.finki.lab_group_b.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.lab_group_b.model.Album;
import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import mk.ukim.finki.lab_group_b.service.AlbumService;
import mk.ukim.finki.lab_group_b.service.ArtistService;
import mk.ukim.finki.lab_group_b.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/listSongs")
public class SongController {
    private final SongService songService;
    private final ArtistService artistService;
    private final AlbumService albumService;

    public SongController(SongService songService, ArtistService artistService, AlbumService albumService) {
        this.songService = songService;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        List<Song> songs = songService.listSongs();
        model.addAttribute("songs", songs);
        return "listSongs";
    }

    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSongById(id);

        return "redirect:/listSongs";
    }

    @GetMapping("/addSong")
    public String addSongPage(Model model) {
        List<Album> albums = albumService.findAll();

        model.addAttribute("albums", albums);
        return "addSong";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String id,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam String releaseYear,
                           @RequestParam Long albumId)
    {
        songService.saveSong(id, title, genre, Integer.parseInt(releaseYear), albumId);
        return "redirect:/listSongs";
    }

    @GetMapping("/edit/{id}")
    public String editSongPage(@PathVariable Long id, Model model)
    {
        Song song = songService.findById(id);
        if(song != null) {
            List<Album> albums = albumService.findAll();
            model.addAttribute("song", song);
            model.addAttribute("albums", albums);
            return "addSong";
        }
        return "redirect:/listSongs";
    }

    @PostMapping("/addArtist")
    public String addArtistToSong(@RequestParam Long songId) {

        return "redirect:/artists/" + songId;
    }
}
