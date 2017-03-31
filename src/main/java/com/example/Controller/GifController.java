package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DK on 31.03.2017.
 */

@Controller
public class GifController {

    @GetMapping("/")
    public String listGifs() {
        return "home";
    }
}
