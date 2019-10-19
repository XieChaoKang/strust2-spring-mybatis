package action.AdminAction;

import Model.Admin;
import Model.Item;
import Model.Warehouse;
import Service.AdminService.AdminServiceImp.AdminLoginImp;
import Service.AdminService.AdminServiceImp.QueryAllWarehouseImpl;
import Service.AdminService.AdminServiceImp.Seil_InsepectionImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

//管理员登录 数据接口
@Controller
public class AdminLogin extends ActionSupport{

   // private HttpServletRequest request = ServletActionContext.getRequest();

   // SendMailTest sendMailTest = new SendMailTest();
    TestSendMail testSendMail = new TestSendMail();

    Admin admin = new Admin();

    @Autowired
   AdminLoginImp adminLoginImp;

    public AdminLoginImp getAdminLoginImp() {
        return adminLoginImp;
    }

    public void setAdminLoginImp(AdminLoginImp adminLoginImp) {
        this.adminLoginImp = adminLoginImp;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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
      //  Self_Inspection();
        String result;
        admin = adminLoginImp.AdminLogin(admin);
        if (admin != null)
        {
            result = SUCCESS;
            ServletActionContext.getRequest().getSession().setAttribute("admin",admin);
        }

        else
        {
            String msg = "登录失败！！"+"\n"+"请检查账号或密码是否正确！！";
            result = ERROR;
            ServletActionContext.getRequest().getSession().setAttribute("msg",msg);
        }

        return result;
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
