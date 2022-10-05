function post(url, usuario){
    $.ajax({
        url: url,
        contentType: 'application/json',
        cache: false,
        method: 'POST',
        dataType: 'json',
        data: JSON.stringify(usuario)
    })
}

function cadastra(){
    event.preventDefault();
    let url = "http://localhost:8000/conta/cadastrar";
    let nome = document.getElementById("nome");
    let sobrenome = document.getElementById("sobrenome");
    let email = document.getElementById("email");
    let senha = document.getElementById("senha");
    let confirmar = document.getElementById("confirmar");
    
    if(nome.value.length == 0 || sobrenome.value.length == 0 || email.value.length == 0 || senha.value.length == 0 || confirmar.value.length == 0){
        window.alert("É necessario preencher todos os campos para concluir o cadastro.");
    }else if(senha.value !== confirmar.value){
        window.alert("O campo senha e o confirmar precisam ser identicos.");
    }else{
        let usuario = {
            "name": nome.value,
            "lastName": sobrenome.value,
            "email": email.value,
            "psw": senha.value
        }
    
        post(url, usuario);

        window.alert("Conta dadastrada.")

        nome.value = "";
        sobrenome.value = "";
        email.value = "";
        senha.value = "";
        confirmar.value = "";
    }
}