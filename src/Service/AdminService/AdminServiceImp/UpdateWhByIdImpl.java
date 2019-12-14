package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Warehouse;
import Service.AdminService.UpdateWhById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢朝康
 * @date 2019/12/13 14:52
 */
@Service
public class UpdateWhByIdImpl implements UpdateWhById {
    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int ud_GW(Warehouse warehouse) {
        return adminMapper.ud_Wh(warehouse);
    }
}
