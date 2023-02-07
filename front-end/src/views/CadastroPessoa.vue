<template>
  <div class="container">
    <TopBar nameOfType="Adicionar" typeOfPage="Membro"></TopBar>

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
      <input
        type="text"
        v-model="membro.nome"
        placeholder="Nome Completo"
        class="input-text"
        style="margin-right: 1rem"
      />
      <input type="text" placeholder="CPF" class="input-text" />
      <div class="break"></div>
      <input
        type="text"
        v-model="membro.cep"
        placeholder="CEP"
        class="input-text"
        style="margin-right: 1rem"
      />
      <input
        type="text"
        v-model="membro.numero"
        placeholder="Número da residência"
        class="input-text"
      />
      <div class="break"></div>
      <input
        type="text"
        v-model="membro.telefone"
        placeholder="Telefone"
        class="input-text"
      />
      <div class="break"></div>

      <form style="margin-bottom: 1rem">
        <input
          type="radio"
          v-model="membro.tipo"
          value="DOADOR"
          name="tipoMembro"
          id="membroDoador"
        />
        <label for="membroDoador">Doador</label>
        <div class="break"></div>
        <input
          type="radio"
          v-model="membro.tipo"
          value="AGENTE"
          name="tipoMembro"
          id="membroAgente"
        />
        <label for="membroAgente">Agente Comunitário</label>
        <div class="break"></div>
        <input
          type="radio"
          v-model="membro.tipo"
          value="RECEBEDOR"
          name="tipoMembro"
          id="membroRecebedor"
        />
        <label for="membroRecebedor">Recebedor</label>
        <div class="break"></div>
        <input
          type="radio"
          v-model="membro.tipo"
          value="ADMIN"
          name="tipoMembro"
          id="administrador"
        />
        <label for="administrador">Administrador</label>
      </form>
      <div class="break"></div>
      <button class="button-form" v-on:click="cadastrarMembro">
        Adicionar
      </button>
    </form>
  </div>
</template>

<script>
// @ is an alias to /src
import TopBar from "../components/TopBar.vue";

export default {
  name: "CadastroPessoa",
  components: {
    TopBar,
  },
  data() {
    return {
      membro: {},
    };
  },
  methods: {
    cadastrarMembro() {
      console.log(this.membro);
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

label {
  margin-left: 1rem;
}
.break {
  height: 1rem;
}
</style>
