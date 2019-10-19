package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Item;
import Model.Warehouse;
import Service.AdminService.Self_Insepection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//仓库物品自检
@Service
public class Seil_InsepectionImpl implements Self_Insepection {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Item> QueryItemByW_num(int warehouse_number) {
        return adminMapper.QueryItemByW_num(warehouse_number);
    }
}
