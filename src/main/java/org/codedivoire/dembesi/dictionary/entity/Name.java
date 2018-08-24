package org.codedivoire.dembesi.dictionary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author  Christian Amani on 21/08/2018.
 */
@Table(name = "nom")
@Entity
public class Name extends AbstractName {

    @Column(name = "nom")
    private String name;

    public Name() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
