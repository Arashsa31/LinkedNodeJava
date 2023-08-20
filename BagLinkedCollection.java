package Program4;

import java.util.Random;

public class BagLinkedCollection<T> extends LinkedCollection<T> implements BagInterface<T> {

	// If this bag is not empty, removes and returns a random element of the bag;
	// otherwise returns null.
	public T grab() {
		if (this.isEmpty()) {
			return null;
		} else {
			Random rand = new Random();
			int index = rand.nextInt(this.size());
			int count = 0;
			LLNode current = head.getLink();
			LLNode prev = head;

			if (count == index) {
				head = head.getLink();
				this.numElements--;
				return (T) prev.getInfo();
			} else {
				while (count + 1 < index & current.getLink() != null) {
					count++;

					prev = current;
					current = current.getLink();
				}
				prev.setLink(current.getLink());
			}
			this.numElements--;
			return (T) current.getInfo();
		}
	}

	// Returns a count of all elements e in this collection such that
	// e.equals(target).
	public int count(T target) {
		int counter = 0;

		LLNode current = head.getLink();
		LLNode prev = head;

		if (head.getInfo().equals(target)) {
			counter++;
		}

		while (prev.getLink() != null) {
			prev = current;
			current = current.getLink();

			if (prev.getInfo().equals(target)) {
				counter++;
			}
		}
		return counter;
	}

	// Removes all elements e from this collection such that e.equals(target)
	// and returns the number of elements removed.
	public int removeAll(T target) {
		int counter = numElements;

		LLNode current = head.getLink();
		LLNode prev = head;

		if (prev.getInfo().equals(target)) {
			head = head.getLink();
			this.numElements--;

		} else {
			while (prev.getLink() != null) {
				prev = current;
				current = current.getLink();

				if (current.getInfo().equals(target)) {
					prev.setLink(current.getLink());
					this.numElements--;
				}
			}
		}
		return counter - numElements;
	}

	// Empties this bag so that it contains zero elements.
	public void clear() {
		head.setLink(null);
		head.setInfo(null);
		numElements = 0;
	}

	public String toString() {

		String tempString = "";

		LLNode current = head.getLink();
		LLNode prev = head;

		if (prev.getInfo() != null)
			tempString = (String) head.getInfo() + "\n";

		// goes through the list
		while (current != null) {
			prev = current;
			current = current.getLink();
			tempString += (String) prev.getInfo() + "\n";
		}

		return tempString;
	}
}
