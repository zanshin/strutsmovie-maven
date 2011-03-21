package movielist.map.dao;

public class TblUsersDBModel {
	private String userId;
	private String password;

    /**
     * Gets the userId
     * @return Returns a String
     * 
     * @uml.property name="userId"
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     * @param userId The userId to set
     * 
     * @uml.property name="userId"
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the password
     * @return Returns a String
     * 
     * @uml.property name="password"
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password The password to set
     * 
     * @uml.property name="password"
     */
    public void setPassword(String password) {
        this.password = password;
    }

}