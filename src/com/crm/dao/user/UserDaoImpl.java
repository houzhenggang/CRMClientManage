package com.crm.dao.user;

import java.util.List;
import java.util.Map;

import com.crm.bean.user.UserBean;
import com.crm.dao.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public int addUser(UserBean uBean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" INSERT INTO user_info ")
				.append(" VALUES£¨?,?,?,?,?,?,?,?,?,?,")
				.append(" ?,to_date(?,'yyyy-mm-dd'),?,to_date(?,'yyyy-mm-dd'),?,?,?,?,?,?, ")
				.append(" ?,?,? ")
				;
		return executeUpdate(sql.toString(),
				uBean.getRole_id(),uBean.getUser_name(),
				uBean.getUser_sex(),uBean.getUser_mobile(),
				uBean.getUser_age(),uBean.getUser_address(),
				uBean.getUser_num(),uBean.getUser_pw(),
				uBean.getUser_tel(),uBean.getUser_idnum(),
				uBean.getUser_email(),uBean.getUser_addtime(),
				uBean.getUser_addman(),uBean.getUser_changetime(),
				uBean.getUser_changeman(),uBean.getUser_intest(),
				uBean.getUser_diploma(),uBean.getUser_bankcard(),
				uBean.getUser_nation(),uBean.getIs_married(),
				uBean.getIs_used());
	}

	@Override
	public List<Map<String, Object>> queryUserOnPage(int nowPage, int pageSize) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append("  select urole.role_name,d.department_name,uinfo.*   ")
				.append("    from user_role urole,department_info d ,(  ")
				.append("         select * from user_info ) uinfo   ")
				.append("   where urole.role_id = uinfo.role_id   ")
				.append("     and d.department_id = uinfo.department_id  ")
				.append("   order by user_id ")
				;
		
		return queryOnPage(sql.toString(), nowPage, pageSize);
	}

}
