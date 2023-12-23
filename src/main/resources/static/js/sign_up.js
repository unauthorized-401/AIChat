function sign_up_process() {
    var username = document.getElementById("username").value;
    var userid = document.getElementById("userid").value;
    var password = document.getElementById("password").value;

    var api = "http://localhost:8080/common/account/join";
    var data = {
        userName: username,
        userId: userid,
        password: password
    };

    fetch(api, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if (data.statusCode == '200') {
            alert(data.statusMessage + " Go to the login page.");
            window.location.href = "http://localhost:8080";
        } else {
            console.log("API Response: ", data);
            alert(data.statusMessage);
        }
    })
    .catch(error => {
        console.error("API Error: ", error);
    });
}

document.addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
        sign_up_process();
    }
});