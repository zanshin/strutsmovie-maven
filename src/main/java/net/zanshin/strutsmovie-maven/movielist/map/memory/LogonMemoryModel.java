package movielist.map.memory;

public class LogonMemoryModel {

	public static boolean validateUser(String userId, String password) {
        return "fred".equalsIgnoreCase(userId) && "flintstone".equals(password);
	}
}