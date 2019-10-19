package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Warehouse;
import Service.AdminService.QueryItemByid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//根据仓库id查询该仓库内物品信息（一对一关联查询）
@Service
public class QueryItemByidImpl implements QueryItemByid {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Warehouse QueryItemById(Warehouse warehouse) {
        return adminMapper.QueryItemById(warehouse.getId());
    }
}
