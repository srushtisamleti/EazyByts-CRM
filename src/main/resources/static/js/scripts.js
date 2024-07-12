/*document.addEventListener('DOMContentLoaded', (event) => {
    // Function to fetch and display contacts
    function fetchContacts() {
        fetch('/api/contacts')
            .then(response => response.json())
            .then(data => {
                const tableBody = document.getElementById('contacts-table-body');
                tableBody.innerHTML = ''; // Clear existing data

                data.forEach(contact => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${contact.id}</td>
                        <td>${contact.firstName}</td>
                        <td>${contact.lastName}</td>
                        <td>${contact.email}</td>
                        <td>${contact.phone}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error fetching contacts:', error));
    }

    // Function to fetch and display sales
    function fetchSales() {
        fetch('/api/sales')
            .then(response => response.json())
            .then(data => {
                const tableBody = document.getElementById('sales-table-body');
                tableBody.innerHTML = ''; // Clear existing data

                data.forEach(sale => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${sale.id}</td>
                        <td>${sale.description}</td>
                        <td>${sale.stage}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error fetching sales:', error));
    }

    // Function to fetch and display tasks
    function fetchTasks() {
        fetch('/api/tasks')
            .then(response => response.json())
            .then(data => {
                const tableBody = document.getElementById('tasks-table-body');
                tableBody.innerHTML = ''; // Clear existing data

                data.forEach(task => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${task.id}</td>
                        <td>${task.description}</td>
                        <td>${new Date(task.dueDate).toLocaleDateString()}</td>
                        <td>${task.title}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error fetching tasks:', error));
    }

    // Function to fetch and display support tickets
    function fetchSupportTickets() {
        fetch('/api/support-tickets')
            .then(response => response.json())
            .then(data => {
                const tableBody = document.getElementById('support-tickets-table-body');
                tableBody.innerHTML = ''; // Clear existing data

                data.forEach(ticket => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${ticket.id}</td>
                        <td>${ticket.issue}</td>
                        <td>${ticket.status}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error fetching support tickets:', error));
    }

    // Fetch data when the page loads
    if (document.getElementById('contacts-table-body')) {
        fetchContacts();
    }
    if (document.getElementById('sales-table-body')) {
        fetchSales();
    }
    if (document.getElementById('tasks-table-body')) {
        fetchTasks();
    }
    if (document.getElementById('support-tickets-table-body')) {
        fetchSupportTickets();
    }
});
*/


// Function to open Contact Form modal
function openContactForm() {
    $('#contact-form').modal('show');
}

// Function to handle form submission
document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();
    // Extract form data
    const name = document.getElementById('contactName').value;
    const email = document.getElementById('contactEmail').value;
    const phone = document.getElementById('contactPhone').value;
    const address = document.getElementById('contactAddress').value;
    
    // Typically send this data to your server here
    console.log('Contact saved:', { name, email, phone, address });

    // Close the form and reset fields
    $('#contact-form').modal('hide');
    document.getElementById('contactForm').reset();
});
