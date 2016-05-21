
//Copyright 2012 Lucas Libraro
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.xinfang.web.eat.ext.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;

@MappedTypes(DateTime.class)
public class DateTimeTypeHandler implements TypeHandler<Object>{

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Timestamp ts = rs.getTimestamp(columnName);
        if (ts != null)
        {
            return new DateTime(ts.getTime(), DateTimeZone.UTC);
        }
        else
        {
            return null;
        }
	}

	@Override
	public Object getResult(ResultSet rs, int i) throws SQLException {
		Timestamp ts = rs.getTimestamp(i);
        if (ts != null)
        {
            return new DateTime(ts.getTime(), DateTimeZone.UTC);
        }
        else
        {
            return null;
        }
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {

		Timestamp ts = cs.getTimestamp(columnIndex);
        if (ts != null)
        {
            return new DateTime(ts.getTime(), DateTimeZone.UTC);
        }
        else
        {
            return null;
        }
	    
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if (parameter != null)
        {
            ps.setTimestamp(i, new Timestamp(((DateTime) parameter).getMillis()));
        }
        else
        {
            ps.setTimestamp(i, null);
        }
		
	}
	
}