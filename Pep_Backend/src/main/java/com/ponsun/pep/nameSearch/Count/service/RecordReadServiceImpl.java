package com.ponsun.pep.nameSearch.Count.service;

import com.ponsun.pep.dto.RecordDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecordReadServiceImpl implements RecordReadService{
    public void setFutureAsync(Future<String> futureStr, Consumer<String> callback) {
        CompletableFuture.supplyAsync(() -> {
            try {
                return futureStr.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return null;
            }
        }).thenAccept(callback).exceptionally(ex -> {
            ex.printStackTrace();
            // Handle the error appropriately
            return null;
        });
    }

    public void updateRecordDTO(RecordDetails recordDetails, Integer id, RecordDTO recordDTO) throws ExecutionException, InterruptedException {
//        System.out.println("AA :"+recordDetails.getValue(id));

        Future<HashMap<String, String>> mapRetFuture = recordDetails.getValue(id);
        HashMap<String, String> mapRet = mapRetFuture.get();  // This will block until the Future completes

        // Now you can retrieve a value from mapRet
        String nationality          = "";
        String Citizenship_Country  = "";
        String futureAddress        = "";
        String EntityType           = "";
        String passport             = "";
        String program              = "";
        if (mapRet.containsKey("Nationality Country"))
            nationality = mapRet.get("Nationality Country");
        if (mapRet.containsKey("Citizenship Country"))
            Citizenship_Country = mapRet.get("Citizenship Country");
        if (mapRet.containsKey("futureAddress"))
            futureAddress = mapRet.get("futureAddress");
        if (mapRet.containsKey("EntityType"))
            EntityType = mapRet.get("EntityType");
        if (mapRet.containsKey("Identifications"))
            passport = mapRet.get("Identifications");
        if (mapRet.containsKey("program"))
            program = mapRet.get("program");

        setStringAsync(nationality,recordDTO::setNationality);
        setStringAsync(Citizenship_Country,recordDTO::setCitizenship);
        setStringAsync(futureAddress,recordDTO::setAddress);
        setStringAsync(EntityType,recordDTO::setEntityType);
        setStringAsync(passport,recordDTO::setPassport);
        setStringAsync(program,recordDTO::setProgram);


//        setFutureAsync(passport, recordDTO::setPassport);
    }

    private void setStringAsync(String str, Consumer<String> setStr) {
        CompletableFuture.supplyAsync(() -> {
            return str;
        }).thenAccept(setStr).exceptionally(ex -> {
            ex.printStackTrace();
            // Handle the error appropriately
            return null;
        });
    }

}