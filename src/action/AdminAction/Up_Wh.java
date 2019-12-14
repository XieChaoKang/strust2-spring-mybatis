package action.AdminAction;

import Model.Warehouse;
import Service.AdminService.AdminServiceImp.UpdateWhByIdImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢朝康
 * @date 2019/12/13 14:53
 */
@Controller
public class Up_Wh extends ActionSupport {
    Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }
    @Autowired
    UpdateWhByIdImpl up1;

    public UpdateWhByIdImpl getUp() {
        return up1;
    }

    public void setUp(UpdateWhByIdImpl up) {
        this.up1 = up;
    }
    @Override
    public String execute() throws Exception {
        System.out.println("test up"+warehouse);

        int count = up1.ud_GW(warehouse);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        json = new JSONObject(map);
        System.out.println(json);

        return SUCCESS;
    }

}
