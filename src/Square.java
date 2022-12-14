
public class Square {
	// to keep the numbers as said in the rules
	public static final int SPACE =0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT =3;
	
	public static final char WORKING = 'o';
	public static final char EXPLORED = '.';
	public static final char ON_EXIT_PATH = 'x';
	public static final char UNKNOWN = '_';
	
	private int row;
	private int col;
	private int type;
	private char status;
	
	/**
	 * The constructor which takes in the position of the square and the type of square.
	 * @param row rows 
	 * @param col columns 
	 * @param type the number which tells which is a wall,start,or exit
	 */
	
	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
		
	}
	/**
	 * Returns the postion's status and prints the walls, start and end positions.
	 */
	 public String toString() 
	 {
		 if(this.type == SPACE) {
			 if(this.status == WORKING) 
				 return "o";
			 else if(this.status == EXPLORED)
				 return ".";
			 else if(this.status == ON_EXIT_PATH)
				 return "x";
			 return "_";
		 }
			
		 else if(this.type == WALL)
			 return "#";
		 else if(this.type == START)
			 return "S";
		
			 return "E";
	 }
	 /**
	  * Checks if the positions of the both sqaures are the same.
	  */
	 @Override 
	 public boolean equals(Object obj) {
		 Square s = (Square)obj;
		 return s.row == this.row && s.col== this.col;
	 }
	 /**
	  * reset the status to UNKNOWN
	  */
	 public void reset() {
		if(status == WORKING || status == EXPLORED || status == ON_EXIT_PATH)
			this.status = UNKNOWN; 
	 }
	 /**
	  * Sets the status 
	  * @param status new status 
	  */
	 public void setStatus(char status) {
		 this.status = status;
	 }
	 /**
	  * gets the location of square
	  * @return row in the position
	  */
	 public int getRow() {
		 return this.row;
	 }
	 /**
	  * gets the location of square
	  * @return row in the position
	  */
	 public int getCol() {
		 return this.col;
	 }
	 /**
	  * gets the type
	  * @return type of square
	  */
	 public int getType() {
		 return this.type;
	 }
	 /**
	  * gets the status of the square
	  * @return status
	  */
	 public char getStatus() {
		 return this.status;
	 }
}
