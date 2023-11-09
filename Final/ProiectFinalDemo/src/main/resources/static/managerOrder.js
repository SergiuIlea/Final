$(document).ready(() => {
    let idOfOrderToEdit;

    $('.delete-icon').click(function () {
         const orderId = this.parentElement.id;
         fetch('orders/' + orderId, {
            method: 'DELETE'
         }).then(response => location.reload());
    });
})