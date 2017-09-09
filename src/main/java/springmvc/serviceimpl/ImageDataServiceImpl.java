package springmvc.serviceimpl;

import org.springframework.stereotype.Service;
import springmvc.dao.ImageDataMapper;
import springmvc.model.ImageData;
import springmvc.service.ImageDataService;

import javax.annotation.Resource;
import java.util.List;

@Service("imageDataService")
public class ImageDataServiceImpl implements ImageDataService {

    @Resource
    ImageDataMapper imageDataMapper;

    public int insertSelective(ImageData imageData) {
        return imageDataMapper.insertSelective(imageData);
    }

    public ImageData selectByPrimaryKey(Integer id) {
        return imageDataMapper.selectByPrimaryKey(id);
    }

    public List<ImageData> selectAllImage() {
        return imageDataMapper.selectAllImage();
    }
}
