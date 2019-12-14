package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Goods_warehouse;
import Model.Item;
import Service.AdminService.QueryAllItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//service层 管理员查询所有物品信息
@Service
public class QueryAllItemImpl implements QueryAllItem {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Item> QueryAllItem() {
        return adminMapper.QueryAllItem();
    }

    @Override
    public List<Item> QueryItemByName(Item item) {
        return adminMapper.QueryItemByName(item);
    }
}
