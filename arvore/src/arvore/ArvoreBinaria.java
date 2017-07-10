package arvore;

public class ArvoreBinaria<T extends Comparable<T>> {

	private Node<T> root;

	public ArvoreBinaria() {
		this.root = new Node();
		this.root.setRight(new Node());
		this.root.setLeft(new Node());
	}

	public ArvoreBinaria(Node node) {
		this.root = node;
		this.root.setRight(new Node());
		this.root.setLeft(new Node());
	}

	public void insert(T element) {
		if (element != null)
			insert(element, root);
	}

	private void insert(T element, Node node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new Node());
			node.getLeft().setParent(node);
			node.setRight(new Node());
			node.getRight().setParent(node);
		} else if (node.getData().compareTo(element) < 0)
			insert(element, node.getRight());
		else if (node.getData().compareTo(element) > 0)
			insert(element, node.getLeft());
	}

	public Node search(T element) {
		return search(element, root);
	}

	private Node search(T element, Node node) {
		if (node.isEmpty())
			return null;
		if (node.getData().equals(element))
			return node;
		if (node.getData().compareTo(element) < 0)
			return search(element, node.getRight());
		return search(element, node.getLeft());
	}

	public boolean isEmpty() {
		return root.isEmpty();
	}

	public Node minimum() {
		if (isEmpty())
			return null;
		return minimum(root);
	}

	private Node minimum(Node node) {
		if (node.getLeft().isEmpty())
			return node;
		return minimum(node.getLeft());
	}

	public Node maximum() {
		if (isEmpty())
			return null;
		return maximum(root);
	}

	private Node maximum(Node<T> node) {
		if (node.getRight().isEmpty())
			return node;
		return maximum(node.getRight());
	}

	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];
		if (!this.isEmpty())
			order(this.root, array, 0);
		return array;
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node<T> node) {
		int retorno = 0;
		if (!node.isEmpty())
			retorno = 1 + size(node.getLeft()) + size(node.getRight());
		return retorno;
	}

	private int order(Node<T> node, T[] array, int indice) {
		int i = indice;
		if (!node.isEmpty()) {
			i = order(node.getLeft(), array, i);
			array[i++] = node.getData();
			i = order(node.getRight(), array, i);
		}
		return i;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node<T> node) {
		int retorno = -1;
		if (!node.isEmpty())
			retorno = 1 + Math.max(height(node.getLeft()), height(node.getRight()));

		return retorno;
	}

	public Node<T> predecessor(Node node) {
		if (node == null || node.isEmpty())
			return null;
		if (!node.getLeft().isEmpty())
			return maximum(node.getLeft());
		Node antecessor = node.getParent();
		while (antecessor != null && !antecessor.isEmpty() && antecessor.getData().compareTo(node.getData()) > 0) {
			node = antecessor;
			antecessor = antecessor.getParent();
		}
		return antecessor;
	}

	public Node<T> sucessor(Node node) {
		if (node == null || node.isEmpty())
			return null;
		if (!node.getRight().isEmpty())
			return minimum(node.getRight());
		Node antecessor = node.getParent();
		while (antecessor != null && !antecessor.isEmpty() && antecessor.getData().compareTo(node.getData()) < 0) {
			node = antecessor;
			antecessor = antecessor.getParent();
		}
		return antecessor;
	}

	public void remove(T element) {

		Node node = null;
		if (element != null) {
			node = search(element);
			if (node != null)
				remove(node);
		}
	}

	private void remove(Node node) {
		if (this.root.getData().equals(node.getData())) {

			Node<T> auxNode = sucessor(node);
			if (auxNode == null)
				auxNode = predecessor(node);

			if (auxNode == null) {
				node.setData(null);
			} else {
				T auxData = (T) node.getData();
				node.setData(auxNode.getData());
				auxNode.setData(auxData);
				remove(auxNode);
			}

		} else {
			if (node.isLeaf())
				node.setData(null);
			else if (node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
				node.getRight().setParent(node.getParent());
				if (node.getData().equals(node.getParent().getRight().getData()))
					node.getParent().setRight(node.getRight());
				else
					node.getParent().setLeft(node.getRight());
			} else if (!node.getLeft().isEmpty() && node.getRight().isEmpty()) {
				node.getLeft().setParent(node.getParent());
				if (node.getParent().getLeft().getData().equals(node.getData()))
					node.getParent().setLeft(node.getLeft());
				else
					node.getParent().setRight(node.getLeft());
			} else {
				Node<T> sucessorNode = sucessor(node);
				T auxData = (T) node.getData();
				node.setData(sucessorNode.getData());
				sucessorNode.setData(auxData);
				remove(sucessorNode);
			}
		}
	}
}
