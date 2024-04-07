/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import service.impl.LoginService;
import views.JLogin;
import views.MainFrame;

/**
 *
 * @author ThuanBui
 */
public class LoginController implements ActionListener{
    private JLogin login;
    private LoginService loginService = new LoginService();
    public LoginController(JLogin login) {
        this.login = login;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Đăng nhập")) {
            String username = this.login.tfUsername.getText();
            String password = this.login.tfPassword.getText();
            int result = loginService.login(username, password);
            if (result == 1) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                this.login.dispose();
            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "Chức năng của nhân viên đang được phát triển và cập nhật sau", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (result == 0) {
                JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu không đúng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (action.equals("Thoát")) {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
    }
    
}
