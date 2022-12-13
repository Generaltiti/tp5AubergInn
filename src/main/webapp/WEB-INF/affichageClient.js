async function afficherClient(){
    var chambre = document.getElementById("idChambre").value
    document.getElementById("clientTable").innerHTML = ""
    var res = await fetch('/afficherClient')
    console.log(res)
    document.getElementById("clientTable").innerHTML = res.body
}