import java.util.Hashtable;

public class SepsetBeliefs {
	Message m1; 
	Message m2;
	
	Hashtable<String, Long> sepsetBelief = new Hashtable<>();
	
	
	public SepsetBeliefs(Message m1, Message m2) {
		this.m1 = m1;
		this.m2 = m2;
		calculateSepsetBelief();
	}


	private void calculateSepsetBelief() {
		Hashtable<String, Integer> s1 = m1.getMessage();
		Hashtable<String, Integer> s2 = m2.getMessage();
		
		//for each value from message1 from clique1 to clique2 and vise verse, multiply values
		s1.forEach((k,v) -> {
			int value = s2.get(k);
			//changed to long because the data doesn't fit to int (too big numbers)
			sepsetBelief.put(k, ((long)v* (long)value));
			//System.out.println(v+ " * " + value + " = " + v*value);
		});
		
		
	}


	@Override
	public String toString() {
		return "SepsetBeliefs "+ m1.nameVariable+ " [sepsetBelief=" + sepsetBelief + "]";
	} 
	

}
