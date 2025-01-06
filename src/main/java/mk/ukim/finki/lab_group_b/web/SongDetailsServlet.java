package mk.ukim.finki.lab_group_b.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab_group_b.model.Song;
import mk.ukim.finki.lab_group_b.service.ArtistService;
import mk.ukim.finki.lab_group_b.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;
    private final SongService songService;

    public SongDetailsServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine, SongService songService) {
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

        String trackId = req.getParameter("trackId");
        Song song = songService.findByTrackId(trackId);

        context.setVariable("song", song);
        context.setVariable("artists", song.getArtists());

        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
    }
}
