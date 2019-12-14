package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Item;
import Service.AdminService.UpdateItemById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢朝康
 * @date 2019/12/7 13:15
 */
//service层 管理员根据物品id修改物品信息
@Service
public class UpdateItemByIdImpl implements UpdateItemById {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int ud_item(Item item) {
        return adminMapper.ud_item(item);
    }
}
