package entities;

import interfaces.Displayable;

public class Person implements Displayable {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private int age;
    private boolean active;

    public Person(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            int age,
            boolean active) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
        setNationalId(nationalId);
        setAge(age);
        setActive(active);
    }

    // Setters ___________________________________________________

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ID cannot be empty.");
            return;
        }
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            System.out.println("First name cannot be empty.");
            return;
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("Last name cannot be empty.");
            return;
        }
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) {
            System.out.println("Date of birth cannot be empty.");
            return;
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            System.out.println("Gender cannot be empty.");
            return;
        }
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            System.out.println("Phone number cannot be empty.");
            return;
        }

        if (!phoneNumber.matches("\\d+")) {
            System.out.println("Phone number must contain numbers only.");
            return;
        }

        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }

        if (!email.contains("@")) {
            System.out.println("Invalid email.");
            return;
        }

        this.email = email;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            System.out.println("Address cannot be empty.");
            return;
        }
        this.address = address;
    }

    public void setNationalId(String nationalId) {
        if (nationalId == null || nationalId.trim().isEmpty()) {
            System.out.println("National ID cannot be empty.");
            return;
        }
        this.nationalId = nationalId;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("Invalid age.");
            return;
        }
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Getters ___________________________________________________

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    // Functions ___________________________________________________

    @Override
    public void displayInfo() {
        System.out.println(
                "ID: " + getId() +
                        ", Name: " + getFirstName() + " " + getLastName() +
                        ", DOB: " + getDateOfBirth() +
                        ", Gender: " + getGender() +
                        ", Phone: " + getPhoneNumber() +
                        ", Email: " + getEmail() +
                        ", Address: " + getAddress() +
                        ", National ID: " + getNationalId() +
                        ", Age: " + getAge() +
                        ", Active: " + isActive()
        );
    }

    @Override
    public String displaySummary() {
        return getId() + " - " + getFirstName() + " " + getLastName();
    }
}