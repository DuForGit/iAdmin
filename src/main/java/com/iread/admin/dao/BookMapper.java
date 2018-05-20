package com.iread.admin.dao;

import com.iread.admin.domain.Action;
import com.iread.admin.domain.Book;
import com.iread.admin.domain.BookInAction;
import com.iread.admin.domain.BookInfos;
import com.iread.admin.domain.BookInfosOfForm;
import com.iread.admin.domain.Chapter;
import com.iread.admin.domain.Text;
import com.iread.admin.domain.Type;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * class
 *
 * @author 方秋都
 * @date 2018/2/8 0008
 * @description
 */
public interface BookMapper {
	
	//图书列表
	@Select("select b.b_id as bid, b.b_name as bname, b.b_price as price,"
    		+ "b.b_cover as cover,"
    		+ "w.w_id as wid,w.w_name as wname,p.p_id as pid,p.p_name as pname from books b "
    		+ "inner join writer w on b.w_id = w.w_id "
    		+ "inner join publish p on b.p_id = p.p_id"
    		+ " order by b.b_id DESC")
	@Results({
		@Result(column="bid",property="id"),
		@Result(column="bname",property="name"),
		@Result(column="price",property="price"),
		@Result(column="cover",property="cover"),
		@Result(column="wid",property="writer.id"),
		@Result(column="wname",property="writer.name"),
		@Result(column="pid",property="publish.id"),
		@Result(column="pname",property="publish.name")
})
    List<Book> getBooks();
    
    
    
    
    
    //图书详情
    @Select("select b.b_id as bid, b.b_name as bname, b.b_price as price,"
    		+ "b.b_summary as summary,b.b_reader as readers,b.b_cover as cover,"
    		+ "b.b_limit as limits,b.b_sales as sales,b.b_search as searchs,b.b_payaway as payaway,b.b_soldout as soldout,"
    		+ "w.w_id as wid,w.w_name as wname,p.p_id as pid,p.p_name as pname,"
    		+ "t.t_id as tid,t.t_name as tname,t.cl_id as classid,"
    		+ "(select cl_name from class c where c.cl_id = t.cl_id) as classname,"
    		+ "(select count(com_id) from comments c where c.b_id = b.b_id) as comments from books b "
    		+ "inner join writer w on b.w_id = w.w_id "
    		+ "inner join publish p on b.p_id = p.p_id "
    		+ "inner join type t on b.t_id = t.t_id "
    		+ " where b.b_id = #{bid}")
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
		@Result(column="classname",property="type.clazz.name"),
		@Result(column="summary",property="summary"),
		@Result(column="readers",property="readers"),
		@Result(column="limits",property="limit"),
		@Result(column="sales",property="sales"),
		@Result(column="searchs",property="searchs"),
		@Result(column="comments",property="comments"),
		@Result(column="payaway",property="payaway"),
		@Result(column="soldout",property="soldout")
    })
    BookInfos showBookInfos(@Param("bid") int bid);
    
    @Select("select cl_id,cl_name from class")
    @Results({
    	@Result(column="cl_id",property="id"),
    	@Result(column="cl_name",property="name")
    })
    List<com.iread.admin.domain.Class> getClasss();
    
    
    @Select("select t_id,t_name from type where cl_id = #{cid}")
    @Results({
    	@Result(column="t_id",property="id"),
    	@Result(column="t_name",property="name")
    })
    List<Type> getTypes(@Param("cid") int cid);
    
    @Update("update books set "
    		+ "b_name=#{name},t_id = #{typeId},w_id = #{writerId},p_id=#{publishId},b_price=#{price},"
    		+ "b_summary=#{summary},b_payaway=#{payaway},b_soldout=#{soldout},b_limit=#{limit}"
    		+ " where b_id=#{id}")
    Integer changeBookInfos(BookInfosOfForm form);
    
    @Update("update books set b_cover = #{cover} where b_id = #{bid}")
    void setBookCover(@Param("bid")int bid,@Param("cover")String cover);
    
    @Select("select b_cover  from books where b_id = #{bid}")
    String getBookCover(@Param("bid")int bid);
    
    
    @Insert("insert into books (b_name,t_id,w_id,p_id,b_price,b_summary,b_payaway,b_soldout,b_limit) values("
    		+ "#{name},#{typeId},#{writerId},#{publishId},#{price},#{summary},#{payaway},#{soldout},#{limit})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    Integer addBookInfos(BookInfosOfForm form);
    
    @Select("select b_name from books where b_id = #{bid}")
    String getBookName(@Param("bid") int bid);
    
    @Select("select cha_id,cha_name,te_id,b_id from chapter where b_id = #{bid}")
    @Results({
    	@Result(column="cha_id",property="id"),
    	@Result(column="cha_name",property="name"),
    	@Result(column="te_id",property="textId"),
    	@Result(column="b_id",property="bookId")
    })
    List<Chapter> getChapters(@Param("bid") int bid);
    
    @Select("select te_text from text where te_id = #{tid}")
    String getText(@Param("tid") int tid);
    
    @Select("select te_id,te_text from text where te_id = #{tid}")
    @Results({
    	@Result(column="te_id",property="id"),
    	@Result(column="te_text",property="text")
    })
    Text getTextInfos(@Param("tid") int tid);
    
    @Insert("insert into text (te_text) value(#{text})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    Integer addNewText(Text text);
    
    @Insert("insert into chapter (cha_name,te_id,b_id) value(#{name},#{textId},#{bookId})")
    void addNewChapter(Chapter chapter);
    
    @Update("update chapter set cha_name = #{name} where cha_id = #{chid}")
    void changeChapterName(@Param("chid")int chid,@Param("name")String name);
    
    @Update("update text set te_text = #{text} where te_id = #{tid}")
    void changeText(@Param("tid")int tid,@Param("text")String text);
    
    @Select("select te_id from chapter where cha_id = #{chid}")
    int selectTextID(@Param("chid")int chid);
    
    @Select("select a.ac_id as id,a.ac_cover as cover,a.b_id as bid,b.b_name as name from action a inner join books b on a.b_id = b.b_id")
    @Results({
    	@Result(column="id",property="id"),
    	@Result(column="cover",property="cover"),
    	@Result(column="bid",property="bookId"),
    	@Result(column="name", property="title")
    })
    List<Action> getActions();
    
    @Insert("insert into action (ac_cover,b_id) values(#{cover},#{bookId})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int addAction(Action a);
    
    @Update("update action set ac_cover = #{cover},b_id = #{bookId}")
    void changeAction(Action a);
    
    @Select("select ac_id,ac_cover,b_id from action where ac_id = #{acid}")
    Action getAction(@Param("acid")int acid);
    
    @Delete("delete from action where ac_id = #{acid}")
    void deleteAction(@Param("acid") int acid);
    
    @Select("select b_id,b_name from books order by b_id desc limit 20")
    @Results({
    	@Result(column="b_id",property="id"),
    	@Result(column="b_name",property="title")
    })
    List<BookInAction> getBooksInAction();
    
    @Update("update action set ac_cover = #{cover} where ac_id = #{acid}")
    void updateActionCover(@Param("acid")int acid,@Param("cover")String cover);
    
    
}
