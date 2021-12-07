package logback.main.repository;

import logback.main.data.EventData;

public interface EventsRepository {

    void saveEventData(EventData eventData);

}
