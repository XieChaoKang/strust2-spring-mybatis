package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Service.AdminService.DeleteItemById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢朝康
 * @date 2019/12/7 1:18
 */
//service层 管理员根据物品id删除物品信息
@Service
public class DeleteItemByIdImpl implements DeleteItemById {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public int de_item(int id) {
        return adminMapper.de_item(id);
    }
}
