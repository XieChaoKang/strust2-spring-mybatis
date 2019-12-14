package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Admin;
import Service.AdminService.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//service层 管理员登录
@Service
public class AdminLoginImp implements AdminLogin {
    @Autowired
    private AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin AdminLogin(Admin admin) {
        return adminMapper.AdminLogin(admin);
    }
}
