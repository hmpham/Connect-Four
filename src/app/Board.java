package app;


public class Board {
	

		private char[][] board;
		private char player1='1';
		private char player2='2';
		
		public Board(){
			board=new char[6][7];
			for(int i=0;i<6;i++){
				for(int j=0;j<7;j++){
					board[i][j]=' ';
				}
			}
		}

		public Board(int row, int col){
			
				board=new char[row][col];
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						board[i][j]=' ';
				}
			}
		}
		
		
		public int getNumRows(){
			return board.length;
		}
		
		public int getNumCols(){
			return board[0].length;
		}
		
		public char getPlayerOne(){
			return player1;
		}
		
		public char getPlayerTwo(){
			return player2;
		}
		
		public void setPlayerOne(char o){
			player1=o;
		}
		
		public void setPlayerTwo(char t){
			player2=t;
		}
		
		public char getToken( int row, int col){
			if(row<0||row>=board.length)
				return '\0';
			else if(col<0||col>=board[0].length)
				return '\0';
			else
				return board[row][col];
		}
		
		public boolean canPlay(){
			
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board[0].length;j++){
					if(board[i][j]==' '){
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean play(int p, int c){
			
			if(c<0||c>=board[0].length){
				return false;
			}
			else if(p==1){

				int i=board.length-1;
				int count1=0;
				for(;i>=0;i--){
					if(board[i][c]==player1||board[i][c]==player2){
						count1++;
					}	
				if(board[i][c]==' '){
						break;
					}
				}
					if(count1<board.length){
						board[i][c]=player1;
						return true;
					}
					else 
						return false;
			    }
			
			else if(p==2){

				int i=board.length-1;
				int count1=0;
				for(;i>=0;i--){
					if(board[i][c]==player1||board[i][c]==player2){
						count1++;
					}	
				if(board[i][c]==' '){
						break;
					}
				}
					if(count1<board.length){
						board[i][c]=player2;
						return true;
					}
					else 
						return false;
			    }
			else
				return false;
				
			}

			
			public int isFinished(){
				int count=0;
				//1horizontal check for player 1
				for(int i=0;i<board.length;i++){
					for(int j=0;j<board[i].length;j++){
						if(board[i][j]==player1){
							count++;
							if(count>=4){
								return 1;
							}
							}
							else
								if(count>=4)
									return 1;
								else{
									count=0;
								}
					}
						if(count>=4){
							return 1;
						}
						else
							count=0;
					}
				//2horizontal check for player 2
				for(int i=0;i<board.length;i++){
					for(int j=0;j<board[i].length;j++){
						if(board[i][j]==player2){
							count++;
							if(count>=4){
								return 2;
							}
							}
						else
							if(count>=4)
								return 2;
							else{
								count=0;
								}
						}
						if(count>=4){
							return 2;
						}
						else
							count=0;
					}
				//3vertical check for player 1
				for(int i=0;i<board[0].length;i++){
					for(int j=0;j<board.length;j++){
						if(board[j][i]==player1){
							count++;
							if(count>=4){
								return 1;
							}
							}
						else
							if(count>=4)
								return 1;
							else{
								count=0;
								}
						}
					if(count>=4){
						return 1;
					}
					else
						count=0;
					}
				//4vertical check for player 2
				for(int i=0;i<board[0].length;i++){
					for(int j=0;j<board.length;j++){
						if(board[j][i]==player2){
							count++;
							if(count>=4){
								return 2;
							}
							}
						else
							if(count>=4)
								return 2;
							else{
								count=0;
								}
						}
					if(count>=4){
						return 2;
					}
					else
						count=0;
					}
				//5right down upper for player1
				for(int col=0;col<board[0].length;col++){
					int col1=col;
					for(int row=0;row<board.length&&col1<board[0].length;row++,col1++){
						if(board[row][col1]==player1){
							count++;
							if(count>=4){
								return 1;
							}
						}
						else{
							if(count>=4){
								return 1;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 1;
					}
					else{
						count=0;
					}
					}
				//6right down upper for player2
				for(int col=0;col<board[0].length;col++){
					int col1=col;
					for(int row=0;row<board.length&&col1<board[0].length;row++,col1++){
						if(board[row][col1]==player2){
							count++;
							if(count>=4){
								return 2;
							}
						}
						else{
							if(count>=4){
								return 2;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 2;
					}
					else{
						count=0;
					}
					}
				//7right down lower for player1
				for(int col=0;col<board[0].length;col++){
					int col1=col;
					for(int row=1;row<board.length&&col1<board[0].length;row++,col1++){
						if(board[row][col1]==player1){
							count++;
							if(count>=4){
								return 1;
							}
						}
						else{
							if(count>=4){
								return 1;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 1;
					}
					else{
						count=0;
					}
					}
				//8right down lower for player2
				for(int col=0;col<board[0].length;col++){
					int col1=col;
					for(int row=1;row<board.length&&col1<board[0].length;row++,col1++){
						if(board[row][col1]==player2){
							count++;
							if(count>=4){
								return 2;
							}
						}
						else{
							if(count>=4){
								return 2;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 2;
					}
					else{
						count=0;
					}
					}
				//9down up upper for player 1
				for(int row=board.length-1;row>=0;row--){
					int row1=row;
					for(int col=0;row1>=0&&col<board[0].length;row1--,col++){
						if(board[row1][col]==player1){
							count++;
							if(count>=4){
								return 1;
							}
						}
						else{
							if(count>=4){
								return 1;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 1;
					}
					else{
						count=0;
					}
					}
				//10down up upper for player 2
				for(int row=board.length-1;row>=0;row--){
					int row1=row;
					for(int col=0;row1>=0&&col<board[0].length;row1--,col++){
						if(board[row1][col]==player2){
							count++;
							if(count>=4){
								return 2;
							}
						}
						else{
							if(count>=4){
								return 2;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 2;
					}
					else{
						count=0;
					}
					}
				//11down up lower for player1
				for(int col=0;col<board[0].length;col++){
					int col1=col;
					for(int row=board.length-1;row>=0&&col1<board[0].length;row--,col1++){
						if(board[row][col1]==player1){
							count++;
							if(count>=4){
								return 1;
							}
						}
						else{
							if(count>=4){
								return 1;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 1;
					}
					else{
						count=0;
					}
					}
				//12down up lower for player2
				for(int col=0;col<board[0].length;col++){
					int col1=col;
					for(int row=board.length-1;row>=0&&col1<board[0].length;row--,col1++){
						if(board[row][col1]==player2){
							count++;
							if(count>=4){
								return 2;
							}
						}
						else{
							if(count>=4){
								return 2;
							}
							else{
								count=0;
							}
							}
						}
					if(count>=4){
						return 2;
					}
					else{
						count=0;
					}
					}
				for(int i=0;i<board.length;i++){
					for(int j=0;j<board[0].length;j++){
						if(board[i][j]==' '){
							return -1;
						}
					}
				}
			
				return 0;
			}
	}	



