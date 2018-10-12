package be.thomasmore.travelmore.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
@DiscriminatorValue("Administrator")
public class Administrator extends Gebruiker {
    public Administrator() {
    }
}
