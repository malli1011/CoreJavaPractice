package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Account implementation for commercial (business) customers.<br><br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount  extends Account{
	private final List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		super(company,accountNumber,pin,startingDeposit);
		authorizedUsers = new ArrayList<>();
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		// complete the function
		authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		// complete the function
		Predicate<Person> personPredicate = p -> p.getFirstName().equalsIgnoreCase(person.getFirstName()) && p.getLastName().equalsIgnoreCase(person.getLastName());
		return authorizedUsers.stream().anyMatch(personPredicate);

	}
}
