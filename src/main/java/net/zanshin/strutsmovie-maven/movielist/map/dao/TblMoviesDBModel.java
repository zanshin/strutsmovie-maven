package movielist.map.dao;

public class TblMoviesDBModel {
	private int id;
	private String name;
	private String comment;
	private int rating;
	private int scale;
	private String worthSeeingAgain;

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
     * Gets the name
     * @return Returns a String
     * 
     * @uml.property name="name"
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name The name to set
     * 
     * @uml.property name="name"
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the comment
     * @return Returns a String
     * 
     * @uml.property name="comment"
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment
     * @param comment The comment to set
     * 
     * @uml.property name="comment"
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the rating
     * @return Returns a int
     * 
     * @uml.property name="rating"
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating
     * @param rating The rating to set
     * 
     * @uml.property name="rating"
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the scale
     * @return Returns a int
     * 
     * @uml.property name="scale"
     */
    public int getScale() {
        return scale;
    }

    /**
     * Sets the scale
     * @param scale The scale to set
     * 
     * @uml.property name="scale"
     */
    public void setScale(int scale) {
        this.scale = scale;
    }

    /**
     * Gets the worthSeeingAgain
     * @return Returns a String
     * 
     * @uml.property name="worthSeeingAgain"
     */
    public String getWorthSeeingAgain() {
        return worthSeeingAgain;
    }

    /**
     * Sets the worthSeeingAgain
     * @param worthSeeingAgain The worthSeeingAgain to set
     * 
     * @uml.property name="worthSeeingAgain"
     */
    public void setWorthSeeingAgain(String worthSeeingAgain) {
        this.worthSeeingAgain = worthSeeingAgain;
    }

}