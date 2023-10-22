package org.caranus.eventticket.model.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.caranus.eventticket.model.Event;

public class EventImpl implements Event, Serializable {

    private static final long serialVersionUID = 2381352458847000576L;

    private long id;

    private String title;

    private Date date;

    public EventImpl() {
    }

    public EventImpl(long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventImpl event = (EventImpl) o;
        return id == event.id && Objects.equals(title, event.title) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date);
    }

    @Override
    public String toString() {
        return "EventImpl{" + "id=" + id + ", title='" + title + '\'' + ", date=" + date + '}';
    }
}
