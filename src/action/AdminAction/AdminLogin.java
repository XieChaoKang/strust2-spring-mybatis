package action.AdminAction;

import Model.Admin;
import Model.Item;
import Model.Warehouse;
import Service.AdminService.AdminServiceImp.AdminLoginImp;
import Service.AdminService.AdminServiceImp.QueryAllWarehouseImpl;
import Service.AdminService.AdminServiceImp.Seil_InsepectionImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//管理员登录 数据接口
@Controller
public class AdminLogin extends ActionSupport{

    //返回JSON数据
    private JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    TestSendMail testSendMail = new TestSendMail();

    Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Autowired
   AdminLoginImp adminLoginImp;

    public AdminLoginImp getAdminLoginImp() {
        return adminLoginImp;
    }

    public void setAdminLoginImp(AdminLoginImp adminLoginImp) {
        this.adminLoginImp = adminLoginImp;
    }

    @Autowired
    QueryAllWarehouseImpl queryAllWarehouseImpl;

    public QueryAllWarehouseImpl getQueryAllWarehouseImpl() {
        return queryAllWarehouseImpl;
    }

    public void setQueryAllWarehouseImpl(QueryAllWarehouseImpl queryAllWarehouseImpl) {
        this.queryAllWarehouseImpl = queryAllWarehouseImpl;
    }

    @Autowired
    Seil_InsepectionImpl seil_insepectionImpl;

    public Seil_InsepectionImpl getSeil_insepectionImpl() {
        return seil_insepectionImpl;
    }

    public void setSeil_insepectionImpl(Seil_InsepectionImpl seil_insepectionImpl) {
        this.seil_insepectionImpl = seil_insepectionImpl;
    }

    @Override
    public String execute() throws Exception {
        int count;
        System.out.println("test data");
        //Self_Inspection();
        admin = adminLoginImp.AdminLogin(admin);
        System.out.println(admin);
        if (admin != null){
            count = 1;
        }
        else {
            count = 0;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        json = new JSONObject(map);

        return SUCCESS;
    }

    //仓库物品自检
    public void Self_Inspection(){
        List<Warehouse> warehouseList = queryAllWarehouseImpl.selectAllWarehouse();
        for (int i = 0;i < warehouseList.size();i++){
           // System.out.println(warehouseList.get(i));
           //Warehouse warehouse = seil_insepectionImpl.QueryAllItemById(warehouseList.get(i).getId());
           //System.out.println(warehouse);
            int warehouse_number = warehouseList.get(i).getId();
            List<Item> itemList = seil_insepectionImpl.QueryItemByW_num(warehouse_number);
           // List<Item> itemList1 = new ArrayList<>();
            for (int j=0;j<itemList.size();j++){
                System.out.println(itemList.get(j).getName()+itemList.get(j).getQuantity());
                if (itemList.get(j).getQuantity()<=10) {
                    System.out.println("调用邮件");

                    testSendMail.test();
                   // itemList1.add(itemList.get(j));
                    //sendMailTest.sendMail(itemList.get(j).getName(),admin.getId());
                }
            }
            //sendMailTest.sendMail(itemList1,admin.getId());
        }
    }

}
