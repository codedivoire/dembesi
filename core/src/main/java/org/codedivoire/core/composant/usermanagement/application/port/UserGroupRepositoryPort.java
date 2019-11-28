package org.codedivoire.core.composant.usermanagement.application.port;

import java.util.List;
import java.util.UUID;
import org.codedivoire.core.composant.usermanagement.domaine.entity.UserGroup;

/**
 * Port du repository de l'entité {@link UserGroup}
 *
 * @author Christian Amani 2019-11-24
 */
public interface UserGroupRepositoryPort {

  void enregistrer(UserGroup groupeUtilisateur);

  List<UserGroup> rechercherTous();

  UserGroup rechercherParId(UUID id);

  UserGroup rechercherParLibelle(String libelle);

  void supprimerParId(UUID id);
}

