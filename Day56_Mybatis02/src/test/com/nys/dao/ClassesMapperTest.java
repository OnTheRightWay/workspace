package com.nys.dao;

import com.nys.dao.ClassesMapper;
import com.nys.domain.Classes;
import com.nys.domain.ClassesQueryParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassesMapperTest {
    private SqlSessionFactory ssf;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        ssf = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml")
        );
        sqlSession = ssf.openSession();

    }

    @Test
    public void insertClasses() throws Exception {
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
        Classes classes = new Classes("Java","男");
        mapper.insertClasses(classes);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByCondition() throws Exception {
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
        Classes classes = new Classes("va","男");
        List<Classes> list =
                mapper.findByCondition(classes);
        System.out.println(Arrays.toString(list.toArray()));
        sqlSession.close();
    }

    @Test
    public void findByIds() throws Exception {
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);
        ids.add(7);
        ClassesQueryParam cqp = new ClassesQueryParam();
        cqp.setClassesIds(ids);
        List<Classes> byIds = mapper.findByIds(cqp);
        System.out.println(Arrays.toString(byIds.toArray()));
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }
}