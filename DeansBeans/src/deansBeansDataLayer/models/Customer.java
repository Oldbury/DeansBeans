package deansBeansDataLayer.models;

import javax.persistence.*;


@Entity
@Table(name = "customers", schema = "deansBeans")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID", nullable = false)
    private int customerID;

    @Column(name = "CustomerName", nullable = false, length = 50)
    private String customerName;

    @Column(name = "AddressLine1", nullable = false, length = 100)
    private String addressLine1;

    @Column(name = "AddressLine2", length = 100)
    private String addressLine2;

    @Column(name = "AddressLine3", length = 100)
    private String addressLine3;

    @Column(name = "PostCode", nullable = false, length = 10)
    private String postCode;

    @Column(name = "Phone", nullable = false, length = 16)
    private String phone;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "SecurityQuestion", nullable = false, length = 200)
    private String securityQuestion;

    @Column(name = "SecurityQuestionAnswer", nullable = false, length = 200)
    private String securityQuestionAnswer;

    public Customer(String customerName, String addressLine1, String addressLine2, String addressLine3, String postCode, String phone, String email, String securityQuestion, String securityQuestionAnswer) {
        this(0, customerName, addressLine1, addressLine2, addressLine3, postCode, phone, email, securityQuestion, securityQuestionAnswer);
    }
   

    public Customer(int customerID, String customerName, String addressLine1, String addressLine2, String addressLine3, String postCode, String phone, String email, String securityQuestion, String securityQuestionAnswer) {
        this.customerID = customerID;
    	this.customerName = customerName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAnswer = securityQuestionAnswer;
    }

    // This is necessary for JPA and hibernate to function correctly
    public Customer() {
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerNumber(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }
    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }


}
