package app;

public class ConnectFour{
	
	
	public static void main(String[] args){
		
		//Create new board object
		Board a=new Board();
		CFGUI b=new CFGUI(a,ChipColor.BLUE,ChipColor.RED);
		
		//Set player tokens for player 1 and player 2
		a.setPlayerOne('1');
		a.setPlayerTwo('2');
		
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);
		Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer
		
		//Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
		
		
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		while(a.canPlay()){
			System.out.println("p1 enter column#");
			int y=p1.playToken();
			a.play(1,y);
		
			p2.lastMove(y);
			b.redraw();
			
			if(a.isFinished()==1){
				break;
			}
			System.out.println("p1 enter column#"); //comment this line when testing AIPlayer
			//System.out.println("AI turn");  //uncomment this line when testing AIPlayer
			int x=p2.playToken();
			a.play(2,x);
			p1.lastMove(x);
			b.redraw();
			
			
			if(a.isFinished()==2){
				break;
			}
			
		}
		
			
	
		
		// Get the status code from the board (isFinished())
		// Print out the results of the game
		b.gameOver(a.isFinished());
		b.close();
	}
	}