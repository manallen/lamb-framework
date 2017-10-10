package org.lamb.lambframework.core.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lamb.lambframework.core.exception.EventException;
import org.lamb.lambframework.core.enumeration.ExceptionEnum;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by WangGang on 2017/6/16 0016.
 * E-mail userbean@outlook.com
 * The final interpretation of this procedure is owned by the author
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();



    public static Map json2Map(String json){
        if (StringUtils.isBlank(json)) {
            throw new EventException(ExceptionEnum.EL00000000);
        }
        try {
            Map map = mapper.readValue(json, Map.class);
            if(map == null){
                throw new EventException(ExceptionEnum.EL00000001);
            }
            return map;
        } catch (IOException e) {
            throw new EventException(ExceptionEnum.EC00000003);
        }
    }

    public static String Map2String(Map map){
        if(map==null){
            throw new EventException(ExceptionEnum.EL00000000);
        }
        if(map.isEmpty()){
            throw new EventException(ExceptionEnum.EL00000000);
        }
        try {
            return  mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new EventException(ExceptionEnum.EC00000003);
        }
    }

    public static  <T>T  get(Map map,String name){

        if (StringUtils.isBlank(name)) {
            throw new EventException(ExceptionEnum.EL00000002);
        }
        if(map==null){
            throw new EventException(ExceptionEnum.EL00000001);
        }
        if(map.isEmpty()){
            throw new EventException(ExceptionEnum.EL00000001);
        }
        T t = (T)map.get(name);
        if(t == null){
            throw new EventException(ExceptionEnum.EL00000000);
        }

        if( t instanceof  String){
            if(StringUtils.isBlank(t.toString())){
                throw new EventException(ExceptionEnum.EL00000000);
            }
            return t;
        }

        if(t instanceof Map){

            if(((Map) t).isEmpty()){
                throw new EventException(ExceptionEnum.EL00000000);
            }

            return t;
        }

        return t;

    }

    public static String objToJson(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new EventException(ExceptionEnum.EC00000004);
        }
    }
}
