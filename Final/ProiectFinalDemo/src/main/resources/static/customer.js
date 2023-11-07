$(document).ready(() =>{
    let idOfOrderToEdit;

    $('#finish-button-modal').click(() =>{
        const user = $('#modal-user').val();
        const phone = $('#modal-phone').val();
        const mail = $('#modal-mail').val();

        const newOrder = {
            user: user,
            phone: phone,
            mail: mail
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
        $('modal-user').val('');
        $('modal-phone').val('');
        $('modal-mail').val('');
    })
})