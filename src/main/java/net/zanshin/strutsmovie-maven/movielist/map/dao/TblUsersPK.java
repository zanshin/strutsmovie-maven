package movielist.map.dao;

public class TblUsersPK {
	private final String userId;

	public TblUsersPK(String userId) {
		this.userId = userId;
	}

    /**
     * 
     * @uml.property name="userId"
     */
    public String getUserId() {
        return userId;
    }

}