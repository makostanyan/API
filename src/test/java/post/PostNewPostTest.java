package post;

import models.Post;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.RandomPostGenerator;
import utility.RequestUtils;
import utility.ResponseUtils;

public class PostNewPostTest extends BaseTest {

    private Post newPost;

    @Test
    public void postNewPost() {
        Post post = RandomPostGenerator.getPost(4616);
        RequestUtils.post(EndPoints.POSTS, post);
        newPost = ResponseUtils.getObjectFromResponse(Post.class);
        softAssert.assertEquals(newPost.getTitle(), post.getTitle(), "Post added wrong");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteAddedUser() {
        RequestUtils.delete(EndPoints.POSTS + "/" + newPost.getId());
    }
}
