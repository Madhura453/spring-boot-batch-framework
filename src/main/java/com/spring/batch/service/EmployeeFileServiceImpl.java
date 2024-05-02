package com.spring.batch.service;

import com.spring.batch.annotation.Position;
import com.spring.batch.constant.EmployeeConstant;
import com.spring.batch.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
@Slf4j
public class EmployeeFileServiceImpl implements EmployeeFileService{

    @Override
    public boolean createFlatFileAndUpload(List<EmployeeDto> regularRpas) {
        boolean uploadFileStatus = false;
        log.info("Converting regularRpas to Flat File. The regularRpas's are: {}",
                regularRpas);
        List<byte[]> byteList = new ArrayList<>();
        List<Long> rids = new ArrayList<>();
        Path writePath = null;
        try {
            regularRpas.stream().forEach((EmployeeDto regulaRpa) ->
            {
                processFixedFile(regulaRpa);
                byte[] regulaRpaBytes = regulaRpa.toString().getBytes(StandardCharsets.ISO_8859_1);
                Collections.addAll(byteList, regulaRpaBytes);
                byte[] newline1 = "\n".getBytes(StandardCharsets.ISO_8859_1);
                Collections.addAll(byteList, newline1);
            });

            byte[] byteArray = byteList.stream()
                    .collect(
                            () -> new ByteArrayOutputStream(),
                            (b, e) -> b.write(e, 0, e.length),
                            (a, b) -> {
                            }).toByteArray();
            Path directoryPath = Files.createDirectories(Paths.get(EmployeeConstant.OUTPUT_ORDER_DATA_DIR));
            String fileName = EmployeeConstant.REGULAR_RPA_FILE_NAME + ".txt";
            final String separator = FileSystems.getDefault().getSeparator();
            String absFileNamePath = directoryPath.toFile().getAbsolutePath() + separator + fileName;
            File f = new File(absFileNamePath);
            if (f.exists()) {
                Files.delete(Path.of(absFileNamePath));
            }
            writePath = Files.createFile(Paths.get(absFileNamePath));
            Files.write(writePath, byteArray);

        } catch (Exception e) {
            log.info("Exception occurred uploading regularRpa's flat file to azure blob storage. " +
                            "The error message is: {}",
                    e);
            uploadFileStatus = false;
        }
        return uploadFileStatus;
    }

    private void extracted(Object newInstance, Field field, int length,
                           String delimeter, String data) throws IllegalAccessException {
        if ("S".equalsIgnoreCase(delimeter)) {
            // right padding
            String f = "%" + (-length) + "s";
            String d = String.format(f, data);
            ReflectionUtils.setField(field, newInstance, d);
        } else if ("N".equalsIgnoreCase(delimeter)) {
            //left padding
            String f = "%" + length + "s";
            String d = String.format(f, data).replace(' ', '0');
            ReflectionUtils.setField(field, newInstance, d);
        }

    }

    private void processFixedFile(Object newInstance) {
        Field[] fields = newInstance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("jdaRpaDetailDtos") && !field.getName().equals("rid")) {
                try {
                    Position position = field.getAnnotation(Position.class);
                    int length = position.length();
                    String delimeter = position.delimeter();
                    ReflectionUtils.makeAccessible(field);
                    String data = Objects.nonNull(field.get(newInstance)) ? field.get(newInstance).toString() : "";
                    data = data.length() >= length ? data.substring(0, length) : data;
                    extracted(newInstance, field, length, delimeter, data);
                } catch (Exception e) {
                    log.info("exception occurred while file creation", e);
                }
            }
        }
    }
}
