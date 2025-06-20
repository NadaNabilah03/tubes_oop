package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.entity.HistoryBooking;
import com.example.TubesOOP.payload.admin.AdminInfoResponse;
import com.example.TubesOOP.payload.admin.AdminLoginRequest;
import com.example.TubesOOP.payload.admin.AdminRegisterRequest;
import com.example.TubesOOP.service.AdminService;
import com.example.TubesOOP.service.HistoryBookingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;



import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HistoryBookingService historyBookingService;

    @PostMapping("/login")
    public String loginAdmin(@ModelAttribute AdminLoginRequest request, HttpServletResponse response) {
        try {
            Admin admin = adminService.authenticateAdmin(request.getEmail(), request.getPassword());

            // Set cookie
            Cookie cookie = new Cookie("userCookie", admin.getEmail());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60); // 1 jam
            response.addCookie(cookie);

            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            return "redirect:/admin/login?error";
        }
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "adminLogin";
    }

    @PostMapping("/register")
    public String registerAdmin(@ModelAttribute AdminRegisterRequest request) {
        try {
            adminService.registerAdmin(
                    request.getUsername(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getProfilePic()
            );
            return "redirect:/admin/login?registered";
        } catch (Exception e) {
            return "redirect:/admin/register?error";
        }
    }


    @GetMapping("/register")
    public String showRegisterForm() {
        return "adminRegister";
    }

    @GetMapping("/profile")
    public String getAdminInfo(@CookieValue(value = "userCookie", defaultValue = "") String email, Model model) {
        System.out.println("Cookie userCookie: " + email); // DEBUG

        if (email.isEmpty()) {
            return "redirect:/admin/login?unauthorized";
        }

        try {
            AdminInfoResponse admin = adminService.getAdminInfo(email);
            model.addAttribute("admin", admin);
            return "adminProfile";
        } catch (Exception e) {
            return "redirect:/admin/login?unauthorized";
        }
    }


    @GetMapping("/about")
    public String aboutPage() {
        return "adminAbout";
    }

    @GetMapping("/dashboard")
    public String showAdminDashboard(@CookieValue(value = "userCookie", defaultValue = "") String userEmail, Model model) {
        List<HistoryBooking> historyList = historyBookingService.getAllHistory();
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("transaksiList", historyList); // ini buat tabel
        return "adminDashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // ✅ Menghapus session, bukan user
        return "redirect:/customer/login?logout";
    }


}
