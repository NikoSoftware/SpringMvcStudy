package springmvc.service;

import springmvc.model.Person;

import java.util.List;

public interface PersonService {

    public Person getPersonById(int id);

    public List<Person> selectAllPerson();
}
