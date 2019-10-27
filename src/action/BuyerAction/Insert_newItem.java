/**
 * @author 谢朝康
 * @date 2019/10/26 23:45
 */
package action.BuyerAction;

import Model.Goods_warehouse;
import Model.Item;
import Service.BuyerService.BuyerServiceImpl.Buyer_Goods_warehouseImpl;
import Service.BuyerService.BuyerServiceImpl.Insert_New_ItemImpl;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Insert_newItem extends ActionSupport {

    //返回json数据的映射
    private JSONObject jsonObject;
    public JSONObject getJsonObject() { return jsonObject; }
    public void setJsonObject(JSONObject jsonObject) { this.jsonObject = jsonObject; }

    Goods_warehouse goodsWarehouse = new Goods_warehouse();

    public Goods_warehouse getGoodsWarehouse() {
        return goodsWarehouse;
    }

    public void setGoodsWarehouse(Goods_warehouse goodsWarehouse) {
        this.goodsWarehouse = goodsWarehouse;
    }

    Item item = new Item();

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Autowired
    Insert_New_ItemImpl insert_new_itemImpl;

    public Insert_New_ItemImpl getInsert_new_itemImpl() {
        return insert_new_itemImpl;
    }

    public void setInsert_new_itemImpl(Insert_New_ItemImpl insert_new_itemImpl) {
        this.insert_new_itemImpl = insert_new_itemImpl;
    }

    @Autowired
    Buyer_Goods_warehouseImpl buyerGoodsWarehouseImpl;

    public Buyer_Goods_warehouseImpl getBuyerGoodsWarehouseImpl() {
        return buyerGoodsWarehouseImpl;
    }

    public void setBuyerGoodsWarehouseImpl(Buyer_Goods_warehouseImpl buyerGoodsWarehouseImpl) {
        this.buyerGoodsWarehouseImpl = buyerGoodsWarehouseImpl;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("goods:"+goodsWarehouse);
        System.out.println("item:"+item);

        buyerGoodsWarehouseImpl.insert(goodsWarehouse);

        item = new Item(goodsWarehouse.getItem_number(),item.getName(),item.getMeasurement(),goodsWarehouse.getWarehouse_number(),goodsWarehouse.getQuantity(),item.getPrice());
        System.out.println("new item:"+item);

        Integer count = insert_new_itemImpl.Insert_new_Item(item);
        System.out.println(count);

        return SUCCESS;
    }
}
