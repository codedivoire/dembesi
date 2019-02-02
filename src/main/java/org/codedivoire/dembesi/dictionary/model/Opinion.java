package org.codedivoire.dembesi.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Christian Amani on 23/01/2019.
 */
@Embeddable
public class Opinion {

    @Column(name = "contre")
    private int reject;

    @Column(name = "pour")
    private int favor;

    public Opinion() {
    }

    public int getReject() {
        return reject;
    }

    public void setReject(int reject) {
        this.reject = reject;
    }

    public int getFavor() {
        return favor;
    }

    public void setFavor(int favor) {
        this.favor = favor;
    }

    public int incrementReject() {
        reject += 1;
        return reject;
    }

    public int decrementReject() {
        reject -= 1;
        return reject;
    }

    public int incrementFavor() {
        favor += 1;
        return favor;
    }

    public int decrementFavor() {
        favor -= 1;
        return favor;
    }
}
