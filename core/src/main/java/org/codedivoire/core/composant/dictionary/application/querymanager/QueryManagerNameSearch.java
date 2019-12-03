package org.codedivoire.core.composant.dictionary.application.querymanager;

import java.util.List;
import org.codedivoire.core.composant.dictionary.application.port.NameSearchServicePort;
import org.codedivoire.core.composant.dictionary.application.vm.SearchResultName;
import org.codedivoire.core.kernelshared.CommandQuery;

/**
 * @author Christian Amani 2019-12-01
 */
public class QueryManagerNameSearch implements CommandQuery<String, List<SearchResultName>> {

  private NameSearchServicePort nameSearchServicePort;

  public QueryManagerNameSearch(
      NameSearchServicePort nameSearchServicePort) {
    this.nameSearchServicePort = nameSearchServicePort;
  }

  @Override
  public List<SearchResultName> query(String term) {
    return nameSearchServicePort.search(term);
  }
}
