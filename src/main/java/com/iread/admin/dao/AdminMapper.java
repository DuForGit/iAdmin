package com.iread.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iread.admin.domain.Admin;

/**
 *项目名称: iAdmin
 *类名称: AdminMapper
 *类描述: 有关管理员的一系列操作，如登录等
 *创建人: Administrator
 *创建时间: 2018年3月12日上午12:07:08
 * @version
 * @author 方秋都
 *
 */
public interface AdminMapper {
	//登录
	@Select(value="select ad_id from admin where ad_name = #{name} and ad_pass = #{pass}")
	Integer getAdminIdByName(@Param("name") String name, @Param("pass") long pass);
	
	@Select(value="select ad_id from admin where ad_number = #{number} and ad_pass = #{pass}")
	Integer getAdminIdByNumber(@Param("number") int number, @Param("pass") long pass);
	
	//获取个人信息
	@Select("select a.ad_id as id, a.ad_number as number,a.ad_name as name,"
			+ "(select r.ro_name from role r  where r.ro_id = a.ro_id) as rolename from admin a"
			+ " where a.ad_id = #{aid}")
	@Results({
		@Result(column="id",property="id"),
		@Result(column="number",property="number"),
		@Result(column="name",property="name"),
		@Result(column="rolename",property="role")
	})
	Admin getMyInfos(@Param("aid") int aid);
	
	@Update("update admin set ad_pass = #{newpass} where ad_id = #{aid} and ad_pass = #{oldpass}")
	Integer changePass(@Param("aid") int aid, @Param("newpass") long newpass,@Param("oldpass")long oldpass);
}
