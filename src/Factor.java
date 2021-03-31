import java.util.Hashtable;

public class Factor {
	int value1;
	int value2;
	
	//variable to store a factor value
	Hashtable<String, Integer> factors = new Hashtable<>();
	
	//init factor variables
	public Factor(int value1, int value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}
	
	//assign values to factor
	public void setFactors(int factorValue1, int factorValue2, int factorValue3, int factorValue4) {
		factors.put("00", factorValue1);
		factors.put("01", factorValue2);
		factors.put("10", factorValue3);
		factors.put("11", factorValue4);
	}

	public int[] getValues() {
		return new int[] {value1, value2};
	}

	
	public Hashtable<String, Integer> getFactors() {
		return factors;
	}
}
