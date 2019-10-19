package action.BuyerAction;

import Model.Goods_warehouse;
import Service.BuyerService.BuyerServiceImpl.Buyer_Goods_warehouseImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

//入库
@Controller
public class Buyer_Goods_warehouse_in extends ActionSupport implements ModelDriven<Goods_warehouse> {

    //返回json数据的映射
    private JSONObject jsonObject;
    public JSONObject getJsonObject() { return jsonObject; }
    public void setJsonObject(JSONObject jsonObject) { this.jsonObject = jsonObject; }

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

    @Override
    public String execute() throws Exception {
      //  String result = null;
        System.out.println(goodsWarehouse);
        Integer count = buyerGoodsWarehouse.insert(goodsWarehouse);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        jsonObject = new JSONObject(map);
//        jsonObject = JSON.parseObject(JSON.toJSONString(count));
       /* if (count != 0)
        {
          //  result = SUCCESS;
            ServletActionContext.getRequest().getSession().setAttribute("count",count);
        }*/

       /* else
        {
            result = ERROR;
        }*/

        return SUCCESS;
    }

}
