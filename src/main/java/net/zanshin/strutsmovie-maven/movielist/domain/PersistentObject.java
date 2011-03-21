package movielist.domain;

public abstract class PersistentObject {
	private int id;

	PersistentObject() {
		super();
	}

    /**
     * 
     * @uml.property name="id"
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @uml.property name="id"
     */
    public void setId(int id) {
        this.id = id;
    }

}