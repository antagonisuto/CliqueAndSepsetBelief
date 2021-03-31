import java.util.Hashtable;
import java.util.Stack;

public class Message {
	CliquePotentials clique;
	CliquePotentials toClique;
	Stack<Integer> valueVariable = new Stack<>();
	Stack<Integer> nameVariable = new Stack<>();

	Hashtable<String, Integer> message = new Hashtable<>(); 
	
	//init a message class 
	public Message(CliquePotentials clique, CliquePotentials toClique) {
		this.clique = clique;
		this.toClique = toClique;
		
		//nameOfFactors
		int[] value1 = clique.getValueOfFactors();
		int[] value2 = toClique.getValueOfFactors();
		
		//message.putAll(clique.cliquePotentialValue);

		//check which variables are common to send
		for(int i=0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(value1[i] == value2[j]) {
					valueVariable.push(i);
					nameVariable.push(value1[i]);
				}
			}
		}

		sendMessage(clique);
	}
	
	
	/* 
	 * 1.variable eliminate
	 * 2.save to message
	 * */
	static int sum = 0;
	
	private void sendMessage(CliquePotentials clique) {
		
		//iterate clique, for each value 
		clique.cliquePotentialValue.forEach((k,v) ->{
			
			//if there is only one common variable
			if(valueVariable.size() == 1) {
				
				//result = to get a left variable -> [010 -> 01], if third variable should be eliminated
				String result = k.substring(valueVariable.peek(),valueVariable.peek()+1); 
				clique.cliquePotentialValue.forEach((k1,v1) ->{
				if(!k.equals(k1)) {
						
						//check from loop, if two key value are identical add to sum
						String result2 = k1.substring(valueVariable.peek(),valueVariable.peek()+1); 
						if(result.equals(result2)) {
							sum = sum + v;
							//System.out.println(result + ": "+ sum);
						}
					}

				});
				
				//then variable eliminated, store value to message table
				message.put(result, sum);
				sum = 0;
			} //if ends
			
			
			//if there is two common variable. the same manipulation as if onle variable to be eliminated
			if(valueVariable.size() == 2) {
				int indexEnd = valueVariable.pop();
				int indexStart = valueVariable.pop();
				String result =  k.substring(indexStart, indexEnd+1);
				clique.cliquePotentialValue.forEach((k1,v1) ->{
				if(!k.equals(k1)) {

						String result2 =  k.substring(indexStart, indexEnd+1);
						if(result.equals(result2)) {
							sum = sum + v;
						}
					}

				});
				valueVariable.push(indexStart);
				valueVariable.push(indexEnd);
				message.put(result, sum);
				sum = 0;
			}
		});
	}

	@Override
	public String toString() {
		return "Message from "+clique+" to "+toClique+" [ nameVariable=" + nameVariable + ", message=" + message
				+ "]";
	}

	public Hashtable<String, Integer> getMessage() {
		return message;
	}

	public Stack<Integer> getValueVariable() {
		return valueVariable;
	}

	public void setValueVariable(Stack<Integer> valueVariable) {
		this.valueVariable = valueVariable;
	}

}
