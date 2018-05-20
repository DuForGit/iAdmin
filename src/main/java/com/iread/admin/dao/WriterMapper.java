package com.iread.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iread.admin.domain.Writer;

/**
 *项目名称: iAdmin
 *类名称: WriterMapper
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月17日下午8:13:12
 * @version
 * @author 方秋都
 *
 */
public interface WriterMapper {
	@Select("select w_id,w_name,w_cover,w_gender,w_summary from writer order by w_name")
	@Results({
		@Result(column="w_id",property="id"),
		@Result(column="w_name",property="name"),
		@Result(column="w_cover",property="cover"),
		@Result(column="w_gender",property="gender"),
		@Result(column="w_summary",property="summary")
	})
	List<Writer> showWriters();
	
	@Select("select w_id,w_name,w_cover,w_gender,w_summary from writer where w_id = #{wid}")
	@Results({
		@Result(column="w_id",property="id"),
		@Result(column="w_name",property="name"),
		@Result(column="w_cover",property="cover"),
		@Result(column="w_gender",property="gender"),
		@Result(column="w_summary",property="summary")
	})
	Writer writer(@Param("wid") int wid);
	
	@Update("update writer set w_name = #{name},w_gender = #{gender},w_summary = #{summary} where w_id = #{wid}")
	void changeWriter(@Param("wid") int wid,@Param("name")String name,@Param("gender") String gender,@Param("summary")String summary);
	
	@Insert("insert into writer (w_name,w_gender,w_summary) values(#{name},#{gender},#{summary})")
	@Options(useGeneratedKeys = true, keyColumn = "w_id",keyProperty="id")
	Integer insertWriter(Writer w);
	//@Insert("insert into writer (w_name,w_gender,w_summary) values(#{name},#{gender},#{summary})")
	//Integer insertWriter(@Param("name")String name,@Param("gender")String gender,@Param("summary")String summary);
	
	@Select("select w_cover from writer where w_id = #{wid}")
	String getOldCover(@Param("wid")int wid);
	
	@Update("update writer set w_cover = #{cover} where w_id = #{wid}")
	void changerCover(@Param("wid")int wid,@Param("cover")String cover);
	
	@Select("select w_id,w_name,w_cover,w_gender,w_summary from writer where w_name like CONCAT(#{info},'%') order by w_name")
	@Results({
		@Result(column="w_id",property="id"),
		@Result(column="w_name",property="name"),
		@Result(column="w_cover",property="cover"),
		@Result(column="w_gender",property="gender"),
		@Result(column="w_summary",property="summary")
	})
	List<Writer> optionWriters(@Param("info") String info);
	
}
