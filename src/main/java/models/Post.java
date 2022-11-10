package models;

public class Post {
    private int id;
    private int user_id;
    private String title;
    private String body;

    public Post(){}
    public Post(PostBuilder postBuilder) {
        this.id = postBuilder.id;
        this.user_id = postBuilder.user_id;
        this.title = postBuilder.title;
        this.body = postBuilder.body;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    public static class PostBuilder {
        private int id;
        private int user_id;
        private String title;
        private String body;


        public PostBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PostBuilder setUser_id(int user_id) {
            this.user_id = user_id;
            return this;
        }

        public PostBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}
