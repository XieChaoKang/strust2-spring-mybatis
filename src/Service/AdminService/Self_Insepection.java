package Service.AdminService;

import Model.Item;
import Model.Warehouse;

import java.util.List;

//仓库自检
public interface Self_Insepection {
    List<Item> QueryItemByW_num(int warehouse_number);
}
