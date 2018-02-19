package algorithm;
import java.util.ArrayList;
import java.util.List;

public class AgeDistanceFinder {
	private final List<Person> persons;

    public AgeDistanceFinder(List<Person> persons) {
        this.persons = persons;
	}

    public AgeDifference find(Goal type) {

        if (persons == null || persons.size() < 2) {
            return new AgeDifference();
        }

		List<AgeDifference> ageDifferences = new ArrayList<AgeDifference>();

		for (int i = 0; i < persons.size() - 1; i++) {
			for (int j = i + 1; j < persons.size(); j++) {
				ageDifferences.add(new AgeDifference(persons.get(i), persons.get(j)));
			}
		}

		AgeDifference result = ageDifferences.get(0);
		for (AgeDifference difference : ageDifferences) {
            if (type == Goal.MIN && difference.difference < result.difference
                    || type == Goal.MAX && difference.difference > result.difference) {
                result = difference;
            }
		}

		return result;
	}
}
