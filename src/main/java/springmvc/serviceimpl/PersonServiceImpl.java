package springmvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.PersonMapper;
import springmvc.model.Person;
import springmvc.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService{

    @Resource
    private PersonMapper personMapper;

    public Person getPersonById(int id) {
        return this.personMapper.selectByPrimaryKey(id);
    }

    public List<Person> selectAllPerson() {
        return this.personMapper.selectAllPerson();
    }
}
