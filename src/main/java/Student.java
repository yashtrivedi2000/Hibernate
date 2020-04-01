import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Student {
	
	@Id @GeneratedValue
	private int student_id;
	private String name;
	private float CGPA;
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "Address",
		joinColumns = @JoinColumn(name="student_id")
			)
	@GenericGenerator(name="increment", strategy = "increment")
	@CollectionId( columns = { @Column }, generator = "increment" , type = @Type(type = "int") )
	private Collection<Address> listOfAddress=new ArrayList<Address>();
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCGPA() {
		return CGPA;
	}
	public void setCGPA(float cGPA) {
		CGPA = cGPA;
	}
}
