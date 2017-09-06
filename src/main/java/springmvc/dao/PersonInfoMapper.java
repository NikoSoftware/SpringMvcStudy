package springmvc.dao;

import springmvc.model.PersonInfo;

public interface PersonInfoMapper {

    PersonInfo selectPersonInfoById(int id);

    PersonInfo BaseResultMap(int id);

}
