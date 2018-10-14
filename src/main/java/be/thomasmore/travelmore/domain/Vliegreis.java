package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vliegreis")
public class Vliegreis extends Reis {

    @Column(name = "vertrekLuchthaven")
    private String vertrekLuchthaven;
    @Column(name = "aankomstLuchthaven")
    private String aankomstLuchthaven;

    public Vliegreis() {
    }

    public String getVertrekLuchthaven() {
        return vertrekLuchthaven;
    }

    public void setVertrekLuchthaven(String vertrekLuchthaven) {
        this.vertrekLuchthaven = vertrekLuchthaven;
    }

    public String getAankomstLuchthaven() {
        return aankomstLuchthaven;
    }

    public void setAankomstLuchthaven(String aankomstLuchthaven) {
        this.aankomstLuchthaven = aankomstLuchthaven;
    }
}
