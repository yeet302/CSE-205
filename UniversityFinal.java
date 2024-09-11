public class UniversityFinal {
	private String name;
	private List<Professor> professors;
	
	public static void main(String[] args) {
		
		// Create our university, with professors
		UniversityFinal ASU = new UniversityFinal("ASU West - Final");
		
		ASU.getProfessors().addLast(new Professor("Dietrich"));
		ASU.getProfessors().addLast(new Professor("Silva"));
		ASU.getProfessors().addLast(new Professor("Wang"));
		ASU.getProfessors().addLast(new Professor("Xu"));
		System.out.println("1: " + ASU);

		// Test accessing members of the list
		System.out.println("3rd Prof is " + ASU.getProfessors().get(3));
		System.out.println("Here is Silva: Position " + ASU.getProfessors().find("Silva"));
		
		// Test insertions
		ASU.getProfessors().insertAfter(2, new Professor("Tibbetts"));
		System.out.println("2: " + ASU);

		ASU.getProfessors().insertAfter("Wang", new Professor("Eckert"));
		System.out.println("3: " + ASU);

		ASU.getProfessors().delete(4);
		System.out.println("4: " + ASU);

		for(int i=1; i <= 5; i++)
			ASU.getProfessors().addFirst(new Professor("Person"+i));
		System.out.println("5: " + ASU);
		
		try { ASU.getProfessors().get(1000); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().find("Turing"); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().insertAfter(1000,new Professor("Turing")); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().insertAfter("Kay",new Professor("Turing")); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

		try { ASU.getProfessors().delete(1000); }
		catch (ArrayIndexOutOfBoundsException e) { System.out.println(e.getMessage()); }
	}
	
	public UniversityFinal(String n) {
		name = n;
		professors = new List<Professor>();
		
		System.out.println("University " + name + " created.");
	}
	
	public List<Professor> getProfessors() {
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