package org.codedivoire.apirest.config.audit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.codedivoire.apirest.entity.PersistentAuditEvent;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Christian Amani
 */
@Component
public class AuditEventConverter {

    /**
     * Convertir une liste de {@link PersistentAuditEvent}s à une liste de {@link AuditEvent}s.
     *
     * @param persistentAuditEvents la liste à convertir
     * @return la liste convertie
     */
    public List<AuditEvent> convertToAuditEvent(Iterable<PersistentAuditEvent> persistentAuditEvents) {
        if (persistentAuditEvents == null) {
            return Collections.emptyList();
        }
        List<AuditEvent> auditEvents = new ArrayList<>();
        for (PersistentAuditEvent persistentAuditEvent : persistentAuditEvents) {
            auditEvents.add(convertToAuditEvent(persistentAuditEvent));
        }
        return auditEvents;
    }

    /**
     * Convertir un {@link PersistentAuditEvent} en {@link AuditEvent}.
     *
     * @param persistentAuditEvent l'évenement à convertir
     * @return l'élément converti
     */
    public AuditEvent convertToAuditEvent(PersistentAuditEvent persistentAuditEvent) {
        if (persistentAuditEvent == null) {
            return null;
        }
        return new AuditEvent(persistentAuditEvent.getAuditEventDate(), persistentAuditEvent.getPrincipal(),
            persistentAuditEvent.getAuditEventType(), convertDataToObjects(persistentAuditEvent.getData()));
    }

    /**
     * Conversion interne. Cela est nécessaire pour prendre en charge l'interface actuelle {@code AuditEventRepository}
     * de l'actionneur SpringBoot.
     *
     * @param data la donnée à convertir
     * @return un map de {@link String}, {@link Object}.
     */
    public Map<String, Object> convertDataToObjects(Map<String, String> data) {
        Map<String, Object> results = new HashMap<>();

        if (data != null) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                results.put(entry.getKey(), entry.getValue());
            }
        }
        return results;
    }

    /**
     * Conversion interne. Cette méthode permettra de sauvegarder des données supplémentaires.
     * Par défaut, l'objet sera sauvegardé sous forme de chaîne.
     *
     * @param data the data to convert.
     * @return un map de {@link String}, {@link String}.
     */
    public Map<String, String> convertDataToStrings(Map<String, Object> data) {
        Map<String, String> results = new HashMap<>();

        if (data != null) {
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                // Extraire les données qui devront être sauvegardées
                if (entry.getValue() instanceof WebAuthenticationDetails) {
                    WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) entry.getValue();
                    results.put("remoteAddress", authenticationDetails.getRemoteAddress());
                    results.put("sessionId", authenticationDetails.getSessionId());
                } else {
                    results.put(entry.getKey(), Objects.toString(entry.getValue()));
                }
            }
        }
        return results;
    }
}
