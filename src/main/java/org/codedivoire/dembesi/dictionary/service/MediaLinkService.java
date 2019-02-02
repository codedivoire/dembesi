package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.MediaLink;
import org.codedivoire.dembesi.dictionary.repository.MediaLinkRepository;
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
public class MediaLinkService implements CRUDService<MediaLink> {

    private final Logger LOG = LoggerFactory.getLogger(MediaLinkService.class);

    private final MediaLinkRepository repository;

    @Autowired
    public MediaLinkService(MediaLinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<MediaLink> save(MediaLink mediaLink) {
        LOG.debug("Debut du Process 'save'");
        mediaLink = repository.save(mediaLink);
        return Optional.of(mediaLink);
    }

    @Override
    public Collection<MediaLink> save(Collection<MediaLink> mediaLinks) {
        LOG.debug("Debut du Process 'save'");
        return repository.saveAll(mediaLinks);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MediaLink> find(long id) {
        LOG.debug("Debut du Process 'find'");
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<MediaLink> find() {
        LOG.debug("Debut du Process 'find'");
        return repository.findAll();
    }

    @Override
    public boolean delete(MediaLink mediaLink) {
        LOG.debug("Debut du Process 'delete'");
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        Optional.of(mediaLink).ifPresent(media -> {
            media.getTemporalEventData().setDeleted(LocalDateTime.now());
            save(media);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }
}
