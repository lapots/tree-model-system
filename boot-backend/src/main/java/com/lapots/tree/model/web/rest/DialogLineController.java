package com.lapots.tree.model.web.rest;

import com.lapots.tree.model.domain.graph.DialogLine;
import com.lapots.tree.model.service.IDialogLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DialogLineController {

    @Autowired
    private IDialogLineService service;

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(value="/tree-model-rest/dialog/{id}", method= RequestMethod.GET, produces="application/json")
    public @ResponseBody DialogLine findDialogLine(@PathVariable String id) {
        return service.findById(id);
    }
}
