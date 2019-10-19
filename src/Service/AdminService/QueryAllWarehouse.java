package Service.AdminService;

import Model.Warehouse;

import java.util.List;

//查询所有仓库信息
public interface QueryAllWarehouse {
    List<Warehouse> selectAllWarehouse();
}
