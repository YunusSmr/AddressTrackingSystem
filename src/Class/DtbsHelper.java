/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yunus
 */
public class DtbsHelper {

    public static ImageIcon rezisePic(String PicPath, byte[] Blobpic, JLabel lbl) {
        ImageIcon myImg;
        if (PicPath != null) {
            myImg = new ImageIcon(PicPath);
        } else {
            myImg = new ImageIcon(Blobpic);
        }
        Image img = myImg.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon myPıcture = new ImageIcon(img);
        return myPıcture;
    }

    public boolean isUsernameExist(String username, String dtbs) {
        boolean uExist = false;
        Connection con = MysqlConnect.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement("SELECT * FROM `" + dtbs + "` WHERE `username`=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                uExist = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went Wrong");
        }

        return uExist;
    }

    public static void edıtInfo(int index, String query) {
        Connection con = MysqlConnect.getConnection();
        PreparedStatement ps;
        switch (index) {
            case 1:
                try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "phone saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 2:
                try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "pıcture saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 3:
              try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "email saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 4:
                try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "password changed");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 5:
            try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "gender saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 6:
            try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Your address Succesfully Added");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 7:
            try {
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Selected row successfully deleted ");
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong:(");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;

        }

    }

    public static void getTable(DefaultTableModel model, String username, int index) {
        switch (index) {
            case 0:
                Connection con = MysqlConnect.getConnection();
                PreparedStatement ps;
                ResultSet rs;
                try {
                    ps = con.prepareStatement("SELECT `address1`,`address2`,`address3` FROM `address` WHERE `username`=?");
                    ps.setString(1, username);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        String a1 = rs.getString(1);
                        String a2 = rs.getString(2);
                        String a3 = rs.getString(3);
                        if (a1 != null) {
                            ps = con.prepareStatement("SELECT `address1`,`group1` FROM `address` WHERE `username`=?");
                            ps.setString(1, username);
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
                            }
                        }
                        if (a2 != null) {
                            ps = con.prepareStatement("SELECT `address2`,`group2` FROM `address` WHERE `username`=?");
                            ps.setString(1, username);
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
                            }
                        }
                        if (a3 != null) {
                            ps = con.prepareStatement("SELECT `address3`,`group3` FROM `address` WHERE `username`=?");
                            ps.setString(1, username);
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Table didnt get!");

                }
                break;
            case 1:
                con = MysqlConnect.getConnection();
                PreparedStatement ps1;
                ResultSet rs1;
                try {
                    ps1 = con.prepareStatement("SELECT `address1`,`address2`,`address3` FROM `address` WHERE `username`=?");
                    ps1.setString(1, username);
                    rs1 = ps1.executeQuery();
                    if (rs1.next()) {
                        String a1 = rs1.getString(1);
                        String a2 = rs1.getString(2);
                        String a3 = rs1.getString(3);
                        if (a1 != null) {
                            ps1 = con.prepareStatement("SELECT `address1`,`group1` FROM `address` WHERE `username`=?");
                            ps1.setString(1, username);
                            rs1 = ps1.executeQuery();
                            if (rs1.next()) {
                                model.addRow(new Object[]{username,rs1.getString(1), rs1.getString(2)});
                            }
                        }
                        if (a2 != null) {
                            ps1 = con.prepareStatement("SELECT `address2`,`group2` FROM `address` WHERE `username`=?");
                            ps1.setString(1, username);
                            rs1 = ps1.executeQuery();
                            if (rs1.next()) {
                                model.addRow(new Object[]{username,rs1.getString(1), rs1.getString(2)});
                            }
                        }
                        if (a3 != null) {
                            ps1 = con.prepareStatement("SELECT `address3`,`group3` FROM `address` WHERE `username`=?");
                            ps1.setString(1, username);
                            rs1 = ps1.executeQuery();
                            if (rs1.next()) {
                                model.addRow(new Object[]{username,rs1.getString(1), rs1.getString(2)});
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Table didnt get!");

                }
                break;

        }
    }
}
