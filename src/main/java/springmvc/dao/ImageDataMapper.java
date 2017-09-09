package springmvc.dao;

import springmvc.model.ImageData;

import java.util.List;

public interface ImageDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImageData record);

    int insertSelective(ImageData record);

    ImageData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImageData record);

    int updateByPrimaryKey(ImageData record);

    List<ImageData> selectAllImage();
}