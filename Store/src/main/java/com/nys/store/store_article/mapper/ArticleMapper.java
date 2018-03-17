package com.nys.store.store_article.mapper;

import com.nys.store.store_article.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from article limit #{i},#{i1}")
    List<Article> selectByHot(@Param("i") int i, @Param("i1") int i1);

    @Select("select * from article where goods_id=#{id}")
    Article selectById(int id);
}
