/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamsu
 */
public class CourseModel {
    public boolean addCourse(String id, String name, String desc, String content, String schedule, String category, String trainer) {   //Function add (lâm)
        int res = 0;                                                            //khai báo res = 0
        String sql = "INSERT INTO tblCourse VALUES (?, ?, ?, ?, ?, ?, ?)";      //chuẩn bị lệnh sql
        Connection conn = ConnectionFactory.getConnection();                    //lấy connection
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);                  //chuẩn bị gán dữ liệu vào câu lệnh sql
            ps.setString(1, id);                                                //gán vào vị trí 1 (dấu ? đầu tiên) với giá trị id vào câu lệnh sql
            ps.setString(2, name);                                              //tiếp tục với các vị trí và giá trị còn lại
            ps.setString(3, desc);
            ps.setString(4, content);
            ps.setString(5, schedule);
            ps.setString(6, category);
            ps.setString(7, trainer);
            res = ps.executeUpdate();                                           //vì executeUpdate trả về giá trị int -> khai báo res kiểu int (add thành công = số dương; add ko thành công = số âm)
            ps.close();                                                         //kết thúc/đóng 2 chức năng khai báo trên (ps và conn)
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res > 0;                                                         //trả về kết quả so sánh res với 0 (true/false)
    }
    
    public ArrayList<Course> getCourses() {                                     //Function getCourse (Cương)
        ArrayList<Course> list = new ArrayList<>();                             //khai báo list
        String sql = "SELECT * FROM tblCourse";                                 //lệnh sql
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stm = conn.createStatement();                             //chạy câu lệnh
            ResultSet res = stm.executeQuery(sql);                              //gán kết quả của câu lệnh
            while(res.next()) {                                                 //vòng lặp cho tới khi hết dữ liệu trong db
                Course c = new Course();
                c.setId(res.getString(1));                                      //gán id = giá trị trả về từ câu lệnh sql (lấy dữ liệu từ dòng = lệnh res.geetString(thứ tự cột))
                c.setName(res.getString(2));                                    //tiếp tục với các vị trí và giá trị còn lại
                c.setDesc(res.getString(3));
                c.setContent(res.getString(4));
                c.setSchedule(res.getString(5));
                c.setCategory(res.getString(6));
                c.setTrainer(res.getString(7));
                list.add(c);                                                    //thêm course trên vào list
            }
            res.close();                                                        //đóng kết nối
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;                                                            //trả về list hoàn thiện
    }
    
    public Course getCourseByID(String id) {                                    //Function getCourseByID (Kiên)
        Course c = null;                                                        //Gọi course, set = null
        String sql = "SELECT * FROM tblCourse WHERE _id = ?";                   //lệnh sql
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);                  //chuẩn bị lệnh sql
            ps.setString(1, id);                                                //chèn dữ liệu vào lệnh
            ResultSet rs = ps.executeQuery();                                   //gán kết quả chạy lệnh
            while(rs.next()) {
                c = new Course();
                c.setId(id);                                                    //gán dữ liệu trả về
                c.setName(rs.getString(2));
                c.setDesc(rs.getString(3));
                c.setContent(rs.getString(4));
                c.setSchedule(rs.getString(5));
                c.setCategory(rs.getString(6));
                c.setTrainer(rs.getString(7));
            }
            rs.close();                                                         //đóng kết nối
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;                                                               //trả về course vừa update
    }
    
    public boolean delCourse(String id) {                                       //Function delCourse (Vũ)
        int res = 0;
        String sql = "DELETE FROM tblCourse WHERE _id = ?";                     //lệnh sql
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);                                    //chuẩn bị lệnh sql
            ps.setString(1, id);                                                //gán giá trị vào lệnh
            res = ps.executeUpdate();                                           //lấy kết quả trả về
            ps.close();                                                         //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res > 0;                                                         //so sánh kết quả trả về với 0 để xác định kq thêm (true/false)
    }
    
    public boolean updateCourse(String id, String name, String desc, String content, String schedule, String category, String trainer) {
        int res = 0;
        String sql = "UPDATE tblCourse SET _name = ?, _desc = ?, _content = ?, _schedule = ?, _category = ?, _trainer = ? WHERE _id = ?";   //lệnh sql
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);                  //chuẩn bị lệnh sql
            ps.setString(1, name);                                              //chèn dữ liệu vào lệnh
            ps.setString(2, desc);
            ps.setString(3, content);
            ps.setString(4, schedule);
            ps.setString(5, category);
            ps.setString(6, trainer);
            ps.setString(7, id);
            res = ps.executeUpdate();                                           //lấy kết quả trả về
            ps.close();                                                         //Đóng kết nối
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res > 0;                                                         //so sánh kết quả trả về với 0
    }
}
