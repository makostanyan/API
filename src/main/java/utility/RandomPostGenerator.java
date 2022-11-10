package utility;

import models.Post;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomPostGenerator {

    public static Post getPost(int user_id) {
        return new Post.PostBuilder()
                .setUser_id(user_id)
                .setTitle(RandomStringUtils.randomAlphabetic(2, 7))
                .setBody(RandomStringUtils.randomAlphabetic(5, 15))
                .build();
    }
}
