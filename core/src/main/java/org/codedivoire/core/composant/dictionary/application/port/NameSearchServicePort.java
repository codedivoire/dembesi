package org.codedivoire.core.composant.dictionary.application.port;

import java.util.List;
import org.codedivoire.core.composant.dictionary.application.vm.SearchResultName;

/**
 * Service pour la recherche de nom
 *
 * @author Christian Amani 2019-12-01
 */
public interface NameSearchServicePort {

  List<SearchResultName> search(String term);
}
