package com.example.main;

import com.example.main.application.dto.PostDto;
import com.example.utils.api.ApiResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/index-request")
    public String indexRequest(@RequestBody PostDto postDto) {
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

    /**
     * @return ResponseEntity
     */
    @ResponseBody
    @GetMapping(value = "/index-rest2")
    public ResponseEntity indexRest2() {
        //@ResponseBody 어노테이션은 return type 앞에 위치한것보다 현재의 형태가 제일 깔끔해 보인다
        return ApiResponseEntity
                .builder()
                .ok();
    }

}
