import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class RSParser {

    public static ArrayList<String> getHeaderRow(ResultSet rs) throws SQLException {
        ArrayList<String> headerRow = new ArrayList<String>();

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();

        for (int i = 1; i <= colCount; i++) {
            headerRow.add(rsmd.getColumnName(i));
        }

        return headerRow;
    }

    public static ArrayList<String> getHeaderRowTypes(ResultSet rs) throws SQLException {
        ArrayList<String> headerRowTypes = new ArrayList<String>();

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();

        for (int i = 1; i <= colCount; i++) {
            headerRowTypes.add(rsmd.getColumnTypeName(i));
        }

        return headerRowTypes;
    }

    public static ArrayList<ArrayList<String>> getBody(ResultSet rs) throws SQLException{
        ArrayList<ArrayList<String>> body = new ArrayList<ArrayList<String>>();
        
        ArrayList<String> headerRowTypes = getHeaderRowTypes(rs);

        while(rs.next()){
            ArrayList<String> row = new ArrayList<String>();

            for(int i = 0; i < headerRowTypes.size(); i++){

                if(headerRowTypes.get(i).equals("int")){
                    row.add("" + rs.getInt(i + 1));
                }
                else if(headerRowTypes.get(i).equals("bigint")){
                    row.add("" + rs.getLong(i + 1));
                }
                else if(headerRowTypes.get(i).equals("varchar")){
                    row.add(rs.getString(i + 1));
                }
                else if(headerRowTypes.get(i).equals("char")){
                    row.add(rs.getString(i + 1));
                }

            }

            body.add(row);
        }
        
        return body;
    }

    public static ArrayList<ArrayList<String>> getTable(ResultSet rs) throws SQLException{
        ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

        ArrayList<String> headerRow = getHeaderRow(rs);
        table.add(headerRow);

        ArrayList<ArrayList<String>> body = getBody(rs);
        table.addAll(body);

        return table;
    }

}
