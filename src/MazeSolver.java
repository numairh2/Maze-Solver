import java.util.ArrayList;

public abstract class MazeSolver {
	private Maze maze;
	private boolean solved;
	private boolean solvable;
	/**
	 * Constructor that takes a Maze as a parameter and stored in a variable that 
	 * extending classes can access.
	 * @param maze Object that references the Maze class
	 */
	public MazeSolver(Maze maze) {
		
		this.maze = maze;
		this.makeEmpty();
		this.add(maze.getStart());
		this.solved = false;
		this.solvable = true; 
	}
	
	
	/**
	 * Create an empty worklist
	 */
	abstract void makeEmpty();
	
	
	/**
	 * checks if the worklist is empty.
	 * @return boolean if the worklist is empty.
	 */
	abstract boolean isEmpty();
	
	
	/**
	 * get the next item in the worklist
	 * @return a Square object.
	 */
	abstract Square next();
	
	
	/**
	 * adds the square object to the worklist
	 * @param sq Square Object 
	 */
	abstract void add(Square sq);
	
	
	/**
	 * checks if the maze is solved.
	 * @return a boolean value if the maze is solved. 
	 */
	public boolean isSolved() 
	{
		return solved;
	}
	
	
	/**
	 * steps through the maze and solves it.
	 */
	public void step() {
		if(!isEmpty())
		{
			Square current = next();
			
			
			if(!solved)
			{
				ArrayList<Square> neighbors = new ArrayList<Square>(maze.getNeighbors(current));
				Square neighbor = null;
				for(int i =0; i < neighbors.size();i++) 
				{
					 neighbor = neighbors.get(i);
		
					if(neighbor.getType() != Square.WALL && neighbor.getStatus() != Square.EXPLORED ) 
					{
						this.add(neighbor); 
						neighbor.setStatus(Square.WORKING);
					}
					if(neighbor.equals(maze.getExit())) 
					 {
						 solved = true;
						 break;
					 }
				}
				
				if(!neighbor.equals(maze.getExit()) && this.isEmpty())
				{
					solvable = false;
				}
				current.setStatus(Square.EXPLORED);
				
				
			} 
			
		}
		else {
			solvable = false;
			solved = false;
		}
	}
	
	
	/**
	 * determines to the text if the Path is solved or not
	 * @return String of if the maze is solved, solvable, or not solvable.
	 */
	public String getPath() {
		String str = "";
		if(isSolved()) 
			str = "maze is solved";
		else if(solvable && this.isEmpty()) 
			str = "maze is not solvable";
		else 
			str = "maze is not solved yet";
		return str;
	}
	
	
	/**
	 * Repeatedly call step while the maze is not solved.
	 */
	public void solve() {
		while(!isSolved() && solvable && !this.isEmpty())
		{
			step();
		}
	}
	
	
	
}
