package revisao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TabelaHash {

	private Pair[] array;
	private int size;
	private int elements;

	public TabelaHash(int size) {
		this.elements = 0;
		this.size = size;
		this.array = new Pair[size];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TabelaHash table = new TabelaHash(sc.nextInt());
		sc.nextLine();

		String[] entrada = sc.nextLine().split(" ");

		while (!entrada[0].equals("end")) {
			if (entrada[0].equals("put")) {
				System.out.println(Arrays.toString(table.put(Integer.parseInt(entrada[1]), entrada[2])));
			} else if (entrada[0].equals("remove")) {
				System.out.println(Arrays.toString(table.remove(Integer.parseInt(entrada[1]))));
			} else if (entrada[0].equals("keys")) {
				System.out.println(Arrays.toString(table.keys()));
			} else if (entrada[0].equals("values")) {
				System.out.println(Arrays.toString(table.values()));
			}
			entrada = sc.nextLine().split(" ");
		}
		
		sc.close();
	}

	private int[] keys() {
		int[] keys = new int[this.elements];
		int i = 0;
		int j = 0;
		while (j <= keys.length && i < size) {
			if (array[i] != null)
				keys[j++] = array[i].getKey();
			i++;
		}
		Arrays.sort(keys);
		return keys;
	}

	private String[] values() {
		String[] values = new String[this.elements];
		int i = 0;
		int j = 0;
		while (j <= values.length && i < size) {
			if (array[i] != null)
				values[j++] = array[i].getValue();
			i++;
		}

		Arrays.sort(values);
		return values;
	}

	private Pair[] remove(int key) {
		if (elements > 0) {
			
			int index = indexOf(key);
			
			if (index != -1) {
				array[index] = null;
				elements--;
			}

		}
		return array;
	}

	private Pair[] put(int key, String value) {
		
			int index = indexOf(key);
			if (index != -1) {
				array[index].setValue(value);
			} else if (size > elements) {
				int j = 0;
				int indice = funcao(key, j);

				while ((array[indice]) != null) {
					indice = funcao(key, ++j);
				}

				array[indice] = new Pair(key, value);
				elements++;
			}
		
		return array;

	}

	private int indexOf(int key) {
		int index = -1;
		int i = 0;
		while (i < array.length) {
			if (array[i] != null && array[i].getKey() == key) {
				index = i;
				break;
			}
			i++;
		}
		return index;
	}

	private int funcao(int key, int probe) {
		return (key + probe) % size;
	}

}

class Pair {
	private int key;
	private String value;

	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "<" + this.getKey() + ", " + this.getValue() + ">";
	}

}