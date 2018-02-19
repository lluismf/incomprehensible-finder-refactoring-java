package algorithm;

public class AgeDifference {

    private Person younger;
    private Person older;

    public Person getYounger() {
        return younger;
    }

    public void setYounger(Person younger) {
        this.younger = younger;
    }

    public Person getOlder() {
        return older;
    }

    public void setOlder(Person older) {
        this.older = older;
    }

    public long difference;

    public AgeDifference() {

    }

    public AgeDifference(Person first, Person second) {
        super();
        if (first.getBirthDate().getTime() < second.getBirthDate().getTime()) {
            this.younger = first;
            this.older = second;
        } else {
            this.younger = second;
            this.older = first;
        }
        this.difference = this.older.getBirthDate().getTime() - this.younger.getBirthDate().getTime();
    }

}
