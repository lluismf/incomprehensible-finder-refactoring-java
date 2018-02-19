package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.AgeDifference;
import algorithm.AgeDistanceFinder;
import algorithm.Goal;
import algorithm.Person;

public class AgeDistanceFinderTest {

    Person sue;
    Person greg;
    Person sarah;
    Person mike;

    @Before
    public void setup() {
        sue = new Person("Sue", 1950, 0, 1);
        greg = new Person("Greg", 1952, 5, 1);
        mike = new Person("Mike", 1979, 0, 1);
        sarah = new Person("Sarah", 1982, 0, 1);
    }

    @Test
    public void returnsEmptyResultsWhenGivenEmptyList() {
        List<Person> persons = new ArrayList<Person>();
        AgeDistanceFinder finder = new AgeDistanceFinder(persons);

        AgeDifference result = finder.find(Goal.MIN);
        assertEquals(null, result.getYounger());
        assertEquals(null, result.getOlder());
    }

    @Test
    public void returnsEmptyResultsWhenGivenOnePerson() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(sue);

        AgeDistanceFinder finder = new AgeDistanceFinder(persons);

        AgeDifference result = finder.find(Goal.MIN);

        assertEquals(null, result.getYounger());
        assertEquals(null, result.getOlder());
    }

    @Test
    public void returnsClosestTwoForTwoPeople() {
        List<Person> persons = Arrays.asList(new Person[] { sue, greg });

        AgeDistanceFinder finder = new AgeDistanceFinder(persons);

        AgeDifference result = finder.find(Goal.MIN);

        assertEquals(sue, result.getYounger());
        assertEquals(greg, result.getOlder());
    }

    @Test
    public void returnsFurthestTwoForTwoPeople() {
        List<Person> list = Arrays.asList(new Person[] { mike, greg });

        AgeDistanceFinder finder = new AgeDistanceFinder(list);

        AgeDifference result = finder.find(Goal.MAX);

        assertEquals(greg, result.getYounger());
        assertEquals(mike, result.getOlder());
    }

    @Test
    public void returnsFurthestTwoForFourPeople() {
        List<Person> persons = Arrays.asList(new Person[] { sue, sarah, mike, greg });
        AgeDistanceFinder finder = new AgeDistanceFinder(persons);

        AgeDifference result = finder.find(Goal.MAX);

        assertEquals(sue, result.getYounger());
        assertEquals(sarah, result.getOlder());
    }

    @Test
    public void returnsClosestTwoForFourPeople() {
        List<Person> persons = Arrays.asList(new Person[] { sue, sarah, mike, greg });

        AgeDistanceFinder finder = new AgeDistanceFinder(persons);

        AgeDifference result = finder.find(Goal.MIN);

        assertEquals(sue, result.getYounger());
        assertEquals(greg, result.getOlder());
    }

}
