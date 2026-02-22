"UTF-8";

var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 200,
        height : 200
    });

    function makeCode () {		
        var link = document.getElementById("QrCodeCliente");	
        if (!link.value) {
            link.focus();		
            return;		
        }		
        qrcode.makeCode(link.value);		
    }		

    makeCode();		

    document.getElementById("QrCodeCliente")		
        .addEventListener("blur", function () {		
            makeCode();		
        });
