package logback.main;

import logback.main.service.EventsService;
import logback.main.service.EventsServiceImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            log.error("No input arguments with file path!");
            throw new Exception("No input arguments with file path!");
        }

        // TODO: validiateArgumentFilePath();
        log.info("Starting job for file " + args[0]);
        startJob(args[0]);

    }

    private static void startJob(String filePath) {
        HashMap<String, JSONObject> eventDataMap = new HashMap<>();
        EventsService eventsService = new EventsServiceImpl();

        JSONParser parser = new JSONParser();
        String line = null;
        JSONObject jsonObj;
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();

        try (Reader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while ((line = bufferedReader.readLine()) != null) {
                jsonObj = (JSONObject) parser.parse(line);
                json.add(jsonObj);
                String id = (String) jsonObj.get("id");
                if (eventDataMap.get(id) == null) {
                    eventDataMap.put(id, jsonObj);
                }
                else {
                    log.debug(String.format("Preparing to save finished event (event id: %s)", id));
                    eventsService.saveFinishedEvent(eventDataMap.get(id), jsonObj);
                    eventDataMap.remove(id);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        System.exit(1);
    }

}