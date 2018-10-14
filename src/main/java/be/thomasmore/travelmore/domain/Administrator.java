package be.thomasmore.travelmore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends Gebruiker {
    public Administrator() {
    }
}
