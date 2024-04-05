function validateRegistrationForm() {
    var name = document.getElementById('name').value;
    var age = document.getElementById('age').value;
    var gender = document.getElementById('gender').value;

    if (name.trim() === '' || age.trim() === '' || gender.trim() === '') {
        alert('Please fill in all fields.');
        return false;
    }

    if (isNaN(age)) {
        alert('Age must be a number.');
        return false;
    }


    return true;
}

function scheduleAppointment() {
    var selectedDate = document.getElementById('appointment-date').value;
    var selectedTime = document.getElementById('appointment-time').value;
    var doctor = document.getElementById('doctor').value;
    var patientId = document.getElementById('patient-id').value;

    if (selectedDate.trim() === '' || selectedTime.trim() === '' || doctor.trim() === '' || patientId.trim() === '') {
        alert('Please fill in all fields.');
        return;
    }


    var appointmentData = {
        date: selectedDate,
        time: selectedTime,
        doctorId: doctor,
        patientId: patientId
    };

    fetch('/api/appointments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(appointmentData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to schedule appointment.');
        }
        alert('Appointment scheduled successfully!');
    })
    .catch(error => {
        console.error('Error scheduling appointment:', error);
        alert('Failed to schedule appointment. Please try again.');
    });
}

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    if (validateRegistrationForm()) {
        this.submit();
    }
});

document.getElementById('appointment-form').addEventListener('submit', function(event) {
    event.preventDefault();

    scheduleAppointment();
});
