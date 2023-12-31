package com.example.main;

import com.example.utils.api.ApiResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {

    /**
     * @return only view
     */
    @GetMapping(value = "/index")
    public String index(){
        return "/user/index";
    }

    /**
     * @param model parameter
     * @return view and data(model) return
     */
    @GetMapping(value = "/index-model")
    public String indexModel(Model model){
        model.addAttribute("user", "");
        return "/user/index";
    }

    /**
     * @param model parameter
     * @param userName parameter
     * @return view and data return
     */
    @GetMapping(value = "/index-param")
    public String indexParam(Model model, @RequestParam("userName") String userName){
        model.addAttribute("user", userName);
        return "/user/index";
    }

    /**
     * @return ResponseEntity
     */
    @GetMapping(value = "/index-rest")
    public @ResponseBody ResponseEntity indexRest() {
        //json type으로 반환하기 위하여 @ResponseBody 어노테이션이 필요함
        return ApiResponseEntity
                .builder()
                .ok();
    }

}
