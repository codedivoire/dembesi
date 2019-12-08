package org.codedivoire.core.subdomains.dictionary.application.querymanager;

import java.util.List;
import org.codedivoire.core.kernelshared.CommandQuery;
import org.codedivoire.core.subdomains.dictionary.application.port.NameSearchServicePort;
import org.codedivoire.core.subdomains.dictionary.application.vm.SearchResultName;

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
