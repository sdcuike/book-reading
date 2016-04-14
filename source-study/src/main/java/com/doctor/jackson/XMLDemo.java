package com.doctor.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author sdcuike
 *
 *         Create At 2016年4月14日 下午6:56:31
 */
public class XMLDemo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        List<Test> list = new ArrayList<>();

        Test test = new Test();
        test.setName("doctor");
        Map<String, String> map = new HashMap<>();
        map.put("age", "16");
        map.put("ke", "vv");
        test.setMap(map);
        list.add(test);

        Test test2 = new Test();
        test2.setName("doctor22");
        Map<String, String> map2 = new HashMap<>();
        map2.put("age2", "162");
        map2.put("ke2", "vv2");
        test2.setMap(map2);
        list.add(test2);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(list);
        System.out.println(xml);
        List<Test> ls = xmlMapper.readValue(xml, new TypeReference<List<Test>>() {
        });
        Test t = ls.get(0);
        System.out.println(t);
        System.out.println(t.getName());
        System.out.println(t.getMap());

    }

    static class Test {
        private String name;
        private Map<String, String> map;

        public Map<String, String> getMap() {
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
