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

public class UpdateReqTest extends BaseTest {
    private User newUser;

    @Test
    public void updateUser() {
        User user = RandomUserGenerator.getUser(Gender.female, Status.active);
        RequestUtils.post(EndPoints.USERS, user);
        newUser = ResponseUtils.getObjectFromResponse(User.class);
        String actualName = newUser.getName();
        String actualEmail = newUser.getEmail();

        RequestUtils.update(EndPoints.USERS + "/" + newUser.getId());

        newUser = ResponseUtils.getObjectFromResponse(User.class);
        String expectedName = newUser.getName();
        String expectedEmail = newUser.getEmail();

        softAssert.assertNotEquals(actualName, expectedName, "User updated wrong");
        softAssert.assertNotEquals(actualEmail, expectedEmail, "User updated wrong");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteAddedUser() {
       RequestUtils.delete(EndPoints.USERS + "/" + newUser.getId());
    }
}
