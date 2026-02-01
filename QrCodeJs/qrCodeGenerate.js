"UTF-8";

var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 200,
        height : 200
    });

    function makeCode () {		
        var link = document.getElementById("link");	
        var elStatus = document.getElementById("invalid-feedback");	
        if (!link.value) {		
            elStatus.innerHTML = "Preencha o campo acima";		
            link.focus();		
            return;		
        }		
        qrcode.makeCode(link.value);		
    }		

    makeCode();		

    document.getElementById("link")		
        .addEventListener("blur", function () {		
            makeCode();		
        });
