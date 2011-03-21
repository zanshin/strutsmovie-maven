package movielist.map.dao;

public class TblMovieRatingsDBModel {
	private int id;
	private String description;

    /**
     * Gets the id
     * @return Returns a int
     * 
     * @uml.property name="id"
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id The id to set
     * 
     * @uml.property name="id"
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the description
     * @return Returns a String
     * 
     * @uml.property name="description"
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     * @param description The description to set
     * 
     * @uml.property name="description"
     */
    public void setDescription(String description) {
        this.description = description;
    }

}