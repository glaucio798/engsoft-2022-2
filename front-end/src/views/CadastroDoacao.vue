<template>
  <div class="container">
    <TopBar nameOfType="Adicionar" typeOfPage="Doações"></TopBar>
    <div class="modal-mask" v-if="modalDoador">
      <modal id="modal-global" v-if="modalDoador">
        <button class="button-close" v-on:click="modalDoador = false">
          <img src="../assets/close.svg" />
        </button>
        <div class="centralizador">
          <table>
            <th>Nome</th>
            <th>Telefone</th>

            <tr
              v-for="doador in doadores"
              :key="doador.id"
              v-on:click="clickList(doador)"
            >
              <td>{{ doador.nome }}</td>
              <td>{{ doador.telefone }}</td>
            </tr>
          </table>
        </div>
      </modal>
    </div>
    <form
      style="
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        justify-content: center;
        margin-top: 3rem;
      "
    >
      <button class="button-form" v-on:click="modalDoador = true">
        Selecionar doador
      </button>
      <div class="break"></div>
      <input
        type="text"
        placeholder="Quantidade de cestas"
        class="input-text"
        v-model="doacao.numCestasDoadas"
      />
      <div class="break"></div>
      <input
        type="text"
        placeholder="Validade da cesta"
        class="input-text"
        v-model="doacao.dataVencimentoLote"
      />
      <div class="break"></div>
      <input
        type="text"
        placeholder="Lote"
        class="input-text"
        v-model="idListaDeEspera"
      />
      <div class="break"></div>
      <button
        class="button-form"
        style="margin-top: 2.5rem"
        v-on:click="cadastrarDoacao"
      >
        Adicionar doação
      </button>
    </form>
  </div>
</template>

<script>
import TopBar from "../components/TopBar.vue";

export default {
  name: "CadastroDoacao",
  components: { TopBar },
  data() {
    return {
      modalDoador: false,
      doacao: {},
      doadores: [
        { id: 0, nome: "José", telefone: "999518107" },
        { id: 1, nome: "José", telefone: "999518107" },
        { id: 2, nome: "José", telefone: "999518107" },
        { id: 3, nome: "José", telefone: "999518107" },
        { id: 4, nome: "José", telefone: "999518107" },
        { id: 5, nome: "José", telefone: "999518107" },
        { id: 6, nome: "José", telefone: "999518107" },
        { id: 7, nome: "José", telefone: "999518107" },
        { id: 8, nome: "José", telefone: "999518107" },
        { id: 9, nome: "José", telefone: "999518107" },
        { id: 10, nome: "José", telefone: "999518107" },
        { id: 11, nome: "José", telefone: "999518107" },
        { id: 12, nome: "José", telefone: "999518107" },
        { id: 13, nome: "José", telefone: "999518107" },
        { id: 14, nome: "José", telefone: "999518107" },
      ],
    };
  },
  methods: {
    abrirModal() {
      this.modalDoador = true;
    },

    clickList(doador) {
      this.doacao.idDoador = doador.id;
      this.modalDoador = false;
    },

    cadastrarDoacao() {
      console.log(this.doacao);
    },
  },
};
</script>

<style scoped>
.input-text {
  padding: 1rem;
  background-color: #e1e4e4;
  border-radius: 0.5rem;
  width: 15rem;
}

.break {
  height: 1rem;
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
