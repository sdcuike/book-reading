package com.doctor.jackson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * @author sdcuike
 *
 * @time 2016年2月28日 下午3:53:59
 * 
 * @see https://github.com/FasterXML/jackson-dataformat-csv
 */
public class JacksonDataformatCsvFile {

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
        CsvSchema csvSchema = csvMapper.schemaFor(CostDetail.class).withHeader();
        System.out.println(csvSchema);
        csvSchema.forEach(t -> System.out.println(t.getName()));
        try (SequenceWriter writer = csvMapper.writer(csvSchema).writeValues(new File("csv.csv"));) {
            writer.write(costDetail);
            // ---
        } catch (Exception e) {
            throw e;
        }

        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        System.out.println("read from file");
        try (InputStream inputStream = JacksonDataformatCsvFile.class.getClassLoader().getResourceAsStream("data.csv");) {

            MappingIterator<CostDetail> values = csvMapper.readerFor(CostDetail.class).with(schema).readValues(inputStream);
            values.forEachRemaining(System.out::println);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
