package springmvc.service;

import springmvc.dao.PersonInfoMapper;
import springmvc.model.PersonInfo;

public interface PersonInfoService {

    public PersonInfo getPersonInfo(int id);

    public PersonInfo getPersonInfoByMapper(int id);
}
