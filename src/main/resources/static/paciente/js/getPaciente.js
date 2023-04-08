window.addEventListener('load', function () {
    (function(){
        const url = '/pacientes/list';
        const settings ={
            method: 'GET'
        }
        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            for(paciente of data){
                console.log(paciente);
                var table = document.getElementById('pacienteDatos');
                var pacienteRow =  table.insertRow();
                let tr_id = 'tr_' + paciente.id;
                pacienteRow.id =tr_id;
                let deleteButton = '<button' +
                                            ' id= ' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                            ' type ="button" onclick="deleteBy('+ paciente.id +')" class="btn_delete">'+ '&times' + '</button>';

                let domicilioButton = '<button' +
                                            ' id= ' + '\"' + 'btn_id_domicilio_' + paciente.domicilio.id + '\"' +
                                            ' type ="button" onclick="getDomicilio('+ paciente.domicilio.id +')" class="btn_id_domicilio">'+ paciente.domicilio.id + '</button>';

                let updateButton = '<button' +
                                            ' id= ' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                            ' type ="button" onclick="findBy('+ paciente.id +')" class="btn_id">'+ paciente.id + '</button>';

                                            
                pacienteRow.innerHTML =
                                        '<td class="tdBoton">' + updateButton + '</td>' +
                                        '<td>' + paciente.nombre.toUpperCase() + '</td>' +
                                        '<td>' + paciente.apellido.toUpperCase() + '</td>' +
                                        '<td>' + paciente.dni.toUpperCase() + '</td>'+
                                        '<td>' + paciente.email.toUpperCase() + '</td>'+
                                        '<td class="domicilioButton">' + domicilioButton + '</td>'+
                                        '<td class="tdDelete">' + deleteButton + '</td> ';
            };
        })
    })

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/odontologoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })

})