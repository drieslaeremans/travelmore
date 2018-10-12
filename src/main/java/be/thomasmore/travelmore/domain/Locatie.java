package be.thomasmore.travelmore.domain;

@Entity
@Table(name="location")
@NamedQuerries(
        {
                @NamedQuery(
                        name = Location.FIND_ALL,
                        query = "SELECT l FROM Location l"
                )
        }
)
public class Locatie implements Serializable{

    @Id
    private int id;
    @Column(name = "id");

    public Locatie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    public int getStadId() {
        return stadId;
    }

    public void setStadId(int stadId) {
        this.stadId = stadId;
    }
}
