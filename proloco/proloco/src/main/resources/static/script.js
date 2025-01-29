document.getElementById('dataForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const anagrafica = {
        nome: document.getElementById('nome').value,
        cognome: document.getElementById('cognome').value,
        codiceFiscale: document.getElementById('codiceFiscale').value,
        dataNascita: document.getElementById('dataNascita').value,
        indirizzo: document.getElementById('indirizzo').value,
        numeroCivico: document.getElementById('numeroCivico').value
    };

    const user = {
        anagrafica: anagrafica,
        email: document.getElementById('email').value,
        numeroCellulare: document.getElementById('numeroCellulare').value
    }

    fetch('/addListToDB', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(user => {
        console.log('Success:', user);
        alert('Dati inviati con successo!');
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Si è verificato un errore durante l\'invio dei dati.');
    });
});