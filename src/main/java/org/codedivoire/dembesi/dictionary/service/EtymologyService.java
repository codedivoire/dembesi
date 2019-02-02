package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.Etymology;
import org.codedivoire.dembesi.dictionary.repository.EtymologyRepository;
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
public class EtymologyService implements CRUDService<Etymology> {

    private Logger LOG = LoggerFactory.getLogger(EtymologyService.class);

    private final EtymologyRepository repository;

    @Autowired
    public EtymologyService(EtymologyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Etymology> save(Etymology etymology) {
        LOG.debug("Debut du Process 'save'");
        etymology = repository.save(etymology);
        return Optional.of(etymology);
    }

    @Override
    public Collection<Etymology> save(Collection<Etymology> etymologies) {
        LOG.debug("Debut du Process 'save'");
        return repository.saveAll(etymologies);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Etymology> find(long id) {
        LOG.debug("Debut du Process 'find'");
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Etymology> find() {
        LOG.debug("Debut du Process 'find'");
        return repository.findAll();
    }

    @Override
    public boolean delete(Etymology etymology) {
        LOG.debug("Debut du Process 'delete'");
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        Optional.of(etymology).ifPresent(ety -> {
            ety.getTemporalEventData().setDeleted(LocalDateTime.now());
            save(ety);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }
}
