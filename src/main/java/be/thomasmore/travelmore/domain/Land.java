package be.thomasmore.travelmore.domain;

@Entity
@DiscriminatorValue("Land")
@Table(name="location")
public class Land extends Locatie implements Serializable{

    @Id
    private int id;
    @Column(name = "id")

    private String naam;
    @Column(name = "naam")
    @size(min=0, max=30)

    public Land() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
