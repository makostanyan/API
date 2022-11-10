package post;

import models.Post;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.Test;
import utility.RequestUtils;
import utility.ResponseUtils;


public class GetAddedPost extends BaseTest {

    @Test
    public void getAddedPost() {
        RequestUtils.get(EndPoints.POSTS + "/2478");
        Post post = ResponseUtils.getObjectFromResponse(Post.class);

        softAssert.assertEquals(post.getTitle(), "Alienus abduco testimonium absens auxilium adsuesco validus.", "User name not found");
        softAssert.assertAll();
    }
}
