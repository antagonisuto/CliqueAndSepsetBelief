import java.util.Arrays;
import java.util.Hashtable;

public class CliquePotentials {
	int factor1;
	int factor2;
	int factor3;
	Factor f1;
	Factor f2;
	Hashtable<String, Integer> cliquePotentialValue = new Hashtable<>();
	
	//init two factor
	public CliquePotentials(Factor factor1, Factor factor2) {
		this.f1 = factor1;
		this.f2 = factor2;
		
		//call method to store values
		initCliquePotentialValue();
	}

	private void initCliquePotentialValue() {
		//check common value of two factors
		if(f1.value1 == f2.value1) {
			/*AB 0 == AC 0
			 * AB 00 * AC 00 = 000
			 * 00 * 01 = 001
			 * 01 * 00 = 010
			 * 01 * 01 = 011
			 * 
			 * 10 * 10 = 100
			 * 10 * 11 = 101
			 * 11 * 10 = 110
			 * 11 * 11 = 111
			 * */
			
			this.factor1 = f1.value1;
			this.factor2 = f1.value2;
			this.factor3 = f2.value2;
			cliquePotentialValue.put("000", f1.getFactors().get("00")*f2.getFactors().get("00"));
			cliquePotentialValue.put("001", f1.getFactors().get("00")*f2.getFactors().get("01"));
			cliquePotentialValue.put("010", f1.getFactors().get("01")*f2.getFactors().get("00"));
			cliquePotentialValue.put("011", f1.getFactors().get("01")*f2.getFactors().get("01"));
			
			cliquePotentialValue.put("100", f1.getFactors().get("10")*f2.getFactors().get("10"));
			cliquePotentialValue.put("101", f1.getFactors().get("10")*f2.getFactors().get("11"));
			cliquePotentialValue.put("110", f1.getFactors().get("11")*f2.getFactors().get("10"));
			cliquePotentialValue.put("111", f1.getFactors().get("11")*f2.getFactors().get("11"));
		} else if(f1.value1 == f2.value2) {
			/* 0 == 1
			 * AB(00) * CA(00) = ABC (000)
			 * AB(00) * CA(10) = ABC (001)
			 * AB(01) * CA(00) = ABC (010)
			 * AB(01) * CA(10) = ABC (011)
			 * 
			 * AB(10) * CA(01) = ABC (100)
			 * AB(10) * CA(11) = ABC (101)
			 * AB(11) * CA(01) = ABC (110)
			 * AB(11) * CA(11) = ABC (111)
			 */
			this.factor1 = f1.value1;
			this.factor2 = f1.value2;
			this.factor3 = f2.value1;
			cliquePotentialValue.put("000", f1.getFactors().get("00")*f2.getFactors().get("00"));
			cliquePotentialValue.put("001", f1.getFactors().get("00")*f2.getFactors().get("10"));
			cliquePotentialValue.put("010", f1.getFactors().get("01")*f2.getFactors().get("00"));
			cliquePotentialValue.put("011", f1.getFactors().get("01")*f2.getFactors().get("10"));
			
			cliquePotentialValue.put("100", f1.getFactors().get("10")*f2.getFactors().get("01"));
			cliquePotentialValue.put("101", f1.getFactors().get("10")*f2.getFactors().get("11"));
			cliquePotentialValue.put("110", f1.getFactors().get("11")*f2.getFactors().get("01"));
			cliquePotentialValue.put("111", f1.getFactors().get("11")*f2.getFactors().get("11"));
		} else if(f1.value2 == f2.value1) {
			/* 1 == 0
			 * BA(00) * AC(00) = ABC (000)
			 * BA(00) * AC(01) = ABC (001)
			 * BA(10) * AC(00) = ABC (010)
			 * BA(10) * AC(01) = ABC (011)
			 * 
			 * BA(01) * AC(10) = ABC (100)
			 * BA(10) * AC(11) = ABC (101)
			 * BA(11) * AC(10) = ABC (110)
			 * BA(11) * AC(11) = ABC (111)
			 */
			this.factor1 = f1.value2;
			this.factor2 = f1.value1;
			this.factor3 = f2.value2;
			cliquePotentialValue.put("000", f1.getFactors().get("00")*f2.getFactors().get("00"));
			cliquePotentialValue.put("001", f1.getFactors().get("00")*f2.getFactors().get("01"));
			cliquePotentialValue.put("010", f1.getFactors().get("10")*f2.getFactors().get("00"));
			cliquePotentialValue.put("011", f1.getFactors().get("10")*f2.getFactors().get("01"));
			
			cliquePotentialValue.put("100", f1.getFactors().get("01")*f2.getFactors().get("10"));
			cliquePotentialValue.put("101", f1.getFactors().get("10")*f2.getFactors().get("11"));
			cliquePotentialValue.put("110", f1.getFactors().get("11")*f2.getFactors().get("10"));
			cliquePotentialValue.put("111", f1.getFactors().get("11")*f2.getFactors().get("11"));		
		} else if (f1.value2 == f2.value2) {
			/* 1 == 1
			 * BA(00) * CA(00) = ABC (000)
			 * BA(00) * CA(10) = ABC (001)
			 * BA(10) * CA(00) = ABC (010)
			 * BA(10) * CA(10) = ABC (011)
			 * 
			 * BA(01) * CA(01) = ABC (100)
			 * BA(01) * CA(11) = ABC (101)
			 * BA(11) * CA(01) = ABC (110)
			 * BA(11) * CA(11) = ABC (111)
			 */
			this.factor1 = f1.value2;
			this.factor2 = f1.value1;
			this.factor3 = f2.value1;
			cliquePotentialValue.put("000", f1.getFactors().get("00")*f2.getFactors().get("00"));
			cliquePotentialValue.put("001", f1.getFactors().get("00")*f2.getFactors().get("10"));
			cliquePotentialValue.put("010", f1.getFactors().get("10")*f2.getFactors().get("00"));
			cliquePotentialValue.put("011", f1.getFactors().get("10")*f2.getFactors().get("10"));
			
			cliquePotentialValue.put("100", f1.getFactors().get("01")*f2.getFactors().get("01"));
			cliquePotentialValue.put("101", f1.getFactors().get("01")*f2.getFactors().get("11"));
			cliquePotentialValue.put("110", f1.getFactors().get("11")*f2.getFactors().get("01"));
			cliquePotentialValue.put("111", f1.getFactors().get("11")*f2.getFactors().get("11"));		
		}
		
		if(cliquePotentialValue.size() != 8) {
			System.out.println("Something wrong with cliquePotentials");
		}
		
	}

	public int[] getValueOfFactors() {
		return new int[] {factor1, factor2, factor3};
	}
	
	public String getNameOfFactors() {
		return "[" + factor1 + ", " + factor2 +", "+ factor3 +"]";
	}

	@Override
	public String toString() {
		return Arrays.toString(getValueOfFactors());
	}
	
	public String getNameClique() {
		return "Clique Potentials " +Arrays.toString(getValueOfFactors()) + " [ values= "+cliquePotentialValue +" ]";
	}

	public Hashtable<String, Integer> getCliquePotentialValue() {
		return cliquePotentialValue;
	}

}
