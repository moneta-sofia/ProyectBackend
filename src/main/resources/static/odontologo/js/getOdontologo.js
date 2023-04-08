// window.addEventListener('load', function () {
    (function(){
        const url = '/odontologos/list';
        const settings ={
            method: 'GET'
        }
        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            for(odontologo of data){
                var table = document.getElementById('odontologoDatos');
                var odontologoRow =  table.insertRow();
                let tr_id = 'tr_' + odontologo.id;
                odontologoRow.id =tr_id;
                let deleteButton = '<button' +
                                            ' id= ' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                            ' type ="button" onclick="deleteBy('+ odontologo.id +')" class="btn_delete">'+ '&times' + '</button>';

                let updateButton = '<button' +
                                            ' id= ' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                            ' type ="button" onclick="findBy('+ odontologo.id +')" class="btn_id">'+ odontologo.id + '</button>';

                odontologoRow.innerHTML =
                                        '<td class="tdBoton">' + updateButton + '</td>' +
                                        '<td>' + odontologo.nombre.toUpperCase() + '</td>' +
                                        '<td>' + odontologo.apellido.toUpperCase() + '</td>' +
                                        '<td>' + odontologo.matricula.toUpperCase() + '</td>'+
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

// })