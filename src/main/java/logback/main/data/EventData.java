package logback.main.data;

import javax.persistence.*;

@Entity
@Table(name = "event_data_table")
public class EventData {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String eventId;

    @Column
    private Long eventDuration;

    @Column
    private String type;

    @Column
    private String host;

    @Column
    private boolean alert;

    public EventData() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(Long eventDuration) {
        this.eventDuration = eventDuration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}
