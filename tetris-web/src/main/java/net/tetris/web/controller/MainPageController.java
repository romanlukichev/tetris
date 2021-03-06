package net.tetris.web.controller;

import net.tetris.services.Player;
import net.tetris.services.PlayerService;
import net.tetris.services.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * User: apofig
 * Date: 9/20/12
 * Time: 1:37 PM
 */
@Controller
@RequestMapping("/")
public class MainPageController {

    @Autowired
    private PlayerService playerService;

    public MainPageController() {
    }

    //for unit test
    MainPageController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage(HttpServletRequest request, Model model) {
        String userIp = request.getRemoteAddr();
        model.addAttribute("ip", userIp);

        Player player = playerService.findPlayerByIp(userIp);
        model.addAttribute("user", player.getName());

        return "main";
    }

}
