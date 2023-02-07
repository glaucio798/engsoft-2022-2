<template>
  <div class="container">
    <TopBar nameOfType="Doações"></TopBar>
    <div id="tabela-doacao" style="margin-top: 1rem">
      <table>
        <th>Data</th>
        <th>Doador</th>
        <th>Recebedor</th>
        <th>Bairro</th>

        <tr
          v-for="doacao in doacoes"
          :key="doacao.id"
          v-on:click="abrirDoacao(doacao)"
        >
          <td>{{ doacao.dataDoacao }}</td>
          <td>{{ doacao.doador.nome }}</td>
          <td>{{ doacao.recebedor }}</td>
          <td>{{ doacao.bairro }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import TopBar from "../components/TopBar.vue";

export default {
  name: "ListaDoacao",
  components: { TopBar },
  data() {
    return {
      doacoes: [
        {
          dataDoacao: "10/11/2022",
          doador: { nome: "Júlio" },
          recebedor: "Juliano",
          bairro: "Salta Filomena",
        },
        {
          dataDoacao: "10/11/2022",
          doador: { nome: "Júlio" },
          recebedor: "Juliano",
          bairro: "Salta Filomena",
        },
        {
          dataDoacao: "10/11/2022",
          doador: { nome: "Júlio" },
          recebedor: "Juliano",
          bairro: "Salta Filomena",
        },
        {
          dataDoacao: "10/11/2022",
          doador: { nome: "Júlio" },
          recebedor: "Juliano",
          bairro: "Salta Filomena",
        },
        {
          dataDoacao: "10/11/2022",
          doador: { nome: "Júlio" },
          recebedor: "Juliano",
          bairro: "Salta Filomena",
        },
        {
          dataDoacao: "10/11/2022",
          doador: { nome: "Júlio" },
          recebedor: "Juliano",
          bairro: "Salta Filomena",
        },
      ],
    };
  },
  methods: {
    abrirDoacao(doacao) {
      console.log(doacao);
    },
  },
};
</script>

<style scoped>
#tabela-doacao {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

table {
  width: 80%;
}
th {
  color: #a0a0a0;
}

td,
th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
