$(document).ready(() =>{
    let idOfOrderUIToEdit;

    $('#finish-button-modal').click(() =>{
        const username = $('#modal-name').val();
        const phone = $('#modal-phone').val();
        const mail = $('#modal-mail').val();
        const products = $('#modal-products').val();

        const newOrderUI = {
            username: username,
            phone: phone,
            mail: mail,
            products: products
        };

        addOrderUI(newOrderUI);
    });

    function addOrderUI(newOrderUI){
        fetch('ordersUI', {
            method: 'POST',
            body: JSON.stringify(newOrderUI),
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