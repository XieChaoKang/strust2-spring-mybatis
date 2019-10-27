package action.AdminAction;

import Model.Admin;
import Service.AdminService.AdminServiceImp.AdminLoginImp;
import Service.AdminService.AdminServiceImp.AdminRegistImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminRegister extends ActionSupport{

    //返回JSON数据
    private JSONObject jsonObject;
    public JSONObject getJsonObject() { return jsonObject; }
    public void setJsonObject(JSONObject jsonObject) { this.jsonObject = jsonObject; }

    Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Autowired
    AdminRegistImpl adminRegistImpl;

    public AdminRegistImpl getAdminRegistImpl() {
        return adminRegistImpl;
    }

    public void setAdminRegistImpl(AdminRegistImpl adminRegistImpl) {
        this.adminRegistImpl = adminRegistImpl;
    }

    @Autowired
    AdminLoginImp adminLoginImp;

    public AdminLoginImp getAdminLoginImp() {
        return adminLoginImp;
    }

    public void setAdminLoginImp(AdminLoginImp adminLoginImp) {
        this.adminLoginImp = adminLoginImp;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("admin:"+admin);
        adminRegistImpl.AdminRegist(admin);
        admin = adminLoginImp.AdminLogin(admin);
        System.out.println("a: "+admin);
        jsonObject = JSON.parseObject(JSON.toJSONString(admin));
        if (jsonObject != null)
        {
            ServletActionContext.getRequest().getSession().setAttribute("admin",admin);
        }

        return SUCCESS;
    }
}
