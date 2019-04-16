package hx.insist.pojo;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String uid;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String intro;

    private String checkcode;

    private Map<String,String> errors = new HashMap<>();


    public User() {
    }

    public User(String uid, String username, String password, String nickname, String email, String intro) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", intro='" + intro + '\'' +
                ", errors=" + errors +
                '}';
    }
    //修改个人信息校验
    public boolean Verification3() {
        boolean isOK = true;

        if(!nickname.matches("^[\\u4E00-\\u9FA5A-Za-z0-9_]+$") || nickname.length()<4 || nickname.length()>16){
            isOK = false;
            errors.put("nickname","昵称为数字、字母、汉字或其组合，且在4-16位之间!");
        }

        return isOK;
    }

    //修改个人信息校验
    public boolean Verification2(String password2) {
        boolean isOK = true;

        if(!nickname.matches("^[\\u4E00-\\u9FA5A-Za-z0-9_]+$") || nickname.length()<4 || nickname.length()>16){
            isOK = false;
            errors.put("nickname","昵称为数字、字母、汉字或其组合，且在4-16位之间!");
        }

        if(!password.matches("[0-9a-zA-Z]{6,16}")){//不为数字或字母的组合，或超出长度
            isOK = false;
            errors.put("password","密码为6-16位数字或字母的组合!");
        }else {
            if (!password.equals(password2)) {
                isOK = false;
                errors.put("password", "两次密码不一致!");
            }
        }

        return isOK;
    }


    //注册校验
     public boolean Verification(String checkcode2){
         boolean isOK = true;

         if(checkcode==null || StringUtils.isEmpty(checkcode)){//空
             isOK = false;
             errors.put("checkcode","验证码必填!");
         }else{//非空
             if(!checkcode.equals(checkcode2)){
                 isOK = false;
                 errors.put("checkcode","验证码填写错误!");
             }
         }
         if(username==null || StringUtils.isEmpty(username)){//空
             isOK = false;
             errors.put("username","账号必填!");
         }else{//非空
             if(!username.matches("[0-9a-zA-Z]{6,16}")){//不为数字或字母的组合，或超出长度
                 isOK = false;
                 errors.put("username","账号为6-16位数字或字母的组合!");
             }
         }
         if(password==null || StringUtils.isEmpty(password)){//空
             isOK = false;
             errors.put("password","密码必填!");
         }else{//非空
             if(!password.matches("[0-9a-zA-Z]{6,16}")){//不为数字或字母的组合，或超出长度
                 isOK = false;
                 errors.put("password","密码为6-16位数字或字母的组合!");
             }
         }
         if(nickname==null || StringUtils.isEmpty(nickname)){//空
             isOK = false;
             errors.put("nickname","昵称必填!");
         }else{//非空
             if(!nickname.matches("^[\\u4E00-\\u9FA5A-Za-z0-9_]+$") || nickname.length()<4 || nickname.length()>16){
                 isOK = false;
                 errors.put("nickname","昵称为数字、字母、汉字或其组合，且在4-16位之间!");
             }
         }
         if(email==null || StringUtils.isEmpty(email)){//空
             isOK = false;
             errors.put("email","email必填!");
         }else{//非空
             if(!email.matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$")){//不为数字或字母的组合，或超出长度
                 isOK = false;
                 errors.put("email","邮箱不符合规则!");
             }
         }
         return isOK;
     }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}