package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.entity.HistoryBooking;
import com.example.TubesOOP.payload.admin.AdminInfoResponse;
import com.example.TubesOOP.payload.admin.AdminLoginRequest;
import com.example.TubesOOP.payload.admin.AdminRegisterRequest;
import com.example.TubesOOP.service.AdminService;
import com.example.TubesOOP.service.HistoryBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HistoryBookingService historyBookingService;

    @PostMapping("/login")
    public String loginAdmin(@ModelAttribute AdminLoginRequest request) {
        try {
            Admin admin = adminService.authenticateAdmin(request.getEmail(), request.getPassword());
            return "redirect:/dashboard";
        } catch (Exception e) {
            return "redirect:/admin/login";
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
            return "redirect:/login?registered";
        } catch (Exception e) {
            return "redirect:/register?error";
        }
    }


    @GetMapping("/register")
    public String showRegisterForm() {
        return "adminRegister";
    }

    @GetMapping("/{email}")
    public String getAdminInfo(@PathVariable String email, Model model) {
        try {
            AdminInfoResponse admin = adminService.getAdminInfo(email); // ambil dari DB
            model.addAttribute("admin", admin);
            return "adminProfile";
        } catch (Exception e) {
            return "redirect:/error";
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


}
