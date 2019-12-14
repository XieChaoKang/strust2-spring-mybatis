package action.AdminAction;

import Model.Item;
import Service.AdminService.AdminServiceImp.UpdateItemByIdImpl;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢朝康
 * @date 2019/12/7 13:17
 */
//修改物品信息 根据物品id 数据接口
@Controller
public class Up_Item extends ActionSupport {

    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    @Autowired
    UpdateItemByIdImpl up;

    public UpdateItemByIdImpl getUp() {
        return up;
    }

    public void setUp(UpdateItemByIdImpl up) {
        this.up = up;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("test up"+item);

        int count = up.ud_item(item);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        json = new JSONObject(map);
        System.out.println(json);

        return SUCCESS;
    }
}
