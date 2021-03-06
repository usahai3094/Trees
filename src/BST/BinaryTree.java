package BST;

public class BinaryTree<E extends Comparable<? super E>> extends Tree<E> {
	
	public BinaryTree()
	{
		super();
	}
	
	public BinaryTree(E val)
	{
		super(val);
	}	
	
	public boolean insert(E val)
	{
		
		if(getRoot()==null) {
			setRoot(val);
			incSize();
			return true;
		}
			
		TreeNode<E> curr = getRoot();
		int comp = val.compareTo(curr.getData());		
		
		while((comp<0 && curr.getLeftChild()!=null) ||
				(comp>0 && curr.getRightChild()!=null)) 
		{			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightChild();
			
			comp = val.compareTo(curr.getData());	
		}
		
		if(comp<0)
		{
			curr.addLeft(val);
			incSize();
		}
		else if(comp>0)
		{
			curr.addRight(val);
			incSize();
		}
		else
			return false;
		
		return true;
			
	}
	
	public void delete(E val)
	{
		TreeNode<E> curr = getRoot();		
		TreeNode<E> prev = curr;
		int comp;		
		
		while(curr!=null){
			comp = val.compareTo(curr.getData());
			
			if(comp < 0){
				prev = curr;
				curr = curr.getLeftChild();
			}else if(comp > 0){
				prev = curr;
				curr = curr.getRightChild();
			}else
				break;
		}
		
		if(curr.getLeftChild()==null){
			if(curr.getRightChild() == null){
				if(prev==curr){
					curr.delete();
				}else{
					comp = curr.getData().compareTo(prev.getData());
				
					if(comp<0)
						prev.deleteLeft();				
					else
						prev.deleteRight();
				}
			}else{
				curr.setData(curr.getRightChild().getData());
				curr.deleteRight();
			}
			
		}else if(curr.getRightChild() == null){
			curr.setData(curr.getLeftChild().getData());
			curr.deleteLeft();
		}else{
			TreeNode<E> smallest = curr.getRightChild();
			
			while(smallest.getLeftChild()!=null){
				smallest=smallest.getLeftChild();
			}
			
			E temp = smallest.getData();
			delete(temp);
			curr.setData(temp);
		}		
	}
	
	public static void main(String args[])
	{
		BinaryTree<Integer> btree = new BinaryTree<Integer>();	
		btree.insert(20);
		btree.insert(10);
		btree.insert(30);
		btree.insert(12);
		btree.insert(5);
		btree.insert(35);
		btree.insert(39);
		btree.insert(3);
		btree.insert(1);
		
		btree.levelOrder();
		System.out.println("\nNodes - "+btree.getSize()+" | Height - "+btree.height(btree.getRoot()));
		System.out.println("Balanced - "+btree.isBalanced(btree.getRoot()));
		System.out.println("**********************************************");
	}
}
