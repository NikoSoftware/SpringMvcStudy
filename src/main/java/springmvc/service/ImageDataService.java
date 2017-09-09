package springmvc.service;

import springmvc.model.ImageData;

import java.util.List;

public interface ImageDataService {

    int insertSelective(ImageData imageData);

    ImageData selectByPrimaryKey(Integer id);

    List<ImageData> selectAllImage();
}
