
public class MazeSolverStack extends MazeSolver {
	private MyStack stack;
	/**
	 * Constructor that takes the super class constructor
	 * @param maze Object that references the Maze class
	 */
	public MazeSolverStack(Maze maze){
		super(maze);
	}
	
	
	/**
	 * Overrides and creates an empty worklist
	 */
	@Override
	public void makeEmpty() {
		this.stack = new MyStack();
	}
	
	
	/**
	 * adds the square object to the worklist
	 * @param sq Square Object 
	 */
	@Override 
	public void add(Square s) {
		this.stack.push(s); //O(1)
	}
	
	/**
	 * checks if the worklist is empty.
	 * @return boolean if the worklist is empty.
	 */
	@Override 
	public boolean isEmpty() {
		return this.stack.isEmpty();
		
	}
	
	/**
	 * Overrides and get the next item in the worklist
	 * @return a Square object.
	 */
	@Override 
	public Square next() {
		
		return this.stack.pop(); //O(1)
	}
		
}


