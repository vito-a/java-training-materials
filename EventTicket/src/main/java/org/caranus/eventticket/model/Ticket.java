package org.caranus.eventticket.model;
public interface Ticket extends AbstractModel {
    public enum Category {STANDARD, PREMIUM, VIP}

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    long getId();
    void setId(long id);
    long getEventId();
    void setEventId(long eventId);
    long getUserId();
    void setUserId(long userId);
    Category getCategory();
    void setCategory(Category category);
    int getPlace();
    void setPlace(int place);

}
