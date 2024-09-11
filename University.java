public class University {
	private String name;
	private StringList professors;
	
	public static void main(String[] args) {
		
		// Create our university, with professors
		University ASU = new University("ASU West - StringList");
		
		ASU.getProfessors().addLast("Dietrich");
		ASU.getProfessors().addLast("Silva");
		ASU.getProfessors().addLast("Wang");
		ASU.getProfessors().addLast("Xu");
		System.out.println("1: " + ASU);

		// Test accessing members of the list
		System.out.println("3rd Prof is " + ASU.getProfessors().get(3));
		System.out.println("Here is Silva: Position " + ASU.getProfessors().find("Silva"));
		
		// Test insertions
		ASU.getProfessors().insertAfter(2, "Tibbetts");
		System.out.println("2: " + ASU);

		ASU.getProfessors().insertAfter("Wang", "Eckert");
		System.out.println("3: " + ASU);

		ASU.getProfessors().delete(4);
		System.out.println("4: " + ASU);

		for(int i=1; i <= 5; i++)
			ASU.getProfessors().addFirst("Person"+i);
		System.out.println("5: " + ASU);
		
		try { ASU.getProfessors().get(1000); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().find("Turing"); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().insertAfter(1000,"Turing"); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().insertAfter("Kay","Turing"); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().delete(1000); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }
	}
	
	public University(String n) {
		name = n;
		professors = new StringList();
		
		System.out.println("University " + name + " created.");
	}
	
	public StringList getProfessors() {
		return professors;
	}
	
	public String toString() {
		String results = "Name: " + name + " with ";
		
		for (int i = 0; i < professors.length(); i++) {
			results += professors.get(i) + (i == professors.length()-1 ? "" : ", ");
		}
		
		return results;
	}
}