package org.codedivoire.core.composant.usermanagement.application.port;

import java.util.List;
import java.util.UUID;
import org.codedivoire.core.composant.usermanagement.domaine.entity.ProfilePhysique;
import org.codedivoire.core.composant.usermanagement.domaine.entity.User;

/**
 * Port du repository de l'entité {@link User}
 *
 * @author Christian Amani 2019-10-24
 */
public interface UserRepositoryPort {

  User rechercherParLogin(String login);

  User rechercherParId(UUID id);

  void enregistrer(User user);

  void enregistrerAvecPersonnePhysiqueEtMorale(User user,
      ProfilePhysique personnePhysique, UUID personneMoraleId);

  void enregistrerAvecPersonneMorale(User user, ProfilePhysique personneMorale);

  List<User> rechercherParTenantId(UUID tenantId);

  void supprimerParId(UUID utilisateurId);
}
