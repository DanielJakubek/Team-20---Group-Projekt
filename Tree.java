
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
	
	/**
	 * adds a new node to the tree, if there are no other nodes in the tree, it will set the new node as the root
	 * @param id the Appointment ID for the new node
	 * @param appointment the appointment associated with the new node
	 */
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
	
	/**
	 * intermediary method that will call the main delete method
	 * @param value the ID of the node
	 */
	public void delete(int value) {
	    root = delete(root, value);
	}

	/**
	 * deletes a node from the tree
	 * @param current the starting node
	 * @param value the ID of the node to be deleted
	 * @return
	 */
	public Node delete(Node current, int value) {
	    if (current == null) {
	        return null;
	    }

	    if (value == current.getAppID()) {
	        // No children
	        if (current.getLeft() == null && current.getRight() == null) {
	            return null;
	        }

	        // Only 1 child
	        if (current.getRight() == null) {
	            return current.getLeft();
	        }
	        if (current.getLeft() == null) {
	            return current.getRight();
	        }

	        // Two children
	        Node smallestValue = minValue(current.getRight());
	        current.setAppID(smallestValue.getAppID());
	        current.setRight(delete(current.getRight(), smallestValue.getAppID()));
	        return current;
	    }
	    if (value < current.getAppID()) {
	        current.setLeft(delete(current.getLeft(), value));
	        return current;
	    }

	    current.setRight(delete(current.getRight(), value));
	    return current;
	}
	
	/**
	 * finds the minimum value in a subtree
	 * @param node the starting node
	 * @return the node with the minimum value
	 */
	public Node minValue(Node node)
	{
		Node minNode = node;
		while (node.getLeft() != null)
		{
			minNode = node.getLeft();
			node = node.getLeft();
		}
		return minNode;
	}
}
