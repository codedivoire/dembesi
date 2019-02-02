package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.Diction;
import org.codedivoire.dembesi.dictionary.entity.Name;
import org.codedivoire.dembesi.dictionary.repository.DictionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Christian Amani on 23/01/2019.
 */
@Service
public class DictionService implements CRUDService<Diction>,OwnerService<Diction> {

    private final Logger LOG = LoggerFactory.getLogger(DictionService.class);

    private final DictionRepository repository;

    @Autowired
    public DictionService(DictionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Diction> save(Diction diction) {
        LOG.debug("Debut du Process 'save'");
        diction = repository.save(diction);
        return Optional.of(diction);
    }

    @Override
    public Collection<Diction> save(Collection<Diction> dictions) {
        LOG.debug("Debut du Process 'save'");
        return repository.saveAll(dictions);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Diction> find(long id) {
        LOG.debug("Debut du Process 'find'");
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Diction> find() {
        LOG.debug("Debut du Process 'find'");
        return repository.findAll();
    }

    @Override
    public boolean delete(Diction diction) {
        LOG.debug("Debut du Process 'delete'");
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        Optional.of(diction).ifPresent(dict -> {
            dict.getTemporalEventData().setDeleted(LocalDateTime.now());
            save(dict);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }

    public boolean putAudioStream(InputStream inputStream, Diction diction) {
        LOG.debug("Debut du Process 'putAudioStream'");
        if (inputStream != null && diction != null) {
            try {
                int size = inputStream.available();
                byte[] bytes = new byte[size];
                int read = inputStream.read(bytes);
                if (read == -1)
                    return false;
                diction.setAudioStream(bytes);
                save(diction);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                LOG.error(e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Optional<Diction> findByOwner(Name name) {
        return Optional.empty();
    }
}
