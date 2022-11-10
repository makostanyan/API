package post;

import models.Post;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.RandomPostGenerator;
import utility.RequestUtils;
import utility.ResponseUtils;

public class UpdatePostTest extends BaseTest {
    private Post newPost;

    @Test
    public void updateUser() {
        Post post = RandomPostGenerator.getPost(4616);
        RequestUtils.post(EndPoints.POSTS, post);
        newPost = ResponseUtils.getObjectFromResponse(Post.class);

        String actualTitle = newPost.getTitle();
        String actualBody = newPost.getBody();

        RequestUtils.update(EndPoints.POSTS + "/" + newPost.getId());
        newPost = ResponseUtils.getObjectFromResponse(Post.class);

        String expectedTitle = newPost.getTitle();
        String expectedBody = newPost.getBody();

        softAssert.assertNotEquals(actualTitle, expectedTitle, "User updated wrong");
        softAssert.assertNotEquals(actualBody, expectedBody, "User updated wrong");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteAddedUser() {
        RequestUtils.delete(EndPoints.POSTS + "/" + newPost.getId());
    }
}
