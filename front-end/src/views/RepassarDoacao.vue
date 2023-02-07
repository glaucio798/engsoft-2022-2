<template>
  <div class="container">
    <TopBar nameOfType="Repassar" typeOfPage="Doação"></TopBar>

    <div class="modal-mask" v-if="modalDoador || modalRecebedor">
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
              v-on:click="registraDoador(doador)"
            >
              <td>{{ doador.nome }}</td>
              <td>{{ doador.telefone }}</td>
            </tr>
          </table>
        </div>
      </modal>
      <modal id="modal-global" v-if="modalRecebedor">
        <button class="button-close" v-on:click="modalRecebedor = false">
          <img src="../assets/close.svg" />
        </button>
        <div class="centralizador">
          <table>
            <th>Nome</th>
            <th>Telefone</th>
            <tr
              v-for="recebedor in recebedores"
              :key="recebedor.id"
              v-on:click="registraRecebedor(recebedor)"
            >
              <td>{{ recebedor.nome }}</td>
              <td>{{ recebedor.telefone }}</td>
            </tr>
          </table>
        </div>
      </modal>
    </div>


    <div class="centralizador" style="margin-top: 5rem">
      <button class="button-form" v-on:click="abreModalDoador">
        Selecionar doador
      </button>
      <div class="break"></div>
      <button class="button-form" v-on:click="abreModalRecebedor">
        Selecionar recebedor
      </button>
      <div class="break"></div>
      <button
        class="button-form"
        style="margin-top: 5rem"
        v-on:click="efetuaDoacao"
      >
        Repassar doação
      </button>
    </div>
  </div>
</template>

<script>
import TopBar from "../components/TopBar.vue";

export default {
  name: "RepassarDoacao",
  components: { TopBar },
  data() {
    return {
      modalDoador: false,
      modalRecebedor: false,
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
      recebedores: [
        { id: 0, nome: "Vitor", telefone: "999518107" },
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
    abreModalDoador() {
      this.modalDoador = true;
    },
    abreModalRecebedor() {
      this.modalRecebedor = true;
    },
    efetuaDoacao() {
      console.log(this.doacao);
    },
    registraDoador(doador) {
      this.doacao.idDoador = doador.id;
      this.modalDoador = false;
    },
    registraRecebedor(recebedor){
      this.doacao.idRecebedor = recebedor.id;
      this.modalRecebedor = false;
    },
  },
};
</script>

<style scoped>
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
