package pl.koneckimarcin.mybodymanagement.entry;

public class Entry {

    private int id;
    private String username;
    private String entryDate;
    private float weight;
    private double steps;
    private String comment;

    public Entry(int id, String username, String entryDate, float weight, double steps, String comment) {
        this.id = id;
        this.username = username;
        this.entryDate = entryDate;
        this.weight = weight;
        this.steps = steps;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getSteps() {
        return steps;
    }

    public void setSteps(double steps) {
        this.steps = steps;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", entryDate=" + entryDate +
                ", weight=" + weight +
                ", steps=" + steps +
                ", description='" + comment + '\'' +
                '}';
    }
}
