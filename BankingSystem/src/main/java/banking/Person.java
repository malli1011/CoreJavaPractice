package banking;

public class Person extends AccountHolder{
	private final String firstName;
	private final String lastName;

	public Person(String firstName, String lastName, int idNumber) {
		// complete the function
		super(idNumber);
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getFirstName() {
		// complete the function
        return firstName;
	}

	public String getLastName() {
		// complete the function
        return lastName;
	}
}
