package ca.zitao.ln.models.persistent;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class Chapter extends RealmObject {
    private String id;
    private String source;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
