<template>
  <div id="app">
    <router-view />
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');

* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  border: none;
  box-sizing: border-box;
  outline: none;
  resize: none;
  font-family: 'Inter', sans-serif;
}

.break {
  flex-basis: 100%;
  height: 0;
}

.button-form {
  height: 3.5rem;
  width: 20rem;
  border-radius: 2rem;
  background-color: #5CC6BA;
  color: white;
  font-size: 1.5rem;
}

.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}

#modal-global {
  height: 70%;
  width: 40rem;
  background-color: white;
  border-radius: 2rem;
  overflow: auto;
  padding-top: 3rem;
}

.button-close {
  position: fixed;
  border-radius: 1.5rem;
  margin-top: -3rem;
  background-color: white;
}

.centralizador {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
}

table {
  border-collapse: collapse;
}

tr:hover {background-color: #e6e6e6;}
</style>