package deansBeansDataLayer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "degreesofroast", schema = "deansBeans")
public class DegreesOfRoast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DegreeOfRoastID", nullable = false)
    private int degreesOfRoastID;
    
    @Column(name = "RoastType", nullable = false)
    private String roastType;
    
    public DegreesOfRoast(int degreesOfRoastID, String roastType) {
		super();
		this.degreesOfRoastID = degreesOfRoastID;
		this.roastType = roastType;
	}

	public DegreesOfRoast()
    {

    }

    public int getDegreesOfRoastID() {
		return degreesOfRoastID;
	}

	public void setDegreesOfRoastID(int degreesOfRoastID) {
		this.degreesOfRoastID = degreesOfRoastID;
	}

	public String getRoastType() {
		return roastType;
	}

	public void setRoastType(String roastType) {
		this.roastType = roastType;
	}

    public  String toString()
    {
        return roastType;
    }
}
