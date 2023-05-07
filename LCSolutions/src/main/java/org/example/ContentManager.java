package org.example;

import java.util.HashSet;

class Content { /* ... */ }
class Event {  /* ... */ }
class UpdateEvent extends Event {
    public UpdateEvent(ContentManager cm, Content e) {
        /* ... */
        System.out.println("Update processed from " + cm.getClass() + " for " + e.getClass());
    }
}

public class ContentManager {
    HashSet<Content> contentNodes = new HashSet<Content>();

    public void addEntity (Content e) {
        contentNodes.add (e);
        contentPublish (new UpdateEvent (this, e));
    }

    public void removeEntity (Content e) {
        if (contentNodes.contains (e)) {
            contentNodes.remove (e);
            contentPublish (new UpdateEvent (this, e));
        }
    }

    protected void contentPublish (Event e) { /* events processing */ }
}
