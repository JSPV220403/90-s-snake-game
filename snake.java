package s_practice;
import java.util.*;

public class snake {
	static char[][] snakeBoard= null;
	static Queue<node>pointer= new LinkedList<>();
	static Queue<node>food= new LinkedList<>();
	
	snake(int row, int col){
		snakeBoard= new char[row][col];
		pointer.add(new node(0,0));
		food.add(new node(1,2));
		food.add(new node(2,5));
		food.add(new node(1,4));
		food.add(new node(0,0));
		foodSet(food.poll());
	}
	
	public static void snakeMove(int row, int col) {
		if(row>=0&&row< snakeBoard.length && col>= 0&& col< snakeBoard[0].length) {
			if(snakeBoard[row][col]=='.') {
				System.out.println("Snake sucide!!");
				System.exit(0);
			}
			pointer.add(new node(row, col));
			if(snakeBoard[row][col]!='X') {
				node n= pointer.poll();
				int r= n.getRow();
				int c= n.getCol();
				snakeBoard[r][c]='\0';
			}
			
			if(snakeBoard[row][col]=='X') {
				
				if(food.isEmpty()) {
					moveHead(row,col);
					System.out.println("You won the game");
					System.exit(0);
				}
				foodSet(food.poll());
			}
			moveHead(row, col);
			
			char direction;
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter snake move: ");
			direction= sc.next().charAt(0);
			if(direction=='R') {
				snakeMove(row, col+1);
			}
			else if(direction=='L') {
				snakeMove(row, col-1);
			}
			else if(direction=='U') {
				snakeMove(row-1, col);
			}
			else if(direction=='D') {
				snakeMove(row+1, col);
			}
			else {
				System.out.println("Invalid direction!!! \nPress F11 to restart the game: ");
				System.exit(0);
			}
		}
		else {
			System.out.println("Snake hitted the boundary so restart the game!!!!");
			System.exit(0);
		}
		
	}
	
	public static void foodSet(node food) {
		
		snakeBoard[food.row][food.col]='X';
	}
	
	public static void moveHead(int row, int col) {
		snakeBoard[row][col]= '.';
		printBoard();
	}
	public static void printBoard() {
		for(char[] row: snakeBoard) {
			for(int j=0; j< snakeBoard[0].length; j++) {
				System.out.print(row[j]+" ");
			}
			System.out.println();
		}
	}
}
