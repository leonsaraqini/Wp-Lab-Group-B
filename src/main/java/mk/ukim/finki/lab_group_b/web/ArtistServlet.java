package mk.ukim.finki.lab_group_b.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.lab_group_b.model.Artist;
import mk.ukim.finki.lab_group_b.model.Song;
import mk.ukim.finki.lab_group_b.service.ArtistService;
import mk.ukim.finki.lab_group_b.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;
    private final SongService songService;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine, SongService songService) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        HttpSession session = req.getSession();

        context.setVariable("trackId", session.getAttribute("trackId"));
        context.setVariable("artists", artistService.listArtists());

        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String selectedArtistId = req.getParameter("artistId");
        String trackId = session.getAttribute("trackId").toString();

        Song song = songService.findById(Long.parseLong(trackId));
        Artist artist = artistService.findById(Long.parseLong(selectedArtistId));

        songService.addArtistToSong(artist, song);

        resp.sendRedirect("/songDetails");
    }
}
