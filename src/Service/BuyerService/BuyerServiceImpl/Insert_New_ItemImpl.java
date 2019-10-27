/**
 * @author 谢朝康
 * @date 2019/10/26 23:44
 */
package Service.BuyerService.BuyerServiceImpl;

import Mapper.BuyerMapper.BuyerMapper;
import Model.Item;
import Service.BuyerService.Insert_New_Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//采购员入库物品 该物品不存在于仓库
@Service
public class Insert_New_ItemImpl implements Insert_New_Item {

    @Autowired
    BuyerMapper buyerMapper;

    public BuyerMapper getBuyerMapper() {
        return buyerMapper;
    }

    public void setBuyerMapper(BuyerMapper buyerMapper) {
        this.buyerMapper = buyerMapper;
    }

    @Override
    public int Insert_new_Item(Item item) {
        return buyerMapper.Insert_new_Item(item);
    }
}
