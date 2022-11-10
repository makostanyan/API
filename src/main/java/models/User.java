package models;

import constants.Gender;
import constants.Status;

public class User {
    private Integer id;
    private String name;
    private String email;
    private Gender gender;
    private Status status;


    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.gender = userBuilder.gender;
        this.status = userBuilder.status;

    }

    public User(){}
        public Integer getId() {
            return id;
        }


        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public Gender getGender() {
            return gender;
        }

        public Status getStatus() {
            return status;
        }


    public static class UserBuilder {
        private Integer id;
        private String name;
        private String email;
        private Gender gender;
        private Status status;


        public UserBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
