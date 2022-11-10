package user;

import constants.Gender;
import constants.Status;
import models.User;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.RandomUserGenerator;
import utility.RequestUtils;
import utility.ResponseUtils;

public class DeleteAddedUserTest extends BaseTest {
    private User newUser;

    @BeforeMethod
    public void postNewUser() {
        User user = RandomUserGenerator.getUser(Gender.female, Status.active);
        RequestUtils.post(EndPoints.USERS, user);
        newUser = ResponseUtils.getObjectFromResponse(User.class);

    }

    @Test
    public void deleteAddedUser() {
        RequestUtils.delete(EndPoints.USERS + "/" + newUser.getId());
        RequestUtils.get(EndPoints.USERS + "/" + newUser.getId());

        String message = ResponseUtils.getMessageInJsonPath();
        softAssert.assertEquals(message, "Resource not found", "User exists");
        softAssert.assertAll();
    }
}
