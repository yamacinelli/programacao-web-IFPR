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
    this.callApi();
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
function callApi() {
    let url = `${apiGit}/${this.ownerRepo}/${this.nameRepo}/commits`;

    if (this.startDate && this.endDate) url = `${url}?since=${this.startDate}&until=${this.endDate}`;

    fetch(url)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            if (json) this.buildMapData(json);
        });
}

function buildMapData(json) {
    const commitsPerDay = {};
    json.forEach(element => {
        const dateCommit = element.commit.author.date.substring(0, 10);
        const messageCommit = element.commit.message;

        if (commitsPerDay[dateCommit]) {
            commitsPerDay[dateCommit].count++;
        } else  {
            commitsPerDay[dateCommit] = { count: 1, date: dateCommit, message: messageCommit };
        }
    });

    if (commitsPerDay) this.buildTableData(commitsPerDay);
}

function buildObject(map) {
    return Object.keys(map).map(indexDate => {
        return {count: map[indexDate].count, date: indexDate, message: map[indexDate].message}
    });
}

function buildTableData(map) {
    let tbody = document.getElementById("tbody");

    this.buildObject(map).forEach(element => {
       let trow = tbody.insertRow();

       const tdata_date = trow.insertCell();
       tdata_date.innerText = element.date;

       const tdata_message = trow.insertCell();
       tdata_message.innerText = element.message;

       const tdata_count = trow.insertCell();
       tdata_count.innerText = element.count;
    });
}
