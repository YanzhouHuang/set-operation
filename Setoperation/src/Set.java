import java.util.ArrayList;

public class Set {

	int[] content = new int[20];
	int cardinality;

	//a Set constructor 
	public Set(int[] in) {
		this.content = in;
	}

	public int[] getContent() {
		return content;
	}

	public void setContent(int[] content) {
		this.content = content;
	}
 
	// union 
	// remove duplicate elements
	public Set union(Set B) {
		int[] C = new int[20];
		int x = 0;
		boolean flag = false;
		int[] tmp = B.getContent();
		for (int i = 0; i < tmp.length; i++) {
			C[x] = tmp[i];
			x++;
		}
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < tmp.length; j++) {
				if (content[i] == tmp[j]) {
					flag = true;
				}
			}
			if (flag == false) {
				C[x] = content[i];
				x++;
			}
			flag = false;
		}
		Set U = new Set(C);
		return U;
	}
	
	// intersection
	public Set intersection(Set B) {
		int[] C = new int[20];
		int x = 0;
		int[] tmp = B.getContent();
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < tmp.length; j++) {
				if (content[i] == tmp[j]) {
					C[x] = content[i];
					x++;
				}
			}
		}
		Set U = new Set(C);
		return U;
	}
	
	// A - B
	public Set difference(Set B) {
		int[] C = new int[20];
		int x = 0;
		boolean flag = false;
		int[] tmp1 = intersection(B).getContent();
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < tmp1.length; j++) {
				if (content[i] == tmp1[j]) {
					flag = true;
				}
			}
			if (flag == false) {
				C[x] = content[i];
				x++;
			}
			flag = false;
		}
		Set U = new Set(C);
		return U;
	}
	
	//U - A or U - B
	public Set complement(Set B) {
		int[] C = new int[20];
		int x = 0;
		boolean flag = false;
		int[] tmp1 = union(B).getContent();
		for (int i = 0; i < tmp1.length; i++) {
			if (tmp1[i] >= 0) {
				for (int j = 0; j < content.length; j++) {
					if (tmp1[i] == content[j]) {
						flag = true;
					}
				}
			}
			if (flag == false) {
				C[x] = tmp1[i];
				x++;
			}
			flag = false;
		}
		Set U = new Set(C);
		return U;
	}
	
	// A*B
	public Set product(Set B) {
		int[] C = new int[400];
		int x = 0;
		int[] tmp1 = union(B).getContent();
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < tmp1.length; j++) {
				C[x] = content[i] * tmp1[j];
				x++;
			}
		}
		Set U = new Set(C);
		return U;
	}

}