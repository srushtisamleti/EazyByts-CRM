document.addEventListener('DOMContentLoaded', function() {
    fetch('/api/contacts')
        .then(response => response.json())
        .then(data => {
            const app = document.getElementById('app');
            data.forEach(contact => {
                const contactCard = document.createElement('div');
                contactCard.className = 'contact-card';
                contactCard.innerHTML = `
                    <h2>${contact.firstName} ${contact.lastName}</h2>
                    <p>Email: ${contact.email}</p>
                    <p>Phone: ${contact.phone}</p>
                `;
                app.appendChild(contactCard);
            });
        });
});
