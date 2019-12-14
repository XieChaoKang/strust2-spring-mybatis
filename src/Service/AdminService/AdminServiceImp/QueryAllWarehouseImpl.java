package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Warehouse;
import Service.AdminService.QueryAllWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//service层 管理员仓库信息
@Service
public class QueryAllWarehouseImpl implements QueryAllWarehouse {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Warehouse> selectAllWarehouse() {
        return adminMapper.selectAllWarehouse();
    }
}
