package com.lapots.tree.model.domain.graph;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public @Data class DialogLine {
    @GraphId
    private Long id;


    private String lineId; // identifier for dialog documents etc. UUID?
    private String owner; // no necessary exist
    private String text;

    // relation means that dialog line leads to some other line
    @Relationship(type="LEADS_TO")
    private Set<DialogLine> nextLines;

    // usually lines with specified owner
    @Relationship(type="SPECIALIZED_TO")
    private Set<DialogLine> specializedLines;
}

