package classOrganiser;

public class StaticVariables {
    private String city;
    private String state;
    private static Integer countOfInitializations = 0;

    public StaticVariables(String city, String state) {
        this.city = city;
        this.state = state;
        countOfInitializations++;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public static Integer getCountOfInitializations() {
        return countOfInitializations;
    }

    public String toString() {
        return String.format("%s, %s\t%d", getCity(), getState(), getCountOfInitializations());
    }
}
