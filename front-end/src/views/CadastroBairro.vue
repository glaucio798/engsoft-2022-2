<template>
  <div class="container">
    <TopBar nameOfType="Adicionar" typeOfPage="Bairro"></TopBar>
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
        class="input-text"
        placeholder="Nome do Bairro"
        v-model="bairro.nomeBairro"
      />
      <div class="break"></div>
      <input
        type="text"
        class="input-text"
        placeholder="Referência (Opcional)"
        v-model="bairro.referencia"
      />
      <div class="break" style="height: 0.2rem"></div>
      <div class="break"></div>

      <button
        class="button-form"
        v-on:click="cadastrarBairro"
        style="margin-top: 5rem"
      >
        Adicionar
      </button>
    </form>
  </div>
</template>

<script>
// @ is an alias to /src
import TopBar from "../components/TopBar.vue";

export default {
  name: "CadastroBairro",
  components: { TopBar },
  data() {
    return {
      bairro: {},
    };
  },
  methods: {
    cadastrarBairro() {
      console.log(this.bairro);
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
</style>
