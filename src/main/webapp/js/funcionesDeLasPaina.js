function cerrarSesion(){
    $.post('ControladorUsuario', {
        envio : "verificar;,;invalidate"
    });
    location.replace("login.html");
}
function desabilitar (){
    var elemnt = document.getElementsByName("atributosLibro");
    $(elemnt).attr('disabled', true);
    $("#campoAutor").attr('disabled', true);
    $('#modificar').attr('disabled', true);
    $("#Cancelar").click(function (){
        $('#busca').attr('disabled', false);
        $('#modificar').attr('disabled', true);
        $(elemnt).val("");
        $("#campoAutor").val("");
        $(this).hide();
        $('#Busqueda').show();
        $(elemnt).attr('disabled', true);
        $("#campoAutor").attr('disabled', true);
        var padre = document.getElementById("padre").innerHTML = "";
    }); 
     
    
}

