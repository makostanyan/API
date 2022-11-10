package post;

import models.Post;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.RandomPostGenerator;
import utility.RequestUtils;
import utility.ResponseUtils;

public class DeleteAddedPostTest extends BaseTest {

    private Post newPost;

    @BeforeMethod
    public void postNewPost() {
        Post post = RandomPostGenerator.getPost(4616);
        RequestUtils.post(EndPoints.POSTS, post);
        newPost = ResponseUtils.getObjectFromResponse(Post.class);
    }

    @Test
    public void deleteAddedUser() {
        RequestUtils.delete(EndPoints.POSTS + "/" + newPost.getId());

        RequestUtils.get(EndPoints.POSTS + "/" + newPost.getId());

        String message = ResponseUtils.getMessageInJsonPath();
        softAssert.assertEquals(message, "Resource not found", "Post exists");
        softAssert.assertAll();
    }
}
