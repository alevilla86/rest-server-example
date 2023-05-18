package com.alevilla86.tutorials.rest.server.dto;

/**
 *
 * @author alejandro
 */
public class UserDto {
    
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private int age;

    public UserDto() {
    }

    public UserDto(String name, String lastName, String email, String phone, int age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserDto{");
        sb.append("name=").append(name);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
    
}
