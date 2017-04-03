package com.example.Controller;

import com.example.data.GifRepository;
import com.example.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by DK on 31.03.2017.
 */

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;


//    @RequestMapping("/")
//    public String listGifts(){
//        return "home";
//    }

    @RequestMapping("/")
    public String listGifts(ModelMap modelMap)
    {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.addAttribute("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/categories")
    public String categories(){
        return "categories";
    }

    @RequestMapping("/favorites")
    public String favorites(ModelMap modelMap){
        List<Gif> allGifs2 = gifRepository.getAllGifs();
        modelMap.addAttribute("gifs", allGifs2);
        return "favorites";
    }

//krok11
//    @RequestMapping("/gif")
//    public String gifDetails(ModelMap modelMap){
//        Gif gif = new Gif("compiler-bot","Dorian",true);
//        modelMap.put("gif",gif);
//        return "gif-details";
//    }

//krok12
//    @RequestMapping("/gif")
//    public String gifDetails(ModelMap modelMap){
//        Gif gif = gifRepository.findByName("android-explosion");
//        modelMap.put("gif",gif);
//        return "gif-details";
//    }

//krok13
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }
}
