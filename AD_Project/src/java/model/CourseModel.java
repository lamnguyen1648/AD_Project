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
    public boolean addCourse(String id, String name, String desc, String content, String schedule, String category, String trainer) {
        int res = 0;
        String sql = "INSERT INTO tblCourse VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = ConnectionFactory.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, desc);
            ps.setString(4, content);
            ps.setString(5, schedule);
            ps.setString(6, category);
            ps.setString(7, trainer);
            res = ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res > 0;
    }
    
    public ArrayList<Course> getCourses() {
        ArrayList<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM tblCourse";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                Course c = new Course();
                c.setId(res.getString(1));
                c.setName(res.getString(2));
                c.setDesc(res.getString(3));
                c.setContent(res.getString(4));
                c.setSchedule(res.getString(5));
                c.setCategory(res.getString(6));
                c.setTrainer(res.getString(7));
                list.add(c);
            }
            res.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Course getCourseByID(String id) {
        Course c = null;
        String sql = "SELECT * FROM tblCourse WHERE _id = ?";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                c = new Course();
                c.setId(id);
                c.setName(rs.getString(2));
                c.setDesc(rs.getString(3));
                c.setContent(rs.getString(4));
                c.setSchedule(rs.getString(5));
                c.setCategory(rs.getString(6));
                c.setTrainer(rs.getString(7));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public boolean delCourse(String id) {
        int res = 0;
        String sql = "DELETE FROM tblCourse WHERE _id = ?";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            res = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res > 0;
    }
    
    public boolean updateCourse(String id, String name, String desc, String content, String schedule, String category, String trainer) {
        int res = 0;
        String sql = "UPDATE tblCourse SET _name = ?, _desc = ?, _content = ?, _schedule = ?, _category = ?, _trainer = ? WHERE _id = ?"; 
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setString(3, content);
            ps.setString(4, schedule);
            ps.setString(5, category);
            ps.setString(6, trainer);
            ps.setString(7, id);
            res = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res > 0;
    }
}
