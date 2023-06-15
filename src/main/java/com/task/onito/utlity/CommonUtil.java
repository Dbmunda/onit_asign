package com.task.onito.utlity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonUtil {

    public static <T> boolean isNullOrEmpty(T object){
        if(object== null){
            return true;
        } else if( (object instanceof String && (((String) object).trim().isEmpty()))
                || (object instanceof List && (( (List) object).isEmpty()))
                || (object instanceof Set && (( (Set) object).isEmpty()))
                || (object instanceof Map && (( (Map) object).isEmpty()))
                || (object instanceof Long && (( (Long) object).equals(0l)))
                || (object instanceof Integer && (( (Integer) object).equals(0)))
        ){
            return true;
        }
        return false;
    }
}
