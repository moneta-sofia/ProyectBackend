window.addEventListener('load', function () {
    const formulario = this.document.querySelector('#update_domicilio_form')
    formulario.addEventListener('submit', function (event){

        event.preventDefault();
        const formData = {
            id: document.querySelector('#idDomicilio').value,
            calle: document.querySelector('#calle').value,
            numero:document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
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



function getDomicilio(id){
    const url = '/domicilios/' + id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data =>{
        let domicilio = data;

        document.querySelector('#idDomicilio').value =domicilio.id;
        document.querySelector('#calle').value=domicilio.calle;
        document.querySelector('#numero').value=domicilio.numero;
        document.querySelector('#localidad').value=domicilio.localidad;
        document.querySelector('#provincia').value=domicilio.provincia;


        const modalContainer = document.querySelector("#modalContainerDomicilio");
        modalContainer.style.opacity = '1';
        modalContainer.style.pointerEvents = 'auto';
    }).catch(error => {
        alert('error ' + error);
    })
}

function editable() {
    const botonEditar = document.querySelector('#botonEditar');
    botonEditar.style.display = 'none';

    console.log('editable');

    const inputs = document.querySelectorAll('.inputModificar');
    inputs.forEach(function (input){
        input.removeAttribute('readonly');
    })
}
