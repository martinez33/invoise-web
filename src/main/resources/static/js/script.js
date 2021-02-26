
fetch('../invoice') //fait un GET sur  l'url "/invoice"
    .then(res => res.json()) //recupère le resultat et peu le manipuler comme du JSON
    .then(res => {
        var invoiceListNode = document.getElementById('invoice-list');//recup le noeud "invoice-list"
        invoiceListNode.innerHTML = "";

        var table = document.createElement("table"); // crée une table
        table.setAttribute("border","1"); //affecte un attribut ""
        invoiceListNode.appendChild(table); //ajoute un table à la fin de la liste des enfants

//Pour chaque facture qui se trouve dans le tableau JSON on crée 1 td et 3 tr
        res.forEach(invoice => {

            var tr = document.createElement("tr");//crée un tr
            table.appendChild(tr);//ajoute un tr à la fin de la liste des enfants

            var td = document.createElement("td");
            var text = document.createTextNode(`${invoice.number}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${invoice.customer.name}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            //Bouton clicable pour avoir le détails de la facture
            var button = document.createElement("button");
            button.setAttribute("type","button");
            button.onclick = function() {
                showDetail(`${invoice.number}`); //Appel la methode en dessous
            };
            text = document.createTextNode("Details");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);


        });

    });


function showDetail(invoiceNumber){
    fetch(invoiceNumber) //fait un fetch sur le service ReST
    .then(res => res.json())
    .then(res => { //le service retourne une facture en particulier grace au numéro
        var invoiceDetailNode = document.getElementById('invoice-detail');
        invoiceDetailNode.innerHTML = "";

        var p = document.createElement("p");
        var text = document.createTextNode(`Number: ${res.number}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        console.log(res);
        text = document.createTextNode(`Customer name: ${res.customer.name}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Order number: ${res.orderNumber}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

    });
}
