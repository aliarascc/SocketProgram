package Model;

/**
 * Creates user with unique id
 * @author dmalbora
 *
 */

public class UserFactory {

	private static int id = 0;
	public IUser getUser()
	{
		return new User(++id, "User_"+id);
	}
	
}
