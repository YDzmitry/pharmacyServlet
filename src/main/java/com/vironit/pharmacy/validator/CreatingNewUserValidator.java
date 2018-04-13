package com.vironit.pharmacy.validator;

import com.vironit.pharmacy.exception.RegistrationValidatorException;
import org.hibernate.exception.ConstraintViolationException;

import java.util.HashMap;
import java.util.Map;

public class CreatingNewUserValidator {

    private Map<String, String> errMessageMap = new HashMap<>();

    public void validate(Exception e){
        if (((ConstraintViolationException) e).getConstraintName().equals("users_login_key")){
            errMessageMap.put("login","Такой пользователь уже присутствует в системе");
        }
        if (((ConstraintViolationException) e).getConstraintName().equals("users_passport_key")){
            errMessageMap.put("passport","Такой паспорт уже присутствует в системе");
        }
        if (!errMessageMap.isEmpty()) {
            throw new RegistrationValidatorException(errMessageMap);
        }
    }

    public Map<String, String> getErrMessageMap() {
        return errMessageMap;
    }
}
