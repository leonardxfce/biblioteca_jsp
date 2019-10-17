function main() {
    const botonLogin = jQuery("#login");
    botonLogin.on("click", comprobarCampos);
}

function comprobarCampos() {
    const inputUser = jQuery("#user");
    const inputConstrasena = jQuery("#pass");
    const valorDelInputUser = inputUser.val();
    const valorDelInputPass = inputConstrasena.val();

    if (valorDelInputPass == "" || valorDelInputPass == "") {
        alert("Hay campos que estan vacios");
    }
    else {
        enviarInformacionAlServidor(valorDelInputUser, valorDelInputPass);
    }
}

function enviarInformacionAlServidor(user, pass) {
    const valoresAEnviar = {
        "usuario": user,
        "password": pass
    }
    jQuery.post("http://localhost:8080/login", valoresAEnviar).done(cuandoTerminaElServidor);
}


function cuandoTerminaElServidor(datosDelServidor) {
    alert(datosDelServidor);
}

const pagina = jQuery(document)
pagina.ready(main);