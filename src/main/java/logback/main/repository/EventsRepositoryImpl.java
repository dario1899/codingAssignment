package logback.main.repository;

import logback.main.data.EventData;
import logback.main.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventsRepositoryImpl implements EventsRepository {

    private static final Logger log = LoggerFactory.getLogger(EventsRepositoryImpl.class);

    @Override
    public void saveEventData(EventData eventData) {
        log.debug(String.format("Saving event data to db (event id: %s)", eventData.getEventId()));
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(eventData);
        session.getTransaction().commit();
        session.close();
    }

}
