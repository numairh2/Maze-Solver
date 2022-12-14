import java.io.*;
import java.util.*;


public class Maze {
	public Square[][] maze;
	private Square start;
	private Square end;
	/**
	 * Default constructor  
	 */
	public Maze() {
		maze = new Square[0][0];
	}
	/**
	 * loads the maze with the dat file. 
	 * @param filename the name of the dat file
	 * @return true or false if the dat file is found
	 */
	public boolean loadMaze(String filename) { 
		
		try {
		Scanner sc = new Scanner(new File(filename)); 
		int row = sc.nextInt();
		int col = sc.nextInt();
		maze = new Square [row][col];
		
		for(int r=0; r<row; r++)// O(n^2)
		{
			for(int c=0; c<col; c++)
			{
				if(sc.hasNextInt()) {
					maze[r][c] = new Square(r,c,sc.nextInt());
				}
			}
		}
		
		sc.close();
		}  catch(FileNotFoundException e) {
			System.out.println("File is not found, please try again");
			return false;
		}
		   
		return true;
	}
	/**
	 * it finds the adjacent return if they are valid to the maze 
	 * @param s  Square to find the neighbors 
	 * @return an ArrayList of Squares which have the neighbors 
	 */
	public List<Square> getNeighbors(Square s){
		
		ArrayList<Square> neighbors = new ArrayList<Square>(); 
		
		int r = s.getRow();
		int c = s.getCol();
		
		
		if(r>0)
			neighbors.add(maze[r-1][c]); //north; O(1)
		
		if(c< maze[r].length -1 )
			neighbors.add(maze[r][c+1]); //west; O(1)
		
		if(r<maze.length - 1) 
			neighbors.add(maze[r+1][c]); //south; O(1)
		
		if(c> 0)
			neighbors.add(maze[r][c-1]); //east; O(1)
		
		return neighbors;
	}
	/**
	 * finds the start of the maze
	 * @return start of the maze
	 */
	public Square getStart() {
		
		for(int r=0; r< maze.length; r++)// O(n^2)
		{
			for(int c=0; c<maze[r].length; c++)
			{
				if(maze[r][c].toString().equals("S"))
					start = maze[r][c];
			}
		}
		return start;
			}
	/**
	 * finds the exit  of the maze
	 * @return exit of the maze
	 */
	public Square getExit() {
		for(int r=0; r< maze.length; r++) //O(n^2)
		{
			for(int c=0; c<maze[r].length; c++)
			{
				if(maze[r][c].toString().equals("E"))
					end = maze[r][c];
			}
		}
		return end;
	}
	/**
	 * reset the whole maze 
	 */
	public void reset() {
		for(int i=0;i < maze.length;i++) { //O(n^2)
			for(int j =0; j < maze[0].length;j++)
			{
				maze[i][j].reset();
			}
		}
		
	}
	/**
	 * prints out the maze
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < maze.length;i++)// O(n^2)
		{
			for(int j =0; j < maze[0].length;j++)
			{
				String n = maze[i][j].toString() + " ";
				sb.append(n);
			}
			sb.append("\n");
		}
		String s = new String(sb);
		return s;
	}
	
}
