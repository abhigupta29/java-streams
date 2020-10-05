package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> carsFiltered = cars.stream()
            .filter(car -> car.getPrice() < 10000)
            .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> personDTOS = people.stream()
            .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
            .collect(Collectors.toList());

    personDTOS.forEach(System.out::println);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);

    System.out.println(averagePrice);
  }

  @Test
  public void test() throws Exception {

  }
}



