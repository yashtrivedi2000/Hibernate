import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Student {
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
	@Id @GeneratedValue
	private int student_id;
	private String name;
	private float CGPA;
	/*
	 * @Embedded private Address address;
	 */
	@ElementCollection
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
	
	//@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	//@CollectionId(columns = { @Column(name="Address_ID") }, generator = "native", type = @Type(type="int"))
	
	 
	
	/*
	 * public Address getAddress() { return address; } 
	 * public void setAddress(Address address) { this.address = address; }
	 */
}
