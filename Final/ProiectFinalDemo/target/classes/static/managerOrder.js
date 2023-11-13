$(document).ready(() => {
    let idOfOrderUIToEdit;

    $('.delete-icon').click(function () {
         const orderUIId = this.parentElement.id;
         fetch('ordersUI/' + orderUIId, {
            method: 'DELETE'
         }).then(response => location.reload());
    });
})