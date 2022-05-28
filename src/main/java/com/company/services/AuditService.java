package com.company.services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    FileWriter writer;

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logAction(String action) throws IOException {
        try {
            writer.append(action);
            writer.append(",");
            writer.append(formatter.format(LocalDateTime.now()));
            writer.append("\n");
            writer.flush();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


    public AuditService() {
        try{
            this.writer = new FileWriter("src/main/java/com/company/resources/audit.csv");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
