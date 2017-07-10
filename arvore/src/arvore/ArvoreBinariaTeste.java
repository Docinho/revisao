package arvore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArvoreBinariaTeste {

	private ArvoreBinaria<Integer> tree;

	@Before
	public void setUp() throws Exception {
		tree = new ArvoreBinaria();
		assertTrue(tree.isEmpty());
	}

	@Test
	public void testInsert() {
		assertTrue(tree.isEmpty());
		tree.insert(87);
		assertFalse(tree.isEmpty());
		tree.insert(7);
		assertFalse(tree.isEmpty());
	}

	@Test
	public void testSearch() {
		assertTrue(tree.isEmpty());
		assertEquals(null, tree.search(2));
		tree.insert(64);
		assertEquals(null, tree.search(2));
		assertEquals(64, tree.search(64).getData());
		tree.insert(43);
		assertEquals(43, tree.search(43).getData());
		assertEquals(null, tree.search(2));
		tree.insert(87);
		assertEquals(87, tree.search(87).getData());
		tree.insert(37);
		assertEquals(37, tree.search(37).getData());
		tree.insert(94);
		assertEquals(94, tree.search(94).getData());
		tree.insert(143);
		assertEquals(143, tree.search(143).getData());
		tree.insert(4);
		assertEquals(4, tree.search(4).getData());
	}

	@Test
	public void testMinimum() {
		assertEquals(null, tree.minimum());
		tree.insert(4);
		assertEquals(4, tree.minimum().getData());
		tree.insert(64);
		assertEquals(4, tree.minimum().getData());
		tree.insert(-64);
		assertEquals(-64, tree.minimum().getData());
		tree.insert(94);
		assertEquals(-64, tree.minimum().getData());
	}

	@Test
	public void testMaximum() {
		assertEquals(null, tree.maximum());
		tree.insert(4);
		assertEquals(4, tree.maximum().getData());
		tree.insert(64);
		assertEquals(64, tree.maximum().getData());
		tree.insert(-64);
		assertEquals(64, tree.maximum().getData());
		tree.insert(94);
		assertEquals(94, tree.maximum().getData());
	}

	@Test
	public void testOrder() {
		Integer[] array = new Integer[0];
		assertEquals(array, tree.order());
		array = new Integer[] { -40, -34, 2, 5, 64 };
		assertEquals(-1, tree.height());
		tree.insert(2);
		assertEquals(0, tree.height());
		tree.insert(5);
		assertEquals(1, tree.height());
		tree.insert(-40);
		assertEquals(1, tree.height());
		tree.insert(64);
		assertEquals(2, tree.height());
		tree.insert(-34);
		assertEquals(2, tree.height());
		assertEquals(array, tree.order());

	}

	@Test
	public void testPredecessor() {
		assertEquals(null, tree.predecessor(null));
		assertEquals(null, tree.predecessor(new Node()));
		tree.insert(2);
		Node n = tree.search(2);
		assertEquals(null, tree.predecessor(n));
		tree.insert(5);
		n = tree.search(5);
		assertEquals(n.getParent(), tree.predecessor(n));
		tree.insert(1);
		n = tree.search(1);
		assertEquals(null, tree.predecessor(n));
		tree.insert(4);
		n = tree.search(4);
		assertEquals(tree.search(2), tree.predecessor(n));
		tree.insert(-1);
		n = tree.search(1);
		assertEquals(tree.search(-1), tree.predecessor(n));

	}

	@Test
	public void testSucessor() {
		assertEquals(null, tree.sucessor(null));
		assertEquals(null, tree.sucessor(new Node()));
		tree.insert(20);
		tree.insert(70);
		tree.insert(15);
		tree.insert(72);
		tree.insert(59);
		tree.insert(88);
		tree.insert(10);
		tree.insert(17);
		Node n = tree.search(20);
		assertEquals(tree.search(59), tree.sucessor(n));
		n = tree.search(88);
		assertEquals(null, tree.sucessor(n));
		n = tree.search(15);
		assertEquals(tree.search(17), tree.sucessor(n));
	}

	@Test
	public void testRemove() {
		tree.remove(null);
		tree.remove(20);
		tree.insert(20);
		tree.remove(20);
		assertTrue(tree.isEmpty());
		tree.insert(20);
		tree.insert(20);
		tree.remove(70);
		assertEquals(null, tree.search(70));
		tree.insert(10);
		tree.remove(10);
		assertEquals(null, tree.search(10));
		tree.insert(70);
		tree.insert(72);
		tree.insert(59);
		tree.insert(88);
		tree.remove(20);
		assertEquals(88, tree.search(88).getData());
		tree.remove(70);
		assertEquals(null, tree.search(70));
		tree.insert(20);
		tree.insert(12);
		tree.insert(9);
		tree.insert(38);
		tree.insert(16);
		tree.insert(87);
		tree.insert(69);
		tree.insert(60);
		tree.remove(59);
		tree.remove(87);
		System.out.println(Arrays.toString(tree.order()));
		tree.remove(20);
		assertEquals(16, tree.search(16).getData());
		assertEquals(88, tree.search(88).getData());
		System.out.println(Arrays.toString(tree.order()));
		tree.remove(88);
		System.out.println(Arrays.toString(tree.order()));


		
	}
}
