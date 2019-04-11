package hx.insist.Vo;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class Account {
    private String username;
    private String password;

    private Map<String,String> errors = new HashMap<>();

    public boolean Verification(){
        boolean isOK = true;

        if(username==null || StringUtils.isEmpty(username)){//空
            isOK = false;
            errors.put("username","账号必填!");
        }else{//非空
            if(username.length()>16){
                isOK = false;
                errors.put("username","账号超出了最大长度!");
            }
        }
        if(password==null || StringUtils.isEmpty(password)){//空
            isOK = false;
            errors.put("password","密码必填!");
        }else{//非空
            if(password.length()>16){
                isOK = false;
                errors.put("password","密码超出了最大长度!");
            }
        }

        return isOK;
    }
}
