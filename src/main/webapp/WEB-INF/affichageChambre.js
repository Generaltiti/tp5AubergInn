async function afficherChambre(){
    var chambre = document.getElementById("idChambre").value
    document.getElementById("chambreTable").innerHTML = ""
    var res = await fetch('/afficherChambre')
    console.log(res)
}