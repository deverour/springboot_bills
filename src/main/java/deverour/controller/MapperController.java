
package deverour.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapperController {
    @Autowired

    @RequestMapping("/queryUser")
    @ResponseBody
    public void queryUser(){
        System.out.println("MapperController");
    }
}
