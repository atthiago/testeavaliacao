function main() {
  let request = new XMLHttpRequest();
  request.open("GET", "http://localhost:8080/selecao");
  request.send();
  request.onload = () => {
    if (request.status === 200) {
      if (JSON.parse(request.response).length === 0) {
        var data = {
          numero: 19,
          nome: "Thiago",
          sobrenome: "Atanasio",
          idade: 18,
        };

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/selecao/convocarJogador", true);
        xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
        xhr.onload = function () {
          console.log(this.responseText);
        };
        xhr.send(JSON.stringify(data));
      } else {
        for (let i = 0; i < JSON.parse(request.response).length; i++) {
          console.log(JSON.parse(request.response)[i]);
          document.getElementById("tabelaSelecao").innerHTML += `
                      <tr>
                          <td>${JSON.parse(request.response)[i].numero}</td>
                          <td>${JSON.parse(request.response)[i].nome}</td>
                          <td>${JSON.parse(request.response)[i].sobrenome}</td>
                          <td>${JSON.parse(request.response)[i].idade}</td>
                          <td>
                              <button onclick="deletarJogador(${
            JSON.parse(request.response)[i].id
            })">Excluir</button>
                          </td>
                      </tr>
                  `;
        }
      }
    } else {
      console.log("Page not found");
    }
  };
}

function deletarJogador(id) {
  let request = new XMLHttpRequest();
  request.open("DELETE", `http://localhost:8080/selecao/excluirJogador/${id}`);
  request.send();
  request.onload = () => {
    if (request.status === 200) {
      window.location.href = "index.html";
    } else {
      console.log("Page not found");
    }
  };
}

function convocar() {
  let numero = document.getElementById("numero").value;
  let nome = document.getElementById("nome").value;
  let sobrenome = document.getElementById("sobrenome").value;
  let idade = document.getElementById("idade").value;

  var data = {
    numero: numero,
    nome: nome,
    sobrenome: sobrenome,
    idade: idade,
  };

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "http://localhost:8080/selecao/convocarJogador", true);
  xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
  xhr.onload = function () {
    console.log(this.responseText);
  };
  xhr.send(JSON.stringify(data));

  window.location.href = "/index.html";
}
