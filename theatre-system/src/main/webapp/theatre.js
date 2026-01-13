document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector("form");

    form.addEventListener("submit", function (event) {

        const theatreName = document.querySelector("input[name='theatreName']").value.trim();
        const location = document.querySelector("input[name='location']").value.trim();
        const city = document.querySelector("input[name='city']").value.trim();
        const totalScreens = document.querySelector("input[name='totalScreens']").value;
        const totalSeats = document.querySelector("input[name='totalSeats']").value;
        const ownerName = document.querySelector("input[name='ownerName']").value.trim();
        const ticketPrice = document.querySelector("input[name='ticketPrice']").value;
        const contactNumber = document.querySelector("input[name='contactNumber']").value.trim();

        if (theatreName === "") {
            alert("Theatre name is required");
            event.preventDefault();
            return;
        }

        if (location === "") {
            alert("Location is required");
            event.preventDefault();
            return;
        }

        if (city === "") {
            alert("City is required");
            event.preventDefault();
            return;
        }

        if (totalScreens <= 0) {
            alert("Total screens must be greater than 0");
            event.preventDefault();
            return;
        }

        if (totalSeats <= 0) {
            alert("Total seats must be greater than 0");
            event.preventDefault();
            return;
        }

        if (ownerName === "") {
            alert("Owner name is required");
            event.preventDefault();
            return;
        }

        if (ticketPrice <= 0) {
            alert("Ticket price must be greater than 0");
            event.preventDefault();
            return;
        }

        if (!/^\d{10}$/.test(contactNumber)) {
            alert("Contact number must be 10 digits");
            event.preventDefault();
            return;
        }

    });

});
