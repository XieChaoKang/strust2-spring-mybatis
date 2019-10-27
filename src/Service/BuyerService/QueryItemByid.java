package Service.BuyerService;

import Model.Item;

/**
 * @author 谢朝康
 * @date 2019/10/26 16:07
 */
public interface QueryItemByid {
    Item  QueryItemByitem_id(int item_number);
}
