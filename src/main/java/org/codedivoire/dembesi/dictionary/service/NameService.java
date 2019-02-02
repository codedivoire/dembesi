package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.Name;
import org.codedivoire.dembesi.dictionary.repository.NameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Christian Amani on 23/01/2019.
 */
@Service
public class NameService implements CRUDService<Name>{

    private final Logger LOG = LoggerFactory.getLogger(NameService.class);

    private final NameRepository repository;

    @Autowired
    public NameService(NameRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Name> save(Name name) {
        LOG.debug("Debut du Process 'save'");
        name = repository.save(name);
        return Optional.of(name);
    }

    @Override
    public Collection<Name> save(Collection<Name> names) {
        LOG.debug("Debut du Process 'save'");
        return repository.saveAll(names);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Name> find(long id) {
        LOG.debug("Debut du Process 'find'");
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Name> find() {
        LOG.debug("Debut du Process 'find'");
        return repository.findAll();
    }

    @Override
    public boolean delete(Name name) {
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        Optional.of(name).ifPresent(value -> {
            value.getTemporalEventData().setDeleted(LocalDateTime.now());
            save(value);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }
}
