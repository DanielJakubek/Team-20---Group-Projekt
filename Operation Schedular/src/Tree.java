
public class Tree {
	private Node root;
	
	/**
	 * Default constructor for the tree class
	 */
	public Tree()
	{
		root = null;
	}
	
	/**
	 * Accessor method for the root node
	 * @return the root node of the tree
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/**
	 * Mutator method for the root node
	 * @param root the root node of the tree
	 */
	public void setRoot(Node root)
	{
		this.root = root;
	}
	
	/**
	 * Determines if a tree is empty by checking if the root node is null
	 * @return returns true if the tree is empty, false if it is not
	 */
	public boolean isTreeEmpty()
	{
		if (this.root == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * searched the tree for a node with the specified ID
	 * @param searchID the desired ID
	 * @return if a node with the matching ID exists, it will return that node, otherwise it will return null
	 */
	public Node findInTree(int searchID)
	{
		Node currentNode = new Node();
		boolean found = false;
		
		currentNode = root;
		
		while(currentNode != null && !found)
		{
			if(currentNode.getAppID() == searchID)
			{
				found = true;
			}
			else
			{
				if(searchID < currentNode.getAppID())
				{
					currentNode = currentNode.getRight();
				}
				else
				{
					currentNode = currentNode.getLeft();
				}
			}
		}
		if(found)
		{
			return currentNode;
		}
		else
		{
			return null;
		}
	}
	
	public void addToTree(int id, Appointment appointment)
	{
		Node newNode = new Node(id, appointment);
		
		Node current = new Node();
		Node previous = new Node();
		boolean found = false;
		
		if(this.isTreeEmpty())
		{
			//if the tree is empty, set the new node to be the root
			this.root = newNode;
		}
		else
		{
			if(findInTree(newNode.getAppID()) == null)
			{
				current = root;
				previous = null;
			}
			while(current != null  && !found)
			{
				previous = current;
				if(newNode.getAppID() < current.getAppID())
				{
					current = current.getLeft();
				}
				else
				{
					current = current.getRight();
				}
			}
			if(findInTree(newNode.getAppID()) == null)
			{
				if(newNode.getAppID() < previous.getAppID())
				{
					previous.setLeft(newNode);
				}
				else
				{
					previous.setRight(newNode);
				}
			}
		}
	}
	
	public Node delete(int id)
	{
		Node previous = null;
		Node current = root;
		
		//find the desired node in the tree and assign the current and previous values
		while(current != null && current.getAppID() != id)
		{
			previous = current;
			
			if(id < current.getAppID())
			{
				current = current.getLeft();
			}
			else
			{
				current = current.getRight();
			}
		}
		
		//Case 1: leaf node
		if(current.getLeft() == null && current.getRight() == null)
		{
			if(current != this.root)
			{
				if(previous.getLeft() == current)
				{
					previous.setLeft(null);
					return current;
				}
				else
				{
					previous.setRight(null);
					return current;
				}
			}
			//if the root node is the only node
			else
			{
				this.root = null;
				return null;
			}
		}
		
		//Case 2: 2 child nodes
		else if(current.getLeft() != null && current.getRight() != null)
		{
			//still working on this
			return null;
		}
		
		//Case 3: 1 child node
		else
		{
			Node child = null;
			if(current.getLeft() == null)
			{
				child = current.getRight();
			}
			else
			{
				child = current.getLeft();
			}
			
			if(current != this.root)
			{
				if(current == previous.getLeft())
				{
					previous.setLeft(child);
				}
				else
				{
					previous.setRight(child);
				}
			}
			else
			{
				this.root = child;
			}
			return current;
		}
	}
}
