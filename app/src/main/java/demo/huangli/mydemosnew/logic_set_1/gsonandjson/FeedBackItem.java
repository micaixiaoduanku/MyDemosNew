package demo.huangli.mydemosnew.logic_set_1.gsonandjson;

/**
 * Created by huangli on 17/1/20.
 */

public class FeedBackItem {

    FeedBack feedback;

    public FeedBack getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedBack feedback) {
        this.feedback = feedback;
    }

    public FeedBackItem(FeedBack feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "FeedBackItem{" +
                "feedback=" + feedback.toString() +
                '}';
    }

    public static class FeedBack{
        private String email;
        private String content;

        public FeedBack(String email, String content) {
            this.email = email;
            this.content = content;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "FeedBackItem{" +
                    "email='" + email + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
