$('#login-btn').click(()=>{
    let user_name = $('#user-name').val()
    let user_password = $('#user-password').val()
    $.ajax({
        url: "/user/login/",
        data:{
            "userName": user_name,
            "userPassword": user_password
        },
        success: function(res){
            // console.log(res)
            if(res.code === 1){
                window.location.href = "/select"
            }else{
                alert(res.msg)
            }
        },
        error: function (err) {
            console.log(err)
        },
        method : "get",
    })
})