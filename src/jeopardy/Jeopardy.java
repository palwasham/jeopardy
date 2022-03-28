package jeopardy;

//Import//
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Jeopardy {
	
	// the variables//
	
	JFrame frame; 
    String Q, Qhint, Name; 
    int Scores, Right, wrong, Hints; //Variables to count the score, the right and wrong answers and how many hints a person takes//


	
	{ // this is the code for the first welcome messages explaining the game and the rules//
		
		UIManager.put("OptionPane.background",Color.BLACK);
		UIManager.put("Panel.background",Color.WHITE); 
		
	 	Name = JOptionPane.showInputDialog("PLEASE ENTER YOUR NAME    \n"); //ask the user for their name//
	 	
		JOptionPane.showMessageDialog(null, "\nHi " + Name + ", Welcome To Jeopardy!\n\nBefore getting started let me run you through the game.        \n"
				+ "You will see 25 questions that will be divided in 5 different categories (Sports, Movies, TvShows, Actors and general)           \n"
				+ "There will also be 5 levels of questions 100 point questions being the easiest and 500 point ones being the hardest.\n"
				+ "You can click on any question and if you get the question right you get the points, And if you get in wrong no points\n"
				+ "If you get the answer wrong beacuse you spelt it inccorrectly then you can use the add points button at the bottom\n"
				+ "There will aslo be a help button at the bottom if at anytime you are confused or need to know how to play the game\n"
				+ "\nCLICK OK WHEN YOU ARE READY TO PLAY\n     ");
		 
		JOptionPane.showMessageDialog(null, "\nGAME RULES:\nYou can answer a question only once. Answer as many questions as you want\n"
				+ "You can ask for an hint if you are ever stuck on a question however if you do ask for help u will only get half the points\n"
				+ "Only add more points when you get an answer wrong because of spelling Error (ADD THE RIGHT AMOUNT OF POINTS DON NOT CHEAT!)       \n\nLETS PLAY!" );
	
	}
	
	
	
public static void main (String[] args ) { //main method runs the race//
		
		EventQueue.invokeLater (new Runnable() {

			public void run() {
				try {
					Jeopardy window = new Jeopardy();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  }			
			
		});
		
	} 
	

public Jeopardy () { //the Game constructor //
		initialize ();
	}
	

private void initialize () { // code to add the JFrame and JButtons on to the frame//
	
	UIManager.put("OptionPane.background",Color.BLACK);
	UIManager.put("Panel.background",Color.BLUE); 
	
		frame = new JFrame(); //JFrame
		frame.setBounds(125,95,1060,800);
		frame.setTitle("Jeopardy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.blue);
		frame.getContentPane () . setLayout(null);
		
		JLabel TITLE = new JLabel (""); //the title//
		TITLE.setFont(new Font("Serif", Font.BOLD, 40));
		TITLE.setBounds(350,15,500,64);
		TITLE.setForeground(Color.white);
		TITLE.setVisible (true);
		TITLE.setText("JEOPARDY GAME");
		frame.getContentPane().add(TITLE);
		
		//THE 5 CATEGORIES TEXT//
		
		JLabel text1 = new JLabel ("");
		text1.setFont(new Font ("Tahoma", Font.BOLD, 18));
		text1.setBounds(100,100,700,14);  
		text1.setForeground(Color.white);
		text1.setVisible (true);
		text1.setText("SPORTS");
		frame.getContentPane().add(text1);
		
		JLabel text2 = new JLabel ("");
		text2.setFont(new Font ("Tahoma", Font.BOLD, 18));
		text2.setBounds(300,100,700,14); 
		text2.setForeground(Color.white);
		text2.setVisible (true);
		text2.setText("MOVIES");
		frame.getContentPane().add(text2);
		
		JLabel text3 = new JLabel ("");
		text3.setFont(new Font ("Tahoma", Font.BOLD, 18));
		text3.setBounds(480,100,700,14);  
		text3.setForeground(Color.white);
		text3.setVisible (true);
		text3.setText("TV SHOWS");
		frame.getContentPane().add(text3);
		
		JLabel text4 = new JLabel ("");
		text4.setFont(new Font ("Tahoma", Font.BOLD, 18));
		text4.setBounds(700,100,700,14); 		
		text4.setForeground(Color.white);
		text4.setVisible (true);
		text4.setText("ACTOR");
		frame.getContentPane().add(text4);
		
		JLabel text5 = new JLabel ("");
		text5.setFont(new Font ("Tahoma", Font.BOLD, 18));
		text5.setBounds(890,100,700,14);  
		text5.setForeground(Color.white);
		text5.setVisible (true);
		text5.setText("GENERAL");
		frame.getContentPane().add(text5);
		
		
		//help, Add point, Total scores and finish button//
		
		JButton Scores1 = new JButton ("Total Scores");
		Scores1.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Scores1.addActionListener(new Scores1());
		Scores1.setBounds(150,640,155,40);
		Scores1. setBackground(Color. BLACK); 
		Scores1. setOpaque(true);
		frame.getContentPane() .add(Scores1);
		
		JButton AddPoints = new JButton ("Add Points");
		AddPoints.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		AddPoints.addActionListener(new AddPoints());
		AddPoints.setBounds(350,640,155,40);
		AddPoints. setBackground(Color. BLACK); 
		AddPoints. setOpaque(true);
		frame.getContentPane() .add(AddPoints);
		
		JButton GameHelp = new JButton ("Game Help");
		GameHelp.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		GameHelp.addActionListener(new GameHelp());
		GameHelp.setBounds(550,640,155,40);
		GameHelp. setBackground(Color. BLACK); 
		GameHelp. setOpaque(true);
		frame.getContentPane() .add(GameHelp);
		
		JButton Finish = new JButton ("Finish Game");
		Finish.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Finish.addActionListener(new  Finish ());
		Finish.setBounds(750,640,155,40);
		Finish. setBackground(Color. BLACK); 
		Finish. setOpaque(true);
		frame.getContentPane() .add(Finish);
		
		

			
		//SPORTS QUESTIONS BUTTONS//
		
		JButton Sports1 = new JButton ("100");
		Sports1.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Sports1.setName("sports100");
		Sports1.addActionListener(sports100);
		Sports1.setBounds(50,140,159,54);
		Sports1. setOpaque(true);
		frame.getContentPane() .add(Sports1);
		
		JButton Sports2 = new JButton ("200");
		Sports2.setName("sports200");
		Sports2.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Sports2.addActionListener(sports200);
		Sports2.setBounds(50,240,159,54);
		Sports2. setOpaque(true);
		frame.getContentPane() .add(Sports2);
		
		JButton Sports3 = new JButton ("300");
		Sports3.setName("sports300");
		Sports3.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Sports3.addActionListener(sports300);
		Sports3.setBounds(50,340,159,54);
		Sports3. setOpaque(true);
		frame.getContentPane() .add(Sports3);
		
		JButton Sports4 = new JButton ("400");		
		Sports4.setName("sports400");
		Sports4.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Sports4.addActionListener(sports400);
		Sports4.setBounds(50,440,159,54);
		Sports4. setOpaque(true);
		frame.getContentPane() .add(Sports4);
		
		JButton Sports5 = new JButton ("500");
		Sports5.setName("sports500");
		Sports5.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Sports5.addActionListener(sports500);
		Sports5.setBounds(50,540,159,54);
		Sports5. setOpaque(true);
		frame.getContentPane() .add(Sports5);
		
			
		//MOVIES QUEATIONS BUTTONS//
		
		JButton Movies1 = new JButton ("100");
		Movies1.setName("Movies100");
		Movies1.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Movies1.addActionListener(Movies100);
		Movies1.setBounds(250,140,159,54);
		Movies1. setOpaque(true);
		frame.getContentPane() .add(Movies1);
		
		JButton Movies2 = new JButton ("200");
		Movies2.setName("Movies200");
		Movies2.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Movies2.addActionListener(Movies200);
		Movies2.setBounds(250,240,159,54);
		Movies2. setOpaque(true);
		frame.getContentPane() .add(Movies2);
		
		JButton Movies3 = new JButton ("300");
		Movies3.setName("Movies300");
		Movies3.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Movies3.addActionListener(Movies300);
		Movies3.setBounds(250,340,159,54);
		Movies3. setOpaque(true);
		frame.getContentPane() .add(Movies3);
		
		JButton Movies4 = new JButton ("400");
		Movies4.setName("Movies400");
		Movies4.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Movies4.addActionListener(Movies400);
		Movies4.setBounds(250,440,159,54);
		Movies4. setOpaque(true);
		frame.getContentPane() .add(Movies4);
		
		JButton Movies5 = new JButton ("500");
		Movies5.setName("Movies500");
		Movies5.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Movies5.addActionListener(Movies500);
		Movies5.setBounds(250,540,159,54);
		Movies5. setOpaque(true);
		frame.getContentPane() .add(Movies5);
		
		
		//TVSHOW QUESTIONS BUTTONS//
		
		JButton TvShows1 = new JButton ("100");
		TvShows1.setName("TvShows100");
		TvShows1.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		TvShows1.addActionListener(TvShows100);
		TvShows1.setBounds(450,140,159,54);
		TvShows1. setOpaque(true);
		frame.getContentPane() .add(TvShows1);
		
		JButton TvShows2 = new JButton ("200");
		TvShows2.setName("TvShows200");
		TvShows2.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		TvShows2.addActionListener(TvShows200);
		TvShows2.setBounds(450,240,159,54);
		TvShows2. setOpaque(true);
		frame.getContentPane() .add(TvShows2);
		
		JButton TvShows3 = new JButton ("300");
		TvShows3.setName("TvShows300");
		TvShows3.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		TvShows3.addActionListener(TvShows300);
		TvShows3.setBounds(450,340,159,54);
		TvShows3. setOpaque(true);
		frame.getContentPane() .add(TvShows3);
		
		JButton TvShows4 = new JButton ("400");
		TvShows4.setName("TvShows400");
		TvShows4.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		TvShows4.addActionListener(TvShows400);
		TvShows4.setBounds(450,440,159,54);
		TvShows4. setOpaque(true);
		frame.getContentPane() .add(TvShows4);
		
		JButton TvShows5 = new JButton ("500");
		TvShows5.setName("TvShows500");
		TvShows5.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		TvShows5.addActionListener(TvShows500);
		TvShows5.setBounds(450,540,159,54);
		TvShows5. setOpaque(true);
		frame.getContentPane() .add(TvShows5);	
		
		
		//ACTOR QUESTIONS BUTTONS//
		
		JButton Actor1 = new JButton ("100");
		Actor1.setName("Actors100");
		Actor1.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Actor1.addActionListener(Actors100);
		Actor1.setBounds(650,140,159,54);
		Actor1. setOpaque(true);
		frame.getContentPane() .add(Actor1);
		
		JButton Actor2 = new JButton ("200");
		Actor2.setName("Actors200");
		Actor2.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Actor2.addActionListener(Actors200);
		Actor2.setBounds(650,240,159,54);
		Actor2. setOpaque(true);
		frame.getContentPane() .add(Actor2);
		
		JButton Actor3 = new JButton ("300");
		Actor3.setName("Actors300");
		Actor3.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Actor3.addActionListener(Actors300);
		Actor3.setBounds(650,340,159,54);
		Actor3. setOpaque(true);
		frame.getContentPane() .add(Actor3);
		
		JButton Actor4 = new JButton ("400");
		Actor4.setName("Actors400");
		Actor4.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Actor4.addActionListener(Actors400);
		Actor4.setBounds(650,440,159,54);
		Actor4. setOpaque(true);
		frame.getContentPane() .add(Actor4);
		
		JButton Actor5 = new JButton ("500");
		Actor5.setName("Actors500");
		Actor5.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		Actor5.addActionListener(Actors500);
		Actor5.setBounds(650,540,159,54);
		Actor5. setOpaque(true);
		frame.getContentPane() .add(Actor5);		
		
		
		//GENERAL QUESTIONS BUTTONS//
		
		JButton General1 = new JButton ("100");
		General1.setName("General100");
		General1.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		General1.addActionListener(General100);
		General1.setBounds(850,140,159,54);
		General1. setOpaque(true);
		frame.getContentPane() .add(General1);
		
		JButton General2 = new JButton ("200");
		General2.setName("General200");
		General2.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		General2.addActionListener(General200);
		General2.setBounds(850,240,159,54);
		General2. setOpaque(true);
		frame.getContentPane() .add(General2);
		
		JButton General3 = new JButton ("300");
		General3.setName("General300");
		General3.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		General3.addActionListener(General300);
		General3.setBounds(850,340,159,54);
		General3. setOpaque(true);
		frame.getContentPane() .add(General3);
		
		JButton General4 = new JButton ("400");
		General4.setName("General400");
		General4.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		General4.addActionListener(General400);
		General4.setBounds(850,440,159,54);
		General4. setOpaque(true);
		frame.getContentPane() .add(General4);
		
		JButton General5 = new JButton ("500");
		General5.setName("General500");
		General5.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		General5.addActionListener(General500);
		General5.setBounds(850,540,159,54);
		General5. setOpaque(true);
		frame.getContentPane() .add(General5);
		
		//more stuff//
		
		JButton Money = new JButton ("");
		Money.setIcon(new ImageIcon("jeoparypic.jpeg"));
		Money.setBounds(140,25,169,40);
		Money. setOpaque(true);
		frame.getContentPane() .add(Money);
		
		JButton Money2 = new JButton ("");
		Money2.setIcon(new ImageIcon("jeoparypic.jpeg"));
		Money2.setBounds(745,25,169,40);
		Money2. setOpaque(true);
		frame.getContentPane() .add(Money2);
		
		JButton Money3 = new JButton ("");
		Money3.setIcon(new ImageIcon("jeoparypic.jpeg"));
		Money3.setBounds(-29,25,169,40);
		Money3. setOpaque(true);
		frame.getContentPane() .add(Money3);
		
		JButton Money4 = new JButton ("");
		Money4.setIcon(new ImageIcon("jeoparypic.jpeg"));
		Money4.setBounds(913,25,169,40);
		Money4. setOpaque(true);
		frame.getContentPane() .add(Money4);

}



 //5 SPORTS QUESTIONS, if any of the sports category questions are pressed//

class Buttons implements ActionListener { // when the button is pressed //
	
	public String question;
	public String answer;
	public String hint;
	public int Points;
	public String buttonName;
	public boolean enabled;
	
	public Buttons(String question, String answer, String hint, String buttonName, int Points) {
		this.question = question;
		this.answer = answer;
		this.hint = hint;
		this.Points = Points;
		this.buttonName = buttonName;
		this.enabled = true;
	}
  
	public void actionPerformed(ActionEvent Args0) {
		
		UIManager.put("OptionPane.background",Color.BLACK);
		UIManager.put("Panel.background",Color.WHITE); 
		
	        Q = JOptionPane.showInputDialog(this.question + "\n'Type hint to get a hint'    \n"); //the question for that button//
	       
	        if (Q.equalsIgnoreCase(this.answer)) { //if the person says the write answer then this code is played//
		   
	       JOptionPane.showMessageDialog(null,"GOOD JOB THAT WAS RIGHT\nYOU GOT " + this.Points + " POINTS :)             ");
	       Scores = Scores + this.Points; //adding the scores//
		   Right++; // to add to the right list//

	      } else if (Q.equalsIgnoreCase("Hint")) { // if the person asks for a hint//
		 	    Hints++; //to add to the hints list//

		    
		 	Qhint = JOptionPane.showInputDialog(this.hint + ", Go ahead and guess   ");
		      
	        if (Qhint.equalsIgnoreCase(this.answer)) { // if after the hint they get the right answer then this code plays//
			    
	        	JOptionPane.showMessageDialog(null,"GOOD JOB THAT WAS RIGHT\nHOWEVER YOU USED A HINT SO YOU GOT " + (this.Points /2) + " POINTS :)             ");
			       Scores = Scores + (this.Points / 2);
				   Right++;				
   
	      } else { //if the person gets the answer wrong//
	       JOptionPane.showMessageDialog(null,"Wrong answer you get no point    \nThe right answer is " + this.answer  + "    ");
	 	   wrong++; //to add to the wrong list//

	      }
	        
	      } else {
		       JOptionPane.showMessageDialog(null,"Wrong answer you get no point    \nThe right answer is " + this.answer  + "    ");
		 	   wrong++;  
	      }
	        
	        this.enabled = false; //to disable a button after its been pressed//
	        Component[] components = frame.getContentPane().getComponents();
	        for(int i = 0; i < components.length; i++) {
	        	if(components[i].getName() == this.buttonName) {
	        		components[i].setEnabled(false);
	        	}
	        }
	        ;
	        
	}
		
 }

//the questions, answers and hints for each question//

public Buttons sports100 = new Buttons("What is the national sport of Canada?", "Lacrosse", "This sports kinda similar to Hockey and football mixed together", "sports100", 100);

public Buttons sports200 = new Buttons("What is the oldest Sport?", "Wrestling", "This sports includes fighting", "sports200", 200);

public Buttons sports300 = new Buttons("Who Created Basket Ball?", "James Naismith", "His last name is Naismith", "sports300", 300);

public Buttons sports400 = new Buttons("What country has competed the most times in the Summer Olympics yet hasn’t won a gold medal?", "Philippines", "Its located in southwest Asia", "sports400", 400);

public Buttons sports500 = new Buttons("The Triple Crown award is given to a horse that wins which three races?", "The Kentucky Derby, Preakness Stakes, and Belmont Stakes races.", "2 of the races are The Kentucky Derby, Preakness Stakes", "sports500", 500);


public Buttons Movies100 = new Buttons("What famous movie is about a love sory and a ship wreck?", "Titanic", "This is about one of the most famous ship wrecks", "Movies100", 100);

public Buttons Movies200 = new Buttons("What was the first movie by Pixar to receive a rating higher than G in the United States?", "The Incredibles", "About a family of 5 who have super powers", "Movies200", 200);

public Buttons Movies300 = new Buttons("What happens to anyone who watches the videotape in the horror film The Ring?", "They Die", "Whatever happens to them it isnt good", "Movies300", 300);

public Buttons Movies400 = new Buttons("Which film earned Stanley Kubrick a Razzie nomination for Worst Director?", "The Shining", "Its sort of a famous horror film now", "Movies400", 400);

public Buttons Movies500 = new Buttons("What is the longest movie ever made?", "The Cure for Insomnia", "This movie is 87 hours long",  "Movies500", 500);


public Buttons TvShows100 = new Buttons("What is a popular teen show about Vampires?", "The Vampire Dairy", "The show name has the word dairy in it", "TvShows100", 100);

public Buttons TvShows200 = new Buttons("Who played Chandler's father on Friends?", "Kathleen Turner", "The person who played chandlers dad was actually a female", "TvShows200", 200);

public Buttons TvShows300 = new Buttons("What was Mickey Mouse's name before it was changed to Mickey?", "Mortimer", "The name starts with a M", "TvShows300", 300);

public Buttons TvShows400 = new Buttons("In the show 'Breaking Bad', where does Walter White hide his money in his home?", "Heating duct", "Something to do with warmth", "TvShows400", 400);

public Buttons TvShows500 = new Buttons("What hospital does the show \"Grey's Anatomy\" take place in?", "Seattle Grace Hospital", "Seattle     _ a _ _ e     _ _ s _ _ _ a _ ", "TvShows500", 500);


public Buttons Actors100 = new Buttons("Who Plays Jughead in the show \"Riverdale\"?", "Cole sprouse", "This actor has a twin brother", "Actors100", 100);

public Buttons Actors200 = new Buttons("Which actress played Jessie in the show \"Jessie\"?", "Debby Ryan", "She was also in insatiable", "Actors200", 200);

public Buttons Actors300 = new Buttons("Which actor plays the character Dr. Sheldon Cooper in \"The Big Bang Theory\"?", "Jim Parsons", "His last name is Parsons", "Actors300", 300);

public Buttons Actors400 = new Buttons("which young disney actor passed away at the age of 20 in 2019?", "Cameron Boyce", "He was in the Descendants series", "Actors400", 400);

public Buttons Actors500 = new Buttons("What famous Hollywood actor was born in 1917, had the middle name of Charles Durman and died in 1997?", "Robert Mitchum", "His last name was Mitchum", "Actors500", 500);


public Buttons General100 = new Buttons("What geometric shape is generally used for stop signs?", "Octagon", "It has 8 sides", "General100", 100);

public Buttons General200 = new Buttons("What is \"cynophobia\"?", "Fear of dogs", "It's being afraid of a specific animal", "General200", 200);

public Buttons General300 = new Buttons("Who named the Pacific Ocean?", "Ferdinand Magellan", "His last names Magellan", "General300", 300);

public Buttons General400 = new Buttons("How many languages are written from right to left?", "12", "More than 10", "General400", 400);

public Buttons General500 = new Buttons("Who was the first woman to win a Nobel Prize (in 1903)?", "Marie Curie", "She is remembered for her discovery of radium and polonium, and \nher huge contribution to finding treatments for cancer", "General500", 500);


//help, score, add points and finish buttons//

class GameHelp implements ActionListener { // when the button is pressed //
	
	public void actionPerformed(ActionEvent Args0) {
		
		UIManager.put("OptionPane.background",Color.BLACK);
	    UIManager.put("Panel.background",Color.WHITE);
	    
    	String Rules; 
    	
    	//the user will be ask what they need help with//
    	
    	Rules = JOptionPane.showInputDialog("\nHi, Welcome to the help center\nwhat do you need help with (1. Game rules, 2. Game instructions)      \n");
	       
        if (Rules.equalsIgnoreCase("1")) { // if the chose rules this code will play//
	   
    		JOptionPane.showMessageDialog(null, "\nGAME RULES:\nYou can answer a question only once. Answer as many questions as you want\n"
    				+ "You can ask for an hint if you are ever stuck on a question however if you do ask for help u will only get half the points\n"
    				+ "Only add more points when you get an answer wrong because of spelling Error (ADD THE RIGHT AMOUNT OF POINTS DON NOT CHEAT!)        \n" );
    	
    		
        } else if (Rules.equalsIgnoreCase("2")) { // if the chose game instructions then this code will play//
    	   
      JOptionPane.showMessageDialog(null,"\nGame instructions:\nPick a category and the which point question you want to answer and just click on it\n"
		    + "You can ask for an hint by typing in 'hint'in the question inbox if you are ever stuck on a question however if you do ask for help u will only get half the points          \n"
      		+ "if at anypoint you want to see you scores click the total score button and it will show you your total score at that point of the game\n"
      		+ "If you ever get A question wrong because of an spelling error then go click on add points button and add the points that question was worth\n"
      		+ "When you are done playing click on finish playin and the game will end, it will show you your total score and how many queation you got right.            \n"); }
        

      }
	}

class Scores1 implements ActionListener { // when the button is pressed //
	
	public void actionPerformed(ActionEvent Args0) {
		
		UIManager.put("OptionPane.background",Color.BLACK);
	    UIManager.put("Panel.background",Color.WHITE);
	    
		JOptionPane.showMessageDialog(null, "Your Current scores is: " + Scores + ".    " ); // will show the overall score//
    
  }

}

class AddPoints implements ActionListener { // when the button is pressed //
	
	public void actionPerformed(ActionEvent Args0) {
    int Points;
	
    UIManager.put("OptionPane.background",Color.BLACK);
    UIManager.put("Panel.background",Color.WHITE);
	    	   
	    	   Points = Integer.parseInt(JOptionPane.showInputDialog("How many point do you need to add?     ")); //the person will be asked how many point they want to add//
	    	   Scores = Scores + Points; //the point will be added//
	    	   Right++; // also add a right to the right questions list because players are asked to add point only when they get a question wrong for spelling or something like that//
	    	   JOptionPane.showMessageDialog(null,"Your Score is Now " + Scores + "     "); //output the total score//
	}
}	

class Finish implements ActionListener { // when the button is pressed //
	
	public void actionPerformed(ActionEvent Args0) {
	
		UIManager.put("OptionPane.background",Color.BLACK);
	    UIManager.put("Panel.background",Color.WHITE);
	    
	    //when the person finished the day the scores, the rights, the wrongs and how many hints they asked for will show up//
	     JOptionPane.showMessageDialog(null, "\nYou got " + Right + " questions right and " + wrong + " questions wrong.       "
	     		+ "\nThroughout the game you asked for " + Hints + " Hints    \nYour Final score is: " + Scores +  "    \nTHANK YOU FOR PLAYING JEOPARDY, BYE!      " );
	     
		System.exit(0); //Program will close//
			
	}
   }

}

			
