/*
 * Copyright (c) 2002, 2018, Oracle and/or its affiliates. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, version 2.0, as published by the
 * Free Software Foundation.
 *
 * This program is also distributed with certain software (including but not
 * limited to OpenSSL) that is licensed under separate terms, as designated in a
 * particular file or component or in included license documentation. The
 * authors of MySQL hereby grant you an additional permission to link the
 * program and your derivative works with the separately licensed software that
 * they have included with MySQL.
 *
 * Without limiting anything contained in the foregoing, this file, which is
 * part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at
 * http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0,
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301  USA
 */

package com.mysql.cj.jdbc;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import com.mysql.cj.Messages;
import com.mysql.cj.conf.PropertyDefinitions;

/**
 * Factory class for MysqlDataSource objects
 */
public class MysqlDataSourceFactory implements ObjectFactory {
    /**
     * The class name for a standard MySQL DataSource.
     */
    protected final static String DATA_SOURCE_CLASS_NAME = MysqlDataSource.class.getName();

    /**
     * The class name for a poolable MySQL DataSource.
     */
    protected final static String POOL_DATA_SOURCE_CLASS_NAME = MysqlConnectionPoolDataSource.class.getName();

    /**
     * The class name for a MysqlXADataSource
     */

    protected final static String XA_DATA_SOURCE_CLASS_NAME = MysqlXADataSource.class.getName();

    /**
     * @param refObj
     * @param nm
     * @param ctx
     * @param env
     * @throws Exception
     */
    public Object getObjectInstance(Object refObj, Name nm, Context ctx, Hashtable<?, ?> env) throws Exception {
        Reference ref = (Reference) refObj;
        String className = ref.getClassName();

        if ((className != null)
                && (className.equals(DATA_SOURCE_CLASS_NAME) || className.equals(POOL_DATA_SOURCE_CLASS_NAME) || className.equals(XA_DATA_SOURCE_CLASS_NAME))) {
            MysqlDataSource dataSource = null;

            try {
                dataSource = (MysqlDataSource) Class.forName(className).newInstance();
            } catch (Exception ex) {
                throw new RuntimeException(Messages.getString("MysqlDataSourceFactory.0", new Object[] { className, ex.toString() }));
            }

            int portNumber = 3306;

            String portNumberAsString = nullSafeRefAddrStringGet("port", ref);

            if (portNumberAsString != null) {
                portNumber = Integer.parseInt(portNumberAsString);
            }

            dataSource.setPort(portNumber);

            String user = nullSafeRefAddrStringGet(PropertyDefinitions.PNAME_user, ref);

            if (user != null) {
                dataSource.setUser(user);
            }

            String password = nullSafeRefAddrStringGet(PropertyDefinitions.PNAME_password, ref);

            if (password != null) {
                dataSource.setPassword(password);
            }

            String serverName = nullSafeRefAddrStringGet("serverName", ref);

            if (serverName != null) {
                dataSource.setServerName(serverName);
            }

            String databaseName = nullSafeRefAddrStringGet("databaseName", ref);

            if (databaseName != null) {
                dataSource.setDatabaseName(databaseName);
            }

            String explicitUrlAsString = nullSafeRefAddrStringGet("explicitUrl", ref);

            if (explicitUrlAsString != null) {
                if (Boolean.valueOf(explicitUrlAsString).booleanValue()) {
                    dataSource.setUrl(nullSafeRefAddrStringGet("url", ref));
                }
            }

            dataSource.setPropertiesViaRef(ref);

            return dataSource;
        }

        // We can't create an instance of the reference
        return null;
    }

    private String nullSafeRefAddrStringGet(String referenceName, Reference ref) {
        RefAddr refAddr = ref.get(referenceName);

        String asString = refAddr != null ? (String) refAddr.getContent() : null;

        return asString;
    }
}
