public class Stack {
	private List theStack;
	
	/**
	 * connstructor for the Stack class
	 */
	public Stack() {
		theStack = new List();
	}
		
	/**
	 * checks if the stack is empty
	 * @return boolean value, true if the stack is empty, false if it is not
	 */
	public boolean isEmpty()
	{
		ListNode top = theStack.getHead();
		return top == null;
	}
	
	/**
	 * pushes a value to the stack
	 * @param x the command being pushed
	 */
	public void push(UndoableCommand x)
	{
		theStack.addToList(x);
	}
	
	/**
	 * pops an item from the stack
	 * @return the item that was popped
	 */
	public UndoableCommand pop()
	{
		if(this.isEmpty())
		{
			System.out.println("The stack is empty");
			return null;
		}
		else
		{
		ListNode temp = theStack.getHead();
		ListNode poppedItem = null;
		
		poppedItem = theStack.getHead();
		theStack.setHead(temp.getNext());
		return poppedItem.getCommand();
		}
	}
	
	/**
	 * getter for the list
	 * @return the list
	 */
	public List getList()
	{
		return this.theStack;
	}
}