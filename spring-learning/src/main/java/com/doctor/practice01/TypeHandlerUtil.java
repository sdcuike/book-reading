package com.doctor.practice01;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sdcuike
 *
 * @time 2016年2月10日 下午10:00:26
 */

@Component
public class TypeHandlerUtil {

    @SuppressWarnings({ "rawtypes", "unused" })
    private static List<TypeHandler> typeHandlers;

    @SuppressWarnings({ "rawtypes", "unused" })
    private static Map<String, TypeHandler> typeHandlerMap;

    @Autowired
    @SuppressWarnings("rawtypes")
    public void setTypeHandlerMap(Map<String, TypeHandler> typeHandlerMap) {
        TypeHandlerUtil.typeHandlerMap = typeHandlerMap;
    }

    @Autowired
    @SuppressWarnings("rawtypes")
    public void setTypeHandlers(List<TypeHandler> typeHandlers) {
        TypeHandlerUtil.typeHandlers = typeHandlers;
    }

    public static Map<String, TypeHandler> getTypeHandlerMap() {
        return typeHandlerMap;
    }

    public static List<TypeHandler> getTypeHandlers() {
        return typeHandlers;
    }
}
