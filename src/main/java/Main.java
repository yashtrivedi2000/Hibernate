import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) 
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();
		// Inserting Data into table...
		Student s = new Student();
		s.setName("Yash");
		s.setCGPA(8.80f);
		Address address1=new Address();
		address1.setCity("Rajkot");
		address1.setPincode("360002");
		address1.setStreet("Sorathiyawadi");
		
		  Address address2=new Address(); address2.setCity("Ahemdabad");
		  address2.setPincode("380002"); address2.setStreet("ISCON Mall");
		  Set<Address> sets=new HashSet<Address>(); 
		  sets.add(address1);
		  sets.add(address2);
		 
		s.setAddress(sets);
		
		//Transaction
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.save(address1);
		session.save(address2);
		session.getTransaction().commit();
		session.close();

		s = null;
		// Retriving Information...
		Session s2 = sf.openSession();
		s2.beginTransaction();
		s = s2.get(Student.class, 1);
		s2.close();
		System.out.println(s.getName());
	}

}
