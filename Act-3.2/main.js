$(document).ready(function() {
    $("h1").css({ "color": "gray", "font-family": "Trebuchet MS", "text-align": "center", "margin-top": "7%" })
    $("form div").css({
        margin: "17px 0",
        border: "1px solid gray",
        "border-radius": "7px",
        padding: "17px",
        background: "white",
    });
    $("form").css({
        "font-family": "Trebuchet MS",
        width: "27%",
        margin: "0 auto",
        border: "1px solid darkred",
        "border-radius": "27px",
        padding: "27px",
        background: "darkred",
    });
    $("label").css({
        display: "inline-block",
        width: "11rem",
        "align-items": "center",
    });
    $("input").css({
        border: "1px dotted gray",
        padding: "7px",
        "border-radius": "7px",
        width: "57%",
    });
    $("button").css({
        border: "1px dotted gray",
        padding: "7px",
        "border-radius": "7px",
        width: "100%",
        "font-size": "medium",
        cursor: "pointer",
    });
    $("button").click(function() {
        if (
            (new Date() - new Date($("input[type='date']").val())) /
            1000 /
            60 /
            60 /
            24 /
            365 <
            18
        ) {
            $("#ageError")
                .html("Your age does not meet the requirements to create an account")
                .css({
                    color: "darkred",
                    "font-family": "Trebuchet MS",
                });
        } else if (
            (new Date() - new Date($("input[type='date']").val())) /
            1000 /
            60 /
            60 /
            24 /
            365 >=
            18
        ) {
            $("#ageError").html("");
        }
        if ($("input[type='email']").val() == "") {
            $("#emailError").html("E-mail is required").css({
                color: "#efd807",
                "font-family": "Trebuchet MS",
            });
        } else if ($("input[type='email']").val() != "") {
            $("#emailError").html("");
        }
        if (validateForm() && ((new Date() - new Date($("input[type='date']").val())) /
                1000 /
                60 /
                60 /
                24 /
                365 >=
                18) && ($("input[type='email']").val() != "")) {
            $("#confirmMsg")
                .html("Your account is confirmed!")
                .css({ color: "green", "font-family": "Trebuchet MS", "margin-top": "2%" });
        }

        function validateForm() {
            var isValid = true;
            $(".input").each(function() {
                if ($(this).val() === "") isValid = false;
            });
            return isValid;
        }
    });
});