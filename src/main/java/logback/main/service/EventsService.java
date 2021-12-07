package logback.main.service;

import org.json.simple.JSONObject;

public interface EventsService {

    void saveFinishedEvent(JSONObject json1, JSONObject json2);

}
