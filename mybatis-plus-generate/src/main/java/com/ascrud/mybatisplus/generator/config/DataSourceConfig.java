/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ascrud.mybatisplus.generator.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ascrud.mybatisplus.exceptions.MybatisPlusException;
import com.ascrud.mybatisplus.generator.config.converts.DB2TypeConvert;
import com.ascrud.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.ascrud.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.ascrud.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.ascrud.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.ascrud.mybatisplus.generator.config.querys.DB2Query;
import com.ascrud.mybatisplus.generator.config.querys.MariadbQuery;
import com.ascrud.mybatisplus.generator.config.querys.MySqlQuery;
import com.ascrud.mybatisplus.generator.config.querys.OracleQuery;
import com.ascrud.mybatisplus.generator.config.querys.PostgreSqlQuery;
import com.ascrud.mybatisplus.generator.config.querys.SqlServerQuery;
import com.ascrud.mybatisplus.generator.config.rules.DbType;

/**
 * <p>
 * 数据库配置
 * </p>
 *
 * @author YangHu
 * @since 2016/8/30
 */
public class DataSourceConfig {

    /**
     * 数据库信息查询
     */
    private IDbQuery dbQuery;
    /**
     * 数据库类型
     */
    private DbType dbType;
    /**
     * PostgreSQL schemaname
     */
    private String schemaname;
    /**
     * 类型转换
     */
    private ITypeConvert typeConvert;
    /**
     * 驱动连接的URL
     */
    private String url;
    /**
     * 驱动名称
     */
    private String driverName;
    /**
     * 数据库连接用户名
     */
    private String username;
    /**
     * 数据库连接密码
     */
    private String password;

    public IDbQuery getDbQuery() {
        if (null == dbQuery) {
            switch (getDbType()) {
                case ORACLE:
                    dbQuery = new OracleQuery();
                    break;
                case SQL_SERVER:
                    dbQuery = new SqlServerQuery();
                    break;
                case POSTGRE_SQL:
                    dbQuery = new PostgreSqlQuery();
                    break;
                case DB2:
                	dbQuery = new DB2Query();
                	break;
                case MARIADB:
                    dbQuery = new MariadbQuery();
                    break;
                default:
                    // 默认 MYSQL
                    dbQuery = new MySqlQuery();
                    break;
            }
        }
        return dbQuery;
    }

    public DataSourceConfig setDbQuery(IDbQuery dbQuery) {
        this.dbQuery = dbQuery;
        return this;
    }

    /**
     * 判断数据库类型
     *
     * @return 类型枚举值
     */
    public DbType getDbType() {
        if (null == dbType) {
            if (driverName.contains("mysql")) {
                dbType = DbType.MYSQL;
            } else if (driverName.contains("oracle")) {
                dbType = DbType.ORACLE;
            } else if (driverName.contains("postgresql")) {
                dbType = DbType.POSTGRE_SQL;
            } else if (driverName.contains("db2")) {
                dbType = DbType.DB2;
            } else if (driverName.contains("mariadb")) {
                dbType = DbType.MARIADB;
            } else {
                throw new MybatisPlusException("Unknown type of database!");
            }
        }
        return dbType;
    }

    public DataSourceConfig setDbType(DbType dbType) {
        this.dbType = dbType;
        return this;
    }

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname;
    }

    public ITypeConvert getTypeConvert() {
        if (null == typeConvert) {
            switch (getDbType()) {
                case ORACLE:
                    typeConvert = new OracleTypeConvert();
                    break;
                case SQL_SERVER:
                    typeConvert = new SqlServerTypeConvert();
                    break;
                case POSTGRE_SQL:
                    typeConvert = new PostgreSqlTypeConvert();
                    break;
                case DB2:
                	typeConvert = new DB2TypeConvert();
                	break;
                case MARIADB:
                    typeConvert = new MySqlTypeConvert();
                    break;
                default:
                    // 默认 MYSQL
                    typeConvert = new MySqlTypeConvert();
                    break;
            }
        }
        return typeConvert;
    }

    public DataSourceConfig setTypeConvert(ITypeConvert typeConvert) {
        this.typeConvert = typeConvert;
        return this;
    }

    /**
     * 创建数据库连接对象
     *
     * @return Connection
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public String getUrl() {
        return url;
    }

    public DataSourceConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDriverName() {
        return driverName;
    }

    public DataSourceConfig setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DataSourceConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataSourceConfig setPassword(String password) {
        this.password = password;
        return this;
    }

}
