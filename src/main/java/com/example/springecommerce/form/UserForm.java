package com.example.springecommerce.form;

import javax.validation.constraints.*;

public class UserForm {

    public class Update {

        @NotNull
        @Positive
        private int id;

        @NotBlank(message = "Full name cannot be null")
        @Size(min=2, max=30, message = "Full name must be between 2 and 30 characters")
        private String fullname;

        private String avatar;

        @Size(min=10 , max = 10, message = "Phone number must be 10 digits")
        private String phone;
        private String address;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

}
