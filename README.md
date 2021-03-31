# CliqueAndSepsetBelief
Work done by Madina Saparbayeva

### To run program 
enter in command line (if you have not IDE): 
	“javac Main.java”
then there should be created .class files and enter
	“java Main”


### The Values
Values were taken from example in moodle. 

The program is unniversal (changeable). 
Change only Main.java.


### Classes
Factor.java
CliquePotentials.java
Message.java
SepsetBelief.java
CliqueBeliefs.java

### The output from example

  - Clique Potentials [0, 1, 2] [ values= {010=69841, 101=68554, 100=153906, 111=65232, 110=146448, 001=86860, 000=85244, 011=71165} ]
  - Clique Potentials [4, 2, 3] [ values= {010=16506, 101=108270, 100=67368, 111=27270, 110=16968, 001=14535, 000=17685, 011=13566} ]
  - Clique Potentials [2, 3, 6] [ values= {010=17630, 101=16272, 100=134244, 111=7248, 110=59796, 001=39457, 000=17302, 011=40205} ]
  - Clique Potentials [5, 3, 6] [ values= {010=14429, 101=61093, 100=41920, 111=38009, 110=30560, 001=99200, 000=23312, 011=61400} ]


  - Message from [0, 1, 2] to [4, 2, 3] [ nameVariable=[2], message={1=205662, 0=209523}]
  - Message from [4, 2, 3] to [0, 1, 2] [ nameVariable=[2], message={1=49518, 0=324810}]
  - Message from [4, 2, 3] to [2, 3, 6] [ nameVariable=[2, 3], message={01=757890, 00=471576, 11=190890, 10=115542}]
  - Message from [2, 3, 6] to [4, 2, 3] [ nameVariable=[2, 3], message={01=123410, 00=276199, 11=50736, 10=113904}]
  - Message from [2, 3, 6] to [5, 3, 6] [ nameVariable=[3, 6], message={01=113904, 00=939708, 11=50736, 10=123410}]
  - Message from [5, 3, 6] to [2, 3, 6] [ nameVariable=[3, 6], message={01=427651, 00=293440, 11=266063, 10=101003}]


  - SepsetBeliefs [2] [sepsetBelief={1=10183970916, 0=68055165630}] 
  - SepsetBeliefs [2, 3] [sepsetBelief={01=93531204900, 00=130248819624, 11=9684995040, 10=13160695968}]
  - SepsetBeliefs [3, 6] [sepsetBelief={01=48711159504, 00=275747915520, 11=13498972368, 10=12464780230}]


  - CliqueBeliefs [0, 1, 2] [cliqueBelief={010=69841, 101=68554, 100=153906, 111=65232, 110=146448, 001=86860, 000=85244, 011=71165}]
  - CliqueBeliefs [4, 2, 3] [cliqueBelief={010=16506, 101=108270, 100=67368, 111=27270, 110=16968, 001=14535, 000=17685, 011=13566}]
  - CliqueBeliefs [2, 3, 6] [cliqueBelief={010=17630, 101=16272, 100=134244, 111=7248, 110=59796, 001=39457, 000=17302, 011=40205}]
