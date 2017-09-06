package springmvc.dao;

import springmvc.model.Websites;

public interface WebsitesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Websites record);

    int insertSelective(Websites record);

    Websites selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Websites record);

    int updateByPrimaryKey(Websites record);
}