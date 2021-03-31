import java.util.Hashtable;
import java.util.Stack;

public class CliqueBeliefs {
	CliquePotentials clique; 
	Message message;
	
	Hashtable<String, Integer> cliqueBelief = new Hashtable<>();

	//init cliqueBeliefs with clique and message
	public CliqueBeliefs(CliquePotentials clique, Message message) {
		this.clique = clique;
		this.message = message;
		calculateCliqueBelief();
	}
	
	static int sum = 1;
	
	private void calculateCliqueBelief() {
		Hashtable<String, Integer> cliqueValue = clique.getCliquePotentialValue();
		Hashtable<String, Integer> messageValue = message.getMessage();
		Stack<Integer> messageVariable = message.getValueVariable();
		
		//check each clique Value with each message Value
		cliqueValue.forEach((k,v) ->{
			if(messageVariable.size() == 1) {
				
				
				String result = k.substring(messageVariable.peek(),messageVariable.peek()+1); 
				messageValue.forEach((k1,v1) ->{
					//if variable are identical muplitply the values
					if(result.equals(k1)) {
						sum = sum * v;
						//System.out.println(result + ": "+ sum);
					}
			

				});
				
				//when all values are multiplied, then store to cliqueBelief table
				cliqueBelief.put(k, sum);
				sum = 1;
			} //if ends

			
			//the same manipulation, but for two variable
			if(messageVariable.size() == 2) {
				int indexEnd = messageVariable.pop();
				int indexStart = messageVariable.pop();
				String result =  k.substring(indexStart, indexEnd+1);
				messageValue.forEach((k1,v1) ->{
					
					if(result.equals(k1)) {
						sum = sum * v;
					}
				
				});
				messageVariable.push(indexStart);
				messageVariable.push(indexEnd);
				cliqueBelief.put(k, sum);
				sum = 1;
			}
		});
	}

	@Override
	public String toString() {
		return "CliqueBeliefs "+ clique.getNameOfFactors() + " [cliqueBelief=" + cliqueBelief + "]";
	}
	
	
	
	

}
