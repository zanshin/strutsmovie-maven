package movielist.domain;

public class Movie extends PersistentObject {
	private String name;
	private String comment;

    /**
     * 
     * @uml.property name="rating"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private MovieRating rating;

	private boolean worthSeeingAgain;
	private int scale;

	public Movie() {
		super();
	}

    /**
     * 
     * @uml.property name="comment"
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @uml.property name="comment"
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @uml.property name="name"
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @uml.property name="name"
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @uml.property name="rating"
     */
    public MovieRating getRating() {
        return (MovieRating) rating.clone();
    }

    /**
     * 
     * @uml.property name="rating"
     */
    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    /**
     * 
     * @uml.property name="worthSeeingAgain"
     */
    public boolean getWorthSeeingAgain() {
        return worthSeeingAgain;
    }

    /**
     * 
     * @uml.property name="worthSeeingAgain"
     */
    public void setWorthSeeingAgain(boolean worthSeeingAgain) {
        this.worthSeeingAgain = worthSeeingAgain;
    }

    /**
     * 
     * @uml.property name="scale"
     */
    public int getScale() {
        return scale;
    }

    /**
     * 
     * @uml.property name="scale"
     */
    public void setScale(int scale) {
        this.scale = scale;
    }

}