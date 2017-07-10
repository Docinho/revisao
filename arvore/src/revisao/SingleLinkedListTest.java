package revisao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

	private SingleLinkedList list;
	
	@Before
	public void setUp() throws Exception {
		this.list = new SingleLinkedList();
	}

	@Test
	public void testInsert() {
		assertEquals(0, this.list.size());
		assertEquals(0, this.list.search(2).getData());
		list.insert(2);
		assertEquals(1, this.list.size());
		list.insert(5);
		assertEquals(2, this.list.size());
		assertEquals(2, this.list.search(2).getData());
		assertEquals(5, this.list.search(5).getData());
		list.insert(52);
		assertEquals(3, this.list.size());
		assertEquals(52, this.list.search(52).getData());
		assertEquals(2, this.list.getHead().getData());
	}

	@Test
	public void testRemove() {
		assertEquals(0, this.list.remove(98));
		list.insert(5);
		assertEquals(0, this.list.remove(8));
		assertEquals(5, this.list.remove(5));
		assertEquals(0, this.list.remove(5));
		list.insert(5);
		list.insert(6);
		list.insert(4);
		list.insert(75);
		assertEquals(4 	, this.list.remove(4));
		assertEquals(75, this.list.remove(75));
		
	}

}
