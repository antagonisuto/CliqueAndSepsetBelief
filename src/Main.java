
public class Main {

	public static void main(String[] args) {
		//BE CAREFULE while assign values
		
		//Initialize factors
		Factor f1 = new Factor(0,1); 
		Factor f2 = new Factor(0,2); 
		Factor f3 = new Factor(2,3); 
		Factor f4 = new Factor(2,4);
		Factor f5 = new Factor(2,6); 
		Factor f6 = new Factor(3,4);
		Factor f7 = new Factor(3,5); 
		Factor f8 = new Factor(5,6); 
		
		//set value of factors as [(False, False), (False, True), (True, False), (True, True)]
		f1.setFactors(404, 331, 454, 432);
		f2.setFactors(211, 215, 339, 151);
		f3.setFactors(211, 215, 339, 151);
		f4.setFactors(45, 401, 42, 101);
		f5.setFactors(82, 187, 396, 48);
		f6.setFactors(393, 168, 323, 270);
		f7.setFactors(496, 262, 307, 191);
		f8.setFactors(47, 200, 160, 199);
		
		//assign cliqueTree to create cliquePotentials
		CliquePotentials clique1 = new CliquePotentials(f1,f2);
		CliquePotentials clique2 = new CliquePotentials(f4,f6);
		CliquePotentials clique3 = new CliquePotentials(f3,f5);
		CliquePotentials clique4 = new CliquePotentials(f7,f8);
		System.out.println(clique1.getNameClique());
		System.out.println(clique2.getNameClique());
		System.out.println(clique3.getNameClique());
		System.out.println(clique4.getNameClique());
		System.out.println();
		

		//assign cliques to calculate messages
		Message message1 = new Message(clique1,clique2);
		Message message1_1 = new Message(clique2,clique1);
		Message message2 = new Message(clique2,clique3);
		Message message2_1 = new Message(clique3,clique2);
		Message message3 = new Message(clique3,clique4);
		Message message3_1 = new Message(clique4,clique3);

		
		System.out.println(message1);
		System.out.println(message1_1);
		System.out.println(message2);
		System.out.println(message2_1);
		System.out.println(message3);
		System.out.println(message3_1);
		System.out.println();
		//System.out.println("M:"+clique1.toString()+" to "+clique2.toString() +": "+ message1.toString());
		//System.out.println(message1_1.toString());
		//System.out.println("M:"+clique2.toString()+" to "+clique3.toString() +": "+ message2.toString());
		//System.out.println(message2_1.toString());
		//System.out.println("M:"+clique3.toString()+" to "+clique4.toString() +": "+ message3.toString());
		
		//get sepset beliefs from messages values 
		SepsetBeliefs sB = new SepsetBeliefs(message1, message1_1);
		SepsetBeliefs sB2 = new SepsetBeliefs(message2, message2_1);
		SepsetBeliefs sB3 = new SepsetBeliefs(message3, message3_1);
		System.out.println(sB);
		System.out.println(sB2);
		System.out.println(sB3);
		System.out.println();
		
		//get clique beliefs from clique and message values
		CliqueBeliefs cB = new CliqueBeliefs(clique1, message1_1); 
		CliqueBeliefs cB2 = new CliqueBeliefs(clique2, message2_1); 
		CliqueBeliefs cB3 = new CliqueBeliefs(clique3, message3_1); 
		System.out.println(cB);
		System.out.println(cB2);
		System.out.println(cB3);
		System.out.println();
		
	}

}
