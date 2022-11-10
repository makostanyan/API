package user;

import models.User;
import base.BaseTest;
import constants.EndPoints;
import org.testng.annotations.Test;;
import utility.RequestUtils;
import utility.ResponseUtils;

public class GetAddedUserTest extends BaseTest {

    @Test
    public void getAddedUser() {
        RequestUtils.get(EndPoints.USERS + "/19");
        ResponseUtils.printBody();
        ResponseUtils.validateResponseWithJsonSchema("src/test/resources/schema.json");

       User user = ResponseUtils.getObjectFromResponse(User.class);

        softAssert.assertEquals(user.getName(), "User10", "User name not found");
        softAssert.assertAll();
    }
}
