package com.iread.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iread.admin.domain.Publish;
import com.iread.admin.domain.Writer;

/**
 *项目名称: iAdmin
 *类名称: PublishMapper
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月17日下午8:23:49
 * @version
 * @author 方秋都
 *
 */
public interface PublishMapper {
	@Select("select p_id,p_name,p_summary,p_cover from publish order by p_name")
	@Results({
		@Result(column="p_id",property="id"),
		@Result(column="p_name",property="name"),
		@Result(column="p_summary",property="summary"),
		@Result(column="p_cover",property="cover")
	})
	List<Publish>showPublishs();
	
	@Select("select p_id,p_name,p_summary,p_cover from publish where p_id = #{pid}")
	@Results({
		@Result(column="p_id",property="id"),
		@Result(column="p_name",property="name"),
		@Result(column="p_summary",property="summary"),
		@Result(column="p_cover",property="cover")
	})
	Publish publish(@Param("pid")int pid);
	
	@Update("update publish set p_name = #{name},p_summary = #{summary} where p_id = #{pid}")
	void changePublishInfos(@Param("pid")int pid,@Param("name")String name, @Param("summary")String summary);
	
	@Insert("insert into publish (p_name,p_summary) values(#{name},#{summary})")
	@Options(keyProperty="id",useGeneratedKeys=true)
	Integer insertPublish(Publish p);
	
	@Select("select p_cover from publish where p_id = #{pid}")
	String getOldCover(@Param("pid")int pid);
	
	@Update("update publish set p_cover = #{cover} where p_id = #{pid}")
	void changerCover(@Param("pid")int wid,@Param("cover")String cover);
	
	@Select("select p_id,p_name,p_summary,p_cover from publish where p_name like CONCAT(#{info},'%') order by p_name")
	@Results({
		@Result(column="p_id",property="id"),
		@Result(column="p_name",property="name"),
		@Result(column="p_summary",property="summary"),
		@Result(column="p_cover",property="cover")
	})
	List<Publish>optionPublishs(@Param("info") String info);
	
}
