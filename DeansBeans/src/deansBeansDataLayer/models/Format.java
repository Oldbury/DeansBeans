package deansBeansDataLayer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formats", schema = "deansBeans")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FormatID", nullable = false)
    private int formatID;
    
    @Column(name = "FormatDescription", nullable = false)
    private String formatDescription;
    
    public Format(int formatID, String formatDescription) {
		super();
		this.formatID = formatID;
		this.formatDescription = formatDescription;
	}

	public Format()
    {

    }

    public int getFormatID() {
		return formatID;
	}

	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}

	public String getFormatDescription() {
		return formatDescription;
	}

	public void setFormatDescription(String formatDescription) {
		this.formatDescription = formatDescription;
	}

    public  String toString()
    {
        return formatDescription;
    }
}
