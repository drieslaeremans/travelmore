package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reis")
public class Reis {

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "datumVertrek")
    private Date datumVertrek;
    @Column(name = "datumAankomst")
    private Date datumTerug;
    @Column(name = "prijsPerPersoon")
    private double prijsPerPersoon;

}
