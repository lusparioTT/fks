package org.nutz.plugins.cache.dao;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;

/**
 * 通过Druid的遍历器获取sql所操作的数据库表
 * @author wendal(wendal1985@gmail.com)
 *
 */
public class NSqlAdapter extends MySqlASTVisitorAdapter {

    public List<String> tableNames = new ArrayList<String>();

    public boolean visit(SQLExprTableSource x) {
    	tableNames.add(x.toString());
        return super.visit(x);
    }
}
