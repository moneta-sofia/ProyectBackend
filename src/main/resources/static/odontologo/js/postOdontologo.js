window.addEventListener('load',function() {

    const formulario = document.querySelector('#add_new_odontologo');
    
    formulario.addEventListener('submit', function (event) {

        event.preventDefault();
        
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,
        };

        console.log(formData);

        const url = '/odontologos';
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
                console.log(data);
                let succesAlert = /*html*/`<div class="alert-succes">
                    <strong>Odontologo agregado</strong></div>`
    
                document.querySelector('#response').innerHTML = succesAlert;
                document.querySelector('#response').style.display = "block";
                document.querySelector('#btn-add-new-odontologo').style.display = "none";
                resetUploadForm();
            })
            .catch(error =>{
                console.log(error);
                let succesAlert = /*html*/`<div class="alert-dismissible">
                <strong> Error, intente mas tarde </strong></div>`
    
                document.querySelector('#response').innerHTML = succesAlert;
                document.querySelector('#response').style.display = "block";
                document.querySelector('#btn-add-new-odontologo').style.display = "none";
                resetUploadForm();
            });


            setTimeout(() => {
                document.querySelector('#response').style.display = "none";
                document.querySelector('#btn-add-new-odontologo').style.display = "block";
            }, 5000)
        })
    
        function resetUploadForm() {
            document.querySelector('#nombre').value = "";
            document.querySelector('#apellido').value = "";
            document.querySelector('#matricula').value = "";
        }

        (function(){
            let pathname = window.location.pathname;
            if(pathname === "/"){
                document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/odontologoList.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })();   
})

