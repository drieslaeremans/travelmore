package be.thomasmore.travelmore.domain;

@Entity
@DiscriminatorValue("Stad")
@Table(name="location")
public class Stad extends Loactie implements Serializable{

    @Id
    private int id;
    @column(name="id")

    private String naam;
    @Column(name="naam")
    @size(min=0, max=30)

    public Stad() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
