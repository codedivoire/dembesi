package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.Definition;
import org.codedivoire.dembesi.dictionary.entity.Name;
import org.codedivoire.dembesi.dictionary.repository.DefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Christian Amani on 23/01/2019.
 */
@Service
public class DefinitionService implements CRUDService<Definition>,OwnerService<Definition> {

    private final Logger LOG = LoggerFactory.getLogger(DefinitionService.class);
    private final DefinitionRepository repository;

    @Autowired
    public DefinitionService(DefinitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Definition> save(Definition definition) {
        LOG.debug("Debut du Process 'save'");
        definition = repository.save(definition);
        return Optional.of(definition);
    }

    @Override
    public Collection<Definition> save(Collection<Definition> definitions) {
        LOG.debug("Debut du Process 'save'");
        return repository.saveAll(definitions);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Definition> find(long id) {
        LOG.debug("Debut du Process 'find'");
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Definition> find() {
        LOG.debug("Debut du Process 'find'");
        return repository.findAll();
    }

    @Override
    public boolean delete(Definition definition) {
        LOG.debug("Debut du Process 'delete'");
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        Optional.of(definition).ifPresent(def -> {
            def.getTemporalEventData().setDeleted(LocalDateTime.now());
            save(definition);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }

    @Override
    public Optional<Definition> findByOwner(Name name) {
        return repository.findByOwner(name);
    }
}
