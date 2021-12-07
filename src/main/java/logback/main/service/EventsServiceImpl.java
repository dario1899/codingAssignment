package logback.main.service;

import logback.main.data.EventData;
import logback.main.repository.EventsRepository;
import logback.main.repository.EventsRepositoryImpl;
import org.json.simple.JSONObject;

public class EventsServiceImpl implements EventsService {

    private EventsRepository eventsRepository = new EventsRepositoryImpl();

    @Override
    public void saveFinishedEvent(JSONObject json1, JSONObject json2) {
        EventData eventData = new EventData();

        String eventId = (String) json1.get("id");
        Long eventDuration = calculateDurationTime(json1, json2);

        eventData.setEventId(eventId);
        eventData.setEventDuration(eventDuration);
        if (json1.get("type") != null) {
            String type = (String) json1.get("type");
            eventData.setType(type);
        }
        if (json1.get("host") != null) {
            String host = (String) json1.get("host");
            eventData.setHost(host);
        }
        if (eventDuration > 4) {
            eventData.setAlert(true);
        }

        eventsRepository.saveEventData(eventData);
    }

    private Long calculateDurationTime(JSONObject json1, JSONObject json2) {
        Long timestamp1 = Long.parseLong((String) json1.get("timestamp"));
        Long timestamp2 = Long.parseLong((String) json2.get("timestamp"));

        return Math.abs(timestamp1 - timestamp2);
    }

}
