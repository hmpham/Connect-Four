package app;

public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private int playerID;
	private int row;
	private int col;
	private int[] co;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID=playerID;
		this.row=row;
		this.col=col;
		co=new int[col];
		
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		co[c]+=1;
	}
	
	//returns column of where to play a token
	public int playToken(){
		
		for(int i=0;i<co.length;i++)
		{
			if(co[i]<row){
				co[i]+=1;
				return i;
			}
			
			}
		
		return col-1;
		
		
}
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		for(int i=0;i<co.length;i++){
			co[i]=0;
	}
	}
}