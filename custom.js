$(document).ready(function() {
    $("#customerForm").submit(function(event) {
        event.preventDefault();

        var formData = {
            firstName: $("#firstName").val(),
            middleName: $("#middleName").val(),
            lastName: $("#lastName").val(),
            mobilenumber: $("#mobilenumber").val(),
            emailId: $("#emailId").val(),
            LocalAddress: $("#LocalAddress").val(),
            LocalAddressDistrict: $("#LocalAddressDistrict").val(),
            LocalAddressState: $("#LocalAddressState").val(),
            PermanentAddress: $("#permanent address").val(),
            PermanentCountry: $("#permanent country").val(),
            PermanentState: $("#permanent state").val(),
            PermanentDistrict: $("#permanent district").val(),
            status: $("#status").val()
        };

        var customerDetails = 
            formData.firstName + " " + 
            formData.middleName + " " + 
            formData.lastName + ", Mobile: " + 
            formData.mobilenumber + ", Email: " + 
            formData.emailId + ", Local Address: " + 
            formData.LocalAddress + ", District: " + 
            formData.LocalAddressDistrict + ", State: " + 
            formData.LocalAddressState + ", Permanent Address: " + 
            formData.PermanentAddress + ", Country: " + 
            formData.PermanentCountry + ", State: " + 
            formData.PermanentState + ", District: " + 
            formData.PermanentDistrict + ", Status: " + 
            formData.status;

        $("#customerList").append("<li>" + customerDetails + "</li>");

        $("#customerForm")[0].reset();
    });
});