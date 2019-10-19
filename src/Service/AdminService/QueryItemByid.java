package Service.AdminService;

import Model.Warehouse;

//根据仓库id查询仓库内物品信息
public interface QueryItemByid {
    Warehouse QueryItemById(Warehouse warehouse);
}
