package com.nexum.backend.infra.files.helperFile;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class CSVhelper {
    public static ByteArrayInputStream userToCSV(List<UserEntity> userEntitys) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (UserEntity userEntity : userEntitys ) {
                List<String> data = Arrays.asList(
                        userEntity.getNome(),
                        userEntity.getSobre()
                );
                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
