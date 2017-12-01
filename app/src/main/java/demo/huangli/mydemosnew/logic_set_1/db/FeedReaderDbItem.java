package demo.huangli.mydemosnew.logic_set_1.db;

/**
 * Created by huangli on 16/9/14.
 */
public class FeedReaderDbItem {
    private String title;
    private String subtitle;

    public FeedReaderDbItem(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
