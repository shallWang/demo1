$("#select").click(()=>{
    let select_website = $("#select-website").val();
    let select_app = $("#select-app").val();
    $.ajax({
        url: "/password/get",
        method: "get",
        data : {
            "website" : select_website,
            "application" : select_app
        },
        success : function (res){
            if(res.code === 1){
                creat(res.data)
            }else if(res.code === -1){
                alert(res.msg)
            }else{
                window.location.href = '/'
            }
        },
        error : function (err){
            console.log(err)
        }
    })
})

function creat(arr){
    let $div = $("#password-div")
    $div.empty()
    let $table = $('<table id="password-table"></table>')
    let $row = $('<tr></tr>>')
    $row.append($('<th>website</th>'))
    $row.append($('<th>application</th>'))
    $row.append($('<th>account</th>'))
    $row.append($('<th>password</th>'))
    $table.append($row)
    for(let i = 0; i < arr.length; i++){
        // $("#password-div").append(arr[i].account + "\t" + arr[i].accountPassword + "<br>")
        let $row = $('<tr class="password-tr"></tr>>')
        if(arr[i].website != null){
            $row.append($('<td class="website">'+arr[i].website+'</td>'))
        }else{
            $row.append($('<td class="website" ></td>'))
        }
        if(arr[i].application != null){
            $row.append($('<td class="application">'+arr[i].application+'</td>'))
        }else{
            $row.append($('<td class="application"></td>'))
        }
        if(arr[i].account != null) {
            $row.append($('<td class="account">' + arr[i].account + '</td>'))
        }else{
            $row.append($('<td class="account"></td>'))
        }
        if(arr[i].accountPassword != null) {
            $row.append($('<td class="password">' + arr[i].accountPassword + '</td>'))
        }else{
            $row.append($('<td class="password"></td>'))
        }
        $table.append($row)
    }
    $div.append($table)
    $('#password-table td').click((that)=>{
        //execCopy($(that.target).text())
        let text = $(that.target).text()
        let $target = $(that.target)[0]
        if(text == null || text === ''){
            alert('空')
            return
        }
        let classes = $target.className
        if("website" === classes){
            window.open(text, 'target')
            return
        }
        navigator.clipboard.writeText(text).then(()=>{
            alert('已复制')
        }).catch((err)=>{
            console.log(err)
        })
    })
}