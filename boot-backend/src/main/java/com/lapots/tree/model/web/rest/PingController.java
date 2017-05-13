package com.lapots.tree.model.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class PingController {

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(value="/tree-model-rest/ping", method= RequestMethod.GET, produces="application/json")
    public @ResponseBody String ping() {
        return "{ \"response\" : \"true\" }";
    }

}
