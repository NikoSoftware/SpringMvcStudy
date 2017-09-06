package springmvc.serviceimpl;

import org.springframework.stereotype.Service;
import springmvc.dao.PersonInfoMapper;
import springmvc.model.PersonInfo;
import springmvc.service.PersonInfoService;

import javax.annotation.Resource;

@Service("personInfoService")
public class PersonInfoServiceImpl implements PersonInfoService{

    @Resource
    private PersonInfoMapper personInfoMapper;

    public PersonInfo getPersonInfo(int id) {
        return personInfoMapper.selectPersonInfoById(id);
    }

    public PersonInfo getPersonInfoByMapper(int id) {
        return personInfoMapper.BaseResultMap(id);
    }
}
