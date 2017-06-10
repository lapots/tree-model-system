package com.lapots.tree.model.domain.graph;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public @Data class DialogLine {
    @GraphId
    private Long id; // this ID is internal for Neo4J and prohibited to use I think

    private String lineId; // this id is a persistent id for the whole system

    // lines that displayed with that message
    @Relationship(type="POSSIBLE_SELECTION")
    private Set<DialogLine> nextLines;
}

