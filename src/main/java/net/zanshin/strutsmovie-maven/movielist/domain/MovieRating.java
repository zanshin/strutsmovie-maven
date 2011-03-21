package movielist.domain;

public class MovieRating extends PersistentObject implements Cloneable {
	private String description;

	public MovieRating() {
		super();
	}

    /**
     * 
     * @uml.property name="description"
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @uml.property name="description"
     */
    public void setDescription(String description) {
        this.description = description;
    }

	public Object clone()throws CloneNotSupportedException {
		Object o = null;

		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
            // todo...
		}

		return o;
	}
}