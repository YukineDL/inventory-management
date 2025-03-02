package com.inventorymanagement.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionMessage {
    public static Map<String, String> messages = new HashMap<>();
    public static String EXISTED_EMPLOYEE = "EXISTED_EMPLOYEE";
    public static String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    public static String USERNAME_INCORRECT = "USERNAME_INCORRECT";
    public static String EMPLOYEE_EXISTED = "EMPLOYEE_EXISTED";
    public static String EMPLOYEE_NOT_EXISTED = "EMPLOYEE_NOT_EXISTED";
    public static String NO_PERMISSION = "NO_PERMISSION";
    static {
        messages.put(EXISTED_EMPLOYEE, "Nhân viên đã tồn tại");
        messages.put(INTERNAL_SERVER_ERROR,"Có lỗi xảy ra trong hệ thống !");
        messages.put(USERNAME_INCORRECT, "tài khoản hoặc mật khẩu không đúng");
        messages.put(EMPLOYEE_EXISTED,"Nhân viên đã tồn tại");
        messages.put(EMPLOYEE_NOT_EXISTED, "Nhân viên không tồn tại");
        messages.put(NO_PERMISSION,"Bạn không có quyền truy cập ");
    }
}
