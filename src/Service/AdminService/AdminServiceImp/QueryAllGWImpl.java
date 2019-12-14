package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Goods_warehouse;
import Service.AdminService.QueryAllGW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//service层 管理员查询所有订单信息
@Service
public class QueryAllGWImpl implements QueryAllGW {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Goods_warehouse> QueryAllGW() {
        return adminMapper.QueryAllGW();
    }
}
