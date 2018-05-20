package com.iread.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.test.context.jdbc.Sql;

import com.iread.admin.domain.Book;

/**
 *项目名称: iAdmin
 *类名称: SearchBooksMapper
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月13日下午10:19:59
 * @version
 * @author 方秋都
 *
 */
public interface SearchBooksMapper {
	
	
	@Select("select b.b_id as bid, b.b_name as bname, b.b_price as price,b.b_cover as cover,"
			+ "w.w_id as wid,w.w_name as wname,p.p_id as pid,p.p_name as pname,"
			+ "t.t_id as tid,t.t_name as tname,t.cl_id as classid,"
			+ "(select cl_name from class c where c.cl_id = t.cl_id) as classname from books b "
			+ "inner join writer w on b.w_id = w.w_id "
			+ "inner join publish p on b.p_id = p.p_id "
			+ "inner join type t on b.t_id = t.t_id where b.b_id = #{id}")
	@Results({
			@Result(column="bid",property="id"),
			@Result(column="bname",property="name"),
			@Result(column="price",property="price"),
			@Result(column="cover",property="cover"),
			@Result(column="wid",property="writer.id"),
			@Result(column="wname",property="writer.name"),
			@Result(column="pid",property="publish.id"),
			@Result(column="pname",property="publish.name"),
			@Result(column="tid",property="type.id"),
			@Result(column="tname",property="type.name"),
			@Result(column="classid",property="type.clazz.id"),
			@Result(column="classname",property="type.clazz.name")
	})
	Book searchBookById(@Param("id")int id);
	
	
	@Select("select b.b_id as bid, b.b_name as bname, b.b_price as price,b.b_cover as cover,"
			+ "w.w_id as wid,w.w_name as wname,p.p_id as pid,p.p_name as pname,"
			+ "t.t_id as tid,t.t_name as tname,t.cl_id as classid,"
			+ "(select cl_name from class c where c.cl_id = t.cl_id) as classname from books b "
			+ "inner join writer w on b.w_id = w.w_id "
			+ "inner join publish p on b.p_id = p.p_id "
			+ "inner join type t on b.t_id = t.t_id where b.b_name like CONCAT('%',#{name},'%')")
	@Results({
		@Result(column="bid",property="id"),
		@Result(column="bname",property="name"),
		@Result(column="price",property="price"),
		@Result(column="cover",property="cover"),
		@Result(column="wid",property="writer.id"),
		@Result(column="wname",property="writer.name"),
		@Result(column="pid",property="publish.id"),
		@Result(column="pname",property="publish.name"),
		@Result(column="tid",property="type.id"),
		@Result(column="tname",property="type.name"),
		@Result(column="classid",property="type.clazz.id"),
		@Result(column="classname",property="type.clazz.name")
	})
	List<Book> searchBooksByName(@Param("name")String name);
}
