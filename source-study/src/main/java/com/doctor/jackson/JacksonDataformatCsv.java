package com.doctor.jackson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * @author sdcuike
 *
 * @time 2016年2月28日 下午3:38:09
 */
public class JacksonDataformatCsv {

    public static void main(String[] args) throws IOException {
        CostDetail costDetail = new CostDetail();
        costDetail.setAmount(BigDecimal.valueOf(12.55D));
        costDetail.setApplyId(11L);
        costDetail.setCostCenterId(66L);
        costDetail.setCreatedTime(new Date());
        costDetail.setStatus(1L);
        costDetail.setTypeId(77L);
        costDetail.setTypeName("v");
        costDetail.setUserId(88L);
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(CostDetail.class);
        String writeValueAsString = csvMapper.writer(csvSchema).writeValueAsString(costDetail);
        System.out.println(writeValueAsString);// 12.55,11,66,1456645956239,1,77,v,88

        CostDetail readValue = csvMapper.readerFor(CostDetail.class).with(csvSchema).readValue(writeValueAsString);
        System.out.println(readValue);// {"applyId":11,"typeId":77,"typeName":"v","status":1,"amount":12.55,"createdTime":"Feb 28, 2016 3:52:36 PM","userId":88,"costCenterId":66}

        Test test = new Test();

        test.setName("doctor");
        Map<String, String> map = new HashMap<>();
        map.put("age", "16");
        map.put("ke", "vv");

        test.setMap(map);
        CsvSchema testSh = csvMapper.schemaFor(Test.class);
        String writeValueAsString2 = csvMapper.writer(testSh).writeValueAsString(test);
        System.out.println(writeValueAsString2);
        // Exception in thread "main" com.fasterxml.jackson.databind.JsonMappingException: CSV generator does not support Object values for properties (through reference chain: com.doctor.jackson.Test["map"])

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
    }

}
