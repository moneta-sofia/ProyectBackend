window.addEventListener('load', function () {
    const formulario = this.document.querySelector('#update_paciente_form')
    formulario.addEventListener('submit', function (event){


        // let odontologoID = document.querySelector('#paciente_id').value;
        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email: document.querySelector('#email').value,
            domicilio: {
                id: document.querySelector('#domicilio').value,
                calle: calle,
                numero: numero,
                localidad:localidad,
                provincia: provincia
            }
        }

        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers:{
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(formData)
        }

        fetch(url,settings)
        .then(response => response.json())
    })
})


var calle = null;
var numero = null;
var localidad= null;
var provincia = null;

function findBy(id){
    const url = '/pacientes/' + id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data =>{
        let paciente = data;

        document.querySelector('#paciente_id').value =paciente.id;
        document.querySelector('#nombre').value=paciente.nombre;
        document.querySelector('#apellido').value=paciente.apellido;
        document.querySelector('#dni').value=paciente.dni;
        document.querySelector('#email').value=paciente.email;
        document.querySelector('#domicilio').value=paciente.domicilio.id;

        calle = paciente.domicilio.calle;
        numero = paciente.domicilio.numero;
        localidad = paciente.domicilio.localidad;
        provincia = paciente.domicilio.provincia;

        const modalContainer = document.querySelector("#modalContainerUpdate");
        modalContainer.style.opacity = '1';
        modalContainer.style.pointerEvents = 'auto';
    }).catch(error => {
        alert('error ' + error)
    })



}

