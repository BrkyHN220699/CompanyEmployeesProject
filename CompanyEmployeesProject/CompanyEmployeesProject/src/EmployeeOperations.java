
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author berkayhan
 */
public class EmployeeOperations {
    
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<Employee> getEmployees() {
        
        ArrayList<Employee> output = new ArrayList<Employee>();
        
        try {
            statement = con.createStatement();
            
            String sorgu = "Select * From calisanlar";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()) {
                
                int Id = rs.getInt("id");
                String Ad = rs.getString("ad");
                String Soyad = rs.getString("soyad");
                String Departman = rs.getString("departman");
                String Maas = rs.getString("maas");

                output.add(new Employee(Id, Ad, Soyad, Departman, Maas));
                
            }
            return output;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    public void updateEmployee(int Id, String YeniAd, String YeniSoyad, String YeniDepartman, String YeniMaas){
        /// To put all the new informations to the right places with control by Id.
        String sorgu = "Update calisanlar set ad = ? , soyad = ? , departman = ? , maas = ? where id = ?"; 
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, YeniAd);
            preparedStatement.setString(2, YeniSoyad);
            preparedStatement.setString(3, YeniDepartman);
            preparedStatement.setString(4, YeniMaas);

            preparedStatement.setInt(5, Id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void deleteEmployee(int Id) {
        /// Delete an employee according to his/her id number.
        String sorgu = "Delete from calisanlar where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, Id);
            
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
    
    public void addEmployee(String Ad, String Soyad, String Departman, String Maas){
        
        String sorgu = "Insert Into calisanlar (ad,soyad,departman,maas) VALUES(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, Ad);
            preparedStatement.setString(2, Soyad);
            preparedStatement.setString(3, Departman);
            preparedStatement.setString(4, Maas);

            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public boolean Login(String userName, String password) {
        
        String sorgu = "Select * from adminler where username = ? and password = ?";
        
        try {
            
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public EmployeeOperations() {
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
        
    }
    
    
    
    
    
    
    
}
