let btn = document.querySelector("#postShopperButton");

// function postmethod() {
//     //datanet
//
//     let formData = new FormData(document.querySelector("#postShopperForm"))
//     // var encData= new URLSearchParams(formData.entries());
//     let requestData = {
//         name: formData.get("listname"),
//         owner: formData.get("listowner")
//     }
//
//     // path notatie
//     fetch("/restservices/list/", {
//         method: "POST",
//         body: JSON.stringify(requestData),
//         headers: {"Content-type": "application/json"}
//     })
//
//         .then(response => response.json())
//         .then(data => console.log(data))
//         .catch(error => console.log(error))
//
//
//
// }

// window.addEventListener("load", function () { //In plaats van function kan ook () =>
//     document.querySelector("#postShopperButton").addEventListener("click", postmethod);
// });

function addproduct() {
    let formData = new FormData(document.querySelector("#addproductForm"));
    let requestData = {
        listname: formData.get("listofproducts"),
        name: formData.get("productname"),
        amount: formData.get("amount")
    }

    fetch("restservices/product/", {
        method: "POST",
        body: JSON.stringify(requestData),
        headers: {"Content-type": "application/json"}
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.log(error))
}
window.addEventListener("load", function(){
    document.querySelector("#addproduct").addEventListener("click", addproduct);
})
//d
function addshopper(){
    let formData= new FormData(document.querySelector("#addshopper"));
    let requestData={
        name: formData.get("shopper")
    }

    fetch("restservices/shopper/", {
        method: "POST",
        body: JSON.stringify(requestData),
        headers: {"Content-type": "application/json"}
    })
        .then(response => response.json())
        .then(data=> console.log(data))
        .catch(error => console.log(error))
}

window.addEventListener("load", function(){
    document.querySelector("#shop").addEventListener("click", addshopper)
});
// heier onder
// function addNieuweLeden(){
//     let formData= new FormData(document.querySelector("#addNieuweLeden"));
//     let requestData={
//         name: formData.get("")
//     }
//
//     fetch("restservices/alleUsers/", {
//         method: "POST",
//         body: JSON.stringify(requestData),
//         headers: {"Content-type": "application/json"}
//     })
//         .then(response => response.json())
//         .then(data=> console.log(data))
//         .catch(error => console.log(error))
// }
//
// window.addEventListener("load", function(){
//     document.querySelector("#user").addEventListener("click", addNieuweLeden)
// });
function addNieuweLeden() {

    let formData= new FormData(document.querySelector("#addNieuweLeden"));
    let requestData={
        name: formData.get("userNaam"),
        pass: formData.get("userWachtwoord"),
        roll: formData.get("userroll")
    }

    fetch("restservices/alleUsers", {
        method: "POST",
        body: JSON.stringify(requestData),
        headers: {"Content-type": "application/json"}
    })
        .then(response => response.json())
        .then(data=> console.log(data))
        .catch(error => console.log(error))
}
window.addEventListener("load", function(){
    document.querySelector("#user").addEventListener("click", addNieuweLeden)
});














function changename(){
    let formData = new FormData(document.querySelector("#patchProduct"))
    let requestData={
        oldname:formData.get("oldname"),
        newName:formData.get("newname")
    }

    fetch("/restservices/product/", {
        method: "PATCH",
        body: JSON.stringify(requestData),
        headers: {"Content-type": "application/json"}
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.log(error))
}


window.addEventListener("load", function(){
    document.querySelector("#patchproductname").addEventListener("click", changename);
});


document.querySelector("#deleteshopper").addEventListener("click", function () {
    let shoppername = document.querySelector("#deleteshoppername").value;

    fetch("restservices/shopper/"+shoppername, {method: 'DELETE'})
        .then(response => console.log(response));
});














































// let btn = document.querySelector("#postShopperButton");
//
// function postmethod() {
//     //opvangen data
//     let formData = new FormData(document.querySelector("#postShopperForm"))
//     // var encData= new URLSearchParams(formData.entries());
//     let requestData = {
//         name: formData.get("listname"),
//         owner: formData.get("listowner")
//     }
//
//     //jerseyconfigpath + ListResource + fetchOptions
//     fetch("/restservices/list/", {
//         method: "POST",
//         body: JSON.stringify(requestData),
//         headers: {"Content-type": "application/json"}
//     })
//         .then(response => response.json())
//         .then(data => console.log(data))
//         .catch(error => console.log(error))
// }
//
// window.addEventListener("load", function () { //In plaats van function kan ook () =>
//     document.querySelector("#postShopperButton").addEventListener("click", postmethod);
// });
//
// function addproduct() {
//     let formData = new FormData(document.querySelector("#addproductForm"));
//     let requestData = {
//         name: formData.get("productName"),
//         amount: formData.get("amount"),
//         listname: formData.get("listofproducts")
//     }
//
//     fetch("restservices/product/", {
//         method: "POST",
//         body: JSON.Stringify(requestData)
//         headers: {"Content-type": "application/json"}
//     })
//         .then(response => response.json())
//         .then(data => console.log(data))
//         .catch(error => console.log(error))
// }
//
//
//
//
// //
// //     fetch("/restservices" ,{
// //         method:"POST",
// //         body: encData
// //     })
// //     .then(response => console.log(response));
// //
// // });