package org.codedivoire.core.composant.dictionary.domain.valueobject;

/**
 * Représentant les différents états q'une information peux posséder
 *
 * @author Christian Amani 2019-11-24
 */
public enum State {

  /**
   * L’information vient d'être ajoutée au système. Non visible pour les utilisateurs qui
   * recherchent encore
   */
  NEW,
  /**
   * Les information ont été indexées dans le moteur de recherche, donc publiées et les utilisateurs
   * peuvent les trouver lorsqu'ils les recherchent.
   */
  PUBLISHED,
  /**
   * Une information qui a été initialement publiée mais qui a été supprimée de l'index.
   */
  UNPUBLISHED,
  /**
   * Les information publiées (indexées dans le moteur de recherche) ont été modifiées et doivent
   * donc être indexées.
   */
  MODIFIED,
  /**
   * Une information soumise par un utilisateur anonyme (indexé dans le moteur de recherche) a été
   * modifiée et doit donc être réindexée.
   */
  SUGGESTED;
}
