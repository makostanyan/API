package user;

import constants.Gender;
import constants.Status;
import models.User;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.RandomUserGenerator;
import utility.RequestUtils;
import utility.ResponseUtils;


public class PostReqTest extends BaseTest {
    private User newUser;

    @Test
    public void postNewUser() {
        User user = RandomUserGenerator.getUser(Gender.female, Status.active);

        RequestUtils.post(EndPoints.USERS, user);

        softAssert.assertEquals(ResponseUtils.getStatusCode(), 201);

        newUser = ResponseUtils.getObjectFromResponse(User.class);

        softAssert.assertEquals(newUser.getName(), user.getName(), "User added wrong");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteAddedUser() {
        RequestUtils.delete(EndPoints.USERS + "/" + newUser.getId());
    }
}
