$(document).ready(() =>{
    let idOfOrderToEdit;

    $('#finish-button-modal').click(() =>{
        const username = $('#modal-name').val();
        const phone = $('#modal-phone').val();
        const mail = $('#modal-mail').val();
        const products = $('#modal-products').val();

        const newOrder = {
            username: username,
            phone: phone,
            mail: mail
            products: products
        };

        addOrder(newOrder);
    });

    function addOrder(newOrder){
        fetch('orders', {
            method: 'POST',
            body: JSON.stringify(newOrder),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if(response.ok){
                location.reload();
            }else {
                alert("You have errors!" + response.status);
            }
        });
    }

    $('#continue-order-button').click(function(){
        $('modal-name').val('');
        $('modal-phone').val('');
        $('modal-mail').val('');
        $('modal-products').val('');
    })
})