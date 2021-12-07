package logback.main.service;

import logback.main.data.EventData;
import logback.main.repository.EventsRepository;
import logback.main.repository.EventsRepositoryImpl;
import org.json.simple.JSONObject;

public class EventsServiceImpl implements EventsService {

    private EventsRepository eventsRepository = new EventsRepositoryImpl();

    private static final String JSON_PROPERTY_ID = "id";
    private static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
    private static final String JSON_PROPERTY_TYPE = "type";
    private static final String JSON_PROPERTY_HOST = "host";

    @Override
    public void saveFinishedEvent(JSONObject json1, JSONObject json2) {
        EventData eventData = new EventData();

        String eventId = (String) json1.get(JSON_PROPERTY_ID);
        Long eventDuration = calculateDurationTime(json1, json2);

        eventData.setEventId(eventId);
        eventData.setEventDuration(eventDuration);
        if (json1.get(JSON_PROPERTY_TYPE) != null) {
            String type = (String) json1.get(JSON_PROPERTY_TYPE);
            eventData.setType(type);
        }
        if (json1.get(JSON_PROPERTY_HOST) != null) {
            String host = (String) json1.get(JSON_PROPERTY_HOST);
            eventData.setHost(host);
        }
        if (eventDuration > 4) {
            eventData.setAlert(true);
        }

        eventsRepository.saveEventData(eventData);
    }

    private Long calculateDurationTime(JSONObject json1, JSONObject json2) {
        Long timestamp1 = Long.parseLong((String) json1.get(JSON_PROPERTY_TIMESTAMP));
        Long timestamp2 = Long.parseLong((String) json2.get(JSON_PROPERTY_TIMESTAMP));

        return Math.abs(timestamp1 - timestamp2);
    }

}
