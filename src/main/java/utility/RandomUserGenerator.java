package utility;

import constants.Gender;
import constants.Status;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
public class RandomUserGenerator {

    public static User getUser(Gender gender, Status status) {
      return new User.UserBuilder()
                .setName( RandomStringUtils.randomAlphabetic(5, 7))
                .setEmail( RandomStringUtils.randomAlphabetic(5, 7) + "@gmail.com")
                .setGender(gender)
                .setStatus(status)
                .build();

    }
}
