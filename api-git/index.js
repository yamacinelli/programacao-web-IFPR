//Globals variables
let urlComplete = null;
let ownerRepo = "";
let nameRepo = "";
let startDate = new Date();
let endDate = new Date();
let mapCommitsPreSave = {};

//Api Git path
const apiGit = "https://api.github.com/repos"

// Api REST
const apiRest = "http://localhost:8080";

function searchCommits() {
    //Hide error messages
    document.getElementById("errorCommit").style.display = "none";
    document.getElementById("errorFork").style.display = "none"
    document.getElementById("buttonSave").style.display = "none"

    this.obtainValuesInput();
    this.callApiForks();
    this.callApiCommits();
}

//Obtain all values from form
function obtainValuesInput() {
    urlComplete = document.getElementById("urlComplete").value;

    if (urlComplete) {
        const cleanUrl = urlComplete.replace("https://github.com/", '');
        const indexBarLine = cleanUrl.indexOf('/');

        ownerRepo = cleanUrl.substring(0, indexBarLine);
        nameRepo = cleanUrl.substring((indexBarLine + 1), cleanUrl.length);
    } else {
        ownerRepo = document.getElementById("ownerRepo").value;
        nameRepo = document.getElementById("nameRepo").value;

        urlComplete = `https://github.com/${ownerRepo}/${nameRepo}`
    }

    startDate = document.getElementById("startDate").value;
    endDate = document.getElementById("endDate").value;
}

//Call Api Git to obtain JSON with information of commits
function callApiCommits() {
    let url = `${apiGit}/${ownerRepo}/${nameRepo}/commits`;

    if (startDate && endDate) url = `${url}?since=${startDate}&until=${endDate}`;

    fetch(url)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            if (json) {
                this.buildMapDataCommits(json);
                document.getElementById("buttonSave").style.display = "flex";
            } else {
                document.getElementById("errorCommit").style.display = "flex";
            }
        });
}

function buildMapDataCommits(json) {
    const commitsPerDay = {};

    json.forEach(element => {
        const dateCommit = element.commit.author.date.substring(0, 10);
        const messageCommit = {message: element.commit.message};

        // Build commitsPerDay
        if (commitsPerDay[dateCommit]) {
            commitsPerDay[dateCommit].message.push(messageCommit);
            commitsPerDay[dateCommit].count++;
        } else {
            commitsPerDay[dateCommit] = {count: 1, date: dateCommit, message: [messageCommit]};
        }
    });

    if (commitsPerDay) {
        this.buildTableDataCommits(commitsPerDay);
        this.buildMapCommitsPreSave(commitsPerDay);
    }
}

//Call Api Git to obtain information about forks and starring
function callApiForks() {
    let url = `${apiGit}/${ownerRepo}/${nameRepo}/forks`;

    fetch(url)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            if (json.length > 0) {
                this.buildMapDataForks(json);
            } else {
                document.getElementById("errorFork").style.display = "flex";
            }
        });
}

function buildMapDataForks(json) {
    let forkMap = {};
    json.forEach(element => {
        forkMap = {forks_count: element.forks_count, stargazers_count: element.stargazers_count};
    });

    if (forkMap) this.buildTableDataForks(forkMap);
}

function buildObjectCommits(map) {
    return Object.keys(map).map(indexDate => {
        return {count: map[indexDate].count, date: indexDate, message: map[indexDate].message}
    });
}

function buildTableDataForks(map) {
    const table = document.createElement("table");
    const thead = document.createElement("thead");
    const th_fork = document.createElement("th");
    const th_star = document.createElement("th");
    const tbody = document.createElement("tbody");

    table.appendChild(thead);
    thead.appendChild(th_fork).innerText = 'Forks Count'
    thead.appendChild(th_star).innerText = 'Stars Count'
    table.appendChild(tbody);

    let trow = tbody.insertRow();

    const tdata_fork = trow.insertCell();
    tdata_fork.innerText = map.forks_count;

    const tdata_star = trow.insertCell();
    tdata_star.innerText = map.stargazers_count;

    //Clean content before append
    document.getElementById("table-forks").innerHTML = '';

    document.getElementById("table-forks").appendChild(table);
}

function buildTableDataCommits(map) {
    const table = document.createElement("table");
    const thead = document.createElement("thead");
    const th_date = document.createElement("th");
    const th_message = document.createElement("th");
    const th_count = document.createElement("th");
    const tbody = document.createElement("tbody");

    table.appendChild(thead);
    thead.appendChild(th_date).innerText = 'Date'
    thead.appendChild(th_message).innerText = 'Message'
    thead.appendChild(th_count).innerText = 'Count'
    table.appendChild(tbody);

    this.buildObjectCommits(map).forEach(element => {
        let trow = tbody.insertRow();

        //Column DATE
        const tdata_date = trow.insertCell();
        tdata_date.innerText = this.formatDate(element.date);

        //Column MESSAGE
        const tdata_message = trow.insertCell();
        element.message.forEach(elementMessage => {
            const listItem = document.createElement("li");
            tdata_message.appendChild(listItem);
            listItem.innerText = elementMessage.message;
        });

        //Column COUNT
        const tdata_count = trow.insertCell();
        tdata_count.innerText = element.count;
    });

    //Clean content before append
    document.getElementById("table-commits").innerHTML = '';

    document.getElementById("table-commits").appendChild(table);
}

//Format date to default pt-BR
function formatDate(date) {
    const dateFormat = new Date(date);
    const options = {
        day: "numeric", month: "numeric", year: "numeric"
    };

    return dateFormat.toLocaleDateString("pt-BR", options);
}

function buildMapCommitsPreSave(map) {
    let commitsPreSave = null;

    this.buildObjectCommits(map).forEach(element => {

        // Build commitsPreSave
        if (!commitsPreSave) {
            commitsPreSave = { repositoryOwner: ownerRepo, repositoryName: nameRepo, repositoryLink: urlComplete, message: `${this.formatDate(element.date)} there were ${element.count} commits`, count: element.count };
        } else {
            commitsPreSave.count += element.count;
            commitsPreSave.message = `${commitsPreSave.message} - ${this.formatDate(element.date)} there were ${element.count} commits`;
        }
    });

    mapCommitsPreSave = commitsPreSave;
}

// Save commits in Api Rest
function saveCommits() {
    const url = `${apiRest}/commit`;
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(this.buildObjectCommitsPreSave(mapCommitsPreSave)),
    }

    fetch(url, options)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            console.log(json);
        });
}

function buildObjectCommitsPreSave(map) {
    let mapToReturn = { repositoryOwner: '', repositoryName: '', repositoryLink: '', message: '', count: 0 };

    Object.keys(map).map(element => {
        mapToReturn[element] = map[element];
    });

    return mapToReturn;
}

function goToPageCommitSaves() {
    window.location.replace("./commit-saves/commit-saves.html");
}
