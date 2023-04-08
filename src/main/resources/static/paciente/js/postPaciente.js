window.addEventListener('load',function() {

    const formulario = document.querySelector('#add_new_paciente');
    
    formulario.addEventListener('submit', function (event) {

        event.preventDefault();
        
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email: document.querySelector('#email').value,
            domicilio: {
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value
            }
        };


        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers:{
                'Content-Type' : 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url,settings)
            .then(response => response.json())
            .then(data =>{
                let succesAlert = /*html*/`<div class="alert-succes">
                    <strong>Paciente agregado</strong></div>`
    
                document.querySelector('#response').innerHTML = succesAlert;
                document.querySelector('#response').style.display = "block";
                document.querySelector('#btn-add-new-paciente').style.display = "none";
                resetUploadForm();
            })
            .catch(error =>{
                console.log(error);
                let succesAlert = /*html*/`<div class="alert-dismissible">
                <strong> Error, intente mas tarde </strong></div>`
    
                document.querySelector('#response').innerHTML = succesAlert;
                document.querySelector('#response').style.display = "block";
                document.querySelector('#btn-add-new-paciente').style.display = "none";
                resetUploadForm();
            });


            setTimeout(() => {
                document.querySelector('#response').style.display = "none";
                document.querySelector('#btn-add-new-paciente').style.display = "block";
            }, 5000)
        })
    
        function resetUploadForm() {
            document.querySelector('#nombre').value ='',
            document.querySelector('#apellido').value ='',
            document.querySelector('#dni').value ='',
            document.querySelector('#email').value ='',

            document.querySelector('#calle').value = "",
            document.querySelector('#numero').value= "",
            document.querySelector('#localidad').value= "",
            document.querySelector('#provincia').value= ""
        }

        (function(){
            let pathname = window.location.pathname;
            if(pathname === "/"){
                document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/pacienteList.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })();   
})

