package com.test.util;

import java.util.Collection;

/**
 * Created by 95 on 2016/11/13.
 */
public class ValidateUtil {
    public static boolean isValid(Collection col){
        if(col == null || col.isEmpty()){
            return false;
        }
        return true;
    }
}
