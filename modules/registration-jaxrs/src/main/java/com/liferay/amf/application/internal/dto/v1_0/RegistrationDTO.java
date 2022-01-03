package com.liferay.amf.application.internal.dto.v1_0;

import com.liferay.amf.model.Registration;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.Date;

@ProviderType
public class RegistrationDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String userName;
    private String emailAddress;
    private String city;
    private String state;
    private Date birthday;
    private String homePhone;
    private String zipCode;
    private String address;

    public RegistrationDTO(){}

    public RegistrationDTO(Registration registration){
        this.firstName = registration.getFirstName();
        this.lastName = registration.getLastName();
        this.userName = registration.getUserName();
        this.emailAddress = registration.getEmailAddress();
        this.city = registration.getCity();
        this.state = registration.getState();
        this.birthday = registration.getBirthday();
        this.homePhone = registration.getHomePhone();
        this.zipCode = String.valueOf(registration.getZipCode());
        this.address = registration.getAddress1();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
