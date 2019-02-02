package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.dictionary.entity.GeoLocation;
import org.codedivoire.dembesi.dictionary.repository.GeoLocationRepository;
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
public class GeoLocationService implements CRUDService<GeoLocation> {

    private final Logger LOG = LoggerFactory.getLogger(GeoLocationService.class);

    private final GeoLocationRepository repository;

    @Autowired
    public GeoLocationService(GeoLocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<GeoLocation> save(GeoLocation geoLocation) {
        LOG.debug("Debut du Process 'save'");
        geoLocation = repository.save(geoLocation);
        return Optional.of(geoLocation);
    }

    @Override
    public Collection<GeoLocation> save(Collection<GeoLocation> geoLocations) {
        LOG.debug("Debut du Process 'save'");
        return repository.saveAll(geoLocations);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<GeoLocation> find(long id) {
        LOG.debug("Debut du Process 'save'");
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<GeoLocation> find() {
        LOG.debug("Debut du Process 'save'");
        return repository.findAll();
    }

    @Override
    public boolean delete(GeoLocation geoLocation) {
        LOG.debug("Debut du Process 'save'");
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        Optional.of(geoLocation).ifPresent(location -> {
            location.getTemporalEventData().setDeleted(LocalDateTime.now());
            save(location);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }
}
