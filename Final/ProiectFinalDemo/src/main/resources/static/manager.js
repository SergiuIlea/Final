$(document).ready(() => {
    let idOfProductToEdit;

    $('#add-product-modal').click(function(){
        $('#modal-name').val('');
        $('#modal-weight').val('');
        $('#modal-dimensions').val('');
        $('#modal-colour').val('');
        $('#modal-price').val('');
    })

    $('#add-button-modal').click(() =>{
        const name = $('#modal-name').val();
        const weight = $('#modal-weight').val();
        const dimensions = $('#modal-dimensions').val();
        const colour = $('#modal-colour').val();
        const price = $('#modal-price').val();

        const newProduct = {
            name: name,
            weight: weight,
            dimensions: dimensions,
            colour: colour,
            price: price
        };
        if(idOfProductToEdit==null){
            addProduct(newProduct);
        }else{
            editProduct(idOfProductToEdit, newProduct);
        }
    });

    $('.edit-icon').click(function () {
         idOfProductToEdit = this.parentElement.id;
         const row = this.parentElement.parentElement;
         const name = row.children[0].innerText;
         const weight = row.children[1].innerText;
         const dimensions = row.children[2].innerText;
         const colour = row.children[3].innerText;
         const price = row.children[4].innerText;l
         $('#modal-name').val(name);
         $('#modal-weight').val(weight);
         $('#modal-dimensions').val(dimensions);
         $('#modal-colour').val(colour);
         $('#modal-price').val(price);
    });

    $('.delete-icon').click(function () {
         const productId = this.parentElement.id;
         fetch('products/' + productId, {
            method: 'DELETE'
         }).then(response => location.reload());
    });


    function addProduct(newProduct){
        fetch('products', {
            method: 'POST',
            body: JSON.stringify(newProduct),
            headers:{
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if(response.ok){
                location.reload();
            }
            else{
                alert("You have errors!" + response.status);
            }
        });
    };

    function editProduct(idOfProductToEdit, newProduct){
        fetch('products/' + idOfProductToEdit, {
            method: 'PUT',
            body: JSON.stringify(newProduct),
            headers:{
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if(response.ok){
                location.reload();
            }
            else{
                alert("You have errors!" + response.status);
            }
        });
    };
})