package org.codedivoire.core.subdomains.usermanagement.domain.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.codedivoire.core.subdomains.usermanagement.domain.exception.PasswordAlreadyUsed;

/**
 * Entité utilisateur
 *
 * @author Christian Amani 2019-11-24
 */
public class User implements Serializable {

  private UUID id;
  private String login;
  private String password;
  private Instant theLastChangeDatePassword;
  private boolean active;
  private boolean lock;
  private boolean connected;
  private UserProfile userProfile;
  private UserGroup userGroup;
  private List<Permission> permissions = new ArrayList<>();
  private List<HistoryPassword> historyPasswords = new ArrayList<>();

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Instant getTheLastChangeDatePassword() {
    return theLastChangeDatePassword;
  }

  public void setTheLastChangeDatePassword(Instant theLastChangeDatePassword) {
    this.theLastChangeDatePassword = theLastChangeDatePassword;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public boolean isLock() {
    return lock;
  }

  public void setLock(boolean lock) {
    this.lock = lock;
  }

  public void setUserProfile(UserProfile personne) {
    userProfile = personne;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }


  public UserProfile createUserProfile(
      String lastName, String firstName, String email, String urlLogo) {
    UserProfile userProfile = new UserProfile();
    userProfile.setLastName(lastName);
    userProfile.setFirstName(firstName);
    userProfile.setEmail(email);
    userProfile.setLogoUrl(urlLogo);
    this.userProfile = userProfile;
    return userProfile;
  }


  public void addPermission(Permission permission) {
    boolean estContenu = permissions.contains(permission);
    if (!estContenu) {
      permissions.add(permission);
    }
  }

  public Set<String> getPermissions() {
    Set<String> groupePermissions = userGroup.getPermissions().stream()
        .map(Permission::getLabel)
        .collect(Collectors.toSet());
    List<String> permissions = this.permissions.stream()
        .map(Permission::getLabel)
        .collect(Collectors.toList());
    groupePermissions.addAll(permissions);
    return groupePermissions;
  }

  public boolean isConnected() {
    return connected;
  }

  public void setConnected(boolean connected) {
    this.connected = connected;
  }

  public List<HistoryPassword> getHistoryPasswords() {
    return historyPasswords;
  }

  public void setHistoryPasswords(
      List<HistoryPassword> historyPasswords) {
    this.historyPasswords = historyPasswords;
  }

  public void addNewHistoryPassword(HistoryPassword historyPassword) {
    if (historyPassword != null) {
      historyPasswords.add(historyPassword);
    }
  }

  public HistoryPassword historizePassword(String newPassword) {
    boolean alreadyUse = isAlreadyUse(newPassword);
    if (!alreadyUse) {
      HistoryPassword historyPassword = new HistoryPassword();
      historyPassword.setUser(this);
      historyPassword.setPassword(password);
      return historyPassword;
    }
    throw new PasswordAlreadyUsed();
  }

  private boolean isAlreadyUse(String nouveauMotPasse) {
    return historyPasswords.stream()
        .map(historyPassword -> historyPassword.getPassword())
        .anyMatch(ancienMotPasse -> ancienMotPasse.equals(nouveauMotPasse));
  }

  public void setUserGroup(UserGroup userGroup) {
    this.userGroup = userGroup;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User that = (User) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, login, password, theLastChangeDatePassword, active, lock, connected,
            userProfile, userGroup, permissions, historyPasswords);
  }

}
