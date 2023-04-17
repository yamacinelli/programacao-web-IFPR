// Api REST
const apiRest = "http://localhost:8080";

// Endpoint
const endpointCommit = "/commit";

function getAllCommitsSaved() {
    fetch(`${apiRest}${endpointCommit}`)
        .then(response => {
            if (response.status === 200) return response.json();
        })
        .then(json => {
            if (json.length > 0) {
                this.buildTableDataCommitSaves(json);
            } else {
                document.getElementById("errorCommitsSaved").style.display = "flex";
            }
        });
}

function buildTableDataCommitSaves(json) {
    const table = document.createElement("table");
    const thead = document.createElement("thead");
    const th_id = document.createElement("th");
    const th_message = document.createElement("th");
    const th_repository_owner = document.createElement("th");
    const th_repository_name = document.createElement("th");
    const th_repository_link = document.createElement("th");
    const th_count = document.createElement("th");
    const tbody = document.createElement("tbody");

    table.appendChild(thead);
    thead.appendChild(th_id).innerText = 'ID';
    thead.appendChild(th_message).innerText = 'Message';
    thead.appendChild(th_repository_owner).innerText = 'Owner Repository';
    thead.appendChild(th_repository_name).innerText = 'Name Repository';
    thead.appendChild(th_repository_link).innerText = 'Link to Repository';
    thead.appendChild(th_count).innerText = 'Count';
    table.appendChild(tbody);

    this.buildObjectCommitsSaved(json).forEach(element => {
        let trow = tbody.insertRow();

        // Column ID
        const td_id = trow.insertCell();
        td_id.innerText = element.id

        // Column MESSAGE
        const td_message = trow.insertCell();
        td_message.innerText = element.message;

        // Column OWNER REPOSITORY
        const td_repository_owner = trow.insertCell();
        td_repository_owner.innerText = element.repositoryOwner;

        // Column NAME REPOSITORY
        const td_repository_name = trow.insertCell();
        td_repository_name.innerText = element.repositoryName;

        // Column LINK REPOSITORY
        const td_repository_link = trow.insertCell();
        const a = document.createElement("a");
        a.href = element.repositoryLink;
        a.target = "_blank";
        a.innerText = "Link to Repository";
        td_repository_link.appendChild(a);

        // Column COUNT
        const td_count = trow.insertCell();
        td_count.innerText = element.count;
    });

    //Clean content before append
    document.getElementById("table-commits-saves").innerHTML = '';

    document.getElementById("table-commits-saves").appendChild(table);
}

function buildObjectCommitsSaved(json) {
    return Object.keys(json).map(index => {
        return { id: json[index].id, repositoryOwner: json[index].repositoryOwner, repositoryName: json[index].repositoryName, repositoryLink: json[index].repositoryLink, message: json[index].message, count: json[index].count }
    });
}