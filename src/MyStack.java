import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack implements StackADT {
	private Square[] stack;
	private int size;
	/**
	 * MyStack Default Constructor 
	 */
	public MyStack(){
		this(1);
	}
	
	/**
	 * Overloaded Constructor with input 
	 * @param intiCap the size 
	 */
	public MyStack(int intiCap)
	{
		this.size = -1;
		this.stack = new Square[intiCap];
		
	}
	
	/**
	 * Checks if isEmpty of the stack 
	 */
	public boolean isEmpty()
	{
		return size == -1;
	}
	
	
	/**
	 * gets the next item without popping the stack
	 */
	public Square peek() 
	{ 
		if(!this.isEmpty())
            return stack[size];
		
		throw new EmptyStackException();
	}
	
	/**
	 * gets the next element by removing it 
	 */
	public Square pop()
	{
		
		if(isEmpty())
			throw new EmptyStackException();
		int returnedTop = size;
		size--;
        return stack[returnedTop];
		
		
	}
	/**
	 * pushes the element into the stack
	 */
	public void push(Square item)
	{
		if (size == stack.length-1) {
			doubleCapacity();
        }
		size++;
		stack[size] = item;
		
		}
	/**
	 * double the capacity size
	 */
		
	private void doubleCapacity() 
	{
		int newSize = stack.length * 2;
		stack = Arrays.copyOf(stack, newSize);
		
	}
	/**
	 * prints out the toString
	 */
	
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < stack.length ;i++) {
            sb.append(stack[i].toString());
            if(i < stack.length-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
	}
	/**
	 * returns the size of the stack 
	 */
	public int size() {
		
		return size;
	}
	/**
	 * clears the stack 
	 */
	public void clear() {
		
	this.stack = new Square[stack.length];
	}
	
}
