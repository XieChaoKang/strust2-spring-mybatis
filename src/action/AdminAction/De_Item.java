package action.AdminAction;

import Service.AdminService.AdminServiceImp.DeleteItemByIdImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢朝康
 * @date 2019/12/7 1:12
 */
//删除物品信息 根据id 数据接口
@Controller
public class De_Item extends ActionSupport {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    @Autowired
    DeleteItemByIdImpl de;

    public DeleteItemByIdImpl getDe() {
        return de;
    }

    public void setDe(DeleteItemByIdImpl de) {
        this.de = de;
    }

    @Override
    public String execute() throws Exception {
        int count = de.de_item(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        json = new JSONObject(map);
        System.out.println(json);
        return SUCCESS;
    }
}
