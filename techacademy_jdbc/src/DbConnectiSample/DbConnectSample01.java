package DbConnectiSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.exceptions.RSAException;
//import com.mysql.cj.xdevapi.Statement;

public class DbConnectSample01 {

    public static void main(String[] args) {
        // 1. ドライバーのクラスをJava上で読み込む
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. DBと接続する
//            con = DriverManager.getConnection(
//                "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
//                "root",
//                "141592****yt"
//            );
//            // 3. DBとやりとりする窓口（Statementオブジェクト）の作成
//            stmt = (Statement) con.createStatement();
//            // 4, 5. Select文の実行と結果を格納／代入
            String sql = "SELECT * FROM country LIMIT 50";
//            rs = stmt.executeQuery(sql);
//            
            try (// DBと接続する
                    Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true", "root",
                        "141592****yt");
                    // DBとやりとりする窓口（Statementオブジェクト）の作成
                    Statement stmt = con.createStatement();
                    // SQLを発行
                    ResultSet rs = stmt.executeQuery(sql);) {
                String s = "aaaa";
                Double.parseDouble(s);
            // 6. 結果を表示する
                while(rs.next()) {
                    String name = rs.getString("Name");
                    //取得した値を表示
                    System.out.println(name);
                }
            } catch (NumberFormatException e) {
                System.err.println();
            }
            
//            sql = "update country set Population = 105000 where Code = 'ABW'";
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count);
            
       
        } catch (ClassNotFoundException e) {
            System.err.println("JDBCドライバーのロードに失敗しました。");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        
            // 7. 接続を閉じる
//        }finally {
//         
//            if(rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    System.err.println("ResultSetを閉じるときにエラーが生じました。");
//                    e.printStackTrace();
//                }
//            }
//            if( stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    System.err.println("Statementを閉じるときにエラーが発生しました。");
//                    e.printStackTrace();
//                }
//            }
//            if( con != null) {
//                try {
//                    con.close();
//                }catch (SQLException e) {
//                    System.err.println("データベース切断時にエラーが起こりました。");
//                    e.printStackTrace();
//                }
//            }
        }
        
     
    }

}
