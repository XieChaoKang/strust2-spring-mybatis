package action.BuyerAction;

import Model.Goods_warehouse;
import Model.Item;
import Service.BuyerService.BuyerServiceImpl.Buyer_Goods_warehouseImpl;
import Service.BuyerService.BuyerServiceImpl.QueryItemByidImpl;
import Service.BuyerService.BuyerServiceImpl.UpdateItemByidImpl;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

//采购物品入库 物品本身在仓库就有
@Controller
public class Buyer_Goods_warehouse_in extends ActionSupport implements ModelDriven<Goods_warehouse> {

    //返回json数据的映射
    private JSONObject jsonObject;
    public JSONObject getJsonObject() { return jsonObject; }
    public void setJsonObject(JSONObject jsonObject) { this.jsonObject = jsonObject; }

    Item item = new Item();

    Goods_warehouse goodsWarehouse = new Goods_warehouse();

    @Override
    public Goods_warehouse getModel() {
        return goodsWarehouse;
    }

    @Autowired
    Buyer_Goods_warehouseImpl buyerGoodsWarehouse;

    public Buyer_Goods_warehouseImpl getBuyerGoodsWarehouse() {
        return buyerGoodsWarehouse;
    }

    public void setBuyerGoodsWarehouse(Buyer_Goods_warehouseImpl buyerGoodsWarehouse) {
        this.buyerGoodsWarehouse = buyerGoodsWarehouse;
    }

    @Autowired
    QueryItemByidImpl query;

    public QueryItemByidImpl getQuery() {
        return query;
    }

    public void setQuery(QueryItemByidImpl query) {
        this.query = query;
    }

    @Autowired
    UpdateItemByidImpl updateItemByidImpl;

    public UpdateItemByidImpl getUpdateItemByidImpl() {
        return updateItemByidImpl;
    }

    public void setUpdateItemByidImpl(UpdateItemByidImpl updateItemByidImpl) {
        this.updateItemByidImpl = updateItemByidImpl;
    }

    @Override
    public String execute() throws Exception {

        Integer count = buyerGoodsWarehouse.insert(goodsWarehouse);

        System.out.println(goodsWarehouse);
        try {
            item = query.QueryItemByitem_id(goodsWarehouse.getItem_number());
            System.out.println(item.getQuantity());
        }catch (NullPointerException e){
            e.printStackTrace();
        }


        if (item != null)
        {
            int quantity = item.getQuantity()+goodsWarehouse.getQuantity();
            System.out.println(quantity);
            Item item1 = new Item(item.getId(),quantity);
            int i = updateItemByidImpl.UpdateItem(item1);
            count = count+i;
        }

        else {
            count = 0;
        }

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        jsonObject = new JSONObject(map);

        return SUCCESS;
    }

}
