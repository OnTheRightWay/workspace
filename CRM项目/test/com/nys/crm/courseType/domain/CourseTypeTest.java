package com.nys.crm.courseType.domain;

import com.nys.crm.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CourseTypeTest {
    @Test
    public void insert() throws Exception {
        QueryRunner query = C3P0Util.getQuery();
        for (int i = 0; i < 50; i++) {

            UUID uuid = UUID.randomUUID();
            query.update(
                    "insert into crm_course_type values('" +
                            uuid+"','10000','4000','C++','c'" +
                            ")"
            );
        }
    }
}