package org.codedivoire.dembesi.common.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Christian Amani on 22/01/2019.
 */
public class DataResponse {

    private String domain;

    private Object item;

    private List<Object> items = new ArrayList<>();

    private Map groupedItems = new HashMap();

    private int totalItems;

    private int totalGroupedItems;

    public DataResponse() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Map getGroupedItems() {
        return groupedItems;
    }

    public void setGroupedItems(Map groupedItems) {
        this.groupedItems = groupedItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalGroupedItems() {
        return totalGroupedItems;
    }

    public void setTotalGroupedItems(int totalGroupedItems) {
        this.totalGroupedItems = totalGroupedItems;
    }
}
