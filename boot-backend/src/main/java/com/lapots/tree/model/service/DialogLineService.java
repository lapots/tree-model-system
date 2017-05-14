package com.lapots.tree.model.service;

import com.lapots.tree.model.domain.graph.DialogLine;
import com.lapots.tree.model.domain.support.NullObjectFactory;
import com.lapots.tree.model.repository.IDialogLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.lapots.tree.model.domain.support.NullObjectFactory.LIST_NB;

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
            return (DialogLine) NullObjectFactory.nullObjectByName(NullObjectFactory.DIALOG_LINE_NB);
        }
    }

    @Override
    public List<DialogLine> findByOwner(String owner) {
        Collection<DialogLine> dialogLines = repository.findByOwner(owner);
        if (null == dialogLines || dialogLines.isEmpty()) {
            return (List<DialogLine>) NullObjectFactory.nullObjectByName(LIST_NB);
        } else {
            return new ArrayList<>(dialogLines);
        }
    }
}
