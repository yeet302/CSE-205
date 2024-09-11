public class StringList {
	private String[] list;
	private int index;
	
	public StringList() {
		list = new String[10];
		index = 0;
	}
	
	public int length() {
		return index;
	}
	
	public void addFirst(String x) {
		if (index == list.length) {
			expand(10);
		}
		
		for (int i = index; i > 0; i--) {
			list[i] = list[i-1];
		}
		
		list[0] = x;
		index++;
	}
	
	public void addLast(String x) {
		if (index == list.length) {
			expand(10);
		}

		list[index++] = x;
	}
	
	public String getFirst() {
		if (index == 0) {
			throw new ArrayIndexOutOfBoundsException("StringList: There is no first.");
		}
		return list[0];
	}
	
	public String get(int c) {
		if (c >= index) {
			throw new ArrayIndexOutOfBoundsException("StringList: There is no #" + c);
		}
		return list[c];
	}

	public int find(String s) {
		int i;
		
		for (i = 0; i < index && list[i].compareTo(s) != 0; i++);
		
		if (i == index) {
			throw new ArrayIndexOutOfBoundsException("StringList: There is no \"" + s + "\"");
		}
		return i;
	}
	
	public void insertAfter(int c, String e) throws ArrayIndexOutOfBoundsException {
		if (c >= index) {
			throw new ArrayIndexOutOfBoundsException("StringList: There is no #" + c);
		}

		if (index == list.length) {
			expand(10);
		}

		for (int i = index; i > (c+1); i--) {
			list[i] = list[i-1];
		}
		list[c+1] = e;
		index++;
	}

	public void insertAfter(String s, String e) {
		int i = find(s);
		if (i >= 0)
			insertAfter(i, e);
	}
	
	public void delete(int c) {
		if (c >= index) {
			throw new ArrayIndexOutOfBoundsException("StringList: There is no #" + c);
		}
		for (int i = c; i < index; i++) {
			list[i] = list[i+1];
		}
		index--;
	}
	
	private void expand(int n){
		String[] newlist = new String[list.length + n];
		for(int i = 0; i < list.length; i++) {
			newlist[i] = list[i];
		}
		list = newlist;
	}
}
