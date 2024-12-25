package common

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class DatabaseKeywords {
	def Connection connection

	@Keyword
	def connectDB() {
		try {
			connection = DriverManager.getConnection(GlobalVariable.urlDB, GlobalVariable.userDB, GlobalVariable.passwordDB);
			println('--------------Connection database ' + GlobalVariable.urlDB + ' success--------------' )
			return connection
		}catch(Exception e){
			print(e)
		}
	}

	@Keyword
	public List<LinkedHashMap<String, String>> executeQuery (String queryString) {
		connection = connectDB()
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(queryString);
		ResultSetMetaData metadata = rs.getMetaData();
		int columnCount = metadata.getColumnCount();
		List<String> columnTitles = new LinkedList<>();
		for (int i = 1; i <= columnCount; i++) {
			String columnTitle = metadata.getColumnName(i);
			columnTitles.add(columnTitle);
		}
		List<LinkedHashMap<String, String>> rowList = new ArrayList<>()
		while (rs.next()) {
			Map<String, String> row = new LinkedHashMap<String, String>()
			for (int i = 0; i < columnTitles.size(); i++) {
				if(rs.getObject(i+1)== null) {
					row.put(columnTitles.get(i), rs.getObject(i+1))
				}
				else {
					row.put(columnTitles.get(i), rs.getObject(i+1).toString())
				}
			}
			rowList.add(row);
		}
		return rowList
	}


	@Keyword
	def closeDB() {
		if(connection !=null) {
			connection.close()
		}
	}
}
