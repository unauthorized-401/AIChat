function login_process() {
    var userid = document.getElementById("userid").value;
    var password = document.getElementById("password").value;

    var api = "http://localhost:8080/common/account/login";
    var data = {
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
            window.location.href = "http://localhost:8080/chat";
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
        login_process();
    }
});