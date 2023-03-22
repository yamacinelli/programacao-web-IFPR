
window.addEventListener("load", obtainDate);

function changeTheme() {
    let theme = document.body.classList[0];
    if (theme === "white-theme") {
        darkMode();
    } else {
        whiteMode();
    }
}

function whiteMode() {
    document.body.classList = "white-theme";

    document.getElementById("img-contrast").src = "/main/assets/icon/moon-outline.svg"; //icon-mode
    document.getElementById("img-contrast").classList.remove("invert-1"); //icon-mode

    document.styleSheets.item(0).cssRules.item(3).style.color = "#000000"; //container
    document.styleSheets.item(0).cssRules.item(11).style.backgroundColor = "#eeeeee"; //input[type=text]
    document.styleSheets.item(0).cssRules.item(11).style.color = "#000000"; //input[type=text]
    document.styleSheets.item(0).cssRules.item(14).style.color = "#000000"; //label-radio
    document.styleSheets.item(0).cssRules.item(29).style.backgroundColor = "#ffffff"; //modal-content
}

function darkMode() {
    document.body.classList = "dark-theme";

    document.getElementById("img-contrast").src = "/main/assets/icon/sunny-outline.svg"; //icon-mode
    document.getElementById("img-contrast").classList.add("invert-1"); //icon-mode

    document.styleSheets.item(0).cssRules.item(3).style.color = "#ffffff"; //container
    document.styleSheets.item(0).cssRules.item(11).style.backgroundColor = "#222222"; //input[type=text]
    document.styleSheets.item(0).cssRules.item(11).style.color = "#ffffff"; //input[type=text]
    document.styleSheets.item(0).cssRules.item(14).style.color = "#ffffff"; //label-radio
    document.styleSheets.item(0).cssRules.item(29).style.backgroundColor = "#222222"; //modal-content
}

function onlyNumbers(inputId) {
    document.getElementById(inputId).value = document.getElementById(inputId).value.replace(/[^\,0-9]*$/, "");
}

function currencyFormat() {
    const formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
        maximumFractionDigits: 2,
        useGrouping: true,
    });
    const value = document.getElementById("valor").value.replace(',', '.').replace(/^[\D\.]+/g, '');
    document.getElementById("valor").value = formatter.format(value);
}

function cpfCnpjFormat() {
    const value = document.getElementById("cpf_cnpj").value.replace(/\D/g, "");
    value.length > 11
        ? document.getElementById("cpf_cnpj").value = value.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, "$1.$2.$3/$4-$5")
        : document.getElementById("cpf_cnpj").value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
}

function obtainDate() {
    let date = new Date();
    date.setDate(1);
    let month = date.toLocaleString("pt-br", { month: "long" });
    document.getElementById("remuneracaoMensal").value = capitalize(month) + " " + date.getFullYear();
}

function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function radioSelected(radio) {
    radio.value === "PIX" && radio.checked ?
        document.styleSheets.item(0).cssRules.item(31).style.display = "block" :
        document.styleSheets.item(0).cssRules.item(31).style.display = "none"; //row-chave
}

function openModal() {
    obtainValueForm();
    writeModal();
    document.getElementById("modal").style.display = "block";
}

window.onclick = function (event) {
    if (event.target === modal) document.getElementById("modal").style.display = "none";
}

function obtainValueForm() {
    valor = document.getElementById("valor").value;
    empregado = document.getElementById("empregado").value;
    aTituloDe = document.getElementById("aTituloDe").value;
    remuneracaoMensal = document.getElementById("remuneracaoMensal").value;
    empregador = document.getElementById("empregador").value;
    cpfCnpj = document.getElementById("cpf_cnpj").value;
    cidade = document.getElementById("cidade").value;
    data = new Date(document.getElementById("data").value);
    chave = document.getElementById("chave").value;
}

function writeModal() {
    document.getElementById("valorWrite").textContent = valor;
    document.getElementById("empregadoWrite").textContent = empregado.toUpperCase();
    document.getElementById("aTituloDeWrite").textContent = aTituloDe.toUpperCase();
    document.getElementById("remuneracaoMensalWrite").textContent = remuneracaoMensal.toUpperCase();
    document.getElementById("empregadorWrite").textContent = empregador.toUpperCase();
    document.getElementById("cpf_cnpjWrite").textContent = cpfCnpj.length > 14 ? "CNPJ: " + cpfCnpj : "CPF: " + cpfCnpj;
    document.getElementById("cidadeWrite").textContent = cidade;
    document.getElementById("dataWrite").textContent = data.getDate() + " de " + capitalize(data.toLocaleString("pt-br", { month: "long" })) + " de " + data.getFullYear();
    // document.getElementById("chaveWrite").textContent = chave;
    document.getElementById("assinaturaWrite").textContent = empregado;
}