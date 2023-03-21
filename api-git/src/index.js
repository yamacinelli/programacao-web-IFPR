//Globals variables
let urlComplete = null;
let ownerRepo = "";
let nameRepo = "";
let startDate = new Date();
let endDate = new Date();

//Api Git path
const apiGit = "https://api.github.com/repos"

function searchCommits() {
    this.obtainValuesInput();
    this.callApiForks();
    this.callApiCommits();
}

//Obtain all values from form
function obtainValuesInput() {
    this.urlComplete = document.getElementById("urlComplete").value;

    if (this.urlComplete) {
        const cleanUrl = this.urlComplete.replace("https://github.com/", '');
        const indexBarLine = cleanUrl.indexOf('/');

        this.ownerRepo = cleanUrl.substring(0, indexBarLine);
        this.nameRepo = cleanUrl.substring((indexBarLine + 1), cleanUrl.length);
    } else {
        this.ownerRepo = document.getElementById("ownerRepo").value;
        this.nameRepo = document.getElementById("nameRepo").value;
    }

    this.startDate = document.getElementById("startDate").value;
    this.endDate = document.getElementById("endDate").value;
}

//Call Api Git to obtain JSON with information of commits
function callApiCommits() {
    let url = `${apiGit}/${this.ownerRepo}/${this.nameRepo}/commits`;

    if (this.startDate && this.endDate) url = `${url}?since=${this.startDate}&until=${this.endDate}`;

    fetch(url)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            if (json) this.buildMapDataCommits(json);
        });
}

function buildMapDataCommits(json) {
    const commitsPerDay = {};

    json.forEach(element => {
        const dateCommit = element.commit.author.date.substring(0, 10);
        const messageCommit = { message: element.commit.message };

        if (commitsPerDay[dateCommit]) {
            commitsPerDay[dateCommit].message.push(messageCommit);
            commitsPerDay[dateCommit].count++;
        } else {
            commitsPerDay[dateCommit] = {count: 1, date: dateCommit, message: [ messageCommit ]};
        }
    });

    if (commitsPerDay) this.buildTableDataCommits(commitsPerDay);
}

//Call Api Git to obtain information about forks and starring
function callApiForks() {
    let url = `${apiGit}/${this.ownerRepo}/${this.nameRepo}/forks`;

    fetch(url)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            if (json.size) this.buildMapDataForks(json);
        });
}

function buildMapDataForks(json) {
    let forkMap = {};
    json.forEach(element => {
       forkMap = { forks_count: element.forks_count, stargazers_count: element.stargazers_count };
    });

    if (forkMap.size) this.buildTableDataForks(forkMap);
}

function buildObjectForks(map) {
    return Object.keys(map).map(() => {
        return {forks_count: map.forks_count, stargazers_count: map.stargazers_count}
    });
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

    this.buildObjectForks(map).forEach(element => {
        let trow = tbody.insertRow();

        const tdata_fork = trow.insertCell();
        tdata_fork.innerText = element.forks_count;

        const tdata_star = trow.insertCell();
        tdata_star.innerText = element.stargazers_count;
    });

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

        const tdata_date = trow.insertCell();
        tdata_date.innerText = element.date;

        const tdata_message = trow.insertCell();
        tdata_message.innerText = element.message;

        const tdata_count = trow.insertCell();
        tdata_count.innerText = element.count;
    });

    //Clean content before append
    document.getElementById("table-commits").innerHTML = '';

    document.getElementById("table-commits").appendChild(table);
}
