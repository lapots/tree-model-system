package com.lapots.tree.model.domain.support;

import com.lapots.tree.model.domain.graph.DialogLine;

import java.util.Collections;

public class NullObjectFactory {

    public static final String DIALOG_LINE_NB = "dl";
    public static final String LIST_NB = "list";

    public static Object nullObjectByName(String name) {
        if (name.equals(DIALOG_LINE_NB)) {
            return new DialogLine();
        } else if (name.equals(LIST_NB)) {
            return Collections.<DialogLine>emptyList();
        } else {
            throw new IllegalArgumentException("No [" + name + "] found!");
        }
    }
}
