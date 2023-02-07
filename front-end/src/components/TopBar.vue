<template>
  <div class="top-bar">
    <button id="return-button">
      <img src="../assets/return.svg" />
    </button>
    <div id="tipo-pagina">
      <h1>{{ nameOfType }}</h1>
      <div class="break"></div>
      <h2 v-if="typeOfPage">{{ typeOfPage }}</h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "TopBar",
  props: {
    nameOfType: {
      type: String,
      required: true,
    },
    typeOfPage: {
      type: String,
      required: false,
    },
  },
};
</script>

<style scoped>
.top-bar {
  display: flex;

  height: 6rem;
  width: 100%;

  align-items: center;
  justify-content: center;

  border: 1px solid #a0a0a0;
}

#return-button {
  position: absolute;
  margin-right: 75rem;
  background-color: white;
  height: 4.5rem;
  width: 4.5rem;
}

#tipo-pagina {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}

h1 {
  font-size: 2rem;
  color: #5cc6ba;
}

h2 {
  font-size: 1.4rem;
  color: #a0a0a0;
}
</style>
