package Program4;

import java.util.Random;

public class BagSortedArrayCollection<T> extends SortedArrayCollection<T> implements BagInterface<T> {

	public BagSortedArrayCollection() {
		super();
	}

	public BagSortedArrayCollection(int capacity) {
		super(capacity);
	}

	public T grab() {
		// If this bag is not empty, removes and returns a random element of the bag;
		// otherwise returns null.
		if (this.isEmpty()) {
			return null;
		} else {
			Random rand = new Random();
			int index = rand.nextInt(this.size());
			T tempValue = this.elements[index];
			for (int i = 0; index + i < this.size(); i++) {
				this.elements[index] = this.elements[index + i];
			}
			this.numElements--;
			return tempValue;
		}
	}

	public int count(T target) {
		// Returns a count of all elements e in this collection such that
		// e.equals(target).
		int counter = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.elements[i].equals(target)) {
				counter++;
			}
		}
		return counter;
	}

	public int removeAll(T target) {
		int counter = 0;

		for (int i = 0; i < this.size(); i++) {
			if (this.elements[i].equals(target)) {
				this.elements[i] = null;
				counter++;
			}
		}

		T[] tempArray = (T[]) new Object[this.size()];
		int j=0;
		for (int i = 0; i < this.size(); i++) {
			if (this.elements[i] != null) {
				tempArray[j++] = this.elements[i];
			}
		}

		for (int i = 0; i < tempArray.length; i++) {
			this.elements[i] = tempArray[i];
		}

		for (int i = 0; i < counter; i++) {
			this.numElements--;
		}

		return counter;
	}

	public void clear() {
		for (int i = 0; i < this.numElements; i++) {
			this.elements[i] = null;
		}
		this.numElements = 0;
	}
	
	public String toString() {
		String tempString = "";
		for (int i=0; i<this.size();i++) {
			tempString += this.elements[i] + "\n";
		}
		return tempString;
	}
}
