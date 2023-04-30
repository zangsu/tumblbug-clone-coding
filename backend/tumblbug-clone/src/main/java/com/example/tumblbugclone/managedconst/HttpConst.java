package com.example.tumblbugclone.managedconst;

public class HttpConst {
    //== URL ==//
    public static final String USER_URI = "/user";
    public static final String USER_SIGNUP_URI = "/signup";

    //== 헤더 이름 ==//
    public static final String HEADER_NAME_ERROR_MESSAGE = "error-message";

    //== 헤더 값 ==//
    public static final String DUPLICATED_USER_ID_MESSAGE = "중복된 사용자 아이디 입니다.";
    public static final String DUPLICATED_USER_EMAIL_MESSAGE = "이미 가입되어 있는 이메일 입니다.";
    public static final String NO_USER_FIND_MESSAGE = "존재하지 않는 유저 인덱스 입니다.";
    public static final String CANT_MODIFY_USER_ID_MESSAGE = "유저의 Id는 변경할 수 없습니다.";
    public static final String UNREGISTER_USER_MESSAGE = "탈퇴한 유저입니다.";
}
