package com.lapots.tree.model.service;

import com.lapots.tree.model.domain.graph.DialogLine;
import com.lapots.tree.model.repository.IDialogLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogLineService implements IDialogLineService {

    @Autowired
    private IDialogLineRepository repository;

    @Override
    public DialogLine findById(String id) {
        DialogLine dialogLine = repository.findByLineId(id);
        if (null != dialogLine) {
            return dialogLine;
        } else {
            return null;
        }
    }
}
