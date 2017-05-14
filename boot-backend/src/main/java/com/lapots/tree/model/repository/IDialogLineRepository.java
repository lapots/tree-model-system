package com.lapots.tree.model.repository;

import com.lapots.tree.model.domain.graph.DialogLine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IDialogLineRepository extends Neo4jRepository<DialogLine, String> {

    /**
     * Returns dialog line by id.
     *
     * @param id dialog line id
     * @return dialog line
     */
    DialogLine findByLineId(String id);

    /**
     * Returns all dialog lines that belong to the owner.
     * @param owner owner
     * @return dialog line collection
     */
    Collection<DialogLine> findByOwner(String owner);
}
