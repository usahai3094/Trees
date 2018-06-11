
public class TreeNode<E> {
	
	private E data;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	
	public TreeNode(E val, TreeNode<E> node) {
		this.data = val;
		this.parent = node;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode<E> addLeft(E val)
	{
		this.left = new TreeNode<E>(val,this);
		return this.left;
	}
	
	public TreeNode<E> addRight(E val)
	{
		this.right = new TreeNode<E>(val,this);
		return this.right;
	}

	public void visit() {
		System.out.println(this.data);
	}

	public TreeNode<E> getLeftChild() {
		return this.left;
	}

	public TreeNode<E> getRightchild() {
		return this.right;
	}
	
	public E getData()
	{
		return this.data;
	}
	
	/*
	public static void main(String args[])
	{
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		node.addLeft(2).addLeft(4);
		node.addRight(3);
		
		TreeNode<Integer> temp = node;
		while(temp.getLeftChild()!=null)
		{
			System.out.println(temp.data);
			temp = temp.getLeftChild();
		}
		System.out.println(temp.data);
	}
	*/
}
